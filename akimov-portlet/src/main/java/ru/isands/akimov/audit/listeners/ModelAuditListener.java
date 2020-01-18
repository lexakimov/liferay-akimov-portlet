package ru.isands.akimov.audit.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.isands.akimov.audit.AuditEntryWrapper;
import ru.isands.akimov.audit.diff_finders.ModelDifferenceFinder;
import ru.isands.akimov.audit.enums.ActionType;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.EntityHistoryException;
import ru.isands.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.isands.akimov.service.AuditEntryLocalServiceUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Класс отслеживающий изменения в сущности для ведения истории изменений.
 *
 * @param <T>
 * @author akimov
 */
public abstract class ModelAuditListener<T extends BaseModel<T>> extends BaseModelListener<T> {

	abstract ModelDifferenceFinder<T> getChangeDetector(T oldModel, T updatedModel) throws NoSuchModelAttributeException;

	abstract EntityType getEntityType();

	abstract ActionType getCreateType();

	abstract ActionType getEditType();

	abstract ActionType getDeleteType();

	abstract T fetchOldModel(int entityId) throws SystemException;

	@Override
	public void onBeforeCreate(T model) throws ModelListenerException {
		process(model, getCreateType());
	}

	@Override
	public void onBeforeUpdate(T model) throws ModelListenerException {
		process(model, getEditType());
	}

	private void process(T updatedModel, ActionType actionType) throws EntityHistoryException {
		try {
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
			long companyId = serviceContext.getCompanyId();
			int entityId = getEntityId(updatedModel);
			Date dateOfChange = new Date();

			String description = actionType.toString();
			AuditEntryWrapper editingHistory =
					new AuditEntryWrapper(entityId, getEntityType(), description, companyId, user, dateOfChange);

			T oldModel = fetchOldModel(entityId);
			ModelDifferenceFinder<T> modelDifferenceFinder = getChangeDetector(oldModel, updatedModel);

			Map<String, Object> newValues = modelDifferenceFinder.getNewValues();
			Map<String, Object> oldValues = modelDifferenceFinder.getOldValues();

			for (String fieldName : oldValues.keySet()) {
				Object oldValue = oldValues.get(fieldName);
				Object newValue = newValues.get(fieldName);

				// TODO handle null-values
				editingHistory.addFieldChange(fieldName, oldValue, newValue);
			}

			if (!editingHistory.isEmpty()) {
				editingHistory.persist();
			}

		} catch (SystemException e) {
			throw new EntityHistoryException(e);
		}
	}

	/**
	 * удаление сущности, сопровождается удалением закрепленных за ней записей истории из AuditEntry и
	 * EntityFieldChange, а также созданием записи в журнале об удалении (FIXME).
	 */
	@Override
	public void onAfterRemove(T model) throws EntityHistoryException {
		try {
			int entityId = getEntityId(model);
			String entityType = getEntityType().toString().toLowerCase();
			AuditEntryLocalServiceUtil.deleteFor(entityType, entityId);

			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
			long companyId = serviceContext.getCompanyId();
			Date dateOfChange = new Date();

			String description = getDeleteType().toString();

			AuditEntryWrapper editingHistory =
					new AuditEntryWrapper(entityId, getEntityType(), description, companyId, user, dateOfChange);

			editingHistory.addFieldChange("fooId", entityId, null);
			editingHistory.persist();

		} catch (SystemException e) {
			throw new EntityHistoryException(e);
		}
	}

	private int getEntityId(T updatedModel) {
		Serializable pkObject = updatedModel.getPrimaryKeyObj();
		return pkObject instanceof Long ? ((Long) pkObject).intValue() : (Integer) pkObject;
	}
}
