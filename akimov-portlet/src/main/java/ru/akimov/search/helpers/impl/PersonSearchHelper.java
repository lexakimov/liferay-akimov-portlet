package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.akimov.model.Person;
import ru.akimov.search.helpers.DynamicQuerySearchHelper;

import javax.portlet.PortletException;

public class PersonSearchHelper extends DynamicQuerySearchHelper<Person> {

	public PersonSearchHelper() {
		super(Person.class);
	}

	public PersonSearchHelper(SearchContainer<Person> container) throws PortletException {
		this();
		container.setResults(this.getResult(container.getStart(), container.getEnd()));
		container.setTotal(this.getTotal());
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.asc("lastName"));
		query.addOrder(OrderFactoryUtil.asc("firstName"));
		return query;
	}
}
