package ru.akimov.utils;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.portlet.PortletRequest;
import java.util.ArrayList;
import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author akimov
 * created at 18.01.20 18:34
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {LogFactoryUtil.class, ParamUtil.class})
public class TabHelperTest {

	@Test
	public void add() {
		TabHelper tabHelper = new TabHelper();
		tabHelper.add("someValue", "КакойтоТекст");
	}

	@Test(expected = IllegalArgumentException.class)
	public void addValueWithComma() {
		TabHelper tabHelper = new TabHelper();
		tabHelper.add("some,Value", "КакойтоТекст");
	}

	@Test(expected = IllegalArgumentException.class)
	public void addNameWithComma() {
		TabHelper tabHelper = new TabHelper();
		tabHelper.add("someValue", "Какойто,Текст");
	}

	@Test
	public void getFirstValue() {
		TabHelper tabHelper = new TabHelper();
		tabHelper.add("someValue", "КакойтоТекст");
		String firstValue = tabHelper.getFirstValue();
		assertEquals("someValue", firstValue);
	}

	@Test
	public void hasValue() {
		TabHelper tabHelper = new TabHelper();
		assertFalse(tabHelper.hasValue("someValue"));
		tabHelper.add("someValue", "КакойтоТекст");
		assertTrue(tabHelper.hasValue("someValue"));
	}

	@Test
	public void getTabNames() {
		TabHelper tabHelper = new TabHelper();
		assertEquals(tabHelper.getTabNames(), Collections.emptyList());
		tabHelper.add("someValue", "КакойтоТекст");
		ArrayList<Object> expected = new ArrayList<>();
		expected.add("КакойтоТекст");
		assertEquals(expected, tabHelper.getTabNames());
	}

	@Test
	public void getTabValues() {
		TabHelper tabHelper = new TabHelper();
		assertEquals(tabHelper.getTabValues(), Collections.emptyList());
		tabHelper.add("someValue", "КакойтоТекст");
		ArrayList<Object> expected = new ArrayList<>();
		expected.add("someValue");
		assertEquals(expected, tabHelper.getTabValues());
	}

	@Test
	public void getTabNamesArray() {
		TabHelper tabHelper = new TabHelper();
		assertArrayEquals(new String[0], tabHelper.getTabNamesArray());
		tabHelper.add("someValue", "КакойтоТекст");
		assertArrayEquals(new String[]{"КакойтоТекст"}, tabHelper.getTabNamesArray());
	}

	@Test
	public void getTabValuesArray() {
		TabHelper tabHelper = new TabHelper();
		assertArrayEquals(new String[0], tabHelper.getTabValuesArray());
		tabHelper.add("someValue", "КакойтоТекст");
		assertArrayEquals(new String[]{"someValue"}, tabHelper.getTabValuesArray());
	}

	@Test
	public void getTabNamesString() {
		TabHelper tabHelper = new TabHelper();
		assertEquals(tabHelper.getTabNamesString(), "");
		tabHelper.add("someValue", "КакойтоТекст");
		assertEquals(tabHelper.getTabNamesString(), "КакойтоТекст");
		tabHelper.add("someValue1", "КакойтоТекст1");
		assertEquals(tabHelper.getTabNamesString(), "КакойтоТекст,КакойтоТекст1");
	}

	@Test
	public void getTabValuesString() {
		TabHelper tabHelper = new TabHelper();
		assertEquals(tabHelper.getTabValuesString(), "");
		tabHelper.add("someValue", "КакойтоТекст");
		assertEquals(tabHelper.getTabValuesString(), "someValue");
		tabHelper.add("someValue1", "КакойтоТекст1");
		assertEquals(tabHelper.getTabValuesString(), "someValue,someValue1");
	}

	@Test
	public void setRequestAttributeFirst() {
		TabHelper tabHelper = new TabHelper();
		tabHelper.add("someValue1", "КакойтоТекст1");
		tabHelper.add("someValue2", "КакойтоТекст2");
		tabHelper.add("someValue3", "КакойтоТекст3");

		PowerMockito.mockStatic(ParamUtil.class);
		when(ParamUtil.getString(any(PortletRequest.class), eq("active_tab_blabla"))).thenReturn("");
		PortletRequest request = PowerMockito.mock(PortletRequest.class);
		tabHelper.setAttribute(request, "active_tab_blabla");
		Mockito.verify(request, times(1)).setAttribute("active_tab_blabla", "someValue1");
	}

	@Test
	public void setRequestAttributeGood() {
		TabHelper tabHelper = new TabHelper();
		tabHelper.add("someValue1", "КакойтоТекст1");
		tabHelper.add("someValue2", "КакойтоТекст2");
		tabHelper.add("someValue3", "КакойтоТекст3");

		PowerMockito.mockStatic(ParamUtil.class);
		when(ParamUtil.getString(any(PortletRequest.class), eq("active_tab_blabla"))).thenReturn("someValue2");
		PortletRequest request = PowerMockito.mock(PortletRequest.class);
		tabHelper.setAttribute(request, "active_tab_blabla");
		Mockito.verify(request, times(1)).setAttribute("active_tab_blabla", "someValue2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void setRequestAttributeBad() {
		TabHelper tabHelper = new TabHelper();
		tabHelper.add("someValue1", "КакойтоТекст1");
		tabHelper.add("someValue2", "КакойтоТекст2");
		tabHelper.add("someValue3", "КакойтоТекст3");

		PowerMockito.mockStatic(ParamUtil.class);
		when(ParamUtil.getString(any(PortletRequest.class), eq("active_tab_blabla"))).thenReturn("badValue");
		PortletRequest request = PowerMockito.mock(PortletRequest.class);
		tabHelper.setAttribute(request, "active_tab_blabla");
	}


}