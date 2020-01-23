package ru.isands.akimov.audit.enums;

import com.liferay.portal.model.User;

/**
 * Типы событий аудита в системе. Названия уже существующих перечислений не менять, т.к. они заносяться в базу.
 *
 * @author akimov
 */
public enum AuditType {
	USER_LOGIN("Пользователь %s вошёл в систему"),
	USER_LOGOUT("Пользователь %s вышёл из системы"),

	USER_REGISTRATION("%s зарегистрировался в системе"),
	USER_REMOVE("%s удалён из системы"),
	USER_ROLE_GRANT("%s выдал %s роль %s"),
	USER_ROLE_REMOVE("%s забрал у %s роль %s"),
	USER_ORG_JOINED("Пользователь %s вписан в организацию %s"),
	USER_ORG_LEFT("Пользователь %s выписан из организации %s"),

	FOO_CREATE("%s создал Foo"),
	FOO_EDIT("%s отредактировал Foo"),
	FOO_DELETE("%s удалил Foo");

	private final String description;

	AuditType(String description) {
		this.description = description;
	}

	public String getDescription(User user) {
		return String.format(description, user != null ? user.getFullName() : "[пользователь не найден]");
	}
}
