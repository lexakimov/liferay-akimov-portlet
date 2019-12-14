package ru.isands.akimov.search_helpers.adapters;

public abstract class EntryAdapter<ADAPTABLE> {

	final ADAPTABLE model;

	EntryAdapter(ADAPTABLE model) {
		this.model = model;
	}

}
