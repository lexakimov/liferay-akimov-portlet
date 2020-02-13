package ru.akimov.utils;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static ru.akimov.utils.DateUtil.DD_MM_YYYY__HH_MM_SS;

/**
 * @author akimov
 * created at 19.01.20 14:42
 */
public class DateUtilTest {

	Date date;

	@Before
	public void init() {
		//Sun Jan 19 14:43:37 NOVT 2020
		date = new Date(1579419817528L);
	}

	@Test
	public void showDate() {
		assertEquals("19.01.2020 07:43:37", DateUtil.showDate(date, DD_MM_YYYY__HH_MM_SS));
		assertEquals("", DateUtil.showDate(null, DD_MM_YYYY__HH_MM_SS));
	}

	@Test
	public void testShowDate() {
	}

	@Test
	public void parseDate() throws ParseException {
		assertNull(DateUtil.parseDate(null, DD_MM_YYYY__HH_MM_SS));
		assertNull(DateUtil.parseDate("", DD_MM_YYYY__HH_MM_SS));

		Date date_ = DateUtil.parseDate("19.01.2020 07:43:37", DD_MM_YYYY__HH_MM_SS);
		assertEquals(1579419817000L, date_.getTime());
	}

	@Test(expected = ParseException.class)
	public void parseBadDate() throws ParseException {
		DateUtil.parseDate("wrongDateString", DD_MM_YYYY__HH_MM_SS);
	}
}