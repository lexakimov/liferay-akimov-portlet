package ru.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.akimov.model.EntityFieldChange;

/**
 * The persistence interface for the Изменение атрибута сущности service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityFieldChangePersistenceImpl
 * @see EntityFieldChangeUtil
 * @generated
 */
public interface EntityFieldChangePersistence extends BasePersistence<EntityFieldChange> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EntityFieldChangeUtil} to access the Изменение атрибута сущности persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the Изменение атрибута сущностиs where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @return the matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.EntityFieldChange> findByEntryId(
        int entryId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the Изменение атрибута сущностиs where entryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryId the entry ID
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @return the range of matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.EntityFieldChange> findByEntryId(
        int entryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the Изменение атрибута сущностиs where entryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryId the entry ID
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.EntityFieldChange> findByEntryId(
        int entryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange findByEntryId_First(int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException;

    /**
    * Returns the first Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Изменение атрибута сущности, or <code>null</code> if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange fetchByEntryId_First(int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange findByEntryId_Last(int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException;

    /**
    * Returns the last Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Изменение атрибута сущности, or <code>null</code> if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange fetchByEntryId_Last(int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Изменение атрибута сущностиs before and after the current Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param fieldChangeId the primary key of the current Изменение атрибута сущности
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange[] findByEntryId_PrevAndNext(
        int fieldChangeId, int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException;

    /**
    * Removes all the Изменение атрибута сущностиs where entryId = &#63; from the database.
    *
    * @param entryId the entry ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByEntryId(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of Изменение атрибута сущностиs where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @return the number of matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public int countByEntryId(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the Изменение атрибута сущности in the entity cache if it is enabled.
    *
    * @param entityFieldChange the Изменение атрибута сущности
    */
    public void cacheResult(ru.akimov.model.EntityFieldChange entityFieldChange);

    /**
    * Caches the Изменение атрибута сущностиs in the entity cache if it is enabled.
    *
    * @param entityFieldChanges the Изменение атрибута сущностиs
    */
    public void cacheResult(
        java.util.List<ru.akimov.model.EntityFieldChange> entityFieldChanges);

    /**
    * Creates a new Изменение атрибута сущности with the primary key. Does not add the Изменение атрибута сущности to the database.
    *
    * @param fieldChangeId the primary key for the new Изменение атрибута сущности
    * @return the new Изменение атрибута сущности
    */
    public ru.akimov.model.EntityFieldChange create(int fieldChangeId);

    /**
    * Removes the Изменение атрибута сущности with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности that was removed
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange remove(int fieldChangeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException;

    public ru.akimov.model.EntityFieldChange updateImpl(
        ru.akimov.model.EntityFieldChange entityFieldChange)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Изменение атрибута сущности with the primary key or throws a {@link ru.akimov.NoSuchEntityFieldChangeException} if it could not be found.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange findByPrimaryKey(int fieldChangeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException;

    /**
    * Returns the Изменение атрибута сущности with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности, or <code>null</code> if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.EntityFieldChange fetchByPrimaryKey(
        int fieldChangeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the Изменение атрибута сущностиs.
    *
    * @return the Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.EntityFieldChange> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the Изменение атрибута сущностиs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @return the range of Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.EntityFieldChange> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the Изменение атрибута сущностиs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.EntityFieldChange> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the Изменение атрибута сущностиs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of Изменение атрибута сущностиs.
    *
    * @return the number of Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
