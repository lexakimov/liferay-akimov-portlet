package ru.isands.akimov.audit.dto;

import com.liferay.portal.model.User;
import ru.isands.akimov.audit.enums.ActionType;
import ru.isands.akimov.audit.enums.EntityType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Запись истории изменений сущности на дату.
 */
public class EntityHistoryEntryWithChanges {

	private final EntityType entityType;
	private final Date dateOfChanges;
	private final User user;
	private final String description;

	private final Map<String, AttributeChange> changes;

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
			AttributeChange attributeChange = new AttributeChange(dateOfChanges, fieldName, oldValue, newValue);
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
			ActionType actionType = ActionType.valueOf(description);
			return actionType.getDescription(user);
		} catch (IllegalArgumentException e) {
			return description;
		}
	}

	/**
	 * key		-	fieldName
	 */
	public Map<String, AttributeChange> getChanges() {
		return changes;
	}
	
}
