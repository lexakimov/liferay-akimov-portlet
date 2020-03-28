package ru.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditEntryGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryGroup
 * @generated
 */
public class AuditEntryGroupWrapper implements AuditEntryGroup,
    ModelWrapper<AuditEntryGroup> {
    private AuditEntryGroup _auditEntryGroup;

    public AuditEntryGroupWrapper(AuditEntryGroup auditEntryGroup) {
        _auditEntryGroup = auditEntryGroup;
    }

    @Override
    public Class<?> getModelClass() {
        return AuditEntryGroup.class;
    }

    @Override
    public String getModelClassName() {
        return AuditEntryGroup.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryGroupId", getEntryGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("eventDate", getEventDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer entryGroupId = (Integer) attributes.get("entryGroupId");

        if (entryGroupId != null) {
            setEntryGroupId(entryGroupId);
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

        Date eventDate = (Date) attributes.get("eventDate");

        if (eventDate != null) {
            setEventDate(eventDate);
        }
    }

    /**
    * Returns the primary key of this Группа записей аудита.
    *
    * @return the primary key of this Группа записей аудита
    */
    @Override
    public int getPrimaryKey() {
        return _auditEntryGroup.getPrimaryKey();
    }

    /**
    * Sets the primary key of this Группа записей аудита.
    *
    * @param primaryKey the primary key of this Группа записей аудита
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _auditEntryGroup.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the entry group ID of this Группа записей аудита.
    *
    * @return the entry group ID of this Группа записей аудита
    */
    @Override
    public int getEntryGroupId() {
        return _auditEntryGroup.getEntryGroupId();
    }

    /**
    * Sets the entry group ID of this Группа записей аудита.
    *
    * @param entryGroupId the entry group ID of this Группа записей аудита
    */
    @Override
    public void setEntryGroupId(int entryGroupId) {
        _auditEntryGroup.setEntryGroupId(entryGroupId);
    }

    /**
    * Returns the company ID of this Группа записей аудита.
    *
    * @return the company ID of this Группа записей аудита
    */
    @Override
    public long getCompanyId() {
        return _auditEntryGroup.getCompanyId();
    }

    /**
    * Sets the company ID of this Группа записей аудита.
    *
    * @param companyId the company ID of this Группа записей аудита
    */
    @Override
    public void setCompanyId(long companyId) {
        _auditEntryGroup.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this Группа записей аудита.
    *
    * @return the user ID of this Группа записей аудита
    */
    @Override
    public long getUserId() {
        return _auditEntryGroup.getUserId();
    }

    /**
    * Sets the user ID of this Группа записей аудита.
    *
    * @param userId the user ID of this Группа записей аудита
    */
    @Override
    public void setUserId(long userId) {
        _auditEntryGroup.setUserId(userId);
    }

    /**
    * Returns the user uuid of this Группа записей аудита.
    *
    * @return the user uuid of this Группа записей аудита
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _auditEntryGroup.getUserUuid();
    }

    /**
    * Sets the user uuid of this Группа записей аудита.
    *
    * @param userUuid the user uuid of this Группа записей аудита
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _auditEntryGroup.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this Группа записей аудита.
    *
    * @return the user name of this Группа записей аудита
    */
    @Override
    public java.lang.String getUserName() {
        return _auditEntryGroup.getUserName();
    }

    /**
    * Sets the user name of this Группа записей аудита.
    *
    * @param userName the user name of this Группа записей аудита
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _auditEntryGroup.setUserName(userName);
    }

    /**
    * Returns the event date of this Группа записей аудита.
    *
    * @return the event date of this Группа записей аудита
    */
    @Override
    public java.util.Date getEventDate() {
        return _auditEntryGroup.getEventDate();
    }

    /**
    * Sets the event date of this Группа записей аудита.
    *
    * @param eventDate the event date of this Группа записей аудита
    */
    @Override
    public void setEventDate(java.util.Date eventDate) {
        _auditEntryGroup.setEventDate(eventDate);
    }

    @Override
    public boolean isNew() {
        return _auditEntryGroup.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _auditEntryGroup.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _auditEntryGroup.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _auditEntryGroup.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _auditEntryGroup.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _auditEntryGroup.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _auditEntryGroup.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _auditEntryGroup.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _auditEntryGroup.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _auditEntryGroup.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _auditEntryGroup.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AuditEntryGroupWrapper((AuditEntryGroup) _auditEntryGroup.clone());
    }

    @Override
    public int compareTo(ru.akimov.model.AuditEntryGroup auditEntryGroup) {
        return _auditEntryGroup.compareTo(auditEntryGroup);
    }

    @Override
    public int hashCode() {
        return _auditEntryGroup.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.akimov.model.AuditEntryGroup> toCacheModel() {
        return _auditEntryGroup.toCacheModel();
    }

    @Override
    public ru.akimov.model.AuditEntryGroup toEscapedModel() {
        return new AuditEntryGroupWrapper(_auditEntryGroup.toEscapedModel());
    }

    @Override
    public ru.akimov.model.AuditEntryGroup toUnescapedModel() {
        return new AuditEntryGroupWrapper(_auditEntryGroup.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _auditEntryGroup.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _auditEntryGroup.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _auditEntryGroup.persist();
    }

    /**
    * Добавить запись аудита в текущую группу записей.
    */
    @Override
    public void addEntry(ru.akimov.model.AuditEntry entry) {
        _auditEntryGroup.addEntry(entry);
    }

    @Override
    public boolean hasEntries() {
        return _auditEntryGroup.hasEntries();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AuditEntryGroupWrapper)) {
            return false;
        }

        AuditEntryGroupWrapper auditEntryGroupWrapper = (AuditEntryGroupWrapper) obj;

        if (Validator.equals(_auditEntryGroup,
                    auditEntryGroupWrapper._auditEntryGroup)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AuditEntryGroup getWrappedAuditEntryGroup() {
        return _auditEntryGroup;
    }

    @Override
    public AuditEntryGroup getWrappedModel() {
        return _auditEntryGroup;
    }

    @Override
    public void resetOriginalValues() {
        _auditEntryGroup.resetOriginalValues();
    }
}
