package ru.akimov.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.ParamUtil;
import ru.akimov.search.helpers.AdaptedSearchHelper;
import ru.akimov.search.helpers.OrderableSearchHelper;
import ru.akimov.search.helpers.SearchHelper;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

/**
 * @author akimov
 * created at 16.07.2020 12:32
 */
public class SearchResultsBinder {

	/**
	 * Связать SearchContainer с SearchHelper
	 * @param container контейнер с JSP
	 * @param helper    объект для поиска данных
	 * @param <T>       тип модели
	 * @throws PortletException
	 */
	public static <T> void bind(SearchContainer<T> container, SearchHelper<T> helper) throws PortletException {
		PortletRequest request = container.getPortletRequest();

		if (helper instanceof OrderableSearchHelper) {
			OrderableSearchHelper<T> orderableHelper = (OrderableSearchHelper<T>) helper;

			String defaultOrderByCol = orderableHelper.getDefaultOrderByCol();
			String orderByCol = ParamUtil.getString(request, container.getOrderByColParam(), defaultOrderByCol);
			String orderByType = ParamUtil.getString(request, container.getOrderByTypeParam(), null);

			// liferay bugfix
			if (String.valueOf(orderByType).equals("null")) {
				orderByType = orderableHelper.getDefaultOrderByType();
			}
			container.setOrderByCol(orderByCol);
			container.setOrderByType(orderByType);

			orderableHelper.setOrderByCol(orderByCol);
			orderableHelper.setOrderByType(orderByType);
		}

		container.setTotal(helper.getTotal());
		int start = container.getStart();
		int end = container.getEnd();

		if (helper instanceof AdaptedSearchHelper) {
			AdaptedSearchHelper adaptedHelper = (AdaptedSearchHelper) helper;
			container.setResults(adaptedHelper.getAdaptedResult(start, end));
		} else {
			container.setResults(helper.getResult(start, end));
		}

		// add default empty message
		String emptyResultsMessage = container.getEmptyResultsMessage();
		if (emptyResultsMessage == null) {
			container.setEmptyResultsMessage("Ничего не найдено");
		}
	}
}
