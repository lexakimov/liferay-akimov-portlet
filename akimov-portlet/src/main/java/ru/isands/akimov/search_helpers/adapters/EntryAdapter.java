package ru.isands.akimov.search_helpers.adapters;

import javax.portlet.PortletException;

public abstract class EntryAdapter<T> {

	final T model;

	public EntryAdapter(T model) throws PortletException {
		this.model = model;
	}

}
