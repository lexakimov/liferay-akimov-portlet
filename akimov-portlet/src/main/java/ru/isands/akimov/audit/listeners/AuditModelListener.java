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

	private static final Log log = LogFactoryUtil.getLog(AuditModelListener.class);

	@Override
	public void onBeforeCreate(T model) throws ModelListenerException {
		log.trace("onBeforeCreate()");
		process(model, getCreateType());
	}

	@Override
	public void onBeforeUpdate(T model) throws ModelListenerException {
		log.trace("onBeforeUpdate()");
		process(model, getEditType());
	}

	private void process(T updatedModel, AuditType auditType) throws EntityHistoryException {
		int entityId = getEntityId(updatedModel);
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long companyId = serviceContext.getCompanyId();
		Date dateOfChange = new Date();
		try {
			User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
			AuditEntryWrapper auditEntry =
					new AuditEntryWrapper(entityId, getEntityType(), auditType, companyId, user, dateOfChange);

			T oldModel = fetchOldModel(entityId);
			ModelComparator<T> modelComparator = getModelComparator(oldModel, updatedModel);

			Map<String, Object> newValues = modelComparator.getNewValues();
			Map<String, Object> oldValues = modelComparator.getOldValues();

			for (String fieldName : oldValues.keySet()) {
				Object oldValue = oldValues.get(fieldName);
				Object newValue = newValues.get(fieldName);
				auditEntry.addFieldChange(fieldName, oldValue, newValue);
			}

			if (auditEntry.hasFieldChanges()) {
				auditEntry.persist();
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
	 */
	@Override
	public void onAfterRemove(T model) throws EntityHistoryException {
		log.trace("onAfterRemove()");
		try {
			int entityId = getEntityId(model);
			// удаление всех записей журнала сущности.
			String entityType = getEntityType().toString();
			AuditEntryLocalServiceUtil.deleteFor(entityType, entityId);

			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			long companyId = serviceContext.getCompanyId();
			Date dateOfChange = new Date();
			User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
			AuditEntryWrapper auditEntry =
					new AuditEntryWrapper(entityId, getEntityType(), getDeleteType(), companyId, user, dateOfChange);

			// FIXME что делать с id?
			auditEntry.addFieldChange("fooId", entityId, null);
			auditEntry.persist();
		} catch (SystemException e) {
			throw new EntityHistoryException(e);
		}
	}

	protected int getEntityId(T updatedModel) {
		Serializable pkObject = updatedModel.getPrimaryKeyObj();
		return pkObject instanceof Long ? ((Long) pkObject).intValue() : (Integer) pkObject;
	}

	protected abstract ModelComparator<T> getModelComparator(T oldModel, T updatedModel) throws NoSuchModelAttributeException;

	protected abstract EntityType getEntityType();

	protected abstract AuditType getCreateType();

	protected abstract AuditType getEditType();

	protected abstract AuditType getDeleteType();

	protected abstract T fetchOldModel(int entityId) throws SystemException;
}
