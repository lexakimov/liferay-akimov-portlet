package ru.akimov.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditEntryGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryGroupLocalService
 * @generated
 */
public class AuditEntryGroupLocalServiceWrapper
    implements AuditEntryGroupLocalService,
        ServiceWrapper<AuditEntryGroupLocalService> {
    private AuditEntryGroupLocalService _auditEntryGroupLocalService;

    public AuditEntryGroupLocalServiceWrapper(
        AuditEntryGroupLocalService auditEntryGroupLocalService) {
        _auditEntryGroupLocalService = auditEntryGroupLocalService;
    }

    /**
    * Adds the Группа записей аудита to the database. Also notifies the appropriate model listeners.
    *
    * @param auditEntryGroup the Группа записей аудита
    * @return the Группа записей аудита that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntryGroup addAuditEntryGroup(
        ru.akimov.model.AuditEntryGroup auditEntryGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.addAuditEntryGroup(auditEntryGroup);
    }

    /**
    * Creates a new Группа записей аудита with the primary key. Does not add the Группа записей аудита to the database.
    *
    * @param entryGroupId the primary key for the new Группа записей аудита
    * @return the new Группа записей аудита
    */
    @Override
    public ru.akimov.model.AuditEntryGroup createAuditEntryGroup(
        int entryGroupId) {
        return _auditEntryGroupLocalService.createAuditEntryGroup(entryGroupId);
    }

    /**
    * Deletes the Группа записей аудита with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита that was removed
    * @throws PortalException if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntryGroup deleteAuditEntryGroup(
        int entryGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.deleteAuditEntryGroup(entryGroupId);
    }

    /**
    * Deletes the Группа записей аудита from the database. Also notifies the appropriate model listeners.
    *
    * @param auditEntryGroup the Группа записей аудита
    * @return the Группа записей аудита that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntryGroup deleteAuditEntryGroup(
        ru.akimov.model.AuditEntryGroup auditEntryGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.deleteAuditEntryGroup(auditEntryGroup);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _auditEntryGroupLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public ru.akimov.model.AuditEntryGroup fetchAuditEntryGroup(
        int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.fetchAuditEntryGroup(entryGroupId);
    }

    /**
    * Returns the Группа записей аудита with the primary key.
    *
    * @param entryGroupId the primary key of the Группа записей аудита
    * @return the Группа записей аудита
    * @throws PortalException if a Группа записей аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntryGroup getAuditEntryGroup(int entryGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.getAuditEntryGroup(entryGroupId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<ru.akimov.model.AuditEntryGroup> getAuditEntryGroups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.getAuditEntryGroups(start, end);
    }

    /**
    * Returns the number of Группа записей аудитаs.
    *
    * @return the number of Группа записей аудитаs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAuditEntryGroupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.getAuditEntryGroupsCount();
    }

    /**
    * Updates the Группа записей аудита in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param auditEntryGroup the Группа записей аудита
    * @return the Группа записей аудита that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntryGroup updateAuditEntryGroup(
        ru.akimov.model.AuditEntryGroup auditEntryGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.updateAuditEntryGroup(auditEntryGroup);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _auditEntryGroupLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _auditEntryGroupLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _auditEntryGroupLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public ru.akimov.model.AuditEntryGroup create()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroupLocalService.create();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AuditEntryGroupLocalService getWrappedAuditEntryGroupLocalService() {
        return _auditEntryGroupLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAuditEntryGroupLocalService(
        AuditEntryGroupLocalService auditEntryGroupLocalService) {
        _auditEntryGroupLocalService = auditEntryGroupLocalService;
    }

    @Override
    public AuditEntryGroupLocalService getWrappedService() {
        return _auditEntryGroupLocalService;
    }

    @Override
    public void setWrappedService(
        AuditEntryGroupLocalService auditEntryGroupLocalService) {
        _auditEntryGroupLocalService = auditEntryGroupLocalService;
    }
}
