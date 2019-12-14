package ru.isands.akimov.search_helpers;

import ru.isands.akimov.model.Person;
import ru.isands.akimov.search_helpers.adapters.PersonEntryAdapter;
import ru.isands.akimov.search_helpers.adapters.EntryAdapter;

import javax.portlet.PortletException;
import java.util.List;

public interface AdaptedSearchHelper<ADAPTER extends PersonEntryAdapter, ADAPTABLE> extends SearchHelper<ADAPTABLE> {

	EntryAdapter<Person> adapt(ADAPTABLE model);

	List<ADAPTER> getAdaptedResult(int start, int end) throws PortletException;

	default List<ADAPTER> getAdaptedResult() throws PortletException {
		return getAdaptedResult(-1, -1);
	}
}
