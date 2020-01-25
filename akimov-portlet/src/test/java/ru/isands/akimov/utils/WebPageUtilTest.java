package ru.isands.akimov.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author akimov
 * created at 25.01.20 16:58
 */
public class WebPageUtilTest {

	@Test
	public void setColor_goodCase() {
		String actual = WebPageUtil.setColor("some text", "red");
		assertEquals("<span style='color: red;'>some text</span>", actual);
	}

	@Test
	public void setColor_textEmpty() {
		String actual = WebPageUtil.setColor("", "red");
		assertEquals("", actual);
	}

	@Test
	public void setColor_textBlank() {
		String actual = WebPageUtil.setColor("\t ", "red");
		assertEquals("", actual);
		actual = WebPageUtil.setColor(" ", "red");
		assertEquals("", actual);
	}

	@Test
	public void setColor_textNull() {
		String actual = WebPageUtil.setColor(null, "red");
		assertEquals("<span style='color: red;'>null</span>", actual);
	}

	@Test
	public void setColor_colorEmpty() {
		String actual = WebPageUtil.setColor("some text", "");
		assertEquals("some text", actual);
	}

	@Test
	public void setColor_colorBlank() {
		String actual = WebPageUtil.setColor("some text", "\t ");
		assertEquals("some text", actual);
	}

	@Test
	public void setColor_colorNull() {
		String actual = WebPageUtil.setColor("some text", null);
		assertEquals("some text", actual);
	}


	@Test
	public void setStyle_goodCases() {
		String expected;
		String actual;

		expected = "<span style='color: red; font-weight: bold; font-style: italic; text-decoration:underline;'>some text</span>";
		actual = WebPageUtil.setStyle("some text", "red", true, true, true);
		assertEquals(expected, actual);

		expected = "<span style='color: red;'>some text</span>";
		actual = WebPageUtil.setStyle("some text", "red", false, false, false);
		assertEquals(expected, actual);

		expected = "<span style='color: red; font-weight: bold;'>some text</span>";
		actual = WebPageUtil.setStyle("some text", "red", true, false, false);
		assertEquals(expected, actual);

		expected = "<span style='color: red; font-style: italic;'>some text</span>";
		actual = WebPageUtil.setStyle("some text", "red", false, true, false);
		assertEquals(expected, actual);

	}

	@Test
	public void setStyle_textEmpty() {
		String actual = WebPageUtil.setStyle("", "red", true, true, true);
		assertEquals("", actual);
	}

	@Test
	public void setStyle_textBlank() {
		String actual = WebPageUtil.setStyle("\t ", "red", true, true, true);
		assertEquals("", actual);
		actual = WebPageUtil.setStyle(" ", "red", true, true, true);
		assertEquals("", actual);
	}

	@Test
	public void setStyle_textNull() {
		String actual = WebPageUtil.setStyle(null, "red", true, true, true);
		String expected = "<span style='color: red; font-weight: bold; font-style: italic; text-decoration:underline;'>null</span>";
		assertEquals(expected, actual);
	}

	@Test
	public void setStyle_colorNull() {
		String actual = WebPageUtil.setStyle("some text", null, true, true, true);
		String expected = "<span style='font-weight: bold; font-style: italic; text-decoration:underline;'>some text</span>";
		assertEquals(expected, actual);
	}




}