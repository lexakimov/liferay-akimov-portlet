package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import ru.akimov.service.AuditEntryGroupLocalServiceUtil;
import ru.akimov.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AuditEntryGroupClp extends BaseModelImpl<AuditEntryGroup>
    implements AuditEntryGroup {
    private int _entryGroupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _eventDate;
    private BaseModel<?> _auditEntryGroupRemoteModel;
    private Class<?> _clpSerializerClass = ru.akimov.service.ClpSerializer.class;

    public AuditEntryGroupClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AuditEntryGroup.class;
    }

    @Override
    public String getModelClassName() {
        return AuditEntryGroup.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _entryGroupId;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setEntryGroupId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _entryGroupId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryGroupId", getEntryGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("eventDate", getEventDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer entryGroupId = (Integer) attributes.get("entryGroupId");

        if (entryGroupId != null) {
            setEntryGroupId(entryGroupId);
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

        Date eventDate = (Date) attributes.get("eventDate");

        if (eventDate != null) {
            setEventDate(eventDate);
        }
    }

    @Override
    public int getEntryGroupId() {
        return _entryGroupId;
    }

    @Override
    public void setEntryGroupId(int entryGroupId) {
        _entryGroupId = entryGroupId;

        if (_auditEntryGroupRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setEntryGroupId", int.class);

                method.invoke(_auditEntryGroupRemoteModel, entryGroupId);
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

        if (_auditEntryGroupRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_auditEntryGroupRemoteModel, companyId);
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

        if (_auditEntryGroupRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_auditEntryGroupRemoteModel, userId);
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

        if (_auditEntryGroupRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_auditEntryGroupRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEventDate() {
        return _eventDate;
    }

    @Override
    public void setEventDate(Date eventDate) {
        _eventDate = eventDate;

        if (_auditEntryGroupRemoteModel != null) {
            try {
                Class<?> clazz = _auditEntryGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setEventDate", Date.class);

                method.invoke(_auditEntryGroupRemoteModel, eventDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean hasEntries() {
        try {
            String methodName = "hasEntries";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            Boolean returnObj = (Boolean) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public void addEntry(ru.akimov.model.AuditEntry entry) {
        try {
            String methodName = "addEntry";

            Class<?>[] parameterTypes = new Class<?>[] {
                    ru.akimov.model.AuditEntry.class
                };

            Object[] parameterValues = new Object[] { entry };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getAuditEntryGroupRemoteModel() {
        return _auditEntryGroupRemoteModel;
    }

    public void setAuditEntryGroupRemoteModel(
        BaseModel<?> auditEntryGroupRemoteModel) {
        _auditEntryGroupRemoteModel = auditEntryGroupRemoteModel;
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

        Class<?> remoteModelClass = _auditEntryGroupRemoteModel.getClass();

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

        Object returnValue = method.invoke(_auditEntryGroupRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AuditEntryGroupLocalServiceUtil.addAuditEntryGroup(this);
        } else {
            AuditEntryGroupLocalServiceUtil.updateAuditEntryGroup(this);
        }
    }

    @Override
    public AuditEntryGroup toEscapedModel() {
        return (AuditEntryGroup) ProxyUtil.newProxyInstance(AuditEntryGroup.class.getClassLoader(),
            new Class[] { AuditEntryGroup.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AuditEntryGroupClp clone = new AuditEntryGroupClp();

        clone.setEntryGroupId(getEntryGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setEventDate(getEventDate());

        return clone;
    }

    @Override
    public int compareTo(AuditEntryGroup auditEntryGroup) {
        int primaryKey = auditEntryGroup.getPrimaryKey();

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

        if (!(obj instanceof AuditEntryGroupClp)) {
            return false;
        }

        AuditEntryGroupClp auditEntryGroup = (AuditEntryGroupClp) obj;

        int primaryKey = auditEntryGroup.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{entryGroupId=");
        sb.append(getEntryGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", eventDate=");
        sb.append(getEventDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("ru.akimov.model.AuditEntryGroup");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>entryGroupId</column-name><column-value><![CDATA[");
        sb.append(getEntryGroupId());
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
            "<column><column-name>eventDate</column-name><column-value><![CDATA[");
        sb.append(getEventDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
