package ru.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.sql.Blob;

import java.util.Date;

/**
 * The base model interface for the Foo service. Represents a row in the &quot;akimov_Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.isands.akimov.model.impl.FooModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.isands.akimov.model.impl.FooImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @see ru.isands.akimov.model.impl.FooImpl
 * @see ru.isands.akimov.model.impl.FooModelImpl
 * @generated
 */
public interface FooModel extends BaseModel<Foo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a foo model instance should use the {@link Foo} interface instead.
     */

    /**
     * Returns the primary key of this foo.
     *
     * @return the primary key of this foo
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this foo.
     *
     * @param primaryKey the primary key of this foo
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the foo ID of this foo.
     *
     * @return the foo ID of this foo
     */
    public int getFooId();

    /**
     * Sets the foo ID of this foo.
     *
     * @param fooId the foo ID of this foo
     */
    public void setFooId(int fooId);

    /**
     * Returns the boolean field of this foo.
     *
     * @return the boolean field of this foo
     */
    public boolean getBooleanField();

    /**
     * Returns <code>true</code> if this foo is boolean field.
     *
     * @return <code>true</code> if this foo is boolean field; <code>false</code> otherwise
     */
    public boolean isBooleanField();

    /**
     * Sets whether this foo is boolean field.
     *
     * @param booleanField the boolean field of this foo
     */
    public void setBooleanField(boolean booleanField);

    /**
     * Returns the short field of this foo.
     *
     * @return the short field of this foo
     */
    public short getShortField();

    /**
     * Sets the short field of this foo.
     *
     * @param shortField the short field of this foo
     */
    public void setShortField(short shortField);

    /**
     * Returns the int field of this foo.
     *
     * @return the int field of this foo
     */
    public int getIntField();

    /**
     * Sets the int field of this foo.
     *
     * @param intField the int field of this foo
     */
    public void setIntField(int intField);

    /**
     * Returns the long field of this foo.
     *
     * @return the long field of this foo
     */
    public long getLongField();

    /**
     * Sets the long field of this foo.
     *
     * @param longField the long field of this foo
     */
    public void setLongField(long longField);

    /**
     * Returns the double field of this foo.
     *
     * @return the double field of this foo
     */
    public double getDoubleField();

    /**
     * Sets the double field of this foo.
     *
     * @param doubleField the double field of this foo
     */
    public void setDoubleField(double doubleField);

    /**
     * Returns the float field of this foo.
     *
     * @return the float field of this foo
     */
    public float getFloatField();

    /**
     * Sets the float field of this foo.
     *
     * @param floatField the float field of this foo
     */
    public void setFloatField(float floatField);

    /**
     * Returns the string field of this foo.
     *
     * @return the string field of this foo
     */
    @AutoEscape
    public String getStringField();

    /**
     * Sets the string field of this foo.
     *
     * @param stringField the string field of this foo
     */
    public void setStringField(String stringField);

    /**
     * Returns the date field of this foo.
     *
     * @return the date field of this foo
     */
    public Date getDateField();

    /**
     * Sets the date field of this foo.
     *
     * @param dateField the date field of this foo
     */
    public void setDateField(Date dateField);

    /**
     * Returns the blob field of this foo.
     *
     * @return the blob field of this foo
     */
    public Blob getBlobField();

    /**
     * Sets the blob field of this foo.
     *
     * @param blobField the blob field of this foo
     */
    public void setBlobField(Blob blobField);

    /**
     * Returns the status of this foo.
     *
     * @return the status of this foo
     */
    public short getStatus();

    /**
     * Sets the status of this foo.
     *
     * @param status the status of this foo
     */
    public void setStatus(short status);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(Foo foo);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Foo> toCacheModel();

    @Override
    public Foo toEscapedModel();

    @Override
    public Foo toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}