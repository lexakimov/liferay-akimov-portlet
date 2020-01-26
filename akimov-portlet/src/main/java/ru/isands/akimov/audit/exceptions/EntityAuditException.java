package ru.isands.akimov.audit.exceptions;

import com.liferay.portal.ModelListenerException;

public class EntityAuditException extends AuditEntryCreateException {

	public EntityAuditException(Exception e) {
		super(e);
	}
}
