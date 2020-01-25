package ru.isands.akimov.audit.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.isands.akimov.audit.AuditEntryWrapper;
import ru.isands.akimov.audit.comparators.ModelComparator;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.EntityHistoryException;
import ru.isands.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.isands.akimov.service.AuditEntryLocalServiceUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Базовый класс отслеживающий изменения в сущности для ведения истории изменений.
 * Классы-наследники прописываются в файл service-ext.properties.
 *
 * @param <T> тип сущности
 * @author akimov
 */
public abstract class AuditModelListener<T extends BaseModel<T>> extends BaseModelListener<T> {

	protected Log log = LogFactoryUtil.getLog(this.getClass());

	public AuditModelListener() {
		log.debug("created");
	}

	protected abstract ModelComparator<T> getChangeDetector(T oldModel, T updatedModel) throws NoSuchModelAttributeException;

	protected abstract EntityType getEntityType();

	protected abstract AuditType getCreateType();

	protected abstract AuditType getEditType();

	protected abstract AuditType getDeleteType();

	protected abstract T fetchOldModel(int entityId) throws SystemException;

	@Override
	public void onBeforeCreate(T model) throws ModelListenerException {
		process(model, getCreateType());
	}

	@Override
	public void onBeforeUpdate(T model) throws ModelListenerException {
		process(model, getEditType());
	}

	private void process(T updatedModel, AuditType auditType) throws EntityHistoryException {
		try {
			int entityId = getEntityId(updatedModel);

			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
			long companyId = serviceContext.getCompanyId();
			Date dateOfChange = new Date();

			String description = auditType.toString();
			AuditEntryWrapper editingHistory =
					new AuditEntryWrapper(entityId, getEntityType(), description, companyId, user, dateOfChange);

			T oldModel = fetchOldModel(entityId);
			ModelComparator<T> modelComparator = getChangeDetector(oldModel, updatedModel);

			Map<String, Object> newValues = modelComparator.getNewValues();
			Map<String, Object> oldValues = modelComparator.getOldValues();

			for (String fieldName : oldValues.keySet()) {
				Object oldValue = oldValues.get(fieldName);
				Object newValue = newValues.get(fieldName);
				editingHistory.addFieldChange(fieldName, oldValue, newValue);
			}

			if (!editingHistory.isEmpty()) {
				editingHistory.persist();
			} else {
				log.debug("Audit entry was not created because model had no changes");
			}

		} catch (SystemException e) {
			throw new EntityHistoryException(e);
		}
	}

	/**
	 * удаление сущности, сопровождается удалением закрепленных за ней записей истории из AuditEntry и
	 * EntityFieldChange, а также созданием записи в журнале об удалении.
	 * TODO что делать с id?
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
