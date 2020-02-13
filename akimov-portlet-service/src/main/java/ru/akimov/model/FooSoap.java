package ru.akimov.model;

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FooSoap implements Serializable {
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

    public FooSoap() {
    }

    public static FooSoap toSoapModel(Foo model) {
        FooSoap soapModel = new FooSoap();

        soapModel.setFooId(model.getFooId());
        soapModel.setBooleanField(model.getBooleanField());
        soapModel.setShortField(model.getShortField());
        soapModel.setIntField(model.getIntField());
        soapModel.setLongField(model.getLongField());
        soapModel.setDoubleField(model.getDoubleField());
        soapModel.setFloatField(model.getFloatField());
        soapModel.setStringField(model.getStringField());
        soapModel.setDateField(model.getDateField());
        soapModel.setBlobField(model.getBlobField());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static FooSoap[] toSoapModels(Foo[] models) {
        FooSoap[] soapModels = new FooSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FooSoap[][] toSoapModels(Foo[][] models) {
        FooSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FooSoap[models.length][models[0].length];
        } else {
            soapModels = new FooSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FooSoap[] toSoapModels(List<Foo> models) {
        List<FooSoap> soapModels = new ArrayList<FooSoap>(models.size());

        for (Foo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FooSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _fooId;
    }

    public void setPrimaryKey(int pk) {
        setFooId(pk);
    }

    public int getFooId() {
        return _fooId;
    }

    public void setFooId(int fooId) {
        _fooId = fooId;
    }

    public boolean getBooleanField() {
        return _booleanField;
    }

    public boolean isBooleanField() {
        return _booleanField;
    }

    public void setBooleanField(boolean booleanField) {
        _booleanField = booleanField;
    }

    public short getShortField() {
        return _shortField;
    }

    public void setShortField(short shortField) {
        _shortField = shortField;
    }

    public int getIntField() {
        return _intField;
    }

    public void setIntField(int intField) {
        _intField = intField;
    }

    public long getLongField() {
        return _longField;
    }

    public void setLongField(long longField) {
        _longField = longField;
    }

    public double getDoubleField() {
        return _doubleField;
    }

    public void setDoubleField(double doubleField) {
        _doubleField = doubleField;
    }

    public float getFloatField() {
        return _floatField;
    }

    public void setFloatField(float floatField) {
        _floatField = floatField;
    }

    public String getStringField() {
        return _stringField;
    }

    public void setStringField(String stringField) {
        _stringField = stringField;
    }

    public Date getDateField() {
        return _dateField;
    }

    public void setDateField(Date dateField) {
        _dateField = dateField;
    }

    public Blob getBlobField() {
        return _blobField;
    }

    public void setBlobField(Blob blobField) {
        _blobField = blobField;
    }

    public short getStatus() {
        return _status;
    }

    public void setStatus(short status) {
        _status = status;
    }
}
