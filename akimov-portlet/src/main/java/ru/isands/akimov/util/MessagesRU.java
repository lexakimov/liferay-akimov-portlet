package ru.isands.akimov.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

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
