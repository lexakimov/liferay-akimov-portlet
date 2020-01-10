package ru.isands.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.isands.akimov.model.EntityEditingHistory;

/**
 * The persistence interface for the entity editing history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityEditingHistoryPersistenceImpl
 * @see EntityEditingHistoryUtil
 * @generated
 */
public interface EntityEditingHistoryPersistence extends BasePersistence<EntityEditingHistory> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EntityEditingHistoryUtil} to access the entity editing history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the entity editing history in the entity cache if it is enabled.
    *
    * @param entityEditingHistory the entity editing history
    */
    public void cacheResult(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory);

    /**
    * Caches the entity editing histories in the entity cache if it is enabled.
    *
    * @param entityEditingHistories the entity editing histories
    */
    public void cacheResult(
        java.util.List<ru.isands.akimov.model.EntityEditingHistory> entityEditingHistories);

    /**
    * Creates a new entity editing history with the primary key. Does not add the entity editing history to the database.
    *
    * @param id the primary key for the new entity editing history
    * @return the new entity editing history
    */
    public ru.isands.akimov.model.EntityEditingHistory create(int id);

    /**
    * Removes the entity editing history with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history that was removed
    * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.EntityEditingHistory remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchEntityEditingHistoryException;

    public ru.isands.akimov.model.EntityEditingHistory updateImpl(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entity editing history with the primary key or throws a {@link ru.isands.akimov.NoSuchEntityEditingHistoryException} if it could not be found.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history
    * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.EntityEditingHistory findByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchEntityEditingHistoryException;

    /**
    * Returns the entity editing history with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history, or <code>null</code> if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.isands.akimov.model.EntityEditingHistory fetchByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the entity editing histories.
    *
    * @return the entity editing histories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.EntityEditingHistory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entity editing histories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityEditingHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of entity editing histories
    * @param end the upper bound of the range of entity editing histories (not inclusive)
    * @return the range of entity editing histories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.EntityEditingHistory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entity editing histories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityEditingHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of entity editing histories
    * @param end the upper bound of the range of entity editing histories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of entity editing histories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.isands.akimov.model.EntityEditingHistory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the entity editing histories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entity editing histories.
    *
    * @return the number of entity editing histories
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
