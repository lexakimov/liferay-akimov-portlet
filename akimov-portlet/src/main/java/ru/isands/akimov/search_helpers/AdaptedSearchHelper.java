package ru.isands.akimov.search_helpers;

import ru.isands.akimov.search_helpers.adapters.EntryAdapter;

import javax.portlet.PortletException;
import java.util.ArrayList;
import java.util.List;

public interface AdaptedSearchHelper<ADAPTER extends EntryAdapter<T>, T> extends SearchHelper<T> {

	ADAPTER adapt(T model) throws PortletException;

	default List<ADAPTER> getAdaptedResult() throws PortletException {
		return getAdaptedResult(-1, -1);
	}

	default List<ADAPTER> getAdaptedResult(int start, int end) throws PortletException {
		List<T> result = getResult(start, end);

		List<ADAPTER> adapted = new ArrayList<>(result.size());
		for (T t : result) {
			adapted.add(adapt(t));
		}
		return adapted;
	}
}
