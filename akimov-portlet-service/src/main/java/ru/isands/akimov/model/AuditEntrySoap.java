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
public class AuditEntrySoap implements Serializable {
    private int _id;
    private int _entityId;
    private String _entityType;
    private long _companyId;
    private long _userId;
    private String _userName;
    private String _description;
    private Date _dateOfChange;

    public AuditEntrySoap() {
    }

    public static AuditEntrySoap toSoapModel(AuditEntry model) {
        AuditEntrySoap soapModel = new AuditEntrySoap();

        soapModel.setId(model.getId());
        soapModel.setEntityId(model.getEntityId());
        soapModel.setEntityType(model.getEntityType());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setDescription(model.getDescription());
        soapModel.setDateOfChange(model.getDateOfChange());

        return soapModel;
    }

    public static AuditEntrySoap[] toSoapModels(AuditEntry[] models) {
        AuditEntrySoap[] soapModels = new AuditEntrySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AuditEntrySoap[][] toSoapModels(AuditEntry[][] models) {
        AuditEntrySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AuditEntrySoap[models.length][models[0].length];
        } else {
            soapModels = new AuditEntrySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AuditEntrySoap[] toSoapModels(List<AuditEntry> models) {
        List<AuditEntrySoap> soapModels = new ArrayList<AuditEntrySoap>(models.size());

        for (AuditEntry model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AuditEntrySoap[soapModels.size()]);
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

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
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
