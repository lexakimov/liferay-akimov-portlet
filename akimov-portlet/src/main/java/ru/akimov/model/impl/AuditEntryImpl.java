package ru.akimov.model.impl;

import ru.akimov.model.AuditEntry;

/**
 * The extended model implementation for the AuditEntry service. Represents a row in the &quot;akimov_audit_entries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link AuditEntry} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class AuditEntryImpl extends AuditEntryBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a audit entry model instance should use the {@link ru.akimov.model.AuditEntry} interface instead.
     */
    public AuditEntryImpl() {
    }
}
