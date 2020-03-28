package ru.akimov.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the AuditEntryGroup service. Represents a row in the &quot;akimov_audit_action_groups&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryGroupModel
 * @see ru.akimov.model.impl.AuditEntryGroupImpl
 * @see ru.akimov.model.impl.AuditEntryGroupModelImpl
 * @generated
 */
public interface AuditEntryGroup extends AuditEntryGroupModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link ru.akimov.model.impl.AuditEntryGroupImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Добавить запись аудита в текущую группу записей.
    */
    public void addEntry(ru.akimov.model.AuditEntry entry);

    public boolean hasEntries();
}
