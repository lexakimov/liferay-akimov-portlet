package ru.akimov.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryLocalService
 * @generated
 */
public class AuditEntryLocalServiceWrapper implements AuditEntryLocalService,
    ServiceWrapper<AuditEntryLocalService> {
    private AuditEntryLocalService _auditEntryLocalService;

    public AuditEntryLocalServiceWrapper(
        AuditEntryLocalService auditEntryLocalService) {
        _auditEntryLocalService = auditEntryLocalService;
    }

    /**
    * Adds the Запись аудита to the database. Also notifies the appropriate model listeners.
    *
    * @param auditEntry the Запись аудита
    * @return the Запись аудита that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntry addAuditEntry(
        ru.akimov.model.AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.addAuditEntry(auditEntry);
    }

    /**
    * Creates a new Запись аудита with the primary key. Does not add the Запись аудита to the database.
    *
    * @param entryId the primary key for the new Запись аудита
    * @return the new Запись аудита
    */
    @Override
    public ru.akimov.model.AuditEntry createAuditEntry(int entryId) {
        return _auditEntryLocalService.createAuditEntry(entryId);
    }

    /**
    * Deletes the Запись аудита with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита that was removed
    * @throws PortalException if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntry deleteAuditEntry(int entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.deleteAuditEntry(entryId);
    }

    /**
    * Deletes the Запись аудита from the database. Also notifies the appropriate model listeners.
    *
    * @param auditEntry the Запись аудита
    * @return the Запись аудита that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntry deleteAuditEntry(
        ru.akimov.model.AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.deleteAuditEntry(auditEntry);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _auditEntryLocalService.dynamicQuery();
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
        return _auditEntryLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _auditEntryLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _auditEntryLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _auditEntryLocalService.dynamicQueryCount(dynamicQuery);
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
        return _auditEntryLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public ru.akimov.model.AuditEntry fetchAuditEntry(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.fetchAuditEntry(entryId);
    }

    /**
    * Returns the Запись аудита with the primary key.
    *
    * @param entryId the primary key of the Запись аудита
    * @return the Запись аудита
    * @throws PortalException if a Запись аудита with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntry getAuditEntry(int entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.getAuditEntry(entryId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<ru.akimov.model.AuditEntry> getAuditEntries(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.getAuditEntries(start, end);
    }

    /**
    * Returns the number of Запись аудитаs.
    *
    * @return the number of Запись аудитаs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAuditEntriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.getAuditEntriesCount();
    }

    /**
    * Updates the Запись аудита in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param auditEntry the Запись аудита
    * @return the Запись аудита that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AuditEntry updateAuditEntry(
        ru.akimov.model.AuditEntry auditEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.updateAuditEntry(auditEntry);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _auditEntryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _auditEntryLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _auditEntryLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Создать новую запись аудита.
    */
    @Override
    public ru.akimov.model.AuditEntry create(int entityId,
        java.lang.String entityType, java.lang.String auditType,
        java.lang.String metadata)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.create(entityId, entityType, auditType,
            metadata);
    }

    /**
    * Удалить записи истории для сущности.
    *
    * @param entityType тип сущности (any case)
    * @param entityId   ключ
    * @throws SystemException
    */
    @Override
    public void deleteFor(java.lang.String entityType, int entityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _auditEntryLocalService.deleteFor(entityType, entityId);
    }

    @Override
    public java.util.List<ru.akimov.model.AuditEntry> getByEntryGroupId(
        int entryGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryLocalService.getByEntryGroupId(entryGroupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AuditEntryLocalService getWrappedAuditEntryLocalService() {
        return _auditEntryLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAuditEntryLocalService(
        AuditEntryLocalService auditEntryLocalService) {
        _auditEntryLocalService = auditEntryLocalService;
    }

    @Override
    public AuditEntryLocalService getWrappedService() {
        return _auditEntryLocalService;
    }

    @Override
    public void setWrappedService(AuditEntryLocalService auditEntryLocalService) {
        _auditEntryLocalService = auditEntryLocalService;
    }
}
