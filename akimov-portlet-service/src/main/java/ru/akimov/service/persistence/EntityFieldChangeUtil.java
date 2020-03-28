package ru.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.akimov.model.EntityFieldChange;

import java.util.List;

/**
 * The persistence utility for the Изменение атрибута сущности service. This utility wraps {@link EntityFieldChangePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
    * Returns all the Изменение атрибута сущностиs where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @return the matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.EntityFieldChange> findByEntryId(
        int entryId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntryId(entryId);
    }

    /**
    * Returns a range of all the Изменение атрибута сущностиs where entryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryId the entry ID
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @return the range of matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.EntityFieldChange> findByEntryId(
        int entryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntryId(entryId, start, end);
    }

    /**
    * Returns an ordered range of all the Изменение атрибута сущностиs where entryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryId the entry ID
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.EntityFieldChange> findByEntryId(
        int entryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEntryId(entryId, start, end, orderByComparator);
    }

    /**
    * Returns the first Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange findByEntryId_First(
        int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException {
        return getPersistence().findByEntryId_First(entryId, orderByComparator);
    }

    /**
    * Returns the first Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching Изменение атрибута сущности, or <code>null</code> if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange fetchByEntryId_First(
        int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEntryId_First(entryId, orderByComparator);
    }

    /**
    * Returns the last Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange findByEntryId_Last(
        int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException {
        return getPersistence().findByEntryId_Last(entryId, orderByComparator);
    }

    /**
    * Returns the last Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching Изменение атрибута сущности, or <code>null</code> if a matching Изменение атрибута сущности could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange fetchByEntryId_Last(
        int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEntryId_Last(entryId, orderByComparator);
    }

    /**
    * Returns the Изменение атрибута сущностиs before and after the current Изменение атрибута сущности in the ordered set where entryId = &#63;.
    *
    * @param fieldChangeId the primary key of the current Изменение атрибута сущности
    * @param entryId the entry ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange[] findByEntryId_PrevAndNext(
        int fieldChangeId, int entryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException {
        return getPersistence()
                   .findByEntryId_PrevAndNext(fieldChangeId, entryId,
            orderByComparator);
    }

    /**
    * Removes all the Изменение атрибута сущностиs where entryId = &#63; from the database.
    *
    * @param entryId the entry ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEntryId(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEntryId(entryId);
    }

    /**
    * Returns the number of Изменение атрибута сущностиs where entryId = &#63;.
    *
    * @param entryId the entry ID
    * @return the number of matching Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static int countByEntryId(int entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEntryId(entryId);
    }

    /**
    * Caches the Изменение атрибута сущности in the entity cache if it is enabled.
    *
    * @param entityFieldChange the Изменение атрибута сущности
    */
    public static void cacheResult(
        ru.akimov.model.EntityFieldChange entityFieldChange) {
        getPersistence().cacheResult(entityFieldChange);
    }

    /**
    * Caches the Изменение атрибута сущностиs in the entity cache if it is enabled.
    *
    * @param entityFieldChanges the Изменение атрибута сущностиs
    */
    public static void cacheResult(
        java.util.List<ru.akimov.model.EntityFieldChange> entityFieldChanges) {
        getPersistence().cacheResult(entityFieldChanges);
    }

    /**
    * Creates a new Изменение атрибута сущности with the primary key. Does not add the Изменение атрибута сущности to the database.
    *
    * @param fieldChangeId the primary key for the new Изменение атрибута сущности
    * @return the new Изменение атрибута сущности
    */
    public static ru.akimov.model.EntityFieldChange create(int fieldChangeId) {
        return getPersistence().create(fieldChangeId);
    }

    /**
    * Removes the Изменение атрибута сущности with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности that was removed
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange remove(int fieldChangeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException {
        return getPersistence().remove(fieldChangeId);
    }

    public static ru.akimov.model.EntityFieldChange updateImpl(
        ru.akimov.model.EntityFieldChange entityFieldChange)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(entityFieldChange);
    }

    /**
    * Returns the Изменение атрибута сущности with the primary key or throws a {@link ru.akimov.NoSuchEntityFieldChangeException} if it could not be found.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности
    * @throws ru.akimov.NoSuchEntityFieldChangeException if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange findByPrimaryKey(
        int fieldChangeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchEntityFieldChangeException {
        return getPersistence().findByPrimaryKey(fieldChangeId);
    }

    /**
    * Returns the Изменение атрибута сущности with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fieldChangeId the primary key of the Изменение атрибута сущности
    * @return the Изменение атрибута сущности, or <code>null</code> if a Изменение атрибута сущности with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.EntityFieldChange fetchByPrimaryKey(
        int fieldChangeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(fieldChangeId);
    }

    /**
    * Returns all the Изменение атрибута сущностиs.
    *
    * @return the Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.EntityFieldChange> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<ru.akimov.model.EntityFieldChange> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the Изменение атрибута сущностиs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Изменение атрибута сущностиs
    * @param end the upper bound of the range of Изменение атрибута сущностиs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.EntityFieldChange> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the Изменение атрибута сущностиs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of Изменение атрибута сущностиs.
    *
    * @return the number of Изменение атрибута сущностиs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EntityFieldChangePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EntityFieldChangePersistence) PortletBeanLocatorUtil.locate(ru.akimov.service.ClpSerializer.getServletContextName(),
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
