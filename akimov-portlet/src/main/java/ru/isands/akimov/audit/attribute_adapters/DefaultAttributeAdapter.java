package ru.isands.akimov.audit.attribute_adapters;

import com.liferay.portal.kernel.util.StringPool;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/**
 * Адаптер для вывода значений атрибутов сущности из базы на страницу.
 *
 * @author akimov
 * created at 19.01.20 13:53
 */
public class DefaultAttributeAdapter {

	public Map<String, Function<String, String>> getAttributeAdapters() {
		return Collections.emptyMap();
	}

	public String adapt(String fieldName, String rawValue) {
		Function<String, String> adapter = getAttributeAdapters().get(fieldName);

		return adapter != null ? adapter.apply(rawValue) : StringPool.BLANK;
	}
}
