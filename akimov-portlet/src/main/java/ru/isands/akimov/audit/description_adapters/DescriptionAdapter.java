package ru.isands.akimov.audit.description_adapters;

import ru.isands.akimov.model.AuditEntry;

/**
 * @author akimov
 * created at 25.01.20 17:44
 */
public interface DescriptionAdapter {

	String adapt(AuditEntry entry);

}
