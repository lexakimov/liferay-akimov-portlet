package ru.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Foo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooWrapper implements Foo, ModelWrapper<Foo> {
    private Foo _foo;

    public FooWrapper(Foo foo) {
        _foo = foo;
    }

    @Override
    public Class<?> getModelClass() {
        return Foo.class;
    }

    @Override
    public String getModelClassName() {
        return Foo.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fooId", getFooId());
        attributes.put("booleanField", getBooleanField());
        attributes.put("shortField", getShortField());
        attributes.put("intField", getIntField());
        attributes.put("longField", getLongField());
        attributes.put("doubleField", getDoubleField());
        attributes.put("floatField", getFloatField());
        attributes.put("stringField", getStringField());
        attributes.put("dateField", getDateField());
        attributes.put("blobField", getBlobField());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer fooId = (Integer) attributes.get("fooId");

        if (fooId != null) {
            setFooId(fooId);
        }

        Boolean booleanField = (Boolean) attributes.get("booleanField");

        if (booleanField != null) {
            setBooleanField(booleanField);
        }

        Short shortField = (Short) attributes.get("shortField");

        if (shortField != null) {
            setShortField(shortField);
        }

        Integer intField = (Integer) attributes.get("intField");

        if (intField != null) {
            setIntField(intField);
        }

        Long longField = (Long) attributes.get("longField");

        if (longField != null) {
            setLongField(longField);
        }

        Double doubleField = (Double) attributes.get("doubleField");

        if (doubleField != null) {
            setDoubleField(doubleField);
        }

        Float floatField = (Float) attributes.get("floatField");

        if (floatField != null) {
            setFloatField(floatField);
        }

        String stringField = (String) attributes.get("stringField");

        if (stringField != null) {
            setStringField(stringField);
        }

        Date dateField = (Date) attributes.get("dateField");

        if (dateField != null) {
            setDateField(dateField);
        }

        Blob blobField = (Blob) attributes.get("blobField");

        if (blobField != null) {
            setBlobField(blobField);
        }

        Short status = (Short) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    /**
    * Returns the primary key of this foo.
    *
    * @return the primary key of this foo
    */
    @Override
    public int getPrimaryKey() {
        return _foo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this foo.
    *
    * @param primaryKey the primary key of this foo
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _foo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the foo ID of this foo.
    *
    * @return the foo ID of this foo
    */
    @Override
    public int getFooId() {
        return _foo.getFooId();
    }

    /**
    * Sets the foo ID of this foo.
    *
    * @param fooId the foo ID of this foo
    */
    @Override
    public void setFooId(int fooId) {
        _foo.setFooId(fooId);
    }

    /**
    * Returns the boolean field of this foo.
    *
    * @return the boolean field of this foo
    */
    @Override
    public boolean getBooleanField() {
        return _foo.getBooleanField();
    }

    /**
    * Returns <code>true</code> if this foo is boolean field.
    *
    * @return <code>true</code> if this foo is boolean field; <code>false</code> otherwise
    */
    @Override
    public boolean isBooleanField() {
        return _foo.isBooleanField();
    }

    /**
    * Sets whether this foo is boolean field.
    *
    * @param booleanField the boolean field of this foo
    */
    @Override
    public void setBooleanField(boolean booleanField) {
        _foo.setBooleanField(booleanField);
    }

    /**
    * Returns the short field of this foo.
    *
    * @return the short field of this foo
    */
    @Override
    public short getShortField() {
        return _foo.getShortField();
    }

    /**
    * Sets the short field of this foo.
    *
    * @param shortField the short field of this foo
    */
    @Override
    public void setShortField(short shortField) {
        _foo.setShortField(shortField);
    }

    /**
    * Returns the int field of this foo.
    *
    * @return the int field of this foo
    */
    @Override
    public int getIntField() {
        return _foo.getIntField();
    }

    /**
    * Sets the int field of this foo.
    *
    * @param intField the int field of this foo
    */
    @Override
    public void setIntField(int intField) {
        _foo.setIntField(intField);
    }

    /**
    * Returns the long field of this foo.
    *
    * @return the long field of this foo
    */
    @Override
    public long getLongField() {
        return _foo.getLongField();
    }

    /**
    * Sets the long field of this foo.
    *
    * @param longField the long field of this foo
    */
    @Override
    public void setLongField(long longField) {
        _foo.setLongField(longField);
    }

    /**
    * Returns the double field of this foo.
    *
    * @return the double field of this foo
    */
    @Override
    public double getDoubleField() {
        return _foo.getDoubleField();
    }

    /**
    * Sets the double field of this foo.
    *
    * @param doubleField the double field of this foo
    */
    @Override
    public void setDoubleField(double doubleField) {
        _foo.setDoubleField(doubleField);
    }

    /**
    * Returns the float field of this foo.
    *
    * @return the float field of this foo
    */
    @Override
    public float getFloatField() {
        return _foo.getFloatField();
    }

    /**
    * Sets the float field of this foo.
    *
    * @param floatField the float field of this foo
    */
    @Override
    public void setFloatField(float floatField) {
        _foo.setFloatField(floatField);
    }

    /**
    * Returns the string field of this foo.
    *
    * @return the string field of this foo
    */
    @Override
    public java.lang.String getStringField() {
        return _foo.getStringField();
    }

    /**
    * Sets the string field of this foo.
    *
    * @param stringField the string field of this foo
    */
    @Override
    public void setStringField(java.lang.String stringField) {
        _foo.setStringField(stringField);
    }

    /**
    * Returns the date field of this foo.
    *
    * @return the date field of this foo
    */
    @Override
    public java.util.Date getDateField() {
        return _foo.getDateField();
    }

    /**
    * Sets the date field of this foo.
    *
    * @param dateField the date field of this foo
    */
    @Override
    public void setDateField(java.util.Date dateField) {
        _foo.setDateField(dateField);
    }

    /**
    * Returns the blob field of this foo.
    *
    * @return the blob field of this foo
    */
    @Override
    public java.sql.Blob getBlobField() {
        return _foo.getBlobField();
    }

    /**
    * Sets the blob field of this foo.
    *
    * @param blobField the blob field of this foo
    */
    @Override
    public void setBlobField(java.sql.Blob blobField) {
        _foo.setBlobField(blobField);
    }

    /**
    * Returns the status of this foo.
    *
    * @return the status of this foo
    */
    @Override
    public short getStatus() {
        return _foo.getStatus();
    }

    /**
    * Sets the status of this foo.
    *
    * @param status the status of this foo
    */
    @Override
    public void setStatus(short status) {
        _foo.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _foo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _foo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _foo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _foo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _foo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _foo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _foo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _foo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _foo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _foo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _foo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FooWrapper((Foo) _foo.clone());
    }

    @Override
    public int compareTo(Foo foo) {
        return _foo.compareTo(foo);
    }

    @Override
    public int hashCode() {
        return _foo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Foo> toCacheModel() {
        return _foo.toCacheModel();
    }

    @Override
    public Foo toEscapedModel() {
        return new FooWrapper(_foo.toEscapedModel());
    }

    @Override
    public Foo toUnescapedModel() {
        return new FooWrapper(_foo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _foo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _foo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _foo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FooWrapper)) {
            return false;
        }

        FooWrapper fooWrapper = (FooWrapper) obj;

        if (Validator.equals(_foo, fooWrapper._foo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Foo getWrappedFoo() {
        return _foo;
    }

    @Override
    public Foo getWrappedModel() {
        return _foo;
    }

    @Override
    public void resetOriginalValues() {
        _foo.resetOriginalValues();
    }
}
