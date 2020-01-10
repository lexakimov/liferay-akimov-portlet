package ru.isands.akimov.search_helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.isands.akimov.model.Person;
import ru.isands.akimov.search_helpers.AdaptedDynamicQuerySearchHelper;
import ru.isands.akimov.search_helpers.adapters.PersonEntryAdapter;

import javax.portlet.PortletException;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptedPersonSearchHelper extends AdaptedDynamicQuerySearchHelper<PersonEntryAdapter, Person> {

	public AdaptedPersonSearchHelper() {
		super(Person.class);
	}

	public AdaptedPersonSearchHelper(SearchContainer<PersonEntryAdapter> container) throws PortletException {
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
	public PersonEntryAdapter adapt(Person model) {
		return new PersonEntryAdapter(model);
	}

	@Override
	public List<PersonEntryAdapter> getAdaptedResult(int start, int end) throws PortletException {
		List<Person> result = getResult(start, end);
		return result.stream().map(this::adapt).collect(Collectors.toList());
	}
}
