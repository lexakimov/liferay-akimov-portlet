/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.isands.akimov.search.containers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import ru.isands.akimov.search.helpers.SearchHelper;

import javax.portlet.PortletException;

/**
 * @author akimov
 * created at 18.01.20 18:06
 */
public abstract class SearchContainer<T> extends com.liferay.portal.kernel.dao.search.SearchContainer<T> {

	public SearchContainer(SearchHelper<T> searchHelper) throws PortletException {
		super();

		/*PortletRequest request = this.getPortletRequest();
		String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
		String orderByType = ParamUtil.getString(portletRequest, "orderByType");*/

	/*	this.orderByCol = ParamUtil.getString(request, searchContainer.getOrderByColParam());
		this.orderByType = ParamUtil.getString(request, searchContainer.getOrderByTypeParam(), "asc");

		searchContainer.setOrderByCol(orderByCol);
		searchContainer.setOrderByType(orderByType);*/

		setResults(searchHelper.getResult(getStart(), getEnd()));
		setTotal(searchHelper.getTotal());
	}

	private static Log _log = LogFactoryUtil.getLog(SearchContainer.class);

}