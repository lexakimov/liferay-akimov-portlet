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
public class EntityEditingHistorySoap implements Serializable {
    private int _id;
    private int _entityId;
    private String _entityType;
    private long _userId;
    private String _description;
    private Date _dateOfChange;

    public EntityEditingHistorySoap() {
    }

    public static EntityEditingHistorySoap toSoapModel(
        EntityEditingHistory model) {
        EntityEditingHistorySoap soapModel = new EntityEditingHistorySoap();

        soapModel.setId(model.getId());
        soapModel.setEntityId(model.getEntityId());
        soapModel.setEntityType(model.getEntityType());
        soapModel.setUserId(model.getUserId());
        soapModel.setDescription(model.getDescription());
        soapModel.setDateOfChange(model.getDateOfChange());

        return soapModel;
    }

    public static EntityEditingHistorySoap[] toSoapModels(
        EntityEditingHistory[] models) {
        EntityEditingHistorySoap[] soapModels = new EntityEditingHistorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EntityEditingHistorySoap[][] toSoapModels(
        EntityEditingHistory[][] models) {
        EntityEditingHistorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EntityEditingHistorySoap[models.length][models[0].length];
        } else {
            soapModels = new EntityEditingHistorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EntityEditingHistorySoap[] toSoapModels(
        List<EntityEditingHistory> models) {
        List<EntityEditingHistorySoap> soapModels = new ArrayList<EntityEditingHistorySoap>(models.size());

        for (EntityEditingHistory model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EntityEditingHistorySoap[soapModels.size()]);
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

    public int getEntityId() {
        return _entityId;
    }

    public void setEntityId(int entityId) {
        _entityId = entityId;
    }

    public String getEntityType() {
        return _entityType;
    }

    public void setEntityType(String entityType) {
        _entityType = entityType;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Date getDateOfChange() {
        return _dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        _dateOfChange = dateOfChange;
    }
}
