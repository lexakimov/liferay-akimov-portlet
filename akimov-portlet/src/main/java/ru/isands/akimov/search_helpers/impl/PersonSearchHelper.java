package ru.isands.akimov.search_helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.isands.akimov.model.Person;
import ru.isands.akimov.search_helpers.DynamicQuerySearchHelper;

import javax.portlet.PortletException;

public class PersonSearchHelper extends DynamicQuerySearchHelper<Person> {

	public PersonSearchHelper() {
		super(Person.class);
	}

	public PersonSearchHelper(SearchContainer<Person> container) throws PortletException {
		super(Person.class, container);
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.asc("lastName"));
		query.addOrder(OrderFactoryUtil.asc("firstName"));
		return query;
	}
}