package ru.isands.akimov.audit.enums;

import com.liferay.portal.model.User;

public enum ActionType {
	FOO_CREATE("%s создал сущность Foo"),
	FOO_EDIT("%s проредактировал сущность Foo"),
	FOO_DELETE("%s удалил сущность Foo"),
	USER_LOGIN("Пользователь %s вошёл в систему"),
	USER_LOGOUT("Пользователь %s вышёл из системы");

	private final String description;

	ActionType(String description) {
		this.description = description;
	}

	public String getDescription(User user) {
		return String.format(description, user != null ? user.getFullName() : "[пользователь не найден]");
	}
}