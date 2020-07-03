package ru.akimov.search.entry_dto.impl;

import ru.akimov.search.entry_dto.SearchEntryDTO;

import java.util.Date;

public class SqlEntity implements SearchEntryDTO {
	private long id;
	private String firstName;
	private String lastName;
	private Date birthDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
