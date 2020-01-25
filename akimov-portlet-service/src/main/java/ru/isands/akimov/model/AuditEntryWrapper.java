package ru.isands.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
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

        attributes.put("auditEntryId", getAuditEntryId());
        attributes.put("auditType", getAuditType());
        attributes.put("entityType", getEntityType());
        attributes.put("entityId", getEntityId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("dateOfChange", getDateOfChange());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer auditEntryId = (Integer) attributes.get("auditEntryId");

        if (auditEntryId != null) {
            setAuditEntryId(auditEntryId);
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

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date dateOfChange = (Date) attributes.get("dateOfChange");

        if (dateOfChange != null) {
            setDateOfChange(dateOfChange);
        }
    }

    /**
    * Returns the primary key of this audit entry.
    *
    * @return the primary key of this audit entry
    */
    @Override
    public int getPrimaryKey() {
        return _auditEntry.getPrimaryKey();
    }

    /**
    * Sets the primary key of this audit entry.
    *
    * @param primaryKey the primary key of this audit entry
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _auditEntry.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the audit entry ID of this audit entry.
    *
    * @return the audit entry ID of this audit entry
    */
    @Override
    public int getAuditEntryId() {
        return _auditEntry.getAuditEntryId();
    }

    /**
    * Sets the audit entry ID of this audit entry.
    *
    * @param auditEntryId the audit entry ID of this audit entry
    */
    @Override
    public void setAuditEntryId(int auditEntryId) {
        _auditEntry.setAuditEntryId(auditEntryId);
    }

    /**
    * Returns the audit type of this audit entry.
    *
    * @return the audit type of this audit entry
    */
    @Override
    public java.lang.String getAuditType() {
        return _auditEntry.getAuditType();
    }

    /**
    * Sets the audit type of this audit entry.
    *
    * @param auditType the audit type of this audit entry
    */
    @Override
    public void setAuditType(java.lang.String auditType) {
        _auditEntry.setAuditType(auditType);
    }

    /**
    * Returns the entity type of this audit entry.
    *
    * @return the entity type of this audit entry
    */
    @Override
    public java.lang.String getEntityType() {
        return _auditEntry.getEntityType();
    }

    /**
    * Sets the entity type of this audit entry.
    *
    * @param entityType the entity type of this audit entry
    */
    @Override
    public void setEntityType(java.lang.String entityType) {
        _auditEntry.setEntityType(entityType);
    }

    /**
    * Returns the entity ID of this audit entry.
    *
    * @return the entity ID of this audit entry
    */
    @Override
    public int getEntityId() {
        return _auditEntry.getEntityId();
    }

    /**
    * Sets the entity ID of this audit entry.
    *
    * @param entityId the entity ID of this audit entry
    */
    @Override
    public void setEntityId(int entityId) {
        _auditEntry.setEntityId(entityId);
    }

    /**
    * Returns the company ID of this audit entry.
    *
    * @return the company ID of this audit entry
    */
    @Override
    public long getCompanyId() {
        return _auditEntry.getCompanyId();
    }

    /**
    * Sets the company ID of this audit entry.
    *
    * @param companyId the company ID of this audit entry
    */
    @Override
    public void setCompanyId(long companyId) {
        _auditEntry.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this audit entry.
    *
    * @return the user ID of this audit entry
    */
    @Override
    public long getUserId() {
        return _auditEntry.getUserId();
    }

    /**
    * Sets the user ID of this audit entry.
    *
    * @param userId the user ID of this audit entry
    */
    @Override
    public void setUserId(long userId) {
        _auditEntry.setUserId(userId);
    }

    /**
    * Returns the user uuid of this audit entry.
    *
    * @return the user uuid of this audit entry
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntry.getUserUuid();
    }

    /**
    * Sets the user uuid of this audit entry.
    *
    * @param userUuid the user uuid of this audit entry
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _auditEntry.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this audit entry.
    *
    * @return the user name of this audit entry
    */
    @Override
    public java.lang.String getUserName() {
        return _auditEntry.getUserName();
    }

    /**
    * Sets the user name of this audit entry.
    *
    * @param userName the user name of this audit entry
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _auditEntry.setUserName(userName);
    }

    /**
    * Returns the date of change of this audit entry.
    *
    * @return the date of change of this audit entry
    */
    @Override
    public java.util.Date getDateOfChange() {
        return _auditEntry.getDateOfChange();
    }

    /**
    * Sets the date of change of this audit entry.
    *
    * @param dateOfChange the date of change of this audit entry
    */
    @Override
    public void setDateOfChange(java.util.Date dateOfChange) {
        _auditEntry.setDateOfChange(dateOfChange);
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
    public int compareTo(ru.isands.akimov.model.AuditEntry auditEntry) {
        return _auditEntry.compareTo(auditEntry);
    }

    @Override
    public int hashCode() {
        return _auditEntry.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.isands.akimov.model.AuditEntry> toCacheModel() {
        return _auditEntry.toCacheModel();
    }

    @Override
    public ru.isands.akimov.model.AuditEntry toEscapedModel() {
        return new AuditEntryWrapper(_auditEntry.toEscapedModel());
    }

    @Override
    public ru.isands.akimov.model.AuditEntry toUnescapedModel() {
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
