package ru.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EntityFieldChange}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityFieldChange
 * @generated
 */
public class EntityFieldChangeWrapper implements EntityFieldChange,
    ModelWrapper<EntityFieldChange> {
    private EntityFieldChange _entityFieldChange;

    public EntityFieldChangeWrapper(EntityFieldChange entityFieldChange) {
        _entityFieldChange = entityFieldChange;
    }

    @Override
    public Class<?> getModelClass() {
        return EntityFieldChange.class;
    }

    @Override
    public String getModelClassName() {
        return EntityFieldChange.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fieldChangeId", getFieldChangeId());
        attributes.put("entryId", getEntryId());
        attributes.put("fieldName", getFieldName());
        attributes.put("oldValue", getOldValue());
        attributes.put("newValue", getNewValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer fieldChangeId = (Integer) attributes.get("fieldChangeId");

        if (fieldChangeId != null) {
            setFieldChangeId(fieldChangeId);
        }

        Integer entryId = (Integer) attributes.get("entryId");

        if (entryId != null) {
            setEntryId(entryId);
        }

        String fieldName = (String) attributes.get("fieldName");

        if (fieldName != null) {
            setFieldName(fieldName);
        }

        String oldValue = (String) attributes.get("oldValue");

        if (oldValue != null) {
            setOldValue(oldValue);
        }

        String newValue = (String) attributes.get("newValue");

        if (newValue != null) {
            setNewValue(newValue);
        }
    }

    /**
    * Returns the primary key of this Изменение атрибута сущности.
    *
    * @return the primary key of this Изменение атрибута сущности
    */
    @Override
    public int getPrimaryKey() {
        return _entityFieldChange.getPrimaryKey();
    }

    /**
    * Sets the primary key of this Изменение атрибута сущности.
    *
    * @param primaryKey the primary key of this Изменение атрибута сущности
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _entityFieldChange.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the field change ID of this Изменение атрибута сущности.
    *
    * @return the field change ID of this Изменение атрибута сущности
    */
    @Override
    public int getFieldChangeId() {
        return _entityFieldChange.getFieldChangeId();
    }

    /**
    * Sets the field change ID of this Изменение атрибута сущности.
    *
    * @param fieldChangeId the field change ID of this Изменение атрибута сущности
    */
    @Override
    public void setFieldChangeId(int fieldChangeId) {
        _entityFieldChange.setFieldChangeId(fieldChangeId);
    }

    /**
    * Returns the entry ID of this Изменение атрибута сущности.
    *
    * @return the entry ID of this Изменение атрибута сущности
    */
    @Override
    public int getEntryId() {
        return _entityFieldChange.getEntryId();
    }

    /**
    * Sets the entry ID of this Изменение атрибута сущности.
    *
    * @param entryId the entry ID of this Изменение атрибута сущности
    */
    @Override
    public void setEntryId(int entryId) {
        _entityFieldChange.setEntryId(entryId);
    }

    /**
    * Returns the field name of this Изменение атрибута сущности.
    *
    * @return the field name of this Изменение атрибута сущности
    */
    @Override
    public java.lang.String getFieldName() {
        return _entityFieldChange.getFieldName();
    }

    /**
    * Sets the field name of this Изменение атрибута сущности.
    *
    * @param fieldName the field name of this Изменение атрибута сущности
    */
    @Override
    public void setFieldName(java.lang.String fieldName) {
        _entityFieldChange.setFieldName(fieldName);
    }

    /**
    * Returns the old value of this Изменение атрибута сущности.
    *
    * @return the old value of this Изменение атрибута сущности
    */
    @Override
    public java.lang.String getOldValue() {
        return _entityFieldChange.getOldValue();
    }

    /**
    * Sets the old value of this Изменение атрибута сущности.
    *
    * @param oldValue the old value of this Изменение атрибута сущности
    */
    @Override
    public void setOldValue(java.lang.String oldValue) {
        _entityFieldChange.setOldValue(oldValue);
    }

    /**
    * Returns the new value of this Изменение атрибута сущности.
    *
    * @return the new value of this Изменение атрибута сущности
    */
    @Override
    public java.lang.String getNewValue() {
        return _entityFieldChange.getNewValue();
    }

    /**
    * Sets the new value of this Изменение атрибута сущности.
    *
    * @param newValue the new value of this Изменение атрибута сущности
    */
    @Override
    public void setNewValue(java.lang.String newValue) {
        _entityFieldChange.setNewValue(newValue);
    }

    @Override
    public boolean isNew() {
        return _entityFieldChange.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _entityFieldChange.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _entityFieldChange.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _entityFieldChange.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _entityFieldChange.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _entityFieldChange.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _entityFieldChange.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _entityFieldChange.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _entityFieldChange.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _entityFieldChange.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _entityFieldChange.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EntityFieldChangeWrapper((EntityFieldChange) _entityFieldChange.clone());
    }

    @Override
    public int compareTo(ru.akimov.model.EntityFieldChange entityFieldChange) {
        return _entityFieldChange.compareTo(entityFieldChange);
    }

    @Override
    public int hashCode() {
        return _entityFieldChange.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.akimov.model.EntityFieldChange> toCacheModel() {
        return _entityFieldChange.toCacheModel();
    }

    @Override
    public ru.akimov.model.EntityFieldChange toEscapedModel() {
        return new EntityFieldChangeWrapper(_entityFieldChange.toEscapedModel());
    }

    @Override
    public ru.akimov.model.EntityFieldChange toUnescapedModel() {
        return new EntityFieldChangeWrapper(_entityFieldChange.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _entityFieldChange.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _entityFieldChange.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _entityFieldChange.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityFieldChangeWrapper)) {
            return false;
        }

        EntityFieldChangeWrapper entityFieldChangeWrapper = (EntityFieldChangeWrapper) obj;

        if (Validator.equals(_entityFieldChange,
                    entityFieldChangeWrapper._entityFieldChange)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public EntityFieldChange getWrappedEntityFieldChange() {
        return _entityFieldChange;
    }

    @Override
    public EntityFieldChange getWrappedModel() {
        return _entityFieldChange;
    }

    @Override
    public void resetOriginalValues() {
        _entityFieldChange.resetOriginalValues();
    }
}
