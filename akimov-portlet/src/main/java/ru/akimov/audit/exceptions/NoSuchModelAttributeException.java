package ru.akimov.audit.exceptions;

public class NoSuchModelAttributeException extends AuditEntryCreateException {

	public NoSuchModelAttributeException(String msg) {
		super(msg);
	}
}
