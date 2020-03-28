package ru.akimov.audit.enums;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import ru.akimov.model.Foo;

/**
 * Типы сущностей в журнале аудита.
 *
 * @author akimov
 */
public enum EntityType {

	USER(User.class), FOO(Foo.class), VOID(Void.class);

	private final Class<?> clazz;

	EntityType(Class<?> clazz) {
		this.clazz = clazz;
	}


	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
