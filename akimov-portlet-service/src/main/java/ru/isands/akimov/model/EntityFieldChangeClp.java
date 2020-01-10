package ru.isands.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.isands.akimov.service.ClpSerializer;
import ru.isands.akimov.service.EntityFieldChangeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class EntityFieldChangeClp extends BaseModelImpl<EntityFieldChange>
    implements EntityFieldChange {
    private int _id;
    private int _historyId;
    private String _fieldName;
    private String _oldValue;
    private String _newValue;
    private BaseModel<?> _entityFieldChangeRemoteModel;
    private Class<?> _clpSerializerClass = ru.isands.akimov.service.ClpSerializer.class;

    public EntityFieldChangeClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return EntityFieldChange.class;
    }

    @Override
    public String getModelClassName() {
        return EntityFieldChange.class.getName();
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
        attributes.put("historyId", getHistoryId());
        attributes.put("fieldName", getFieldName());
        attributes.put("oldValue", getOldValue());
        attributes.put("newValue", getNewValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer id = (Integer) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer historyId = (Integer) attributes.get("historyId");

        if (historyId != null) {
            setHistoryId(historyId);
        }

        String fieldName = (String) attributes.get("fieldName");

        if (fieldName != null) {
            setFieldName(fieldName);
        }

        String oldValue = (String) attributes.get("oldValue");

        if (oldValue != null) {
            setOldValue(oldValue);
        }

        String newValue = (String) attributes.get("newValue");

        if (newValue != null) {
            setNewValue(newValue);
        }
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public void setId(int id) {
        _id = id;

        if (_entityFieldChangeRemoteModel != null) {
            try {
                Class<?> clazz = _entityFieldChangeRemoteModel.getClass();

                Method method = clazz.getMethod("setId", int.class);

                method.invoke(_entityFieldChangeRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getHistoryId() {
        return _historyId;
    }

    @Override
    public void setHistoryId(int historyId) {
        _historyId = historyId;

        if (_entityFieldChangeRemoteModel != null) {
            try {
                Class<?> clazz = _entityFieldChangeRemoteModel.getClass();

                Method method = clazz.getMethod("setHistoryId", int.class);

                method.invoke(_entityFieldChangeRemoteModel, historyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFieldName() {
        return _fieldName;
    }

    @Override
    public void setFieldName(String fieldName) {
        _fieldName = fieldName;

        if (_entityFieldChangeRemoteModel != null) {
            try {
                Class<?> clazz = _entityFieldChangeRemoteModel.getClass();

                Method method = clazz.getMethod("setFieldName", String.class);

                method.invoke(_entityFieldChangeRemoteModel, fieldName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOldValue() {
        return _oldValue;
    }

    @Override
    public void setOldValue(String oldValue) {
        _oldValue = oldValue;

        if (_entityFieldChangeRemoteModel != null) {
            try {
                Class<?> clazz = _entityFieldChangeRemoteModel.getClass();

                Method method = clazz.getMethod("setOldValue", String.class);

                method.invoke(_entityFieldChangeRemoteModel, oldValue);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNewValue() {
        return _newValue;
    }

    @Override
    public void setNewValue(String newValue) {
        _newValue = newValue;

        if (_entityFieldChangeRemoteModel != null) {
            try {
                Class<?> clazz = _entityFieldChangeRemoteModel.getClass();

                Method method = clazz.getMethod("setNewValue", String.class);

                method.invoke(_entityFieldChangeRemoteModel, newValue);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getEntityFieldChangeRemoteModel() {
        return _entityFieldChangeRemoteModel;
    }

    public void setEntityFieldChangeRemoteModel(
        BaseModel<?> entityFieldChangeRemoteModel) {
        _entityFieldChangeRemoteModel = entityFieldChangeRemoteModel;
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

        Class<?> remoteModelClass = _entityFieldChangeRemoteModel.getClass();

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

        Object returnValue = method.invoke(_entityFieldChangeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EntityFieldChangeLocalServiceUtil.addEntityFieldChange(this);
        } else {
            EntityFieldChangeLocalServiceUtil.updateEntityFieldChange(this);
        }
    }

    @Override
    public EntityFieldChange toEscapedModel() {
        return (EntityFieldChange) ProxyUtil.newProxyInstance(EntityFieldChange.class.getClassLoader(),
            new Class[] { EntityFieldChange.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EntityFieldChangeClp clone = new EntityFieldChangeClp();

        clone.setId(getId());
        clone.setHistoryId(getHistoryId());
        clone.setFieldName(getFieldName());
        clone.setOldValue(getOldValue());
        clone.setNewValue(getNewValue());

        return clone;
    }

    @Override
    public int compareTo(EntityFieldChange entityFieldChange) {
        int primaryKey = entityFieldChange.getPrimaryKey();

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

        if (!(obj instanceof EntityFieldChangeClp)) {
            return false;
        }

        EntityFieldChangeClp entityFieldChange = (EntityFieldChangeClp) obj;

        int primaryKey = entityFieldChange.getPrimaryKey();

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

        sb.append("{id=");
        sb.append(getId());
        sb.append(", historyId=");
        sb.append(getHistoryId());
        sb.append(", fieldName=");
        sb.append(getFieldName());
        sb.append(", oldValue=");
        sb.append(getOldValue());
        sb.append(", newValue=");
        sb.append(getNewValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("ru.isands.akimov.model.EntityFieldChange");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>historyId</column-name><column-value><![CDATA[");
        sb.append(getHistoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fieldName</column-name><column-value><![CDATA[");
        sb.append(getFieldName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>oldValue</column-name><column-value><![CDATA[");
        sb.append(getOldValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>newValue</column-name><column-value><![CDATA[");
        sb.append(getNewValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
