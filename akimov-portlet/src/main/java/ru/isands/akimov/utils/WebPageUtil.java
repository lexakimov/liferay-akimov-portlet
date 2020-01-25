package ru.isands.akimov.utils;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author akimov
 * created at 25.01.20 16:54
 */
public class WebPageUtil {

	public static String setColor(String text, String color) {
		return setStyle(text, color, false, false, false);
	}

	public static String setStyle(String text, String color, boolean bold, boolean italic, boolean underline) {
		text = String.valueOf(text);
		text = text.trim();
		if (text.isEmpty()) {
			return StringPool.BLANK;
		}

		color = color == null ? StringPool.BLANK : color.trim();

		String style = "";
		if (!color.isEmpty()) {
			style += "color: " + color + "; ";
		}
		if (bold) {
			style += "font-weight: bold; ";
		}
		if (italic) {
			style += "font-style: italic; ";
		}
		if (underline) {
			style += "text-decoration:underline;";
		}

		style = style.trim();

		return style.isEmpty() ? text : "<span style='" + style.trim() + "'>" + text + "</span>";
	}


}
