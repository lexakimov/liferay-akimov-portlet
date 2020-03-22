package ru.akimov.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.akimov.model.AttachmentFile;

import java.util.List;

/**
 * The persistence utility for the attachment file service. This utility wraps {@link AttachmentFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentFilePersistence
 * @see AttachmentFilePersistenceImpl
 * @generated
 */
public class AttachmentFileUtil {
    private static AttachmentFilePersistence _persistence;

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
    public static void clearCache(AttachmentFile attachmentFile) {
        getPersistence().clearCache(attachmentFile);
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
    public static List<AttachmentFile> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AttachmentFile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AttachmentFile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AttachmentFile update(AttachmentFile attachmentFile)
        throws SystemException {
        return getPersistence().update(attachmentFile);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AttachmentFile update(AttachmentFile attachmentFile,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(attachmentFile, serviceContext);
    }

    /**
    * Caches the attachment file in the entity cache if it is enabled.
    *
    * @param attachmentFile the attachment file
    */
    public static void cacheResult(
        ru.akimov.model.AttachmentFile attachmentFile) {
        getPersistence().cacheResult(attachmentFile);
    }

    /**
    * Caches the attachment files in the entity cache if it is enabled.
    *
    * @param attachmentFiles the attachment files
    */
    public static void cacheResult(
        java.util.List<ru.akimov.model.AttachmentFile> attachmentFiles) {
        getPersistence().cacheResult(attachmentFiles);
    }

    /**
    * Creates a new attachment file with the primary key. Does not add the attachment file to the database.
    *
    * @param id the primary key for the new attachment file
    * @return the new attachment file
    */
    public static ru.akimov.model.AttachmentFile create(int id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the attachment file with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file that was removed
    * @throws ru.akimov.NoSuchAttachmentFileException if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AttachmentFile remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAttachmentFileException {
        return getPersistence().remove(id);
    }

    public static ru.akimov.model.AttachmentFile updateImpl(
        ru.akimov.model.AttachmentFile attachmentFile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(attachmentFile);
    }

    /**
    * Returns the attachment file with the primary key or throws a {@link ru.akimov.NoSuchAttachmentFileException} if it could not be found.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file
    * @throws ru.akimov.NoSuchAttachmentFileException if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AttachmentFile findByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAttachmentFileException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the attachment file with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file, or <code>null</code> if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.akimov.model.AttachmentFile fetchByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the attachment files.
    *
    * @return the attachment files
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.AttachmentFile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the attachment files.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of attachment files
    * @param end the upper bound of the range of attachment files (not inclusive)
    * @return the range of attachment files
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.AttachmentFile> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the attachment files.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of attachment files
    * @param end the upper bound of the range of attachment files (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of attachment files
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.akimov.model.AttachmentFile> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the attachment files from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of attachment files.
    *
    * @return the number of attachment files
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AttachmentFilePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AttachmentFilePersistence) PortletBeanLocatorUtil.locate(ru.akimov.service.ClpSerializer.getServletContextName(),
                    AttachmentFilePersistence.class.getName());

            ReferenceRegistry.registerReference(AttachmentFileUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AttachmentFilePersistence persistence) {
    }
}
