package ru.isands.akimov.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EntityFieldChangeSoap implements Serializable {
    private int _id;
    private int _auditEntryId;
    private String _fieldName;
    private String _oldValue;
    private String _newValue;

    public EntityFieldChangeSoap() {
    }

    public static EntityFieldChangeSoap toSoapModel(EntityFieldChange model) {
        EntityFieldChangeSoap soapModel = new EntityFieldChangeSoap();

        soapModel.setId(model.getId());
        soapModel.setAuditEntryId(model.getAuditEntryId());
        soapModel.setFieldName(model.getFieldName());
        soapModel.setOldValue(model.getOldValue());
        soapModel.setNewValue(model.getNewValue());

        return soapModel;
    }

    public static EntityFieldChangeSoap[] toSoapModels(
        EntityFieldChange[] models) {
        EntityFieldChangeSoap[] soapModels = new EntityFieldChangeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EntityFieldChangeSoap[][] toSoapModels(
        EntityFieldChange[][] models) {
        EntityFieldChangeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EntityFieldChangeSoap[models.length][models[0].length];
        } else {
            soapModels = new EntityFieldChangeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EntityFieldChangeSoap[] toSoapModels(
        List<EntityFieldChange> models) {
        List<EntityFieldChangeSoap> soapModels = new ArrayList<EntityFieldChangeSoap>(models.size());

        for (EntityFieldChange model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EntityFieldChangeSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(int pk) {
        setId(pk);
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getAuditEntryId() {
        return _auditEntryId;
    }

    public void setAuditEntryId(int auditEntryId) {
        _auditEntryId = auditEntryId;
    }

    public String getFieldName() {
        return _fieldName;
    }

    public void setFieldName(String fieldName) {
        _fieldName = fieldName;
    }

    public String getOldValue() {
        return _oldValue;
    }

    public void setOldValue(String oldValue) {
        _oldValue = oldValue;
    }

    public String getNewValue() {
        return _newValue;
    }

    public void setNewValue(String newValue) {
        _newValue = newValue;
    }
}
