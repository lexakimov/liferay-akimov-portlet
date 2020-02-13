package ru.akimov.audit.description;

import ru.akimov.model.AuditEntry;

/**
 * @author akimov
 * created at 25.01.20 17:44
 */
public interface DescriptionAdapter {

	String adapt(AuditEntry entry);

}
