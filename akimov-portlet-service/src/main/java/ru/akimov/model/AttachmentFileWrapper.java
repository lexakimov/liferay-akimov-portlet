package ru.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AttachmentFile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentFile
 * @generated
 */
public class AttachmentFileWrapper implements AttachmentFile,
    ModelWrapper<AttachmentFile> {
    private AttachmentFile _attachmentFile;

    public AttachmentFileWrapper(AttachmentFile attachmentFile) {
        _attachmentFile = attachmentFile;
    }

    @Override
    public Class<?> getModelClass() {
        return AttachmentFile.class;
    }

    @Override
    public String getModelClassName() {
        return AttachmentFile.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("fileName", getFileName());
        attributes.put("extension", getExtension());
        attributes.put("size", getSize());
        attributes.put("mimeType", getMimeType());
        attributes.put("data", getData());
        attributes.put("uploaded", getUploaded());
        attributes.put("userId", getUserId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer id = (Integer) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String fileName = (String) attributes.get("fileName");

        if (fileName != null) {
            setFileName(fileName);
        }

        String extension = (String) attributes.get("extension");

        if (extension != null) {
            setExtension(extension);
        }

        Integer size = (Integer) attributes.get("size");

        if (size != null) {
            setSize(size);
        }

        String mimeType = (String) attributes.get("mimeType");

        if (mimeType != null) {
            setMimeType(mimeType);
        }

        Blob data = (Blob) attributes.get("data");

        if (data != null) {
            setData(data);
        }

        Date uploaded = (Date) attributes.get("uploaded");

        if (uploaded != null) {
            setUploaded(uploaded);
        }

        Integer userId = (Integer) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }
    }

    /**
    * Returns the primary key of this attachment file.
    *
    * @return the primary key of this attachment file
    */
    @Override
    public int getPrimaryKey() {
        return _attachmentFile.getPrimaryKey();
    }

    /**
    * Sets the primary key of this attachment file.
    *
    * @param primaryKey the primary key of this attachment file
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _attachmentFile.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this attachment file.
    *
    * @return the ID of this attachment file
    */
    @Override
    public int getId() {
        return _attachmentFile.getId();
    }

    /**
    * Sets the ID of this attachment file.
    *
    * @param id the ID of this attachment file
    */
    @Override
    public void setId(int id) {
        _attachmentFile.setId(id);
    }

    /**
    * Returns the file name of this attachment file.
    *
    * @return the file name of this attachment file
    */
    @Override
    public java.lang.String getFileName() {
        return _attachmentFile.getFileName();
    }

    /**
    * Sets the file name of this attachment file.
    *
    * @param fileName the file name of this attachment file
    */
    @Override
    public void setFileName(java.lang.String fileName) {
        _attachmentFile.setFileName(fileName);
    }

    /**
    * Returns the extension of this attachment file.
    *
    * @return the extension of this attachment file
    */
    @Override
    public java.lang.String getExtension() {
        return _attachmentFile.getExtension();
    }

    /**
    * Sets the extension of this attachment file.
    *
    * @param extension the extension of this attachment file
    */
    @Override
    public void setExtension(java.lang.String extension) {
        _attachmentFile.setExtension(extension);
    }

    /**
    * Returns the size of this attachment file.
    *
    * @return the size of this attachment file
    */
    @Override
    public int getSize() {
        return _attachmentFile.getSize();
    }

    /**
    * Sets the size of this attachment file.
    *
    * @param size the size of this attachment file
    */
    @Override
    public void setSize(int size) {
        _attachmentFile.setSize(size);
    }

    /**
    * Returns the mime type of this attachment file.
    *
    * @return the mime type of this attachment file
    */
    @Override
    public java.lang.String getMimeType() {
        return _attachmentFile.getMimeType();
    }

    /**
    * Sets the mime type of this attachment file.
    *
    * @param mimeType the mime type of this attachment file
    */
    @Override
    public void setMimeType(java.lang.String mimeType) {
        _attachmentFile.setMimeType(mimeType);
    }

    /**
    * Returns the data of this attachment file.
    *
    * @return the data of this attachment file
    */
    @Override
    public java.sql.Blob getData() {
        return _attachmentFile.getData();
    }

    /**
    * Sets the data of this attachment file.
    *
    * @param data the data of this attachment file
    */
    @Override
    public void setData(java.sql.Blob data) {
        _attachmentFile.setData(data);
    }

    /**
    * Returns the uploaded of this attachment file.
    *
    * @return the uploaded of this attachment file
    */
    @Override
    public java.util.Date getUploaded() {
        return _attachmentFile.getUploaded();
    }

    /**
    * Sets the uploaded of this attachment file.
    *
    * @param uploaded the uploaded of this attachment file
    */
    @Override
    public void setUploaded(java.util.Date uploaded) {
        _attachmentFile.setUploaded(uploaded);
    }

    /**
    * Returns the user ID of this attachment file.
    *
    * @return the user ID of this attachment file
    */
    @Override
    public int getUserId() {
        return _attachmentFile.getUserId();
    }

    /**
    * Sets the user ID of this attachment file.
    *
    * @param userId the user ID of this attachment file
    */
    @Override
    public void setUserId(int userId) {
        _attachmentFile.setUserId(userId);
    }

    @Override
    public boolean isNew() {
        return _attachmentFile.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _attachmentFile.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _attachmentFile.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _attachmentFile.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _attachmentFile.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _attachmentFile.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _attachmentFile.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _attachmentFile.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _attachmentFile.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _attachmentFile.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _attachmentFile.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AttachmentFileWrapper((AttachmentFile) _attachmentFile.clone());
    }

    @Override
    public int compareTo(ru.akimov.model.AttachmentFile attachmentFile) {
        return _attachmentFile.compareTo(attachmentFile);
    }

    @Override
    public int hashCode() {
        return _attachmentFile.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.akimov.model.AttachmentFile> toCacheModel() {
        return _attachmentFile.toCacheModel();
    }

    @Override
    public ru.akimov.model.AttachmentFile toEscapedModel() {
        return new AttachmentFileWrapper(_attachmentFile.toEscapedModel());
    }

    @Override
    public ru.akimov.model.AttachmentFile toUnescapedModel() {
        return new AttachmentFileWrapper(_attachmentFile.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _attachmentFile.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _attachmentFile.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _attachmentFile.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AttachmentFileWrapper)) {
            return false;
        }

        AttachmentFileWrapper attachmentFileWrapper = (AttachmentFileWrapper) obj;

        if (Validator.equals(_attachmentFile,
                    attachmentFileWrapper._attachmentFile)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AttachmentFile getWrappedAttachmentFile() {
        return _attachmentFile;
    }

    @Override
    public AttachmentFile getWrappedModel() {
        return _attachmentFile;
    }

    @Override
    public void resetOriginalValues() {
        _attachmentFile.resetOriginalValues();
    }
}
