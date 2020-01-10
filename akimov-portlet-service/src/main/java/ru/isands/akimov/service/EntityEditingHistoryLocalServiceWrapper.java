package ru.isands.akimov.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EntityEditingHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EntityEditingHistoryLocalService
 * @generated
 */
public class EntityEditingHistoryLocalServiceWrapper
    implements EntityEditingHistoryLocalService,
        ServiceWrapper<EntityEditingHistoryLocalService> {
    private EntityEditingHistoryLocalService _entityEditingHistoryLocalService;

    public EntityEditingHistoryLocalServiceWrapper(
        EntityEditingHistoryLocalService entityEditingHistoryLocalService) {
        _entityEditingHistoryLocalService = entityEditingHistoryLocalService;
    }

    /**
    * Adds the entity editing history to the database. Also notifies the appropriate model listeners.
    *
    * @param entityEditingHistory the entity editing history
    * @return the entity editing history that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.isands.akimov.model.EntityEditingHistory addEntityEditingHistory(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.addEntityEditingHistory(entityEditingHistory);
    }

    /**
    * Creates a new entity editing history with the primary key. Does not add the entity editing history to the database.
    *
    * @param id the primary key for the new entity editing history
    * @return the new entity editing history
    */
    @Override
    public ru.isands.akimov.model.EntityEditingHistory createEntityEditingHistory(
        int id) {
        return _entityEditingHistoryLocalService.createEntityEditingHistory(id);
    }

    /**
    * Deletes the entity editing history with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history that was removed
    * @throws PortalException if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.isands.akimov.model.EntityEditingHistory deleteEntityEditingHistory(
        int id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.deleteEntityEditingHistory(id);
    }

    /**
    * Deletes the entity editing history from the database. Also notifies the appropriate model listeners.
    *
    * @param entityEditingHistory the entity editing history
    * @return the entity editing history that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.isands.akimov.model.EntityEditingHistory deleteEntityEditingHistory(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.deleteEntityEditingHistory(entityEditingHistory);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _entityEditingHistoryLocalService.dynamicQuery();
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
        return _entityEditingHistoryLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityEditingHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _entityEditingHistoryLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityEditingHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _entityEditingHistoryLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _entityEditingHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
        return _entityEditingHistoryLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public ru.isands.akimov.model.EntityEditingHistory fetchEntityEditingHistory(
        int id) throws com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.fetchEntityEditingHistory(id);
    }

    /**
    * Returns the entity editing history with the primary key.
    *
    * @param id the primary key of the entity editing history
    * @return the entity editing history
    * @throws PortalException if a entity editing history with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.isands.akimov.model.EntityEditingHistory getEntityEditingHistory(
        int id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.getEntityEditingHistory(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<ru.isands.akimov.model.EntityEditingHistory> getEntityEditingHistories(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.getEntityEditingHistories(start,
            end);
    }

    /**
    * Returns the number of entity editing histories.
    *
    * @return the number of entity editing histories
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getEntityEditingHistoriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.getEntityEditingHistoriesCount();
    }

    /**
    * Updates the entity editing history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param entityEditingHistory the entity editing history
    * @return the entity editing history that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.isands.akimov.model.EntityEditingHistory updateEntityEditingHistory(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistoryLocalService.updateEntityEditingHistory(entityEditingHistory);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _entityEditingHistoryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _entityEditingHistoryLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _entityEditingHistoryLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
    * Удалить записи истории для сущности.
    *
    * @param entityType тип сущности
    * @param entityId   ключ
    * @throws SystemException
    */
    @Override
    public void deleteFor(java.lang.String entityType, int entityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _entityEditingHistoryLocalService.deleteFor(entityType, entityId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EntityEditingHistoryLocalService getWrappedEntityEditingHistoryLocalService() {
        return _entityEditingHistoryLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEntityEditingHistoryLocalService(
        EntityEditingHistoryLocalService entityEditingHistoryLocalService) {
        _entityEditingHistoryLocalService = entityEditingHistoryLocalService;
    }

    @Override
    public EntityEditingHistoryLocalService getWrappedService() {
        return _entityEditingHistoryLocalService;
    }

    @Override
    public void setWrappedService(
        EntityEditingHistoryLocalService entityEditingHistoryLocalService) {
        _entityEditingHistoryLocalService = entityEditingHistoryLocalService;
    }
}
