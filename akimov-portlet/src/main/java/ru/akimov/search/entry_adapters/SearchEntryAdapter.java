package ru.akimov.search.entry_adapters;

import ru.akimov.search.helpers.AdaptedSearchHelper;

import javax.portlet.PortletException;

/**
 * Адаптер объекта результата поиска.
 *
 * @param <T> тип объекта, который адаприруем.
 * @author akimov
 * created at 14.12.19 18:55
 * @see AdaptedSearchHelper
 */
public abstract class SearchEntryAdapter<T> {

	protected final T model;

	public SearchEntryAdapter(T model) throws PortletException {
		this.model = model;
	}

}
