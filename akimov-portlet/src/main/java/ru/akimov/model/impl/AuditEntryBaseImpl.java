package ru.akimov.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import ru.akimov.model.AuditEntry;

import ru.akimov.service.AuditEntryLocalServiceUtil;

/**
 * The extended model base implementation for the AuditEntry service. Represents a row in the &quot;akimov_audit_action_entries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryImpl
 * @see ru.akimov.model.AuditEntry
 * @generated
 */
public abstract class AuditEntryBaseImpl extends AuditEntryModelImpl
    implements AuditEntry {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a Запись аудита model instance should use the {@link AuditEntry} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AuditEntryLocalServiceUtil.addAuditEntry(this);
        } else {
            AuditEntryLocalServiceUtil.updateAuditEntry(this);
        }
    }
}
