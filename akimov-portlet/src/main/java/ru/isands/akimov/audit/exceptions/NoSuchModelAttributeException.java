package ru.isands.akimov.audit.exceptions;

import com.liferay.portal.ModelListenerException;

public class NoSuchModelAttributeException extends AuditEntryCreateException {

	public NoSuchModelAttributeException(String msg) {
		super(msg);
	}
}
