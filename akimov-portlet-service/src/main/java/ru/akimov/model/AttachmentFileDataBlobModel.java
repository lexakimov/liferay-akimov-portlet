package ru.akimov.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the data column in AttachmentFile.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentFile
 * @generated
 */
public class AttachmentFileDataBlobModel {
    private int _id;
    private Blob _dataBlob;

    public AttachmentFileDataBlobModel() {
    }

    public AttachmentFileDataBlobModel(int id) {
        _id = id;
    }

    public AttachmentFileDataBlobModel(int id, Blob dataBlob) {
        _id = id;
        _dataBlob = dataBlob;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public Blob getDataBlob() {
        return _dataBlob;
    }

    public void setDataBlob(Blob dataBlob) {
        _dataBlob = dataBlob;
    }
}
