package ru.isands.akimov.search_helpers.adapters;

import ru.isands.akimov.search_helpers.AdaptedSearchHelper;

import javax.portlet.PortletException;

/**
 * Адаптер объекта результата поиска.
 *
 * @param <T> тип объекта, который адаприруем.
 * @author akimov
 * created at 14.12.19 18:55
 * @see AdaptedSearchHelper
 */
public abstract class EntryAdapter<T> {

	final T model;

	public EntryAdapter(T model) throws PortletException {
		this.model = model;
	}

}
