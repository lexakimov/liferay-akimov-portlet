package ru.akimov.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EntityFieldChange. This utility wraps
 * {@link ru.akimov.service.impl.EntityFieldChangeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EntityFieldChangeLocalService
 * @see ru.akimov.service.base.EntityFieldChangeLocalServiceBaseImpl
 * @see ru.akimov.service.impl.EntityFieldChangeLocalServiceImpl
 * @generated
 */
public class EntityFieldChangeLocalServiceUtil {
    private static EntityFieldChangeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ru.akimov.service.impl.EntityFieldChangeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the Изменение атрибута сущности to the database. Also notifies the appropriate model listeners.
    *
    * @param entityFieldChange the Изменение атрибута сущности
    * @return the Изменение атрибута сущности that was added
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange addEntityFieldChange(
        ru.akimov.model.EntityFieldChange entityFieldChange)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addEntityFieldChange(entityFieldChange);
    }

    /**
    * Creates a new Изменение атрибута сущности with the primary key. Does not add the Изменение атрибута сущности to the database.
    *
    * @param fieldChangeId the primary key for the new Изменение атрибута сущности
    * @return the new Изменение атрибута сущности
    */
    public static ru.akimov.model.EntityFieldChange createEntityFieldChange(
        int fieldChangeId) {
        return getService().createEntityFieldChange(fieldChangeId);
    }

    /**
    * Deletes the Изменение атрибута сущности with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности that was removed
    * @throws PortalException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange deleteEntityFieldChange(
        int fieldChangeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEntityFieldChange(fieldChangeId);
    }

    /**
    * Deletes the Изменение атрибута сущности from the database. Also notifies the appropriate model listeners.
    *
    * @param entityFieldChange the Изменение атрибута сущности
    * @return the Изменение атрибута сущности that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange deleteEntityFieldChange(
        ru.akimov.model.EntityFieldChange entityFieldChange)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEntityFieldChange(entityFieldChange);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static ru.akimov.model.EntityFieldChange fetchEntityFieldChange(
        int fieldChangeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchEntityFieldChange(fieldChangeId);
    }

    /**
    * Returns the Изменение атрибута сущности with the primary key.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности
    * @throws PortalException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange getEntityFieldChange(
        int fieldChangeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEntityFieldChange(fieldChangeId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the Изменение атрибута сущностиs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @return the range of Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.EntityFieldChange> getEntityFieldChanges(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEntityFieldChanges(start, end);
    }

    /**
    * Returns the number of Изменение атрибута сущностиs.
    *
    * @return the number of Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static int getEntityFieldChangesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEntityFieldChangesCount();
    }

    /**
    * Updates the Изменение атрибута сущности in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param entityFieldChange the Изменение атрибута сущности
    * @return the Изменение атрибута сущности that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange updateEntityFieldChange(
        ru.akimov.model.EntityFieldChange entityFieldChange)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateEntityFieldChange(entityFieldChange);
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

    public static java.util.List<ru.akimov.model.EntityFieldChange> getByEntryId(
        int entryId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getByEntryId(entryId);
    }

    public static void clearService() {
        _service = null;
    }

    public static EntityFieldChangeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EntityFieldChangeLocalService.class.getName());

            if (invokableLocalService instanceof EntityFieldChangeLocalService) {
                _service = (EntityFieldChangeLocalService) invokableLocalService;
            } else {
                _service = new EntityFieldChangeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(EntityFieldChangeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(EntityFieldChangeLocalService service) {
    }
}
