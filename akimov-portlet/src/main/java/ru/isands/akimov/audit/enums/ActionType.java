package ru.isands.akimov.audit.enums;

import com.liferay.portal.model.User;

/**
 * Типы действий пользователя в системе. Названия уже существующих перечислений не менять, т.к. они заносяться в базу.
 *
 * @author akimov
 */
public enum ActionType {
	USER_LOGIN("Пользователь %s вошёл в систему"),
	USER_LOGOUT("Пользователь %s вышёл из системы"),

	FOO_CREATE("%s создал Foo"),
	FOO_EDIT("%s отредактировал Foo"),
	FOO_DELETE("%s удалил Foo");

	private final String description;

	ActionType(String description) {
		this.description = description;
	}

	public String getDescription(User user) {
		return String.format(description, user != null ? user.getFullName() : "[пользователь не найден]");
	}
}
