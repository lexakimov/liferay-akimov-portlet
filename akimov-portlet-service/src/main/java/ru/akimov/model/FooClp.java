package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.akimov.service.ClpSerializer;
import ru.akimov.service.FooLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class FooClp extends BaseModelImpl<Foo> implements Foo {
    private int _fooId;
    private boolean _booleanField;
    private short _shortField;
    private int _intField;
    private long _longField;
    private double _doubleField;
    private float _floatField;
    private String _stringField;
    private Date _dateField;
    private Blob _blobField;
    private short _status;
    private BaseModel<?> _fooRemoteModel;
    private Class<?> _clpSerializerClass = ru.akimov.service.ClpSerializer.class;

    public FooClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Foo.class;
    }

    @Override
    public String getModelClassName() {
        return Foo.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _fooId;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setFooId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _fooId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fooId", getFooId());
        attributes.put("booleanField", getBooleanField());
        attributes.put("shortField", getShortField());
        attributes.put("intField", getIntField());
        attributes.put("longField", getLongField());
        attributes.put("doubleField", getDoubleField());
        attributes.put("floatField", getFloatField());
        attributes.put("stringField", getStringField());
        attributes.put("dateField", getDateField());
        attributes.put("blobField", getBlobField());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer fooId = (Integer) attributes.get("fooId");

        if (fooId != null) {
            setFooId(fooId);
        }

        Boolean booleanField = (Boolean) attributes.get("booleanField");

        if (booleanField != null) {
            setBooleanField(booleanField);
        }

        Short shortField = (Short) attributes.get("shortField");

        if (shortField != null) {
            setShortField(shortField);
        }

        Integer intField = (Integer) attributes.get("intField");

        if (intField != null) {
            setIntField(intField);
        }

        Long longField = (Long) attributes.get("longField");

        if (longField != null) {
            setLongField(longField);
        }

        Double doubleField = (Double) attributes.get("doubleField");

        if (doubleField != null) {
            setDoubleField(doubleField);
        }

        Float floatField = (Float) attributes.get("floatField");

        if (floatField != null) {
            setFloatField(floatField);
        }

        String stringField = (String) attributes.get("stringField");

        if (stringField != null) {
            setStringField(stringField);
        }

        Date dateField = (Date) attributes.get("dateField");

        if (dateField != null) {
            setDateField(dateField);
        }

        Blob blobField = (Blob) attributes.get("blobField");

        if (blobField != null) {
            setBlobField(blobField);
        }

        Short status = (Short) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    @Override
    public int getFooId() {
        return _fooId;
    }

    @Override
    public void setFooId(int fooId) {
        _fooId = fooId;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setFooId", int.class);

                method.invoke(_fooRemoteModel, fooId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getBooleanField() {
        return _booleanField;
    }

    @Override
    public boolean isBooleanField() {
        return _booleanField;
    }

    @Override
    public void setBooleanField(boolean booleanField) {
        _booleanField = booleanField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setBooleanField", boolean.class);

                method.invoke(_fooRemoteModel, booleanField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public short getShortField() {
        return _shortField;
    }

    @Override
    public void setShortField(short shortField) {
        _shortField = shortField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setShortField", short.class);

                method.invoke(_fooRemoteModel, shortField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getIntField() {
        return _intField;
    }

    @Override
    public void setIntField(int intField) {
        _intField = intField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setIntField", int.class);

                method.invoke(_fooRemoteModel, intField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getLongField() {
        return _longField;
    }

    @Override
    public void setLongField(long longField) {
        _longField = longField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setLongField", long.class);

                method.invoke(_fooRemoteModel, longField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getDoubleField() {
        return _doubleField;
    }

    @Override
    public void setDoubleField(double doubleField) {
        _doubleField = doubleField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setDoubleField", double.class);

                method.invoke(_fooRemoteModel, doubleField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public float getFloatField() {
        return _floatField;
    }

    @Override
    public void setFloatField(float floatField) {
        _floatField = floatField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setFloatField", float.class);

                method.invoke(_fooRemoteModel, floatField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStringField() {
        return _stringField;
    }

    @Override
    public void setStringField(String stringField) {
        _stringField = stringField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setStringField", String.class);

                method.invoke(_fooRemoteModel, stringField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getDateField() {
        return _dateField;
    }

    @Override
    public void setDateField(Date dateField) {
        _dateField = dateField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setDateField", Date.class);

                method.invoke(_fooRemoteModel, dateField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Blob getBlobField() {
        return _blobField;
    }

    @Override
    public void setBlobField(Blob blobField) {
        _blobField = blobField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setBlobField", Blob.class);

                method.invoke(_fooRemoteModel, blobField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public short getStatus() {
        return _status;
    }

    @Override
    public void setStatus(short status) {
        _status = status;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", short.class);

                method.invoke(_fooRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFooRemoteModel() {
        return _fooRemoteModel;
    }

    public void setFooRemoteModel(BaseModel<?> fooRemoteModel) {
        _fooRemoteModel = fooRemoteModel;
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

        Class<?> remoteModelClass = _fooRemoteModel.getClass();

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

        Object returnValue = method.invoke(_fooRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FooLocalServiceUtil.addFoo(this);
        } else {
            FooLocalServiceUtil.updateFoo(this);
        }
    }

    @Override
    public Foo toEscapedModel() {
        return (Foo) ProxyUtil.newProxyInstance(Foo.class.getClassLoader(),
            new Class[] { Foo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FooClp clone = new FooClp();

        clone.setFooId(getFooId());
        clone.setBooleanField(getBooleanField());
        clone.setShortField(getShortField());
        clone.setIntField(getIntField());
        clone.setLongField(getLongField());
        clone.setDoubleField(getDoubleField());
        clone.setFloatField(getFloatField());
        clone.setStringField(getStringField());
        clone.setDateField(getDateField());
        clone.setBlobField(getBlobField());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(Foo foo) {
        int primaryKey = foo.getPrimaryKey();

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

        if (!(obj instanceof FooClp)) {
            return false;
        }

        FooClp foo = (FooClp) obj;

        int primaryKey = foo.getPrimaryKey();

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
        StringBundler sb = new StringBundler(23);

        sb.append("{fooId=");
        sb.append(getFooId());
        sb.append(", booleanField=");
        sb.append(getBooleanField());
        sb.append(", shortField=");
        sb.append(getShortField());
        sb.append(", intField=");
        sb.append(getIntField());
        sb.append(", longField=");
        sb.append(getLongField());
        sb.append(", doubleField=");
        sb.append(getDoubleField());
        sb.append(", floatField=");
        sb.append(getFloatField());
        sb.append(", stringField=");
        sb.append(getStringField());
        sb.append(", dateField=");
        sb.append(getDateField());
        sb.append(", blobField=");
        sb.append(getBlobField());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("ru.akimov.model.Foo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fooId</column-name><column-value><![CDATA[");
        sb.append(getFooId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>booleanField</column-name><column-value><![CDATA[");
        sb.append(getBooleanField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shortField</column-name><column-value><![CDATA[");
        sb.append(getShortField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>intField</column-name><column-value><![CDATA[");
        sb.append(getIntField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>longField</column-name><column-value><![CDATA[");
        sb.append(getLongField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>doubleField</column-name><column-value><![CDATA[");
        sb.append(getDoubleField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>floatField</column-name><column-value><![CDATA[");
        sb.append(getFloatField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stringField</column-name><column-value><![CDATA[");
        sb.append(getStringField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateField</column-name><column-value><![CDATA[");
        sb.append(getDateField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>blobField</column-name><column-value><![CDATA[");
        sb.append(getBlobField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
