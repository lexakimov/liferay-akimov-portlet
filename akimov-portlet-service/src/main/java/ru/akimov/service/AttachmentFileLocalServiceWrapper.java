package ru.akimov.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AttachmentFileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentFileLocalService
 * @generated
 */
public class AttachmentFileLocalServiceWrapper
    implements AttachmentFileLocalService,
        ServiceWrapper<AttachmentFileLocalService> {
    private AttachmentFileLocalService _attachmentFileLocalService;

    public AttachmentFileLocalServiceWrapper(
        AttachmentFileLocalService attachmentFileLocalService) {
        _attachmentFileLocalService = attachmentFileLocalService;
    }

    /**
    * Adds the attachment file to the database. Also notifies the appropriate model listeners.
    *
    * @param attachmentFile the attachment file
    * @return the attachment file that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AttachmentFile addAttachmentFile(
        ru.akimov.model.AttachmentFile attachmentFile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.addAttachmentFile(attachmentFile);
    }

    /**
    * Creates a new attachment file with the primary key. Does not add the attachment file to the database.
    *
    * @param id the primary key for the new attachment file
    * @return the new attachment file
    */
    @Override
    public ru.akimov.model.AttachmentFile createAttachmentFile(int id) {
        return _attachmentFileLocalService.createAttachmentFile(id);
    }

    /**
    * Deletes the attachment file with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file that was removed
    * @throws PortalException if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AttachmentFile deleteAttachmentFile(int id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.deleteAttachmentFile(id);
    }

    /**
    * Deletes the attachment file from the database. Also notifies the appropriate model listeners.
    *
    * @param attachmentFile the attachment file
    * @return the attachment file that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AttachmentFile deleteAttachmentFile(
        ru.akimov.model.AttachmentFile attachmentFile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.deleteAttachmentFile(attachmentFile);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _attachmentFileLocalService.dynamicQuery();
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
        return _attachmentFileLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _attachmentFileLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _attachmentFileLocalService.dynamicQuery(dynamicQuery, start,
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
        return _attachmentFileLocalService.dynamicQueryCount(dynamicQuery);
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
        return _attachmentFileLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public ru.akimov.model.AttachmentFile fetchAttachmentFile(int id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.fetchAttachmentFile(id);
    }

    /**
    * Returns the attachment file with the primary key.
    *
    * @param id the primary key of the attachment file
    * @return the attachment file
    * @throws PortalException if a attachment file with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AttachmentFile getAttachmentFile(int id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.getAttachmentFile(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<ru.akimov.model.AttachmentFile> getAttachmentFiles(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.getAttachmentFiles(start, end);
    }

    /**
    * Returns the number of attachment files.
    *
    * @return the number of attachment files
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAttachmentFilesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.getAttachmentFilesCount();
    }

    /**
    * Updates the attachment file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param attachmentFile the attachment file
    * @return the attachment file that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ru.akimov.model.AttachmentFile updateAttachmentFile(
        ru.akimov.model.AttachmentFile attachmentFile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.updateAttachmentFile(attachmentFile);
    }

    @Override
    public ru.akimov.model.AttachmentFileDataBlobModel getDataBlobModel(
        java.io.Serializable primaryKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _attachmentFileLocalService.getDataBlobModel(primaryKey);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _attachmentFileLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _attachmentFileLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _attachmentFileLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AttachmentFileLocalService getWrappedAttachmentFileLocalService() {
        return _attachmentFileLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAttachmentFileLocalService(
        AttachmentFileLocalService attachmentFileLocalService) {
        _attachmentFileLocalService = attachmentFileLocalService;
    }

    @Override
    public AttachmentFileLocalService getWrappedService() {
        return _attachmentFileLocalService;
    }

    @Override
    public void setWrappedService(
        AttachmentFileLocalService attachmentFileLocalService) {
        _attachmentFileLocalService = attachmentFileLocalService;
    }
}
