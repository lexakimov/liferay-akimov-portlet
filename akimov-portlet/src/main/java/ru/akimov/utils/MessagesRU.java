package ru.akimov.utils;

import com.liferay.portal.kernel.language.LanguageUtil;
import ru.akimov.portlet.MVCExtendedPortlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Альтернатива {@link LanguageUtil}
 *
 * @author akimov
 * created at 14.12.19 19:21
 * @see LanguageUtil
 * @see MVCExtendedPortlet
 */
public class MessagesRU {

	private static Properties _props;

	static {
		_props = new Properties();
		InputStream resourceAsStream = MessagesRU.class.getResourceAsStream("/messages_ru.properties");
		InputStreamReader isr = new InputStreamReader(resourceAsStream, UTF_8);
		try {
			_props.load(isr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getMessage(String key) {
		return _props.getProperty(key, key);
	}
}
