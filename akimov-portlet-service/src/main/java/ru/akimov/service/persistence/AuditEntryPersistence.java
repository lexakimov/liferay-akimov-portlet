package ru.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.akimov.model.AuditEntry;

/**
 * The persistence interface for the Запись аудита service.
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
     * Never modify or reference this interface directly. Always use {@link AuditEntryUtil} to access the Запись аудита persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the Запись аудитаs where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @return the matching Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntry> findByEntryGroupId(
        int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the Запись аудитаs where entryGroupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryGroupId the entry group ID
    * @param start the lower bound of the range of Запись аудитаs
    * @param end the upper bound of the range of Запись аудитаs (not inclusive)
    * @return the range of matching Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntry> findByEntryGroupId(
        int entryGroupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the Запись аудитаs where entryGroupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryGroupId the entry group ID
    * @param start the lower bound of the range of Запись аудитаs
    * @param end the upper bound of the range of Запись аудитаs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntry> findByEntryGroupId(
        int entryGroupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Запись аудита
    * @throws ru.akimov.NoSuchAuditEntryException if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry findByEntryGroupId_First(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException;

    /**
    * Returns the first Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Запись аудита, or <code>null</code> if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry fetchByEntryGroupId_First(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Запись аудита
    * @throws ru.akimov.NoSuchAuditEntryException if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry findByEntryGroupId_Last(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException;

    /**
    * Returns the last Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Запись аудита, or <code>null</code> if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry fetchByEntryGroupId_Last(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Запись аудитаs before and after the current Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryId the primary key of the current Запись аудита
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next Запись аудита
    * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry[] findByEntryGroupId_PrevAndNext(
        int entryId, int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException;

    /**
    * Removes all the Запись аудитаs where entryGroupId = &#63; from the database.
    *
    * @param entryGroupId the entry group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByEntryGroupId(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of Запись аудитаs where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @return the number of matching Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public int countByEntryGroupId(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the Запись аудита in the entity cache if it is enabled.
    *
    * @param auditEntry the Запись аудита
    */
    public void cacheResult(ru.akimov.model.AuditEntry auditEntry);

    /**
    * Caches the Запись аудитаs in the entity cache if it is enabled.
    *
    * @param auditEntries the Запись аудитаs
    */
    public void cacheResult(
        java.util.List<ru.akimov.model.AuditEntry> auditEntries);

    /**
    * Creates a new Запись аудита with the primary key. Does not add the Запись аудита to the database.
    *
    * @param entryId the primary key for the new Запись аудита
    * @return the new Запись аудита
    */
    public ru.akimov.model.AuditEntry create(int entryId);

    /**
    * Removes the Запись аудита with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита that was removed
    * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry remove(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException;

    public ru.akimov.model.AuditEntry updateImpl(
        ru.akimov.model.AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Запись аудита with the primary key or throws a {@link ru.akimov.NoSuchAuditEntryException} if it could not be found.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита
    * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry findByPrimaryKey(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException;

    /**
    * Returns the Запись аудита with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита, or <code>null</code> if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntry fetchByPrimaryKey(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the Запись аудитаs.
    *
    * @return the Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the Запись аудитаs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Запись аудитаs
    * @param end the upper bound of the range of Запись аудитаs (not inclusive)
    * @return the range of Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntry> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the Запись аудитаs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Запись аудитаs
    * @param end the upper bound of the range of Запись аудитаs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntry> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the Запись аудитаs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of Запись аудитаs.
    *
    * @return the number of Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
