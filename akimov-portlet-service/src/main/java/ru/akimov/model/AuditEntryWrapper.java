package ru.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntry
 * @generated
 */
public class AuditEntryWrapper implements AuditEntry, ModelWrapper<AuditEntry> {
    private AuditEntry _auditEntry;

    public AuditEntryWrapper(AuditEntry auditEntry) {
        _auditEntry = auditEntry;
    }

    @Override
    public Class<?> getModelClass() {
        return AuditEntry.class;
    }

    @Override
    public String getModelClassName() {
        return AuditEntry.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryId", getEntryId());
        attributes.put("entryGroupId", getEntryGroupId());
        attributes.put("auditType", getAuditType());
        attributes.put("entityType", getEntityType());
        attributes.put("entityId", getEntityId());
        attributes.put("metadata", getMetadata());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer entryId = (Integer) attributes.get("entryId");

        if (entryId != null) {
            setEntryId(entryId);
        }

        Integer entryGroupId = (Integer) attributes.get("entryGroupId");

        if (entryGroupId != null) {
            setEntryGroupId(entryGroupId);
        }

        String auditType = (String) attributes.get("auditType");

        if (auditType != null) {
            setAuditType(auditType);
        }

        String entityType = (String) attributes.get("entityType");

        if (entityType != null) {
            setEntityType(entityType);
        }

        Integer entityId = (Integer) attributes.get("entityId");

        if (entityId != null) {
            setEntityId(entityId);
        }

        String metadata = (String) attributes.get("metadata");

        if (metadata != null) {
            setMetadata(metadata);
        }
    }

    /**
    * Returns the primary key of this Запись аудита.
    *
    * @return the primary key of this Запись аудита
    */
    @Override
    public int getPrimaryKey() {
        return _auditEntry.getPrimaryKey();
    }

    /**
    * Sets the primary key of this Запись аудита.
    *
    * @param primaryKey the primary key of this Запись аудита
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _auditEntry.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the entry ID of this Запись аудита.
    *
    * @return the entry ID of this Запись аудита
    */
    @Override
    public int getEntryId() {
        return _auditEntry.getEntryId();
    }

    /**
    * Sets the entry ID of this Запись аудита.
    *
    * @param entryId the entry ID of this Запись аудита
    */
    @Override
    public void setEntryId(int entryId) {
        _auditEntry.setEntryId(entryId);
    }

    /**
    * Returns the entry group ID of this Запись аудита.
    *
    * @return the entry group ID of this Запись аудита
    */
    @Override
    public int getEntryGroupId() {
        return _auditEntry.getEntryGroupId();
    }

    /**
    * Sets the entry group ID of this Запись аудита.
    *
    * @param entryGroupId the entry group ID of this Запись аудита
    */
    @Override
    public void setEntryGroupId(int entryGroupId) {
        _auditEntry.setEntryGroupId(entryGroupId);
    }

    /**
    * Returns the audit type of this Запись аудита.
    *
    * @return the audit type of this Запись аудита
    */
    @Override
    public java.lang.String getAuditType() {
        return _auditEntry.getAuditType();
    }

    /**
    * Sets the audit type of this Запись аудита.
    *
    * @param auditType the audit type of this Запись аудита
    */
    @Override
    public void setAuditType(java.lang.String auditType) {
        _auditEntry.setAuditType(auditType);
    }

    /**
    * Returns the entity type of this Запись аудита.
    *
    * @return the entity type of this Запись аудита
    */
    @Override
    public java.lang.String getEntityType() {
        return _auditEntry.getEntityType();
    }

    /**
    * Sets the entity type of this Запись аудита.
    *
    * @param entityType the entity type of this Запись аудита
    */
    @Override
    public void setEntityType(java.lang.String entityType) {
        _auditEntry.setEntityType(entityType);
    }

    /**
    * Returns the entity ID of this Запись аудита.
    *
    * @return the entity ID of this Запись аудита
    */
    @Override
    public int getEntityId() {
        return _auditEntry.getEntityId();
    }

    /**
    * Sets the entity ID of this Запись аудита.
    *
    * @param entityId the entity ID of this Запись аудита
    */
    @Override
    public void setEntityId(int entityId) {
        _auditEntry.setEntityId(entityId);
    }

    /**
    * Returns the metadata of this Запись аудита.
    *
    * @return the metadata of this Запись аудита
    */
    @Override
    public java.lang.String getMetadata() {
        return _auditEntry.getMetadata();
    }

    /**
    * Sets the metadata of this Запись аудита.
    *
    * @param metadata the metadata of this Запись аудита
    */
    @Override
    public void setMetadata(java.lang.String metadata) {
        _auditEntry.setMetadata(metadata);
    }

    @Override
    public boolean isNew() {
        return _auditEntry.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _auditEntry.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _auditEntry.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _auditEntry.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _auditEntry.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _auditEntry.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _auditEntry.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _auditEntry.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _auditEntry.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _auditEntry.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _auditEntry.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AuditEntryWrapper((AuditEntry) _auditEntry.clone());
    }

    @Override
    public int compareTo(ru.akimov.model.AuditEntry auditEntry) {
        return _auditEntry.compareTo(auditEntry);
    }

    @Override
    public int hashCode() {
        return _auditEntry.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.akimov.model.AuditEntry> toCacheModel() {
        return _auditEntry.toCacheModel();
    }

    @Override
    public ru.akimov.model.AuditEntry toEscapedModel() {
        return new AuditEntryWrapper(_auditEntry.toEscapedModel());
    }

    @Override
    public ru.akimov.model.AuditEntry toUnescapedModel() {
        return new AuditEntryWrapper(_auditEntry.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _auditEntry.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _auditEntry.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _auditEntry.persist();
    }

    /**
    * Добавить к текущей записи аудита запись об изменении атрибута сущности.
    *
    * @param fieldName имя атрибута.
    * @param oldValue  старое значение.
    * @param newValue  новое значение.
    * @throws SystemException
    */
    @Override
    public void addFieldChange(java.lang.String fieldName,
        java.lang.Object oldValue, java.lang.Object newValue)
        throws com.liferay.portal.kernel.exception.SystemException {
        _auditEntry.addFieldChange(fieldName, oldValue, newValue);
    }

    /**
    * @return true если запись истории изменения имеет закрепленные за собой записи об изменениях атрибутов сущности.
    */
    @Override
    public boolean hasFieldChanges() {
        return _auditEntry.hasFieldChanges();
    }

    @Override
    public long getUserId()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _auditEntry.getUserId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AuditEntryWrapper)) {
            return false;
        }

        AuditEntryWrapper auditEntryWrapper = (AuditEntryWrapper) obj;

        if (Validator.equals(_auditEntry, auditEntryWrapper._auditEntry)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AuditEntry getWrappedAuditEntry() {
        return _auditEntry;
    }

    @Override
    public AuditEntry getWrappedModel() {
        return _auditEntry;
    }

    @Override
    public void resetOriginalValues() {
        _auditEntry.resetOriginalValues();
    }
}
