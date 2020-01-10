package ru.isands.akimov.history.exceptions;

import com.liferay.portal.ModelListenerException;

public class EntityHistoryException extends ModelListenerException {

	public EntityHistoryException(Exception e) {
		super(e);
	}
}
