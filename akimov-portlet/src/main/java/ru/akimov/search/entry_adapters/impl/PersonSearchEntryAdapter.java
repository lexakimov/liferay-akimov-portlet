package ru.akimov.search.entry_adapters.impl;

import ru.akimov.model.Person;
import ru.akimov.search.entry_adapters.SearchEntryAdapter;
import ru.akimov.utils.WebPageUtil;
import ru.akimov.enums.Gender;

import javax.portlet.PortletException;
import java.text.SimpleDateFormat;

public class PersonSearchEntryAdapter extends SearchEntryAdapter<Person> {

	public PersonSearchEntryAdapter(Person model) throws PortletException {
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
		return !model.getAddress().isEmpty()
				? model.getAddress()
				: WebPageUtil.setColor("не указан", "gray");
	}

}
