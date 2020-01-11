package ru.isands.akimov.audit.enums;

public enum EntityType {

	USER, FOO;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
