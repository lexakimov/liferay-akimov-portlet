package ru.isands.akimov.enums;

import ru.isands.akimov.portlet.ExtendedMVCPortlet;

/**
 * @author akimov
 * created at 14.12.19 10:36
 */
public enum Gender {
	UNKNOWN(0, "не указан"),
	MALE(1, "мужской"),
	FEMALE(2, "женский");

	private int ordinal;
	private String label;

	Gender(int ordinal, String label) {
		this.ordinal = ordinal;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public static Gender getByOrdinal(int ordinal) {
		for (Gender gender : values()) {
			if (gender.ordinal == ordinal) {
				return gender;
			}
		}
		return null;
	}
}
