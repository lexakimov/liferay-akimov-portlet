package ru.isands.akimov.audit.exceptions;

import com.liferay.portal.ModelListenerException;

public class EntityHistoryException extends AuditEntryCreateException {

	public EntityHistoryException(Exception e) {
		super(e);
	}
}
