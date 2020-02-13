package ru.akimov.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;
import ru.akimov.model.AuditEntry;

/**
 * Provides the local service utility for AuditEntry. This utility wraps
 * {@link ru.isands.akimov.service.impl.AuditEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryLocalService
 * @see ru.isands.akimov.service.base.AuditEntryLocalServiceBaseImpl
 * @see ru.isands.akimov.service.impl.AuditEntryLocalServiceImpl
 * @generated
 */
public class AuditEntryLocalServiceUtil {
    private static AuditEntryLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ru.isands.akimov.service.impl.AuditEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the audit entry to the database. Also notifies the appropriate model listeners.
    *
    * @param auditEntry the audit entry
    * @return the audit entry that was added
    * @throws SystemException if a system exception occurred
    */
    public static AuditEntry addAuditEntry(
        AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAuditEntry(auditEntry);
    }

    /**
    * Creates a new audit entry with the primary key. Does not add the audit entry to the database.
    *
    * @param auditEntryId the primary key for the new audit entry
    * @return the new audit entry
    */
    public static AuditEntry createAuditEntry(
        int auditEntryId) {
        return getService().createAuditEntry(auditEntryId);
    }

    /**
    * Deletes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param auditEntryId the primary key of the audit entry
    * @return the audit entry that was removed
    * @throws PortalException if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static AuditEntry deleteAuditEntry(
        int auditEntryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAuditEntry(auditEntryId);
    }

    /**
    * Deletes the audit entry from the database. Also notifies the appropriate model listeners.
    *
    * @param auditEntry the audit entry
    * @return the audit entry that was removed
    * @throws SystemException if a system exception occurred
    */
    public static AuditEntry deleteAuditEntry(
        AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAuditEntry(auditEntry);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static AuditEntry fetchAuditEntry(
        int auditEntryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAuditEntry(auditEntryId);
    }

    /**
    * Returns the audit entry with the primary key.
    *
    * @param auditEntryId the primary key of the audit entry
    * @return the audit entry
    * @throws PortalException if a audit entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static AuditEntry getAuditEntry(
        int auditEntryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAuditEntry(auditEntryId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<AuditEntry> getAuditEntries(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAuditEntries(start, end);
    }

    /**
    * Returns the number of audit entries.
    *
    * @return the number of audit entries
    * @throws SystemException if a system exception occurred
    */
    public static int getAuditEntriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAuditEntriesCount();
    }

    /**
    * Updates the audit entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param auditEntry the audit entry
    * @return the audit entry that was updated
    * @throws SystemException if a system exception occurred
    */
    public static AuditEntry updateAuditEntry(
        AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAuditEntry(auditEntry);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Удалить записи истории для сущности.
    *
    * @param entityType тип сущности (any case)
    * @param entityId   ключ
    * @throws SystemException
    */
    public static void deleteFor(java.lang.String entityType, int entityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteFor(entityType, entityId);
    }

    public static void clearService() {
        _service = null;
    }

    public static AuditEntryLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AuditEntryLocalService.class.getName());

            if (invokableLocalService instanceof AuditEntryLocalService) {
                _service = (AuditEntryLocalService) invokableLocalService;
            } else {
                _service = new AuditEntryLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AuditEntryLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AuditEntryLocalService service) {
    }
}