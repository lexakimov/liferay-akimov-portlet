package ru.akimov.utils;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author akimov
 * created at 03.07.2020 17:40
 */
public class ResourcesUtil {

	public static String getContent(String relativePath) {
		try {
			ClassLoader classLoader = ResourcesUtil.class.getClassLoader();
			URL resource = classLoader.getResource(relativePath);
			byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
			return new String(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
