package ru.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.akimov.model.AuditEntryGroup;

/**
 * The persistence interface for the Группа записей аудита service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryGroupPersistenceImpl
 * @see AuditEntryGroupUtil
 * @generated
 */
public interface AuditEntryGroupPersistence extends BasePersistence<AuditEntryGroup> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AuditEntryGroupUtil} to access the Группа записей аудита persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the Группа записей аудита in the entity cache if it is enabled.
    *
    * @param auditEntryGroup the Группа записей аудита
    */
    public void cacheResult(ru.akimov.model.AuditEntryGroup auditEntryGroup);

    /**
    * Caches the Группа записей аудитаs in the entity cache if it is enabled.
    *
    * @param auditEntryGroups the Группа записей аудитаs
    */
    public void cacheResult(
        java.util.List<ru.akimov.model.AuditEntryGroup> auditEntryGroups);

    /**
    * Creates a new Группа записей аудита with the primary key. Does not add the Группа записей аудита to the database.
    *
    * @param entryGroupId the primary key for the new Группа записей аудита
    * @return the new Группа записей аудита
    */
    public ru.akimov.model.AuditEntryGroup create(int entryGroupId);

    /**
    * Removes the Группа записей аудита with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита that was removed
    * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntryGroup remove(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryGroupException;

    public ru.akimov.model.AuditEntryGroup updateImpl(
        ru.akimov.model.AuditEntryGroup auditEntryGroup)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Группа записей аудита with the primary key or throws a {@link ru.akimov.NoSuchAuditEntryGroupException} if it could not be found.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита
    * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntryGroup findByPrimaryKey(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryGroupException;

    /**
    * Returns the Группа записей аудита with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита, or <code>null</code> if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AuditEntryGroup fetchByPrimaryKey(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the Группа записей аудитаs.
    *
    * @return the Группа записей аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntryGroup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the Группа записей аудитаs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Группа записей аудитаs
    * @param end the upper bound of the range of Группа записей аудитаs (not inclusive)
    * @return the range of Группа записей аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntryGroup> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the Группа записей аудитаs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Группа записей аудитаs
    * @param end the upper bound of the range of Группа записей аудитаs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of Группа записей аудитаs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AuditEntryGroup> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the Группа записей аудитаs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of Группа записей аудитаs.
    *
    * @return the number of Группа записей аудитаs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
