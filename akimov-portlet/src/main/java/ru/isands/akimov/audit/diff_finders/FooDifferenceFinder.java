package ru.isands.akimov.audit.diff_finders;

import ru.isands.akimov.audit.exceptions.EntityFieldChangeDetectorException;
import ru.isands.akimov.model.Foo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FooDifferenceFinder extends ModelDifferenceFinder<Foo> {

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

		WATCH_ONLY_FIELDS = Collections.unmodifiableList(columns);
	}

	public FooDifferenceFinder(Foo old, Foo new_) throws EntityFieldChangeDetectorException {
		super(old, new_);
	}

	@Override
	List<String> getWatchOnlyFields() {
		return WATCH_ONLY_FIELDS;
	}
}