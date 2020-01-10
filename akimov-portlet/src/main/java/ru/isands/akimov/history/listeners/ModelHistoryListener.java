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

import java.util.Date;
import java.util.Map;

public abstract class ModelHistoryListener<T extends BaseModel<T>> extends BaseModelListener<T> {

	public abstract EntityType getEntityType();

	public abstract T fetchOldModel(long entityId) throws SystemException;

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
			long entityId = (long) updatedModel.getPrimaryKeyObj();
			Date dateOfChange = new Date();

			EntityEditingHistoryWrapper hist = new EntityEditingHistoryWrapper(entityId, getEntityType(), userId, dateOfChange);

			T oldModel = fetchOldModel(entityId);
			ChangeDetector changeDetector = getChangeDetector(oldModel, updatedModel);

			Map<String, Object> newValues = changeDetector.getNewValues();
			Map<String, Object> oldValues = changeDetector.getOldValues();

			for (String fieldName : oldValues.keySet()) {
				Object oldValue = oldValues.get(fieldName);
				Object newValue = newValues.get(fieldName);
				hist.addFieldChange(fieldName, oldValue, newValue);
			}
			hist.persist();
		} catch (SystemException e) {
			throw new EntityHistoryException(e);
		}
	}

	/**
	 * удаление записей истории из EntityEditingHistory и EntityFieldChange
	 *
	 * @param model сущность
	 * @throws ModelListenerException
	 */
	@Override
	public void onAfterRemove(T model) throws ModelListenerException {
		try {
			int pk = (int) model.getPrimaryKeyObj();
			String entityType = getEntityType().toString().toLowerCase();
			EntityEditingHistoryLocalServiceUtil.deleteFor(entityType, pk);
		} catch (SystemException e) {
			throw new ModelListenerException(e);
		}
	}
}
