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
public class AuditEntryGroupSoap implements Serializable {
    private int _entryGroupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _eventDate;

    public AuditEntryGroupSoap() {
    }

    public static AuditEntryGroupSoap toSoapModel(AuditEntryGroup model) {
        AuditEntryGroupSoap soapModel = new AuditEntryGroupSoap();

        soapModel.setEntryGroupId(model.getEntryGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setEventDate(model.getEventDate());

        return soapModel;
    }

    public static AuditEntryGroupSoap[] toSoapModels(AuditEntryGroup[] models) {
        AuditEntryGroupSoap[] soapModels = new AuditEntryGroupSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AuditEntryGroupSoap[][] toSoapModels(
        AuditEntryGroup[][] models) {
        AuditEntryGroupSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AuditEntryGroupSoap[models.length][models[0].length];
        } else {
            soapModels = new AuditEntryGroupSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AuditEntryGroupSoap[] toSoapModels(
        List<AuditEntryGroup> models) {
        List<AuditEntryGroupSoap> soapModels = new ArrayList<AuditEntryGroupSoap>(models.size());

        for (AuditEntryGroup model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AuditEntryGroupSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _entryGroupId;
    }

    public void setPrimaryKey(int pk) {
        setEntryGroupId(pk);
    }

    public int getEntryGroupId() {
        return _entryGroupId;
    }

    public void setEntryGroupId(int entryGroupId) {
        _entryGroupId = entryGroupId;
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

    public Date getEventDate() {
        return _eventDate;
    }

    public void setEventDate(Date eventDate) {
        _eventDate = eventDate;
    }
}
