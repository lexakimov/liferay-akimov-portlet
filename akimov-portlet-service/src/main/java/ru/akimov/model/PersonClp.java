package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.akimov.service.ClpSerializer;
import ru.akimov.service.PersonLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PersonClp extends BaseModelImpl<Person> implements Person {
    private int _personId;
    private String _lastName;
    private String _firstName;
    private String _middleName;
    private int _gender;
    private Date _birthDate;
    private String _address;
    private BaseModel<?> _personRemoteModel;
    private Class<?> _clpSerializerClass = ClpSerializer.class;

    public PersonClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Person.class;
    }

    @Override
    public String getModelClassName() {
        return Person.class.getName();
    }

    @Override
    public int getPrimaryKey() {
        return _personId;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setPersonId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _personId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("personId", getPersonId());
        attributes.put("lastName", getLastName());
        attributes.put("firstName", getFirstName());
        attributes.put("middleName", getMiddleName());
        attributes.put("gender", getGender());
        attributes.put("birthDate", getBirthDate());
        attributes.put("address", getAddress());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer personId = (Integer) attributes.get("personId");

        if (personId != null) {
            setPersonId(personId);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String middleName = (String) attributes.get("middleName");

        if (middleName != null) {
            setMiddleName(middleName);
        }

        Integer gender = (Integer) attributes.get("gender");

        if (gender != null) {
            setGender(gender);
        }

        Date birthDate = (Date) attributes.get("birthDate");

        if (birthDate != null) {
            setBirthDate(birthDate);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }
    }

    @Override
    public int getPersonId() {
        return _personId;
    }

    @Override
    public void setPersonId(int personId) {
        _personId = personId;

        if (_personRemoteModel != null) {
            try {
                Class<?> clazz = _personRemoteModel.getClass();

                Method method = clazz.getMethod("setPersonId", int.class);

                method.invoke(_personRemoteModel, personId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;

        if (_personRemoteModel != null) {
            try {
                Class<?> clazz = _personRemoteModel.getClass();

                Method method = clazz.getMethod("setLastName", String.class);

                method.invoke(_personRemoteModel, lastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;

        if (_personRemoteModel != null) {
            try {
                Class<?> clazz = _personRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstName", String.class);

                method.invoke(_personRemoteModel, firstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMiddleName() {
        return _middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        _middleName = middleName;

        if (_personRemoteModel != null) {
            try {
                Class<?> clazz = _personRemoteModel.getClass();

                Method method = clazz.getMethod("setMiddleName", String.class);

                method.invoke(_personRemoteModel, middleName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getGender() {
        return _gender;
    }

    @Override
    public void setGender(int gender) {
        _gender = gender;

        if (_personRemoteModel != null) {
            try {
                Class<?> clazz = _personRemoteModel.getClass();

                Method method = clazz.getMethod("setGender", int.class);

                method.invoke(_personRemoteModel, gender);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getBirthDate() {
        return _birthDate;
    }

    @Override
    public void setBirthDate(Date birthDate) {
        _birthDate = birthDate;

        if (_personRemoteModel != null) {
            try {
                Class<?> clazz = _personRemoteModel.getClass();

                Method method = clazz.getMethod("setBirthDate", Date.class);

                method.invoke(_personRemoteModel, birthDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAddress() {
        return _address;
    }

    @Override
    public void setAddress(String address) {
        _address = address;

        if (_personRemoteModel != null) {
            try {
                Class<?> clazz = _personRemoteModel.getClass();

                Method method = clazz.getMethod("setAddress", String.class);

                method.invoke(_personRemoteModel, address);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPersonRemoteModel() {
        return _personRemoteModel;
    }

    public void setPersonRemoteModel(BaseModel<?> personRemoteModel) {
        _personRemoteModel = personRemoteModel;
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

        Class<?> remoteModelClass = _personRemoteModel.getClass();

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

        Object returnValue = method.invoke(_personRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PersonLocalServiceUtil.addPerson(this);
        } else {
            PersonLocalServiceUtil.updatePerson(this);
        }
    }

    @Override
    public Person toEscapedModel() {
        return (Person) ProxyUtil.newProxyInstance(Person.class.getClassLoader(),
            new Class[] { Person.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PersonClp clone = new PersonClp();

        clone.setPersonId(getPersonId());
        clone.setLastName(getLastName());
        clone.setFirstName(getFirstName());
        clone.setMiddleName(getMiddleName());
        clone.setGender(getGender());
        clone.setBirthDate(getBirthDate());
        clone.setAddress(getAddress());

        return clone;
    }

    @Override
    public int compareTo(Person person) {
        int primaryKey = person.getPrimaryKey();

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

        if (!(obj instanceof PersonClp)) {
            return false;
        }

        PersonClp person = (PersonClp) obj;

        int primaryKey = person.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{personId=");
        sb.append(getPersonId());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", middleName=");
        sb.append(getMiddleName());
        sb.append(", gender=");
        sb.append(getGender());
        sb.append(", birthDate=");
        sb.append(getBirthDate());
        sb.append(", address=");
        sb.append(getAddress());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("ru.isands.akimov.model.Person");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>personId</column-name><column-value><![CDATA[");
        sb.append(getPersonId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>middleName</column-name><column-value><![CDATA[");
        sb.append(getMiddleName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>gender</column-name><column-value><![CDATA[");
        sb.append(getGender());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>birthDate</column-name><column-value><![CDATA[");
        sb.append(getBirthDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
