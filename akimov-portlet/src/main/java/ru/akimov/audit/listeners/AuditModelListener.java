package ru.akimov.audit.listeners;

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
import ru.akimov.audit.AuditEntryWrapper;
import ru.akimov.audit.comparators.ModelComparator;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.audit.exceptions.EntityAuditException;
import ru.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.akimov.audit.messaging.AuditMessagingUtil;
import ru.akimov.service.AuditEntryLocalServiceUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Базовый класс, отслеживающий изменения в сущности для ведения истории изменений.
 * Классы-наследники прописываются в файл service-ext.properties.
 *
 * @param <T> тип сущности
 * @author akimov
 */
public abstract class AuditModelListener<T extends BaseModel<T>> extends BaseModelListener<T> {

	private static final Log log = LogFactoryUtil.getLog(AuditModelListener.class);

	@Override
	public final void onBeforeCreate(T model) throws ModelListenerException {
		log.trace("onBeforeCreate()");
		if (AuditMessagingUtil.isPreventDefaultAudit()) {
			log.debug("return...");
			return;
		}
		process(model, getDefaultCreateType());
	}

	@Override
	public final void onBeforeUpdate(T model) throws ModelListenerException {
		log.trace("onBeforeUpdate()");
		if (AuditMessagingUtil.isPreventDefaultAudit()) {
			log.debug("return...");
			return;
		}
		process(model, getDefaultEditType());
	}

	private void process(T updatedModel, AuditType auditType) throws EntityAuditException {

		int entityId = getEntityId(updatedModel);

		// выявить изменения полей
		ModelComparator<T> modelComparator;
		try {
			T oldModel = fetchOldModel(entityId);
			modelComparator = getModelComparator(oldModel, updatedModel);
		} catch (SystemException e) {
			throw new EntityAuditException(e);
		}

		Map<String, Object> newValues = modelComparator.getNewValues();
		Map<String, Object> oldValues = modelComparator.getOldValues();
		Set<String> changedFields = modelComparator.getChangedFields();

		auditType = getSpecialAuditType(changedFields, auditType);

		Date dateOfChange = new Date();
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long companyId = serviceContext.getCompanyId();

		try {
			// кто инициатор события
			User initiator = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());

			String metadata = "";
			AuditEntryWrapper auditEntry =
					new AuditEntryWrapper(entityId, getEntityType(), auditType, companyId, initiator, dateOfChange, metadata);

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
			throw new EntityAuditException(e);
		}
	}

	/**
	 * Здесь можно переопределить тип действия в зависимости от комбинации изменённых полей.
	 *
	 * @param changedFields набор изменённых аттрибутов.
	 * @param defaultType   стандартный тип (создание, изиенение, удаление).
	 * @return тип действия пользователя.
	 */
	protected AuditType getSpecialAuditType(Set<String> changedFields, AuditType defaultType) {
		return defaultType;
	}

	/**
	 * удаление сущности, сопровождается удалением закрепленных за ней записей истории из AuditEntry и
	 * EntityFieldChange, а также созданием записи в журнале об удалении.
	 */
	@Override
	public final void onAfterRemove(T model) throws EntityAuditException {
		log.trace("onAfterRemove()");
		if (AuditMessagingUtil.isPreventDefaultAudit()){
			log.debug("return...");
			return;
		}

		int entityId = getEntityId(model);
		String entityType = getEntityType().toString();
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long companyId = serviceContext.getCompanyId();
		Date dateOfChange = new Date();

		try {
			// сперва удаляем все записи сущности из журнала
			AuditEntryLocalServiceUtil.deleteFor(entityType, entityId);

			User initiator = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());

			String metadata = "";
			AuditEntryWrapper auditEntry =
					new AuditEntryWrapper(entityId, getEntityType(), getDefaultDeleteType(), companyId, initiator, dateOfChange, metadata);

			// FIXME что делать с id?
			auditEntry.addFieldChange("fooId", entityId, null);
			auditEntry.persist();

		} catch (SystemException e) {
			throw new EntityAuditException(e);
		}
	}

	protected int getEntityId(T updatedModel) {
		Serializable pkObject = updatedModel.getPrimaryKeyObj();
		return pkObject instanceof Long ? ((Long) pkObject).intValue() : (Integer) pkObject;
	}

	protected abstract ModelComparator<T> getModelComparator(T oldModel, T updatedModel)
			throws NoSuchModelAttributeException;

	protected abstract EntityType getEntityType();

	protected abstract AuditType getDefaultCreateType();

	protected abstract AuditType getDefaultEditType();

	protected abstract AuditType getDefaultDeleteType();

	protected abstract T fetchOldModel(int entityId) throws SystemException;
}
