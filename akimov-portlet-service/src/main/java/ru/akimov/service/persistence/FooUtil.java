package ru.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.akimov.model.Foo;

import java.util.List;

/**
 * The persistence utility for the foo service. This utility wraps {@link FooPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FooPersistence
 * @see FooPersistenceImpl
 * @generated
 */
public class FooUtil {
    private static FooPersistence _persistence;

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
    public static void clearCache(Foo foo) {
        getPersistence().clearCache(foo);
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
    public static List<Foo> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Foo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Foo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Foo update(Foo foo) throws SystemException {
        return getPersistence().update(foo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Foo update(Foo foo, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(foo, serviceContext);
    }

    /**
    * Caches the foo in the entity cache if it is enabled.
    *
    * @param foo the foo
    */
    public static void cacheResult(ru.akimov.model.Foo foo) {
        getPersistence().cacheResult(foo);
    }

    /**
    * Caches the foos in the entity cache if it is enabled.
    *
    * @param foos the foos
    */
    public static void cacheResult(java.util.List<ru.akimov.model.Foo> foos) {
        getPersistence().cacheResult(foos);
    }

    /**
    * Creates a new foo with the primary key. Does not add the foo to the database.
    *
    * @param fooId the primary key for the new foo
    * @return the new foo
    */
    public static ru.akimov.model.Foo create(int fooId) {
        return getPersistence().create(fooId);
    }

    /**
    * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fooId the primary key of the foo
    * @return the foo that was removed
    * @throws ru.akimov.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.Foo remove(int fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchFooException {
        return getPersistence().remove(fooId);
    }

    public static ru.akimov.model.Foo updateImpl(ru.akimov.model.Foo foo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(foo);
    }

    /**
    * Returns the foo with the primary key or throws a {@link ru.akimov.NoSuchFooException} if it could not be found.
    *
    * @param fooId the primary key of the foo
    * @return the foo
    * @throws ru.akimov.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.Foo findByPrimaryKey(int fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchFooException {
        return getPersistence().findByPrimaryKey(fooId);
    }

    /**
    * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fooId the primary key of the foo
    * @return the foo, or <code>null</code> if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.Foo fetchByPrimaryKey(int fooId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(fooId);
    }

    /**
    * Returns all the foos.
    *
    * @return the foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.Foo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the foos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.Foo> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the foos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.Foo> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the foos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of foos.
    *
    * @return the number of foos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static FooPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FooPersistence) PortletBeanLocatorUtil.locate(ru.akimov.service.ClpSerializer.getServletContextName(),
                    FooPersistence.class.getName());

            ReferenceRegistry.registerReference(FooUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(FooPersistence persistence) {
    }
}
