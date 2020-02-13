package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Person service. Represents a row in the &quot;akimov_Person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.isands.akimov.model.impl.PersonModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.isands.akimov.model.impl.PersonImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Person
 * @see ru.isands.akimov.model.impl.PersonImpl
 * @see ru.isands.akimov.model.impl.PersonModelImpl
 * @generated
 */
public interface PersonModel extends BaseModel<Person> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a person model instance should use the {@link Person} interface instead.
     */

    /**
     * Returns the primary key of this person.
     *
     * @return the primary key of this person
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this person.
     *
     * @param primaryKey the primary key of this person
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the person ID of this person.
     *
     * @return the person ID of this person
     */
    public int getPersonId();

    /**
     * Sets the person ID of this person.
     *
     * @param personId the person ID of this person
     */
    public void setPersonId(int personId);

    /**
     * Returns the last name of this person.
     *
     * @return the last name of this person
     */
    @AutoEscape
    public String getLastName();

    /**
     * Sets the last name of this person.
     *
     * @param lastName the last name of this person
     */
    public void setLastName(String lastName);

    /**
     * Returns the first name of this person.
     *
     * @return the first name of this person
     */
    @AutoEscape
    public String getFirstName();

    /**
     * Sets the first name of this person.
     *
     * @param firstName the first name of this person
     */
    public void setFirstName(String firstName);

    /**
     * Returns the middle name of this person.
     *
     * @return the middle name of this person
     */
    @AutoEscape
    public String getMiddleName();

    /**
     * Sets the middle name of this person.
     *
     * @param middleName the middle name of this person
     */
    public void setMiddleName(String middleName);

    /**
     * Returns the gender of this person.
     *
     * @return the gender of this person
     */
    public int getGender();

    /**
     * Sets the gender of this person.
     *
     * @param gender the gender of this person
     */
    public void setGender(int gender);

    /**
     * Returns the birth date of this person.
     *
     * @return the birth date of this person
     */
    public Date getBirthDate();

    /**
     * Sets the birth date of this person.
     *
     * @param birthDate the birth date of this person
     */
    public void setBirthDate(Date birthDate);

    /**
     * Returns the address of this person.
     *
     * @return the address of this person
     */
    @AutoEscape
    public String getAddress();

    /**
     * Sets the address of this person.
     *
     * @param address the address of this person
     */
    public void setAddress(String address);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(Person person);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Person> toCacheModel();

    @Override
    public Person toEscapedModel();

    @Override
    public Person toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}