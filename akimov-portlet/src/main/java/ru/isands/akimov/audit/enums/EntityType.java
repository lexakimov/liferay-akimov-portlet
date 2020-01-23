package ru.isands.akimov.audit.enums;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import ru.isands.akimov.model.Foo;

/**
 * Типы сущностей в журнале аудита.
 *
 * @author akimov
 */
public enum EntityType {

	USER(User.class), FOO(Foo.class);

	private final Class<? extends BaseModel<?>> clazz;

	EntityType(Class<? extends BaseModel<?>> clazz) {
		this.clazz = clazz;
	}

	public Class<? extends BaseModel<?>> getClazz() {
		return clazz;
	}

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
