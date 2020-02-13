package ru.akimov.audit.exceptions;

public class EntityAuditException extends AuditEntryCreateException {

	public EntityAuditException(Exception e) {
		super(e);
	}
}
