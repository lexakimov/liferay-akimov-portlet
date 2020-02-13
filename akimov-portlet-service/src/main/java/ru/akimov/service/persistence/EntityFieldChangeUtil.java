package ru.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.akimov.NoSuchEntityFieldChangeException;
import ru.akimov.model.EntityFieldChange;
import ru.akimov.service.ClpSerializer;

import java.util.List;

/**
 * The persistence utility for the entity field change service. This utility wraps {@link EntityFieldChangePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityFieldChangePersistence
 * @see EntityFieldChangePersistenceImpl
 * @generated
 */
public class EntityFieldChangeUtil {
    private static EntityFieldChangePersistence _persistence;

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
    public static void clearCache(EntityFieldChange entityFieldChange) {
        getPersistence().clearCache(entityFieldChange);
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
    public static List<EntityFieldChange> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<EntityFieldChange> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<EntityFieldChange> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static EntityFieldChange update(EntityFieldChange entityFieldChange)
        throws SystemException {
        return getPersistence().update(entityFieldChange);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static EntityFieldChange update(
        EntityFieldChange entityFieldChange, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(entityFieldChange, serviceContext);
    }

    /**
    * Caches the entity field change in the entity cache if it is enabled.
    *
    * @param entityFieldChange the entity field change
    */
    public static void cacheResult(
        EntityFieldChange entityFieldChange) {
        getPersistence().cacheResult(entityFieldChange);
    }

    /**
    * Caches the entity field changes in the entity cache if it is enabled.
    *
    * @param entityFieldChanges the entity field changes
    */
    public static void cacheResult(
        java.util.List<EntityFieldChange> entityFieldChanges) {
        getPersistence().cacheResult(entityFieldChanges);
    }

    /**
    * Creates a new entity field change with the primary key. Does not add the entity field change to the database.
    *
    * @param id the primary key for the new entity field change
    * @return the new entity field change
    */
    public static EntityFieldChange create(int id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the entity field change with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the entity field change
    * @return the entity field change that was removed
    * @throws NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static EntityFieldChange remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
			NoSuchEntityFieldChangeException {
        return getPersistence().remove(id);
    }

    public static EntityFieldChange updateImpl(
        EntityFieldChange entityFieldChange)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(entityFieldChange);
    }

    /**
    * Returns the entity field change with the primary key or throws a {@link NoSuchEntityFieldChangeException} if it could not be found.
    *
    * @param id the primary key of the entity field change
    * @return the entity field change
    * @throws NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static EntityFieldChange findByPrimaryKey(
        int id)
        throws com.liferay.portal.kernel.exception.SystemException,
			NoSuchEntityFieldChangeException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the entity field change with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the entity field change
    * @return the entity field change, or <code>null</code> if a entity field change with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static EntityFieldChange fetchByPrimaryKey(
        int id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the entity field changes.
    *
    * @return the entity field changes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<EntityFieldChange> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<EntityFieldChange> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<EntityFieldChange> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the entity field changes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of entity field changes.
    *
    * @return the number of entity field changes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EntityFieldChangePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EntityFieldChangePersistence) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EntityFieldChangePersistence.class.getName());

            ReferenceRegistry.registerReference(EntityFieldChangeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EntityFieldChangePersistence persistence) {
    }
}
