package ru.isands.akimov.history.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import ru.isands.akimov.history.EntityEditingHistoryWrapper;
import ru.isands.akimov.history.change_detectors.ChangeDetector;
import ru.isands.akimov.history.enums.EntityType;
import ru.isands.akimov.history.exceptions.EntityFieldChangeDetectorException;
import ru.isands.akimov.history.exceptions.EntityHistoryException;
import ru.isands.akimov.service.EntityEditingHistoryLocalServiceUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Класс отслеживающий изменения в сущности для ведения истории изменений.
 *
 * @param <T>
 */
public abstract class ModelHistoryListener<T extends BaseModel<T>> extends BaseModelListener<T> {

	public abstract EntityType getEntityType();

	public abstract T fetchOldModel(int entityId) throws SystemException;

	public abstract ChangeDetector<T> getChangeDetector(T oldModel, T updatedModel) throws EntityFieldChangeDetectorException;

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

			EntityEditingHistoryWrapper editingHistory =
					new EntityEditingHistoryWrapper(entityId, getEntityType(), userId, dateOfChange);

			T oldModel = fetchOldModel(entityId);
			ChangeDetector<T> changeDetector = getChangeDetector(oldModel, updatedModel);

			Map<String, Object> newValues = changeDetector.getNewValues();
			Map<String, Object> oldValues = changeDetector.getOldValues();

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
			int pk = getEntityId(model);
			String entityType = getEntityType().toString().toLowerCase();
			EntityEditingHistoryLocalServiceUtil.deleteFor(entityType, pk);
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
