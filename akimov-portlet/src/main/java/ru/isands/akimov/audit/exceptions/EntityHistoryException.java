package ru.isands.akimov.audit.exceptions;

import com.liferay.portal.ModelListenerException;

public class EntityHistoryException extends ModelListenerException {

	public EntityHistoryException(Exception e) {
		super(e);
	}
}
