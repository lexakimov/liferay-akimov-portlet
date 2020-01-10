package ru.isands.akimov.history.exceptions;

import com.liferay.portal.ModelListenerException;

public class EntityFieldChangeDetectorException extends ModelListenerException {

	public EntityFieldChangeDetectorException(String msg) {
		super(msg);
	}
}
