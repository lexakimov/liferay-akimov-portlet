package ru.isands.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import ru.isands.akimov.service.AuditEntryLocalServiceUtil;
import ru.isands.akimov.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AuditEntryClp extends BaseModelImpl<AuditEntry>
    implements AuditEntry {
    private int _id;
    private int _entityId;
    private String _entityType;
    private long _userId;
    private String _userUuid;
    private String _description;
    private Date _dateOfChange;
    private BaseModel<?> _auditEntryRemoteModel;
    private Class<?> _clpSerializerClass = ru.isands.akimov.service.ClpSerializer.class;

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
        attributes.put("entityId", getEntityId());
        attributes.put("entityType", getEntityType());
        attributes.put("userId", getUserId());
        attributes.put("description", getDescription());
        attributes.put("dateOfChange", getDateOfChange());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer id = (Integer) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer entityId = (Integer) attributes.get("entityId");

        if (entityId != null) {
            setEntityId(entityId);
        }

        String entityType = (String) attributes.get("entityType");

        if (entityType != null) {
            setEntityType(entityType);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Date dateOfChange = (Date) attributes.get("dateOfChange");

        if (dateOfChange != null) {
            setDateOfChange(dateOfChange);
        }
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public void setId(int id) {
        _id = id;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setId", int.class);

                method.invoke(_auditEntryRemoteModel, id);
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
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_auditEntryRemoteModel, description);
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

        clone.setId(getId());
        clone.setEntityId(getEntityId());
        clone.setEntityType(getEntityType());
        clone.setUserId(getUserId());
        clone.setDescription(getDescription());
        clone.setDateOfChange(getDateOfChange());

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
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", entityId=");
        sb.append(getEntityId());
        sb.append(", entityType=");
        sb.append(getEntityType());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", dateOfChange=");
        sb.append(getDateOfChange());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("ru.isands.akimov.model.AuditEntry");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entityId</column-name><column-value><![CDATA[");
        sb.append(getEntityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entityType</column-name><column-value><![CDATA[");
        sb.append(getEntityType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateOfChange</column-name><column-value><![CDATA[");
        sb.append(getDateOfChange());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
