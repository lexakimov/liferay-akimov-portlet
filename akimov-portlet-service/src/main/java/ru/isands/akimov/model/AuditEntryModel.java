package ru.isands.akimov.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AuditEntry service. Represents a row in the &quot;akimov_audit_entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.isands.akimov.model.impl.AuditEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.isands.akimov.model.impl.AuditEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntry
 * @see ru.isands.akimov.model.impl.AuditEntryImpl
 * @see ru.isands.akimov.model.impl.AuditEntryModelImpl
 * @generated
 */
public interface AuditEntryModel extends BaseModel<AuditEntry> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a audit entry model instance should use the {@link AuditEntry} interface instead.
     */

    /**
     * Returns the primary key of this audit entry.
     *
     * @return the primary key of this audit entry
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this audit entry.
     *
     * @param primaryKey the primary key of this audit entry
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the audit entry ID of this audit entry.
     *
     * @return the audit entry ID of this audit entry
     */
    public int getAuditEntryId();

    /**
     * Sets the audit entry ID of this audit entry.
     *
     * @param auditEntryId the audit entry ID of this audit entry
     */
    public void setAuditEntryId(int auditEntryId);

    /**
     * Returns the audit type of this audit entry.
     *
     * @return the audit type of this audit entry
     */
    @AutoEscape
    public String getAuditType();

    /**
     * Sets the audit type of this audit entry.
     *
     * @param auditType the audit type of this audit entry
     */
    public void setAuditType(String auditType);

    /**
     * Returns the entity type of this audit entry.
     *
     * @return the entity type of this audit entry
     */
    @AutoEscape
    public String getEntityType();

    /**
     * Sets the entity type of this audit entry.
     *
     * @param entityType the entity type of this audit entry
     */
    public void setEntityType(String entityType);

    /**
     * Returns the entity ID of this audit entry.
     *
     * @return the entity ID of this audit entry
     */
    public int getEntityId();

    /**
     * Sets the entity ID of this audit entry.
     *
     * @param entityId the entity ID of this audit entry
     */
    public void setEntityId(int entityId);

    /**
     * Returns the company ID of this audit entry.
     *
     * @return the company ID of this audit entry
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this audit entry.
     *
     * @param companyId the company ID of this audit entry
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this audit entry.
     *
     * @return the user ID of this audit entry
     */
    public long getUserId();

    /**
     * Sets the user ID of this audit entry.
     *
     * @param userId the user ID of this audit entry
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this audit entry.
     *
     * @return the user uuid of this audit entry
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this audit entry.
     *
     * @param userUuid the user uuid of this audit entry
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this audit entry.
     *
     * @return the user name of this audit entry
     */
    @AutoEscape
    public String getUserName();

    /**
     * Sets the user name of this audit entry.
     *
     * @param userName the user name of this audit entry
     */
    public void setUserName(String userName);

    /**
     * Returns the date of change of this audit entry.
     *
     * @return the date of change of this audit entry
     */
    public Date getDateOfChange();

    /**
     * Sets the date of change of this audit entry.
     *
     * @param dateOfChange the date of change of this audit entry
     */
    public void setDateOfChange(Date dateOfChange);

    /**
     * Returns the metadata of this audit entry.
     *
     * @return the metadata of this audit entry
     */
    @AutoEscape
    public String getMetadata();

    /**
     * Sets the metadata of this audit entry.
     *
     * @param metadata the metadata of this audit entry
     */
    public void setMetadata(String metadata);

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
    public int compareTo(ru.isands.akimov.model.AuditEntry auditEntry);

    @Override
    public int hashCode();

    @Override
    public CacheModel<ru.isands.akimov.model.AuditEntry> toCacheModel();

    @Override
    public ru.isands.akimov.model.AuditEntry toEscapedModel();

    @Override
    public ru.isands.akimov.model.AuditEntry toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
