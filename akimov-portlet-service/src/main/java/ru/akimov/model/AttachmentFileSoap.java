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
public class AttachmentFileSoap implements Serializable {
    private int _id;
    private String _fileName;
    private String _extension;
    private int _size;
    private String _mimeType;
    private Blob _data;
    private Date _uploaded;
    private int _userId;

    public AttachmentFileSoap() {
    }

    public static AttachmentFileSoap toSoapModel(AttachmentFile model) {
        AttachmentFileSoap soapModel = new AttachmentFileSoap();

        soapModel.setId(model.getId());
        soapModel.setFileName(model.getFileName());
        soapModel.setExtension(model.getExtension());
        soapModel.setSize(model.getSize());
        soapModel.setMimeType(model.getMimeType());
        soapModel.setData(model.getData());
        soapModel.setUploaded(model.getUploaded());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static AttachmentFileSoap[] toSoapModels(AttachmentFile[] models) {
        AttachmentFileSoap[] soapModels = new AttachmentFileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AttachmentFileSoap[][] toSoapModels(AttachmentFile[][] models) {
        AttachmentFileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AttachmentFileSoap[models.length][models[0].length];
        } else {
            soapModels = new AttachmentFileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AttachmentFileSoap[] toSoapModels(List<AttachmentFile> models) {
        List<AttachmentFileSoap> soapModels = new ArrayList<AttachmentFileSoap>(models.size());

        for (AttachmentFile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AttachmentFileSoap[soapModels.size()]);
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

    public String getFileName() {
        return _fileName;
    }

    public void setFileName(String fileName) {
        _fileName = fileName;
    }

    public String getExtension() {
        return _extension;
    }

    public void setExtension(String extension) {
        _extension = extension;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }

    public String getMimeType() {
        return _mimeType;
    }

    public void setMimeType(String mimeType) {
        _mimeType = mimeType;
    }

    public Blob getData() {
        return _data;
    }

    public void setData(Blob data) {
        _data = data;
    }

    public Date getUploaded() {
        return _uploaded;
    }

    public void setUploaded(Date uploaded) {
        _uploaded = uploaded;
    }

    public int getUserId() {
        return _userId;
    }

    public void setUserId(int userId) {
        _userId = userId;
    }
}
