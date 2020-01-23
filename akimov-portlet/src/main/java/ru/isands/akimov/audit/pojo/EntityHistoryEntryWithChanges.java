package ru.isands.akimov.audit.pojo;

import com.liferay.portal.model.User;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.audit.enums.EntityType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Запись истории изменений сущности на дату.
 *
 * @author akimov
 */
public class EntityHistoryEntryWithChanges {

	private final EntityType entityType;
	private final Date dateOfChanges;
	private final User user;
	private final String description;

	private final Map<String, ModelAttributeChange> changes;

	public EntityHistoryEntryWithChanges(EntityType entityType, User user, String description, Date dateOfChanges, String[][] changesTuple) {
		this.entityType = entityType;
		this.dateOfChanges = dateOfChanges;
		this.user = user;
		this.description = description;

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
		try {
			AuditType auditType = AuditType.valueOf(description);
			return auditType.getDescription(user);
		} catch (IllegalArgumentException e) {
			return description;
		}
	}

	/**
	 * key		-	fieldName
	 */
	public Map<String, ModelAttributeChange> getChanges() {
		return changes;
	}

}
