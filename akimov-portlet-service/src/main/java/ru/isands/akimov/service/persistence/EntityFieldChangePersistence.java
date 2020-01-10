package ru.isands.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.isands.akimov.model.EntityFieldChange;

/**
 * The persistence interface for the entity field change service.
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
     * Never modify or reference this interface directly. Always use {@link EntityFieldChangeUtil} to access the entity field change persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the entity field change in the entity cache if it is enabled.
    *
    * @param entityFieldChange the entity field change
    */
    public void cacheResult(
        ru.isands.akimov.model.EntityFieldChange entityFieldChange);

    /**
    * Caches the entity field changes in the entity cache if it is enabled.
    *
    * @param entityFieldChanges the entity field changes
    */
    public void cacheResult(
        java.util.List<ru.isands.akimov.model.EntityFieldChange> entityFieldChanges);

    /**
    * Creates a new entity field change with the primary key. Does not add the entity field change to the database.
    *
    * @param id the primary key for the new entity field change
    * @return the new entity field change
    */
    public ru.isands.akimov.model.EntityFieldChange create(int id);

    /**
    * Removes the entity field change with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the entity field change
    * @return the entity field change that was removed
    * @throws ru.isands.akimov.NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.EntityFieldChange remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchEntityFieldChangeException;

    public ru.isands.akimov.model.EntityFieldChange updateImpl(
        ru.isands.akimov.model.EntityFieldChange entityFieldChange)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entity field change with the primary key or throws a {@link ru.isands.akimov.NoSuchEntityFieldChangeException} if it could not be found.
    *
    * @param id the primary key of the entity field change
    * @return the entity field change
    * @throws ru.isands.akimov.NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.EntityFieldChange findByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchEntityFieldChangeException;

    /**
    * Returns the entity field change with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the entity field change
    * @return the entity field change, or <code>null</code> if a entity field change with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.EntityFieldChange fetchByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the entity field changes.
    *
    * @return the entity field changes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.EntityFieldChange> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entity field changes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of entity field changes
    * @param end the upper bound of the range of entity field changes (not inclusive)
    * @return the range of entity field changes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.EntityFieldChange> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entity field changes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of entity field changes
    * @param end the upper bound of the range of entity field changes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of entity field changes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.EntityFieldChange> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the entity field changes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entity field changes.
    *
    * @return the number of entity field changes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
