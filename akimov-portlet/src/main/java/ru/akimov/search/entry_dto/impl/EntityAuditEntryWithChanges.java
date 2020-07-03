package ru.akimov.search.entry_dto.impl;

import com.liferay.portal.model.User;
import ru.akimov.audit.description.DescriptionManager;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.model.AuditEntry;
import ru.akimov.search.entry_dto.SearchEntryDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Запись истории изменений сущности на дату.
 *
 * @author akimov
 */
public class EntityAuditEntryWithChanges implements SearchEntryDTO {

	private final AuditEntry auditEntry;
	private final EntityType entityType;
	private final Date dateOfChanges;
	private final User user;

	private final Map<String, ModelAttributeChange> changes;

	public EntityAuditEntryWithChanges(
			AuditEntry auditEntry, EntityType entityType, User user, Date dateOfChanges, String[][] changesTuple) {

		this.entityType = entityType;
		this.dateOfChanges = dateOfChanges;
		this.user = user;
		this.auditEntry = auditEntry;

		this.changes = new HashMap<>();
		for (String[] change : changesTuple) {
			String fieldName = change[0];
			String oldValue = change[1];
			String newValue = change[2];
			ModelAttributeChange attributeChange = new ModelAttributeChange(dateOfChanges, fieldName, oldValue, newValue);
			this.changes.put(fieldName, attributeChange);
		}
	}

	public String getEntityType() {
		return entityType.toString().toLowerCase();
	}

	public Date getDateOfChanges() {
		return dateOfChanges;
	}

	public User getUser() {
		return user;
	}

	public String getDescription() {
		return DescriptionManager.formDescription(auditEntry);
	}

	/**
	 * key		-	fieldName
	 */
	public Map<String, ModelAttributeChange> getChanges() {
		return changes;
	}

	/**
	 * Изменение атрибута сущности.
	 *
	 * @author akimov
	 */
	public static class ModelAttributeChange {

		private final Date dateOfChange;
		private final String fieldName;
		private final String oldValue;
		private final String newValue;

		ModelAttributeChange(Date dateOfChange, String fieldName, String oldValue, String newValue) {
			this.dateOfChange = dateOfChange;
			this.fieldName = fieldName;
			this.oldValue = oldValue;
			this.newValue = newValue;
		}

		public Date getDateOfChange() {
			return dateOfChange;
		}

		public String getFieldName() {
			return fieldName;
		}

		public String getOldValue() {
			return oldValue;
		}

		public String getNewValue() {
			return newValue;
		}
	}
}
