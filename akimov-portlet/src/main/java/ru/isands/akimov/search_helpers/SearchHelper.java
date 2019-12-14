package ru.isands.akimov.search_helpers;

import javax.portlet.PortletException;
import java.util.List;

public interface SearchHelper<T> {

	int getTotal() throws PortletException;

	List<T> getResult(int start, int end) throws PortletException;

	default List<T> getResult() throws PortletException {
		return getResult(-1, -1);
	}

}
