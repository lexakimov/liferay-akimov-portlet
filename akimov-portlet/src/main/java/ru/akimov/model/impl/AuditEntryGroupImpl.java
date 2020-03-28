package ru.akimov.model.impl;

import ru.akimov.model.AuditEntry;

import java.util.ArrayList;
import java.util.List;

public class AuditEntryGroupImpl extends AuditEntryGroupBaseImpl {

	public List<AuditEntry> entries;

	public AuditEntryGroupImpl() {
		entries = new ArrayList<>();
	}

	/**
	 * Добавить запись аудита в текущую группу записей.
	 */
	public void addEntry(AuditEntry entry) {
		entry.setEntryGroupId(getEntryGroupId());
		entries.add(entry);
	}

	public boolean hasEntries() {
		return !entries.isEmpty();
	}

}
