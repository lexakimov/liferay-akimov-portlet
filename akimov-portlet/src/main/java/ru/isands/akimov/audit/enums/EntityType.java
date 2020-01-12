package ru.isands.akimov.audit.enums;

/**
 * Типы сущностей в журнале аудита.
 *
 * @author akimov
 */
public enum EntityType {

	USER, FOO;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
