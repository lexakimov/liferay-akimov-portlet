package ru.akimov.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.akimov.model.AttachmentFile;

/**
 * The persistence interface for the attachment file service.
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
     * Never modify or reference this interface directly. Always use {@link AttachmentFileUtil} to access the attachment file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the attachment file in the entity cache if it is enabled.
    *
    * @param attachmentFile the attachment file
    */
    public void cacheResult(ru.akimov.model.AttachmentFile attachmentFile);

    /**
    * Caches the attachment files in the entity cache if it is enabled.
    *
    * @param attachmentFiles the attachment files
    */
    public void cacheResult(
        java.util.List<ru.akimov.model.AttachmentFile> attachmentFiles);

    /**
    * Creates a new attachment file with the primary key. Does not add the attachment file to the database.
    *
    * @param id the primary key for the new attachment file
    * @return the new attachment file
    */
    public ru.akimov.model.AttachmentFile create(int id);

    /**
    * Removes the attachment file with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file that was removed
    * @throws ru.akimov.NoSuchAttachmentFileException if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AttachmentFile remove(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAttachmentFileException;

    public ru.akimov.model.AttachmentFile updateImpl(
        ru.akimov.model.AttachmentFile attachmentFile)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the attachment file with the primary key or throws a {@link ru.akimov.NoSuchAttachmentFileException} if it could not be found.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file
    * @throws ru.akimov.NoSuchAttachmentFileException if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AttachmentFile findByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.akimov.NoSuchAttachmentFileException;

    /**
    * Returns the attachment file with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file, or <code>null</code> if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ru.akimov.model.AttachmentFile fetchByPrimaryKey(int id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the attachment files.
    *
    * @return the attachment files
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ru.akimov.model.AttachmentFile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ru.akimov.model.AttachmentFile> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ru.akimov.model.AttachmentFile> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the attachment files from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of attachment files.
    *
    * @return the number of attachment files
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
