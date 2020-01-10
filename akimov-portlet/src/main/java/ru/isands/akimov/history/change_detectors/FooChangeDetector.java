package ru.isands.akimov.history.change_detectors;

import ru.isands.akimov.history.exceptions.EntityFieldChangeDetectorException;
import ru.isands.akimov.model.Foo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FooChangeDetector extends ChangeDetector<Foo> {

	private static final List<String> WATCH_ONLY_FIELDS;

	static {
		// column names from service.xml
		List<String> temp = new ArrayList<>();

		temp.add("booleanField");
		temp.add("shortField");
		temp.add("intField");
		temp.add("longField");
		temp.add("doubleField");
		temp.add("floatField");
		temp.add("stringField");
		temp.add("dateField");
		temp.add("blobField");

		WATCH_ONLY_FIELDS = Collections.unmodifiableList(temp);
	}

	public FooChangeDetector(Foo old, Foo new_) throws EntityFieldChangeDetectorException {
		super(old, new_);
	}

	@Override
	List<String> getWatchOnlyFields() {
		return WATCH_ONLY_FIELDS;
	}
}
