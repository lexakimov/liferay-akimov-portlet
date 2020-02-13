package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import ru.akimov.service.AuditEntryLocalServiceUtil;
import ru.akimov.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AuditEntryClp extends BaseModelImpl<AuditEntry>
    implements AuditEntry {
    private int _auditEntryId;
    private String _auditType;
    private String _entityType;
    private int _entityId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _dateOfChange;
    private String _metadata;
    private BaseModel<?> _auditEntryRemoteModel;
    private Class<?> _clpSerializerClass = ru.akimov.service.ClpSerializer.class;

    public AuditEntryClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AuditEntry.class;
    }

    @Override
    public String getModelClassName() {
        return AuditEntry.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _auditEntryId;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setAuditEntryId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _auditEntryId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("auditEntryId", getAuditEntryId());
        attributes.put("auditType", getAuditType());
        attributes.put("entityType", getEntityType());
        attributes.put("entityId", getEntityId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("dateOfChange", getDateOfChange());
        attributes.put("metadata", getMetadata());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer auditEntryId = (Integer) attributes.get("auditEntryId");

        if (auditEntryId != null) {
            setAuditEntryId(auditEntryId);
        }

        String auditType = (String) attributes.get("auditType");

        if (auditType != null) {
            setAuditType(auditType);
        }

        String entityType = (String) attributes.get("entityType");

        if (entityType != null) {
            setEntityType(entityType);
        }

        Integer entityId = (Integer) attributes.get("entityId");

        if (entityId != null) {
            setEntityId(entityId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date dateOfChange = (Date) attributes.get("dateOfChange");

        if (dateOfChange != null) {
            setDateOfChange(dateOfChange);
        }

        String metadata = (String) attributes.get("metadata");

        if (metadata != null) {
            setMetadata(metadata);
        }
    }

    @Override
    public int getAuditEntryId() {
        return _auditEntryId;
    }

    @Override
    public void setAuditEntryId(int auditEntryId) {
        _auditEntryId = auditEntryId;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setAuditEntryId", int.class);

                method.invoke(_auditEntryRemoteModel, auditEntryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAuditType() {
        return _auditType;
    }

    @Override
    public void setAuditType(String auditType) {
        _auditType = auditType;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setAuditType", String.class);

                method.invoke(_auditEntryRemoteModel, auditType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEntityType() {
        return _entityType;
    }

    @Override
    public void setEntityType(String entityType) {
        _entityType = entityType;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setEntityType", String.class);

                method.invoke(_auditEntryRemoteModel, entityType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getEntityId() {
        return _entityId;
    }

    @Override
    public void setEntityId(int entityId) {
        _entityId = entityId;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setEntityId", int.class);

                method.invoke(_auditEntryRemoteModel, entityId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_auditEntryRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_auditEntryRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_auditEntryRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getDateOfChange() {
        return _dateOfChange;
    }

    @Override
    public void setDateOfChange(Date dateOfChange) {
        _dateOfChange = dateOfChange;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setDateOfChange", Date.class);

                method.invoke(_auditEntryRemoteModel, dateOfChange);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMetadata() {
        return _metadata;
    }

    @Override
    public void setMetadata(String metadata) {
        _metadata = metadata;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setMetadata", String.class);

                method.invoke(_auditEntryRemoteModel, metadata);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAuditEntryRemoteModel() {
        return _auditEntryRemoteModel;
    }

    public void setAuditEntryRemoteModel(BaseModel<?> auditEntryRemoteModel) {
        _auditEntryRemoteModel = auditEntryRemoteModel;
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

        Class<?> remoteModelClass = _auditEntryRemoteModel.getClass();

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

        Object returnValue = method.invoke(_auditEntryRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AuditEntryLocalServiceUtil.addAuditEntry(this);
        } else {
            AuditEntryLocalServiceUtil.updateAuditEntry(this);
        }
    }

    @Override
    public AuditEntry toEscapedModel() {
        return (AuditEntry) ProxyUtil.newProxyInstance(AuditEntry.class.getClassLoader(),
            new Class[] { AuditEntry.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AuditEntryClp clone = new AuditEntryClp();

        clone.setAuditEntryId(getAuditEntryId());
        clone.setAuditType(getAuditType());
        clone.setEntityType(getEntityType());
        clone.setEntityId(getEntityId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setDateOfChange(getDateOfChange());
        clone.setMetadata(getMetadata());

        return clone;
    }

    @Override
    public int compareTo(AuditEntry auditEntry) {
        int primaryKey = auditEntry.getPrimaryKey();

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

        if (!(obj instanceof AuditEntryClp)) {
            return false;
        }

        AuditEntryClp auditEntry = (AuditEntryClp) obj;

        int primaryKey = auditEntry.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{auditEntryId=");
        sb.append(getAuditEntryId());
        sb.append(", auditType=");
        sb.append(getAuditType());
        sb.append(", entityType=");
        sb.append(getEntityType());
        sb.append(", entityId=");
        sb.append(getEntityId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", dateOfChange=");
        sb.append(getDateOfChange());
        sb.append(", metadata=");
        sb.append(getMetadata());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("ru.akimov.model.AuditEntry");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>auditEntryId</column-name><column-value><![CDATA[");
        sb.append(getAuditEntryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>auditType</column-name><column-value><![CDATA[");
        sb.append(getAuditType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entityType</column-name><column-value><![CDATA[");
        sb.append(getEntityType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entityId</column-name><column-value><![CDATA[");
        sb.append(getEntityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateOfChange</column-name><column-value><![CDATA[");
        sb.append(getDateOfChange());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>metadata</column-name><column-value><![CDATA[");
        sb.append(getMetadata());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
