package ru.isands.akimov.audit.attribute_adapters;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import ru.isands.akimov.utils.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static ru.isands.akimov.utils.DateUtil.DD_MM_YYYY__HH_MM;
import static ru.isands.akimov.utils.DateUtil.ISO_8601;

/**
 * @author akimov
 * created at 19.01.20 13:57
 */
public class FooAttributeAdapter extends DefaultAttributeAdapter {

	private final Log _log = LogFactoryUtil.getLog(FooAttributeAdapter.class);

	@Override
	public Map<String, Function<String, String>> getAttributeAdapters() {

		Map<String, Function<String, String>> adapters = new HashMap<>();

		adapters.put("dateField", getDateAdapter());
		adapters.put("booleanField", getBooleanAdapter());

		return adapters;
	}

	private Function<String, String> getBooleanAdapter() {
		return rawValue -> {

			if (rawValue == null || rawValue.isEmpty()) {
				return StringPool.BLANK;
			}

			boolean parsed = Boolean.parseBoolean(rawValue);

			return parsed ? "есть в наличии" : "отсутствует";
		};
	}

	private Function<String, String> getDateAdapter() {
		return rawValue -> {

			if (rawValue == null || rawValue.isEmpty()) {
				return StringPool.BLANK;
			}

			Date parsed = null;
			try {
				parsed = DateUtil.parseDate(rawValue, ISO_8601);
			} catch (ParseException e) {
				_log.error(e.getMessage());
			}

			return DateUtil.showDate(parsed, DD_MM_YYYY__HH_MM, "[ошибка]");
		};
	}


}
