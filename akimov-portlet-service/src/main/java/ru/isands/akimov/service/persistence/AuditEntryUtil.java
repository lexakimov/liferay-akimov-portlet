package ru.isands.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.isands.akimov.model.AuditEntry;

import java.util.List;

/**
 * The persistence utility for the audit entry service. This utility wraps {@link AuditEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryPersistence
 * @see AuditEntryPersistenceImpl
 * @generated
 */
public class AuditEntryUtil {
    private static AuditEntryPersistence _persistence;

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
    public static void clearCache(AuditEntry auditEntry) {
        getPersistence().clearCache(auditEntry);
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
    public static List<AuditEntry> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AuditEntry> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AuditEntry> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AuditEntry update(AuditEntry auditEntry)
        throws SystemException {
        return getPersistence().update(auditEntry);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AuditEntry update(AuditEntry auditEntry,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(auditEntry, serviceContext);
    }

    /**
    * Caches the audit entry in the entity cache if it is enabled.
    *
    * @param auditEntry the audit entry
    */
    public static void cacheResult(ru.isands.akimov.model.AuditEntry auditEntry) {
        getPersistence().cacheResult(auditEntry);
    }

    /**
    * Caches the audit entries in the entity cache if it is enabled.
    *
    * @param auditEntries the audit entries
    */
    public static void cacheResult(
        java.util.List<ru.isands.akimov.model.AuditEntry> auditEntries) {
        getPersistence().cacheResult(auditEntries);
    }

    /**
    * Creates a new audit entry with the primary key. Does not add the audit entry to the database.
    *
    * @param id the primary key for the new audit entry
    * @return the new audit entry
    */
    public static ru.isands.akimov.model.AuditEntry create(int id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the audit entry
    * @return the audit entry that was removed
    * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.akimov.model.AuditEntry remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchAuditEntryException {
        return getPersistence().remove(id);
    }

    public static ru.isands.akimov.model.AuditEntry updateImpl(
        ru.isands.akimov.model.AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(auditEntry);
    }

    /**
    * Returns the audit entry with the primary key or throws a {@link ru.isands.akimov.NoSuchAuditEntryException} if it could not be found.
    *
    * @param id the primary key of the audit entry
    * @return the audit entry
    * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.akimov.model.AuditEntry findByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.isands.akimov.NoSuchAuditEntryException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the audit entry with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the audit entry
    * @return the audit entry, or <code>null</code> if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.isands.akimov.model.AuditEntry fetchByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the audit entries.
    *
    * @return the audit entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.isands.akimov.model.AuditEntry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<ru.isands.akimov.model.AuditEntry> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<ru.isands.akimov.model.AuditEntry> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the audit entries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of audit entries.
    *
    * @return the number of audit entries
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AuditEntryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AuditEntryPersistence) PortletBeanLocatorUtil.locate(ru.isands.akimov.service.ClpSerializer.getServletContextName(),
                    AuditEntryPersistence.class.getName());

            ReferenceRegistry.registerReference(AuditEntryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AuditEntryPersistence persistence) {
    }
}