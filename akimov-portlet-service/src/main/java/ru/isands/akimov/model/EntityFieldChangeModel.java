package ru.isands.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the EntityFieldChange service. Represents a row in the &quot;akimov_entity_field_change&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.isands.akimov.model.impl.EntityFieldChangeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.isands.akimov.model.impl.EntityFieldChangeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityFieldChange
 * @see ru.isands.akimov.model.impl.EntityFieldChangeImpl
 * @see ru.isands.akimov.model.impl.EntityFieldChangeModelImpl
 * @generated
 */
public interface EntityFieldChangeModel extends BaseModel<EntityFieldChange> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a entity field change model instance should use the {@link EntityFieldChange} interface instead.
     */

    /**
     * Returns the primary key of this entity field change.
     *
     * @return the primary key of this entity field change
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this entity field change.
     *
     * @param primaryKey the primary key of this entity field change
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the ID of this entity field change.
     *
     * @return the ID of this entity field change
     */
    public int getId();

    /**
     * Sets the ID of this entity field change.
     *
     * @param id the ID of this entity field change
     */
    public void setId(int id);

    /**
     * Returns the audit entry ID of this entity field change.
     *
     * @return the audit entry ID of this entity field change
     */
    public int getAuditEntryId();

    /**
     * Sets the audit entry ID of this entity field change.
     *
     * @param auditEntryId the audit entry ID of this entity field change
     */
    public void setAuditEntryId(int auditEntryId);

    /**
     * Returns the field name of this entity field change.
     *
     * @return the field name of this entity field change
     */
    @AutoEscape
    public String getFieldName();

    /**
     * Sets the field name of this entity field change.
     *
     * @param fieldName the field name of this entity field change
     */
    public void setFieldName(String fieldName);

    /**
     * Returns the old value of this entity field change.
     *
     * @return the old value of this entity field change
     */
    @AutoEscape
    public String getOldValue();

    /**
     * Sets the old value of this entity field change.
     *
     * @param oldValue the old value of this entity field change
     */
    public void setOldValue(String oldValue);

    /**
     * Returns the new value of this entity field change.
     *
     * @return the new value of this entity field change
     */
    @AutoEscape
    public String getNewValue();

    /**
     * Sets the new value of this entity field change.
     *
     * @param newValue the new value of this entity field change
     */
    public void setNewValue(String newValue);

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
    public int compareTo(
        ru.isands.akimov.model.EntityFieldChange entityFieldChange);

    @Override
    public int hashCode();

    @Override
    public CacheModel<ru.isands.akimov.model.EntityFieldChange> toCacheModel();

    @Override
    public ru.isands.akimov.model.EntityFieldChange toEscapedModel();

    @Override
    public ru.isands.akimov.model.EntityFieldChange toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
