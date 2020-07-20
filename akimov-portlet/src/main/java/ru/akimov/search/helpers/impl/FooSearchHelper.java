package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.akimov.model.Foo;
import ru.akimov.search.helpers.DynamicQuerySearchHelper;

import javax.portlet.PortletException;

public class FooSearchHelper extends DynamicQuerySearchHelper<Foo> {
	public FooSearchHelper() {
		super(Foo.class);
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.asc("fooId"));

		return query;
	}
}
