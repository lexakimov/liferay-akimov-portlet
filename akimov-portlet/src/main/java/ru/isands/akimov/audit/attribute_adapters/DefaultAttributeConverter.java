package ru.isands.akimov.audit.attribute_adapters;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/**
 * Адаптер для вывода значений атрибутов сущности из базы на страницу.
 * Данная дефолтная реализация просто выводит значени атрибутов как они хранятся в базе.
 *
 * @author akimov
 * created at 19.01.20 13:53
 */
public class DefaultAttributeConverter {

	public Map<String, Function<String, String>> getAttributeAdapters() {
		return Collections.emptyMap();
	}

	public String adapt(String fieldName, String rawValue) {
		Function<String, String> adapter = getAttributeAdapters().get(fieldName);

		return adapter != null ? adapter.apply(rawValue) : rawValue;
	}
}
