package ru.isands.akimov.search_helpers.adapters;

import ru.isands.akimov.enums.Gender;
import ru.isands.akimov.model.Person;

import javax.portlet.PortletException;
import java.text.SimpleDateFormat;

public class PersonEntryAdapter extends EntryAdapter<Person> {

	public PersonEntryAdapter(Person model) throws PortletException {
		super(model);
	}

	public String getFio() {
		return String.join(" ", model.getLastName(), model.getFirstName(), model.getMiddleName());
	}

	public String getBirthDate() {
		return new SimpleDateFormat("dd/MMM/yyyy").format(model.getBirthDate());
	}

	public String getGender() {
		return Gender.getByOrdinal(model.getGender()).getLabel();
	}

	public String getAddress() {
		return !model.getAddress().isEmpty() ? model.getAddress() : "<span style='color: gray;'>не указан</span>";
	}

}
