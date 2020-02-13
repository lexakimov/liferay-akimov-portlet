package ru.akimov.audit.exceptions;

import com.liferay.portal.ModelListenerException;

public class AuditEntryCreateException extends ModelListenerException {

	public AuditEntryCreateException(Exception e) {
		super(e);
	}

	public AuditEntryCreateException(String msg) {
		super(msg);
	}

}
