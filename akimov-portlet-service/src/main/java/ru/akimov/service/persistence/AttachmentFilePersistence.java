package ru.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.akimov.model.AttachmentFile;

/**
 * The persistence interface for the Вложения service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentFilePersistenceImpl
 * @see AttachmentFileUtil
 * @generated
 */
public interface AttachmentFilePersistence extends BasePersistence<AttachmentFile> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AttachmentFileUtil} to access the Вложения persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the Вложения in the entity cache if it is enabled.
    *
    * @param attachmentFile the Вложения
    */
    public void cacheResult(ru.akimov.model.AttachmentFile attachmentFile);

    /**
    * Caches the Вложенияs in the entity cache if it is enabled.
    *
    * @param attachmentFiles the Вложенияs
    */
    public void cacheResult(
        java.util.List<ru.akimov.model.AttachmentFile> attachmentFiles);

    /**
    * Creates a new Вложения with the primary key. Does not add the Вложения to the database.
    *
    * @param id the primary key for the new Вложения
    * @return the new Вложения
    */
    public ru.akimov.model.AttachmentFile create(int id);

    /**
    * Removes the Вложения with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the Вложения
    * @return the Вложения that was removed
    * @throws ru.akimov.NoSuchAttachmentFileException if a Вложения with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AttachmentFile remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAttachmentFileException;

    public ru.akimov.model.AttachmentFile updateImpl(
        ru.akimov.model.AttachmentFile attachmentFile)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Вложения with the primary key or throws a {@link ru.akimov.NoSuchAttachmentFileException} if it could not be found.
    *
    * @param id the primary key of the Вложения
    * @return the Вложения
    * @throws ru.akimov.NoSuchAttachmentFileException if a Вложения with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AttachmentFile findByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAttachmentFileException;

    /**
    * Returns the Вложения with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the Вложения
    * @return the Вложения, or <code>null</code> if a Вложения with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AttachmentFile fetchByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the Вложенияs.
    *
    * @return the Вложенияs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AttachmentFile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the Вложенияs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Вложенияs
    * @param end the upper bound of the range of Вложенияs (not inclusive)
    * @return the range of Вложенияs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AttachmentFile> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the Вложенияs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of Вложенияs
    * @param end the upper bound of the range of Вложенияs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of Вложенияs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AttachmentFile> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the Вложенияs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of Вложенияs.
    *
    * @return the number of Вложенияs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
