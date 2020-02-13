package ru.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Person}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Person
 * @generated
 */
public class PersonWrapper implements Person, ModelWrapper<Person> {
    private Person _person;

    public PersonWrapper(Person person) {
        _person = person;
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

    /**
    * Returns the primary key of this person.
    *
    * @return the primary key of this person
    */
    @Override
    public int getPrimaryKey() {
        return _person.getPrimaryKey();
    }

    /**
    * Sets the primary key of this person.
    *
    * @param primaryKey the primary key of this person
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _person.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the person ID of this person.
    *
    * @return the person ID of this person
    */
    @Override
    public int getPersonId() {
        return _person.getPersonId();
    }

    /**
    * Sets the person ID of this person.
    *
    * @param personId the person ID of this person
    */
    @Override
    public void setPersonId(int personId) {
        _person.setPersonId(personId);
    }

    /**
    * Returns the last name of this person.
    *
    * @return the last name of this person
    */
    @Override
    public java.lang.String getLastName() {
        return _person.getLastName();
    }

    /**
    * Sets the last name of this person.
    *
    * @param lastName the last name of this person
    */
    @Override
    public void setLastName(java.lang.String lastName) {
        _person.setLastName(lastName);
    }

    /**
    * Returns the first name of this person.
    *
    * @return the first name of this person
    */
    @Override
    public java.lang.String getFirstName() {
        return _person.getFirstName();
    }

    /**
    * Sets the first name of this person.
    *
    * @param firstName the first name of this person
    */
    @Override
    public void setFirstName(java.lang.String firstName) {
        _person.setFirstName(firstName);
    }

    /**
    * Returns the middle name of this person.
    *
    * @return the middle name of this person
    */
    @Override
    public java.lang.String getMiddleName() {
        return _person.getMiddleName();
    }

    /**
    * Sets the middle name of this person.
    *
    * @param middleName the middle name of this person
    */
    @Override
    public void setMiddleName(java.lang.String middleName) {
        _person.setMiddleName(middleName);
    }

    /**
    * Returns the gender of this person.
    *
    * @return the gender of this person
    */
    @Override
    public int getGender() {
        return _person.getGender();
    }

    /**
    * Sets the gender of this person.
    *
    * @param gender the gender of this person
    */
    @Override
    public void setGender(int gender) {
        _person.setGender(gender);
    }

    /**
    * Returns the birth date of this person.
    *
    * @return the birth date of this person
    */
    @Override
    public java.util.Date getBirthDate() {
        return _person.getBirthDate();
    }

    /**
    * Sets the birth date of this person.
    *
    * @param birthDate the birth date of this person
    */
    @Override
    public void setBirthDate(java.util.Date birthDate) {
        _person.setBirthDate(birthDate);
    }

    /**
    * Returns the address of this person.
    *
    * @return the address of this person
    */
    @Override
    public java.lang.String getAddress() {
        return _person.getAddress();
    }

    /**
    * Sets the address of this person.
    *
    * @param address the address of this person
    */
    @Override
    public void setAddress(java.lang.String address) {
        _person.setAddress(address);
    }

    @Override
    public boolean isNew() {
        return _person.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _person.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _person.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _person.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _person.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _person.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _person.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _person.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _person.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _person.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _person.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PersonWrapper((Person) _person.clone());
    }

    @Override
    public int compareTo(ru.akimov.model.Person person) {
        return _person.compareTo(person);
    }

    @Override
    public int hashCode() {
        return _person.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.akimov.model.Person> toCacheModel() {
        return _person.toCacheModel();
    }

    @Override
    public ru.akimov.model.Person toEscapedModel() {
        return new PersonWrapper(_person.toEscapedModel());
    }

    @Override
    public ru.akimov.model.Person toUnescapedModel() {
        return new PersonWrapper(_person.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _person.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _person.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _person.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PersonWrapper)) {
            return false;
        }

        PersonWrapper personWrapper = (PersonWrapper) obj;

        if (Validator.equals(_person, personWrapper._person)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Person getWrappedPerson() {
        return _person;
    }

    @Override
    public Person getWrappedModel() {
        return _person;
    }

    @Override
    public void resetOriginalValues() {
        _person.resetOriginalValues();
    }
}
