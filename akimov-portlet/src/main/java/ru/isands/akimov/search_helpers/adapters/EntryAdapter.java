package ru.isands.akimov.search_helpers.adapters;

public abstract class EntryAdapter<T> {

	final T model;

	EntryAdapter(T model) {
		this.model = model;
	}

}
