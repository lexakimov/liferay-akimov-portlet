package ru.akimov.audit;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.EntityFieldChange;
import ru.akimov.service.AuditEntryLocalServiceUtil;
import ru.akimov.service.EntityFieldChangeLocalServiceUtil;
import ru.akimov.utils.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.akimov.utils.DateUtil.ISO_8601;

/**
 * Класс-обёртка над записью аудита.
 *
 * @author akimov
 * created at 10.01.20 11:11
 */
public class AuditEntryWrapper {

	private static final Log log = LogFactoryUtil.getLog(AuditEntryWrapper.class);

	private AuditEntry auditEntry;

	private List<EntityFieldChange> fieldChanges;

	public AuditEntryWrapper(int entityId,
							 EntityType entityType,
							 AuditType auditType,
							 Date dateOfChange,
							 String metadata) throws SystemException {
		this(entityId, entityType, auditType, 0, null, dateOfChange, metadata);
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long companyId = serviceContext.getCompanyId();
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		auditEntry.setCompanyId(companyId);
		auditEntry.setUserId(user.getUserId());
		auditEntry.setUserName(user.getFullName());
	}

	public AuditEntryWrapper(int entityId,
							 EntityType entityType,
							 AuditType auditType,
							 long companyId,
							 User user,
							 Date dateOfChange,
							 String metadata) throws SystemException {

		int historyEntryId = (int) CounterLocalServiceUtil.increment(AuditEntry.class.getName());

		auditEntry = AuditEntryLocalServiceUtil.createAuditEntry(historyEntryId);
		auditEntry.setEntityId(entityId);
		auditEntry.setEntityType(entityType.toString());
		auditEntry.setCompanyId(companyId);
		if (user != null) {
			auditEntry.setUserId(user.getUserId());
			auditEntry.setUserName(user.getFullName());
		}
		auditEntry.setDateOfChange(dateOfChange);
		auditEntry.setAuditType(auditType.toString());
		auditEntry.setMetadata(metadata);

		fieldChanges = new ArrayList<>();
	}

	/**
	 * добавить к записи истории изменения сущности запись об изменении атрибута.
	 *
	 * @param fieldName имя атрибута.
	 * @param oldValue  старое значение.
	 * @param newValue  новое значение.
	 * @throws SystemException
	 */
	public void addFieldChange(String fieldName, Object oldValue, Object newValue) throws SystemException {
		int fieldChangeId = (int) CounterLocalServiceUtil.increment(EntityFieldChange.class.getName());

		EntityFieldChange fieldChange = EntityFieldChangeLocalServiceUtil.createEntityFieldChange(fieldChangeId);
		fieldChange.setAuditEntryId(auditEntry.getAuditEntryId());
		fieldChange.setFieldName(fieldName);

		fieldChange.setOldValue(attributeToString(oldValue));
		fieldChange.setNewValue(attributeToString(newValue));

		fieldChanges.add(fieldChange);
	}

	/**
	 * format date attributes to ISO 8601 before storing it to database
	 *
	 * @param attrValue raw attribute value
	 * @return attribute value string, ready to store into database.
	 */
	private String attributeToString(Object attrValue) {
		String oldValueString = StringPool.BLANK;
		if (attrValue != null) {
			oldValueString = (attrValue instanceof Date)
					? DateUtil.showDate((Date) attrValue, ISO_8601)
					: attrValue.toString();
		}
		return oldValueString;
	}

	/**
	 * @return true если запись истории изменения сущности не имеет закрепленных за собой записей об изменениях атрибутов.
	 */
	public boolean hasFieldChanges() {
		return !fieldChanges.isEmpty();
	}

	/**
	 * полностью сохранить запись истории изменения в базу
	 */
	public void persist() throws SystemException {
		for (EntityFieldChange fieldChange : fieldChanges) {
			fieldChange.persist();
		}
		auditEntry.persist();

		if (log.isDebugEnabled()) {
			int auditId = auditEntry.getAuditEntryId();
			String entityType = auditEntry.getEntityType();
			int entityId = auditEntry.getEntityId();
			log.debug(String.format(
					"audit entry [%d] for entity %s(%d) with %d field changes persisted in database",
					auditId, entityType, entityId, fieldChanges.size()
			));
		}
	}
}
