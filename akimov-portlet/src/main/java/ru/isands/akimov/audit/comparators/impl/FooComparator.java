package ru.isands.akimov.audit.comparators.impl;

import ru.isands.akimov.audit.comparators.ModelComparator;
import ru.isands.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.isands.akimov.model.Foo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FooComparator extends ModelComparator<Foo> {

	private static final List<String> WATCH_ONLY_FIELDS;

	static {
		// column names from service.xml
		List<String> columns = new ArrayList<>();

		columns.add("booleanField");
		columns.add("shortField");
		columns.add("intField");
		columns.add("longField");
		columns.add("doubleField");
		columns.add("floatField");
		columns.add("stringField");
		columns.add("dateField");
		columns.add("blobField");
		columns.add("status");

		WATCH_ONLY_FIELDS = Collections.unmodifiableList(columns);
	}

	public FooComparator(Foo old, Foo new_) throws NoSuchModelAttributeException {
		super(old, new_);
	}

	@Override
	protected List<String> getWatchOnlyFields() {
		return WATCH_ONLY_FIELDS;
	}


}
