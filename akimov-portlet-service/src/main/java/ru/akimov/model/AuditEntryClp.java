package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.akimov.service.AuditEntryLocalServiceUtil;
import ru.akimov.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AuditEntryClp extends BaseModelImpl<AuditEntry>
    implements AuditEntry {
    private int _entryId;
    private int _entryGroupId;
    private String _auditType;
    private String _entityType;
    private int _entityId;
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
        return _entryId;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setEntryId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _entryId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryId", getEntryId());
        attributes.put("entryGroupId", getEntryGroupId());
        attributes.put("auditType", getAuditType());
        attributes.put("entityType", getEntityType());
        attributes.put("entityId", getEntityId());
        attributes.put("metadata", getMetadata());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer entryId = (Integer) attributes.get("entryId");

        if (entryId != null) {
            setEntryId(entryId);
        }

        Integer entryGroupId = (Integer) attributes.get("entryGroupId");

        if (entryGroupId != null) {
            setEntryGroupId(entryGroupId);
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

        String metadata = (String) attributes.get("metadata");

        if (metadata != null) {
            setMetadata(metadata);
        }
    }

    @Override
    public int getEntryId() {
        return _entryId;
    }

    @Override
    public void setEntryId(int entryId) {
        _entryId = entryId;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setEntryId", int.class);

                method.invoke(_auditEntryRemoteModel, entryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getEntryGroupId() {
        return _entryGroupId;
    }

    @Override
    public void setEntryGroupId(int entryGroupId) {
        _entryGroupId = entryGroupId;

        if (_auditEntryRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setEntryGroupId", int.class);

                method.invoke(_auditEntryRemoteModel, entryGroupId);
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

    @Override
    public void addFieldChange(java.lang.String fieldName,
        java.lang.Object oldValue, java.lang.Object newValue) {
        try {
            String methodName = "addFieldChange";

            Class<?>[] parameterTypes = new Class<?>[] {
                    java.lang.String.class, java.lang.Object.class,
                    java.lang.Object.class
                };

            Object[] parameterValues = new Object[] {
                    fieldName, oldValue, newValue
                };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public long getUserId() {
        try {
            String methodName = "getUserId";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            Long returnObj = (Long) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public boolean hasFieldChanges() {
        try {
            String methodName = "hasFieldChanges";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            Boolean returnObj = (Boolean) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
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

        clone.setEntryId(getEntryId());
        clone.setEntryGroupId(getEntryGroupId());
        clone.setAuditType(getAuditType());
        clone.setEntityType(getEntityType());
        clone.setEntityId(getEntityId());
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
        StringBundler sb = new StringBundler(13);

        sb.append("{entryId=");
        sb.append(getEntryId());
        sb.append(", entryGroupId=");
        sb.append(getEntryGroupId());
        sb.append(", auditType=");
        sb.append(getAuditType());
        sb.append(", entityType=");
        sb.append(getEntityType());
        sb.append(", entityId=");
        sb.append(getEntityId());
        sb.append(", metadata=");
        sb.append(getMetadata());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("ru.akimov.model.AuditEntry");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>entryId</column-name><column-value><![CDATA[");
        sb.append(getEntryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entryGroupId</column-name><column-value><![CDATA[");
        sb.append(getEntryGroupId());
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
            "<column><column-name>metadata</column-name><column-value><![CDATA[");
        sb.append(getMetadata());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
