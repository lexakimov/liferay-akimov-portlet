package ru.isands.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.isands.akimov.model.EntityEditingHistory;

import java.util.List;

/**
 * The persistence utility for the entity editing history service. This utility wraps {@link EntityEditingHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityEditingHistoryPersistence
 * @see EntityEditingHistoryPersistenceImpl
 * @generated
 */
public class EntityEditingHistoryUtil {
    private static EntityEditingHistoryPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(EntityEditingHistory entityEditingHistory) {
        getPersistence().clearCache(entityEditingHistory);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<EntityEditingHistory> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<EntityEditingHistory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<EntityEditingHistory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static EntityEditingHistory update(
        EntityEditingHistory entityEditingHistory) throws SystemException {
        return getPersistence().update(entityEditingHistory);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static EntityEditingHistory update(
        EntityEditingHistory entityEditingHistory, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(entityEditingHistory, serviceContext);
    }

    /**
    * Caches the entity editing history in the entity cache if it is enabled.
    *
    * @param entityEditingHistory the entity editing history
    */
    public static void cacheResult(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory) {
        getPersistence().cacheResult(entityEditingHistory);
    }

    /**
    * Caches the entity editing histories in the entity cache if it is enabled.
    *
    * @param entityEditingHistories the entity editing histories
    */
    public static void cacheResult(
        java.util.List<ru.isands.akimov.model.EntityEditingHistory> entityEditingHistories) {
        getPersistence().cacheResult(entityEditingHistories);
    }

    /**
    * Creates a new entity editing history with the primary key. Does not add the entity editing history to the database.
    *
    * @param id the primary key for the new entity editing history
    * @return the new entity editing history
    */
    public static ru.isands.akimov.model.EntityEditingHistory create(int id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the entity editing history with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history that was removed
    * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.akimov.model.EntityEditingHistory remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchEntityEditingHistoryException {
        return getPersistence().remove(id);
    }

    public static ru.isands.akimov.model.EntityEditingHistory updateImpl(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(entityEditingHistory);
    }

    /**
    * Returns the entity editing history with the primary key or throws a {@link ru.isands.akimov.NoSuchEntityEditingHistoryException} if it could not be found.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history
    * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.akimov.model.EntityEditingHistory findByPrimaryKey(
        int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchEntityEditingHistoryException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the entity editing history with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history, or <code>null</code> if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.akimov.model.EntityEditingHistory fetchByPrimaryKey(
        int id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the entity editing histories.
    *
    * @return the entity editing histories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.akimov.model.EntityEditingHistory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<ru.isands.akimov.model.EntityEditingHistory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<ru.isands.akimov.model.EntityEditingHistory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the entity editing histories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of entity editing histories.
    *
    * @return the number of entity editing histories
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EntityEditingHistoryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EntityEditingHistoryPersistence) PortletBeanLocatorUtil.locate(ru.isands.akimov.service.ClpSerializer.getServletContextName(),
                    EntityEditingHistoryPersistence.class.getName());

            ReferenceRegistry.registerReference(EntityEditingHistoryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EntityEditingHistoryPersistence persistence) {
    }
}
