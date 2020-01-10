package ru.isands.akimov.search_helpers;

import ru.isands.akimov.model.Person;
import ru.isands.akimov.search_helpers.adapters.EntryAdapter;

import javax.portlet.PortletException;
import java.util.List;

public interface AdaptedSearchHelper<ADAPTER extends EntryAdapter<T>, T> extends SearchHelper<T> {

	EntryAdapter<Person> adapt(T model);

	List<ADAPTER> getAdaptedResult(int start, int end) throws PortletException;

	default List<ADAPTER> getAdaptedResult() throws PortletException {
		return getAdaptedResult(-1, -1);
	}
}
