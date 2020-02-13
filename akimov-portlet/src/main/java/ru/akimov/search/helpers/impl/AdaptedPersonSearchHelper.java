package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.akimov.model.Person;
import ru.akimov.search.helpers.AdaptedDynamicQuerySearchHelper;
import ru.akimov.search.entry_adapters.impl.PersonSearchEntryAdapter;

import javax.portlet.PortletException;

public class AdaptedPersonSearchHelper extends AdaptedDynamicQuerySearchHelper<PersonSearchEntryAdapter, Person> {

	public AdaptedPersonSearchHelper() {
		super(Person.class);
	}

	public AdaptedPersonSearchHelper(SearchContainer<PersonSearchEntryAdapter> container) throws PortletException {
		this();
		container.setResults(this.getAdaptedResult(container.getStart(), container.getEnd()));
		container.setTotal(this.getTotal());
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.asc("lastName"));
		query.addOrder(OrderFactoryUtil.asc("firstName"));
		return query;
	}

	@Override
	public PersonSearchEntryAdapter adapt(Person model) throws PortletException {
		return new PersonSearchEntryAdapter(model);
	}

}
