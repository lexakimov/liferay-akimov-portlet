package ru.akimov.model;

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
    private int _auditEntryId;
    private String _auditType;
    private String _entityType;
    private int _entityId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _dateOfChange;
    private String _metadata;

    public AuditEntrySoap() {
    }

    public static AuditEntrySoap toSoapModel(AuditEntry model) {
        AuditEntrySoap soapModel = new AuditEntrySoap();

        soapModel.setAuditEntryId(model.getAuditEntryId());
        soapModel.setAuditType(model.getAuditType());
        soapModel.setEntityType(model.getEntityType());
        soapModel.setEntityId(model.getEntityId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setDateOfChange(model.getDateOfChange());
        soapModel.setMetadata(model.getMetadata());

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
        return _auditEntryId;
    }

    public void setPrimaryKey(int pk) {
        setAuditEntryId(pk);
    }

    public int getAuditEntryId() {
        return _auditEntryId;
    }

    public void setAuditEntryId(int auditEntryId) {
        _auditEntryId = auditEntryId;
    }

    public String getAuditType() {
        return _auditType;
    }

    public void setAuditType(String auditType) {
        _auditType = auditType;
    }

    public String getEntityType() {
        return _entityType;
    }

    public void setEntityType(String entityType) {
        _entityType = entityType;
    }

    public int getEntityId() {
        return _entityId;
    }

    public void setEntityId(int entityId) {
        _entityId = entityId;
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

    public Date getDateOfChange() {
        return _dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        _dateOfChange = dateOfChange;
    }

    public String getMetadata() {
        return _metadata;
    }

    public void setMetadata(String metadata) {
        _metadata = metadata;
    }
}
