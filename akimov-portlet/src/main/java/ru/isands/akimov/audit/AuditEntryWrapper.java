package ru.isands.akimov.audit;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.model.EntityFieldChange;
import ru.isands.akimov.service.AuditEntryLocalServiceUtil;
import ru.isands.akimov.service.EntityFieldChangeLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс-обёртка над записью аудита.
 *
 * @author akimov
 * created at 10.01.20 11:11
 */
public class AuditEntryWrapper {

	private AuditEntry editingHistoryEntry;

	private List<EntityFieldChange> fieldChanges;

	public AuditEntryWrapper(
			int entityId, EntityType entityType, String description, long companyId, User user, Date dateOfChange)
			throws SystemException {

		int historyEntryId = (int) CounterLocalServiceUtil.increment(AuditEntry.class.getName());

		editingHistoryEntry = AuditEntryLocalServiceUtil.createAuditEntry(historyEntryId);
		editingHistoryEntry.setEntityId(entityId);
		editingHistoryEntry.setEntityType(entityType.toString());
		editingHistoryEntry.setCompanyId(companyId);
		editingHistoryEntry.setUserId(user.getUserId());
		editingHistoryEntry.setUserName(user.getFullName());
		editingHistoryEntry.setDateOfChange(dateOfChange);
		editingHistoryEntry.setDescription(description);

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
		fieldChange.setAuditEntryId(editingHistoryEntry.getId());
		fieldChange.setFieldName(fieldName);
		fieldChange.setOldValue(oldValue != null ? oldValue.toString() : StringPool.BLANK);
		fieldChange.setNewValue(newValue != null ? newValue.toString() : StringPool.BLANK);

		fieldChanges.add(fieldChange);
	}

	/**
	 * @return true если запись истории изменения сущности не имеет закрепленных за собой записей об изменениях атрибутов.
	 */
	public boolean isEmpty() {
		return fieldChanges.isEmpty();
	}

	/**
	 * полностью сохранить запись истории изменения в базу
	 */
	public void persist() throws SystemException {
		for (EntityFieldChange fieldChange : fieldChanges) {
			fieldChange.persist();
		}
		editingHistoryEntry.persist();
	}
}
