package ru.isands.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.isands.akimov.model.Person;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Person in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Person
 * @generated
 */
public class PersonCacheModel implements CacheModel<Person>, Externalizable {
    public int personId;
    public String lastName;
    public String firstName;
    public String middleName;
    public int gender;
    public long birthDate;
    public String address;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{personId=");
        sb.append(personId);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", middleName=");
        sb.append(middleName);
        sb.append(", gender=");
        sb.append(gender);
        sb.append(", birthDate=");
        sb.append(birthDate);
        sb.append(", address=");
        sb.append(address);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Person toEntityModel() {
        PersonImpl personImpl = new PersonImpl();

        personImpl.setPersonId(personId);

        if (lastName == null) {
            personImpl.setLastName(StringPool.BLANK);
        } else {
            personImpl.setLastName(lastName);
        }

        if (firstName == null) {
            personImpl.setFirstName(StringPool.BLANK);
        } else {
            personImpl.setFirstName(firstName);
        }

        if (middleName == null) {
            personImpl.setMiddleName(StringPool.BLANK);
        } else {
            personImpl.setMiddleName(middleName);
        }

        personImpl.setGender(gender);

        if (birthDate == Long.MIN_VALUE) {
            personImpl.setBirthDate(null);
        } else {
            personImpl.setBirthDate(new Date(birthDate));
        }

        if (address == null) {
            personImpl.setAddress(StringPool.BLANK);
        } else {
            personImpl.setAddress(address);
        }

        personImpl.resetOriginalValues();

        return personImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        personId = objectInput.readInt();
        lastName = objectInput.readUTF();
        firstName = objectInput.readUTF();
        middleName = objectInput.readUTF();
        gender = objectInput.readInt();
        birthDate = objectInput.readLong();
        address = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(personId);

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }

        if (middleName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(middleName);
        }

        objectOutput.writeInt(gender);
        objectOutput.writeLong(birthDate);

        if (address == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(address);
        }
    }
}
