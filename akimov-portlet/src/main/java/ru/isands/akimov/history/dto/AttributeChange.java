package ru.isands.akimov.history.dto;

import java.util.Date;

/**
 * Изменение атрибута сущности.
 */
public class AttributeChange {

	private final Date dateOfChange;
	private final String fieldName;
	private final String oldValue;
	private final String newValue;

	AttributeChange(Date dateOfChange, String fieldName, String oldValue, String newValue) {
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
