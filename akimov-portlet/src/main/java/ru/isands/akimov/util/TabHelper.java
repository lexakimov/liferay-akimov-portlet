package ru.isands.akimov.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.PortletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс-обёртка над листами, упрощающий определение вкладок для тега liferay-ui:tabs.
 *
 * @author akimov
 * created at 13.01.20 14:31
 */
public final class TabHelper {

	public static final Log log = LogFactoryUtil.getLog(TabHelper.class);

	private List<String> tabNames;

	private List<String> tabValues;

	public TabHelper() {
		this.tabNames = new ArrayList<>();
		this.tabValues = new ArrayList<>();
	}

	/**
	 * Добавить пару ключ-значение. Запрещается использовать запятые напрямую, но можно использовать спецсимвол &sbquo;
	 *
	 * @param tabValue - значение, используется как параметр урла.
	 * @param tabName  - название вкладки.
	 * @throws IllegalArgumentException если была запятая.
	 */
	public void add(String tabValue, String tabName) throws IllegalArgumentException {
		String nameTrimmed = tabName.trim();
		String valueTrimmed = tabValue.trim();

		if (nameTrimmed.contains(",") || valueTrimmed.contains(",")) {
			throw new IllegalArgumentException(
					String.format("в названии вкладки не должно быть запятых; '%s' - '%s'", valueTrimmed, nameTrimmed));
		}
		if (nameTrimmed.isEmpty() || valueTrimmed.isEmpty()) {
			log.warn(String.format("пустое название вкладки или её параметра: '%s' - '%s'", valueTrimmed, nameTrimmed));
		}
		if (tabNames.contains(nameTrimmed)) {
			log.warn(String.format("список названий вкладок уже содержит: '%s'", nameTrimmed));
		}
		if (tabValues.contains(valueTrimmed)) {
			log.warn(String.format("список параметров вкладок уже содержит: '%s'", valueTrimmed));
		}

		tabNames.add(nameTrimmed);
		tabValues.add(valueTrimmed);
	}

	public String getFirstValue() {
		return !tabValues.isEmpty() ? tabValues.get(0) : StringPool.BLANK;
	}

	public boolean hasValue(String tabValue) {
		return tabValues.contains(tabValue);
	}

	public List<String> getTabNames() {
		return tabNames;
	}

	public List<String> getTabValues() {
		return tabValues;
	}

	public String[] getTabNamesArray() {
		return tabNames.toArray(new String[0]);
	}

	public String[] getTabValuesArray() {
		return tabValues.toArray(new String[0]);
	}

	public String getTabNamesString() {
		return StringUtil.merge(tabNames, ",");
	}

	public String getTabValuesString() {
		return StringUtil.merge(tabValues, ",");
	}

	/**
	 * Позволяет задать запросу строковый аттрибут текущей выбранной вкладки.
	 *
	 * @param request
	 * @param attributeName
	 */
	public void setAttribute(PortletRequest request, String attributeName) {
		String activeTab = ParamUtil.getString(request, attributeName);

		if (!activeTab.isEmpty() && !tabValues.contains(activeTab)) {
			throw new IllegalArgumentException("unknown tab name: " + activeTab);
		}

		if (activeTab.isEmpty()) {
			activeTab = getFirstValue();
		}
		request.setAttribute(attributeName, activeTab);
	}

}
