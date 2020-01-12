package ru.isands.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.isands.akimov.model.AuditEntry;

/**
 * The persistence interface for the audit entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryPersistenceImpl
 * @see AuditEntryUtil
 * @generated
 */
public interface AuditEntryPersistence extends BasePersistence<AuditEntry> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AuditEntryUtil} to access the audit entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the audit entry in the entity cache if it is enabled.
    *
    * @param auditEntry the audit entry
    */
    public void cacheResult(ru.isands.akimov.model.AuditEntry auditEntry);

    /**
    * Caches the audit entries in the entity cache if it is enabled.
    *
    * @param auditEntries the audit entries
    */
    public void cacheResult(
        java.util.List<ru.isands.akimov.model.AuditEntry> auditEntries);

    /**
    * Creates a new audit entry with the primary key. Does not add the audit entry to the database.
    *
    * @param id the primary key for the new audit entry
    * @return the new audit entry
    */
    public ru.isands.akimov.model.AuditEntry create(int id);

    /**
    * Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the audit entry
    * @return the audit entry that was removed
    * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.AuditEntry remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchAuditEntryException;

    public ru.isands.akimov.model.AuditEntry updateImpl(
        ru.isands.akimov.model.AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the audit entry with the primary key or throws a {@link ru.isands.akimov.NoSuchAuditEntryException} if it could not be found.
    *
    * @param id the primary key of the audit entry
    * @return the audit entry
    * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.AuditEntry findByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchAuditEntryException;

    /**
    * Returns the audit entry with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the audit entry
    * @return the audit entry, or <code>null</code> if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.AuditEntry fetchByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the audit entries.
    *
    * @return the audit entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.AuditEntry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the audit entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of audit entries
    * @param end the upper bound of the range of audit entries (not inclusive)
    * @return the range of audit entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.AuditEntry> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the audit entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of audit entries
    * @param end the upper bound of the range of audit entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of audit entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.AuditEntry> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the audit entries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of audit entries.
    *
    * @return the number of audit entries
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
