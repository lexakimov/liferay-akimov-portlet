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
		temp.add("name");
		temp.add("inn");
		temp.add("isManufacturer");
		temp.add("formManufacturer");
		temp.add("regAddress");
		temp.add("actualAddress");
		temp.add("certNumber");
		temp.add("certDate");
		temp.add("certAuthorityId");

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
