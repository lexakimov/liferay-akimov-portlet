package ru.isands.akimov.search_helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.search_helpers.DynamicQuerySearchHelper;

import javax.portlet.PortletException;

public class FooSearchHelper extends DynamicQuerySearchHelper<Foo> {
	private FooSearchHelper() {
		super(Foo.class);
	}

	public FooSearchHelper(SearchContainer<Foo> container) throws PortletException {
		this();
		container.setResults(this.getResult(container.getStart(), container.getEnd()));
		container.setTotal(this.getTotal());
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.asc("fooId"));

		return query;
	}
}
