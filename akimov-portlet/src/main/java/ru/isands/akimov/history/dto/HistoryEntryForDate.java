package ru.isands.akimov.history.dto;

import ru.isands.akimov.history.enums.EntityType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Запись истории изменений сущности на дату.
 */
public class HistoryEntryForDate {

	private final EntityType entityType;
	private final Date dateOfChanges;

	private final Map<String, AttributeChange> changes;

	public HistoryEntryForDate(EntityType entityType, Date dateOfChanges, String[][] changesTuple) {
		this.entityType = entityType;
		this.dateOfChanges = dateOfChanges;
		this.changes = new HashMap<>();
		for (String[] change : changesTuple) {
			String fieldName = change[0];
			String oldValue = change[1];
			String newValue = change[2];
			AttributeChange attributeChange = new AttributeChange(dateOfChanges, fieldName, oldValue, newValue);
			this.changes.put(fieldName, attributeChange);
		}
	}

	public Date getDateOfChanges() {
		return dateOfChanges;
	}

	/**
	 * key		-	fieldName
	 */
	public Map<String, AttributeChange> getChanges() {
		return changes;
	}

	public String getEntityType() {
		return entityType.toString().toLowerCase();
	}
}
