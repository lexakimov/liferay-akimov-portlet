package ru.isands.akimov.audit.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import ru.isands.akimov.audit.AuditEntryWrapper;
import ru.isands.akimov.audit.diff_finders.ModelDifferenceFinder;
import ru.isands.akimov.audit.enums.ActionType;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.EntityFieldChangeDetectorException;
import ru.isands.akimov.audit.exceptions.EntityHistoryException;
import ru.isands.akimov.service.EntityEditingHistoryLocalServiceUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Класс отслеживающий изменения в сущности для ведения истории изменений.
 *
 * @param <T>
 */
public abstract class ModelAuditListener<T extends BaseModel<T>> extends BaseModelListener<T> {

	public abstract EntityType getEntityType();

	public abstract T fetchOldModel(int entityId) throws SystemException;

	public abstract ModelDifferenceFinder<T> getChangeDetector(T oldModel, T updatedModel) throws EntityFieldChangeDetectorException;

	@Override
	public void onBeforeCreate(T model) throws ModelListenerException {
		process(model);
	}

	@Override
	public void onBeforeUpdate(T model) throws ModelListenerException {
		process(model);
	}

	private void process(T updatedModel) throws EntityHistoryException {
		try {
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			long userId = serviceContext.getUserId();
			int entityId = getEntityId(updatedModel);
			Date dateOfChange = new Date();

			String description = ActionType.FOO_EDIT.toString();
			AuditEntryWrapper editingHistory =
					new AuditEntryWrapper(entityId, getEntityType(), description, userId, dateOfChange);

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
	 * удаление сущности, сопровождается удалением закрепленных за ней записей истории из EntityEditingHistory и
	 * EntityFieldChange
	 */
	@Override
	public void onAfterRemove(T model) throws EntityHistoryException {
		try {
			int entityId = getEntityId(model);
			String entityType = getEntityType().toString().toLowerCase();
			EntityEditingHistoryLocalServiceUtil.deleteFor(entityType, entityId);


			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			long userId = serviceContext.getUserId();
			Date dateOfChange = new Date();

			String description = ActionType.FOO_DELETE.toString();

			AuditEntryWrapper editingHistory =
					new AuditEntryWrapper(entityId, getEntityType(), description, userId, dateOfChange);

			editingHistory.addFieldChange("fooId", entityId, null);
			editingHistory.persist();

		} catch (SystemException e) {
			throw new EntityHistoryException(e);
		}
	}

	private int getEntityId(T updatedModel) {
		Serializable pkObject = updatedModel.getPrimaryKeyObj();
		int entityId;
		if (pkObject instanceof Long) {
			entityId = ((Long) pkObject).intValue();
		} else {
			entityId = (Integer) pkObject;
		}
		return entityId;
	}
}
