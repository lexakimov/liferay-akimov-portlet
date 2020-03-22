package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.akimov.service.AttachmentFileLocalServiceUtil;
import ru.akimov.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AttachmentFileClp extends BaseModelImpl<AttachmentFile>
    implements AttachmentFile {
    private int _id;
    private String _fileName;
    private String _extension;
    private int _size;
    private String _mimeType;
    private Blob _data;
    private Date _uploaded;
    private int _userId;
    private BaseModel<?> _attachmentFileRemoteModel;
    private Class<?> _clpSerializerClass = ru.akimov.service.ClpSerializer.class;

    public AttachmentFileClp() {
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
    public int getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
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

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public void setId(int id) {
        _id = id;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setId", int.class);

                method.invoke(_attachmentFileRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFileName() {
        return _fileName;
    }

    @Override
    public void setFileName(String fileName) {
        _fileName = fileName;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setFileName", String.class);

                method.invoke(_attachmentFileRemoteModel, fileName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getExtension() {
        return _extension;
    }

    @Override
    public void setExtension(String extension) {
        _extension = extension;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setExtension", String.class);

                method.invoke(_attachmentFileRemoteModel, extension);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getSize() {
        return _size;
    }

    @Override
    public void setSize(int size) {
        _size = size;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setSize", int.class);

                method.invoke(_attachmentFileRemoteModel, size);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMimeType() {
        return _mimeType;
    }

    @Override
    public void setMimeType(String mimeType) {
        _mimeType = mimeType;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setMimeType", String.class);

                method.invoke(_attachmentFileRemoteModel, mimeType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Blob getData() {
        return _data;
    }

    @Override
    public void setData(Blob data) {
        _data = data;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setData", Blob.class);

                method.invoke(_attachmentFileRemoteModel, data);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getUploaded() {
        return _uploaded;
    }

    @Override
    public void setUploaded(Date uploaded) {
        _uploaded = uploaded;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setUploaded", Date.class);

                method.invoke(_attachmentFileRemoteModel, uploaded);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(int userId) {
        _userId = userId;

        if (_attachmentFileRemoteModel != null) {
            try {
                Class<?> clazz = _attachmentFileRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", int.class);

                method.invoke(_attachmentFileRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAttachmentFileRemoteModel() {
        return _attachmentFileRemoteModel;
    }

    public void setAttachmentFileRemoteModel(
        BaseModel<?> attachmentFileRemoteModel) {
        _attachmentFileRemoteModel = attachmentFileRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _attachmentFileRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_attachmentFileRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AttachmentFileLocalServiceUtil.addAttachmentFile(this);
        } else {
            AttachmentFileLocalServiceUtil.updateAttachmentFile(this);
        }
    }

    @Override
    public AttachmentFile toEscapedModel() {
        return (AttachmentFile) ProxyUtil.newProxyInstance(AttachmentFile.class.getClassLoader(),
            new Class[] { AttachmentFile.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AttachmentFileClp clone = new AttachmentFileClp();

        clone.setId(getId());
        clone.setFileName(getFileName());
        clone.setExtension(getExtension());
        clone.setSize(getSize());
        clone.setMimeType(getMimeType());
        clone.setData(getData());
        clone.setUploaded(getUploaded());
        clone.setUserId(getUserId());

        return clone;
    }

    @Override
    public int compareTo(AttachmentFile attachmentFile) {
        int primaryKey = attachmentFile.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AttachmentFileClp)) {
            return false;
        }

        AttachmentFileClp attachmentFile = (AttachmentFileClp) obj;

        int primaryKey = attachmentFile.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", fileName=");
        sb.append(getFileName());
        sb.append(", extension=");
        sb.append(getExtension());
        sb.append(", size=");
        sb.append(getSize());
        sb.append(", mimeType=");
        sb.append(getMimeType());
        sb.append(", data=");
        sb.append(getData());
        sb.append(", uploaded=");
        sb.append(getUploaded());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("ru.akimov.model.AttachmentFile");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileName</column-name><column-value><![CDATA[");
        sb.append(getFileName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>extension</column-name><column-value><![CDATA[");
        sb.append(getExtension());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>size</column-name><column-value><![CDATA[");
        sb.append(getSize());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mimeType</column-name><column-value><![CDATA[");
        sb.append(getMimeType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>data</column-name><column-value><![CDATA[");
        sb.append(getData());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>uploaded</column-name><column-value><![CDATA[");
        sb.append(getUploaded());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
