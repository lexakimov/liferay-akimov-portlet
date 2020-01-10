package ru.isands.akimov.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the blobField column in Foo.
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooBlobFieldBlobModel {
    private int _fooId;
    private Blob _blobFieldBlob;

    public FooBlobFieldBlobModel() {
    }

    public FooBlobFieldBlobModel(int fooId) {
        _fooId = fooId;
    }

    public FooBlobFieldBlobModel(int fooId, Blob blobFieldBlob) {
        _fooId = fooId;
        _blobFieldBlob = blobFieldBlob;
    }

    public int getFooId() {
        return _fooId;
    }

    public void setFooId(int fooId) {
        _fooId = fooId;
    }

    public Blob getBlobFieldBlob() {
        return _blobFieldBlob;
    }

    public void setBlobFieldBlob(Blob blobFieldBlob) {
        _blobFieldBlob = blobFieldBlob;
    }
}
