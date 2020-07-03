package ru.akimov.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the AuditEntry service. Represents a row in the &quot;akimov_audit_action_entries&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryModel
 * @see ru.akimov.model.impl.AuditEntryImpl
 * @see ru.akimov.model.impl.AuditEntryModelImpl
 * @generated
 */
public interface AuditEntry extends AuditEntryModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link ru.akimov.model.impl.AuditEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Добавить к текущей записи аудита запись об изменении атрибута сущности.
    *
    * @param fieldName имя атрибута.
    * @param oldValue  старое значение.
    * @param newValue  новое значение.
    * @throws SystemException
    */
    public void addFieldChange(java.lang.String fieldName,
        java.lang.Object oldValue, java.lang.Object newValue)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @return true если запись истории изменения имеет закрепленные за собой записи об изменениях атрибутов сущности.
    */
    public boolean hasFieldChanges();

    public long getUserId()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
