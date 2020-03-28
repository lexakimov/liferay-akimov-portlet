package ru.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.akimov.model.AuditEntry;

import java.util.List;

/**
 * The persistence utility for the Запись аудита service. This utility wraps {@link AuditEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
    * Returns all the Запись аудитаs where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @return the matching Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.AuditEntry> findByEntryGroupId(
        int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntryGroupId(entryGroupId);
    }

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
    public static java.util.List<ru.akimov.model.AuditEntry> findByEntryGroupId(
        int entryGroupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntryGroupId(entryGroupId, start, end);
    }

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
    public static java.util.List<ru.akimov.model.AuditEntry> findByEntryGroupId(
        int entryGroupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEntryGroupId(entryGroupId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Запись аудита
    * @throws ru.akimov.NoSuchAuditEntryException if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntry findByEntryGroupId_First(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException {
        return getPersistence()
                   .findByEntryGroupId_First(entryGroupId, orderByComparator);
    }

    /**
    * Returns the first Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Запись аудита, or <code>null</code> if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntry fetchByEntryGroupId_First(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEntryGroupId_First(entryGroupId, orderByComparator);
    }

    /**
    * Returns the last Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Запись аудита
    * @throws ru.akimov.NoSuchAuditEntryException if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntry findByEntryGroupId_Last(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException {
        return getPersistence()
                   .findByEntryGroupId_Last(entryGroupId, orderByComparator);
    }

    /**
    * Returns the last Запись аудита in the ordered set where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Запись аудита, or <code>null</code> if a matching Запись аудита could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntry fetchByEntryGroupId_Last(
        int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEntryGroupId_Last(entryGroupId, orderByComparator);
    }

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
    public static ru.akimov.model.AuditEntry[] findByEntryGroupId_PrevAndNext(
        int entryId, int entryGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException {
        return getPersistence()
                   .findByEntryGroupId_PrevAndNext(entryId, entryGroupId,
            orderByComparator);
    }

    /**
    * Removes all the Запись аудитаs where entryGroupId = &#63; from the database.
    *
    * @param entryGroupId the entry group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEntryGroupId(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEntryGroupId(entryGroupId);
    }

    /**
    * Returns the number of Запись аудитаs where entryGroupId = &#63;.
    *
    * @param entryGroupId the entry group ID
    * @return the number of matching Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public static int countByEntryGroupId(int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEntryGroupId(entryGroupId);
    }

    /**
    * Caches the Запись аудита in the entity cache if it is enabled.
    *
    * @param auditEntry the Запись аудита
    */
    public static void cacheResult(ru.akimov.model.AuditEntry auditEntry) {
        getPersistence().cacheResult(auditEntry);
    }

    /**
    * Caches the Запись аудитаs in the entity cache if it is enabled.
    *
    * @param auditEntries the Запись аудитаs
    */
    public static void cacheResult(
        java.util.List<ru.akimov.model.AuditEntry> auditEntries) {
        getPersistence().cacheResult(auditEntries);
    }

    /**
    * Creates a new Запись аудита with the primary key. Does not add the Запись аудита to the database.
    *
    * @param entryId the primary key for the new Запись аудита
    * @return the new Запись аудита
    */
    public static ru.akimov.model.AuditEntry create(int entryId) {
        return getPersistence().create(entryId);
    }

    /**
    * Removes the Запись аудита with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита that was removed
    * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntry remove(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException {
        return getPersistence().remove(entryId);
    }

    public static ru.akimov.model.AuditEntry updateImpl(
        ru.akimov.model.AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(auditEntry);
    }

    /**
    * Returns the Запись аудита with the primary key or throws a {@link ru.akimov.NoSuchAuditEntryException} if it could not be found.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита
    * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntry findByPrimaryKey(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAuditEntryException {
        return getPersistence().findByPrimaryKey(entryId);
    }

    /**
    * Returns the Запись аудита with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита, or <code>null</code> if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AuditEntry fetchByPrimaryKey(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(entryId);
    }

    /**
    * Returns all the Запись аудитаs.
    *
    * @return the Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.AuditEntry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<ru.akimov.model.AuditEntry> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<ru.akimov.model.AuditEntry> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the Запись аудитаs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of Запись аудитаs.
    *
    * @return the number of Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AuditEntryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AuditEntryPersistence) PortletBeanLocatorUtil.locate(ru.akimov.service.ClpSerializer.getServletContextName(),
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
