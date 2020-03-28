package ru.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.akimov.model.AuditEntryGroup;

import java.util.List;

/**
 * The persistence utility for the Группа записей аудита service. This utility wraps {@link AuditEntryGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryGroupPersistence
 * @see AuditEntryGroupPersistenceImpl
 * @generated
 */
public class AuditEntryGroupUtil {
    private static AuditEntryGroupPersistence _persistence;

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
    public static void clearCache(AuditEntryGroup auditEntryGroup) {
        getPersistence().clearCache(auditEntryGroup);
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
    public static List<AuditEntryGroup> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AuditEntryGroup> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AuditEntryGroup> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AuditEntryGroup update(AuditEntryGroup auditEntryGroup)
        throws SystemException {
        return getPersistence().update(auditEntryGroup);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AuditEntryGroup update(AuditEntryGroup auditEntryGroup,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(auditEntryGroup, serviceContext);
    }

    /**
    * Caches the Группа записей аудита in the entity cache if it is enabled.
    *
    * @param auditEntryGroup the Группа записей аудита
    */
    public static void cacheResult(
        ru.akimov.model.AuditEntryGroup auditEntryGroup) {
        getPersistence().cacheResult(auditEntryGroup);
    }

    /**
    * Caches the Группа записей аудитаs in the entity cache if it is enabled.
    *
    * @param auditEntryGroups the Группа записей аудитаs
    */
    public static void cacheResult(
        java.util.List<ru.akimov.model.AuditEntryGroup> auditEntryGroups) {
        getPersistence().cacheResult(auditEntryGroups);
    }

    /**
    * Creates a new Группа записей аудита with the primary key. Does not add the Группа записей аудита to the database.
    *
    * @param entryGroupId the primary key for the new Группа записей аудита
    * @return the new Группа записей аудита
    */
    public static ru.akimov.model.AuditEntryGroup create(int entryGroupId) {
        return getPersistence().create(entryGroupId);
    }

    /**
    * Removes the Группа записей аудита with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита that was removed
    * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntryGroup remove(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryGroupException {
        return getPersistence().remove(entryGroupId);
    }

    public static ru.akimov.model.AuditEntryGroup updateImpl(
        ru.akimov.model.AuditEntryGroup auditEntryGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(auditEntryGroup);
    }

    /**
    * Returns the Группа записей аудита with the primary key or throws a {@link ru.akimov.NoSuchAuditEntryGroupException} if it could not be found.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита
    * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntryGroup findByPrimaryKey(
        int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryGroupException {
        return getPersistence().findByPrimaryKey(entryGroupId);
    }

    /**
    * Returns the Группа записей аудита with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита, or <code>null</code> if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntryGroup fetchByPrimaryKey(
        int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(entryGroupId);
    }

    /**
    * Returns all the Группа записей аудитаs.
    *
    * @return the Группа записей аудитаs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.AuditEntryGroup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<ru.akimov.model.AuditEntryGroup> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<ru.akimov.model.AuditEntryGroup> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the Группа записей аудитаs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of Группа записей аудитаs.
    *
    * @return the number of Группа записей аудитаs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AuditEntryGroupPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AuditEntryGroupPersistence) PortletBeanLocatorUtil.locate(ru.akimov.service.ClpSerializer.getServletContextName(),
                    AuditEntryGroupPersistence.class.getName());

            ReferenceRegistry.registerReference(AuditEntryGroupUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AuditEntryGroupPersistence persistence) {
    }
}
