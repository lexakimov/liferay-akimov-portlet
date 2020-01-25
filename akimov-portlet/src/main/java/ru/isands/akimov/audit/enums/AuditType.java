package ru.isands.akimov.audit.enums;

/**
 * Типы событий аудита в системе. Названия уже существующих перечислений не менять, т.к. они заносяться в базу.
 *
 * @author akimov
 */
public enum AuditType {
	USER_LOGIN,
	USER_LOGOUT,
	USER_REGISTRATION,
	USER_REMOVE,
	USER_ROLE_GRANT,
	USER_ROLE_REMOVE,
	USER_ORG_JOINED,
	USER_ORG_LEFT,

	FOO_CREATE,
	FOO_EDIT,
	FOO_STATUS_CHANGE,
	FOO_DELETE;
}
