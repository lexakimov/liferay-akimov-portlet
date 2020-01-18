package ru.isands.akimov.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author akimov
 * created at 18.01.20 19:45
 */
public final class DateUtil {

	private static final Log log = LogFactoryUtil.getLog(DateUtil.class);

	public static final DateFormat DD_MM_YYYY = new SimpleDateFormat("dd.MM.yyyy");

	public static final DateFormat DD_MM_YYYY__HH_MM = new SimpleDateFormat("dd.MM.yyyy HH:mm");

	public static final DateFormat DD_MM_YYYY__HH_MM_SS = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	public static final DateFormat YYYY_MM_DD__HH_MM_SS = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	/**
	 * <fmt:formatDate timeZone="${timeZone}" value='<%= date %>' pattern="dd.MM.yyyy HH:mm:ss"/>
	 *
	 * @param date     дата
	 * @param timeZone часовой пояс (есть у пользователя, настраивается в Свойствах отображения (панель управления))
	 * @return dd.MM.yyyy HH:mm
	 */
	public static String formatNullable(Date date, TimeZone timeZone) {
		return FastDateFormatFactoryUtil.getSimpleDateFormat("dd.MM.yyyy HH:mm", timeZone).format(date);
	}

	/**
	 * @return строку формата format, либо пустую строку
	 */
	public static String showDate(Date date, DateFormat format) {
		return showDate(date, format, GetterUtil.DEFAULT_STRING);
	}

	/**
	 * @return строку формата format, либо defaultString
	 */
	public static String showDate(Date date, DateFormat format, String defaultString) {
		return date != null ? format.format(date) : defaultString;
	}

	/**
	 * Парсит дату из строки
	 *
	 * @param dateString
	 * @param format
	 * @return дату, либо null если строка пуста или null
	 * @throws ParseException
	 */
	public static Date parseDate(String dateString, DateFormat format) throws ParseException {
		if (dateString == null || dateString.isEmpty()) {
			return null;
		}
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			log.error("Date parsing error");
			throw e;
		}
	}
}
