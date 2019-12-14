package ru.isands.akimov.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersonSoap implements Serializable {
    private int _personId;
    private String _lastName;
    private String _firstName;
    private String _middleName;
    private int _gender;
    private Date _birthDate;
    private String _address;

    public PersonSoap() {
    }

    public static PersonSoap toSoapModel(Person model) {
        PersonSoap soapModel = new PersonSoap();

        soapModel.setPersonId(model.getPersonId());
        soapModel.setLastName(model.getLastName());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setMiddleName(model.getMiddleName());
        soapModel.setGender(model.getGender());
        soapModel.setBirthDate(model.getBirthDate());
        soapModel.setAddress(model.getAddress());

        return soapModel;
    }

    public static PersonSoap[] toSoapModels(Person[] models) {
        PersonSoap[] soapModels = new PersonSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PersonSoap[][] toSoapModels(Person[][] models) {
        PersonSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PersonSoap[models.length][models[0].length];
        } else {
            soapModels = new PersonSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PersonSoap[] toSoapModels(List<Person> models) {
        List<PersonSoap> soapModels = new ArrayList<PersonSoap>(models.size());

        for (Person model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PersonSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _personId;
    }

    public void setPrimaryKey(int pk) {
        setPersonId(pk);
    }

    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getMiddleName() {
        return _middleName;
    }

    public void setMiddleName(String middleName) {
        _middleName = middleName;
    }

    public int getGender() {
        return _gender;
    }

    public void setGender(int gender) {
        _gender = gender;
    }

    public Date getBirthDate() {
        return _birthDate;
    }

    public void setBirthDate(Date birthDate) {
        _birthDate = birthDate;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }
}
