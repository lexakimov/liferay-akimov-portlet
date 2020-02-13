package ru.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.akimov.model.AuditEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuditEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntry
 * @generated
 */
public class AuditEntryCacheModel implements CacheModel<AuditEntry>,
    Externalizable {
    public int auditEntryId;
    public String auditType;
    public String entityType;
    public int entityId;
    public long companyId;
    public long userId;
    public String userName;
    public long dateOfChange;
    public String metadata;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{auditEntryId=");
        sb.append(auditEntryId);
        sb.append(", auditType=");
        sb.append(auditType);
        sb.append(", entityType=");
        sb.append(entityType);
        sb.append(", entityId=");
        sb.append(entityId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", dateOfChange=");
        sb.append(dateOfChange);
        sb.append(", metadata=");
        sb.append(metadata);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AuditEntry toEntityModel() {
        AuditEntryImpl auditEntryImpl = new AuditEntryImpl();

        auditEntryImpl.setAuditEntryId(auditEntryId);

        if (auditType == null) {
            auditEntryImpl.setAuditType(StringPool.BLANK);
        } else {
            auditEntryImpl.setAuditType(auditType);
        }

        if (entityType == null) {
            auditEntryImpl.setEntityType(StringPool.BLANK);
        } else {
            auditEntryImpl.setEntityType(entityType);
        }

        auditEntryImpl.setEntityId(entityId);
        auditEntryImpl.setCompanyId(companyId);
        auditEntryImpl.setUserId(userId);

        if (userName == null) {
            auditEntryImpl.setUserName(StringPool.BLANK);
        } else {
            auditEntryImpl.setUserName(userName);
        }

        if (dateOfChange == Long.MIN_VALUE) {
            auditEntryImpl.setDateOfChange(null);
        } else {
            auditEntryImpl.setDateOfChange(new Date(dateOfChange));
        }

        if (metadata == null) {
            auditEntryImpl.setMetadata(StringPool.BLANK);
        } else {
            auditEntryImpl.setMetadata(metadata);
        }

        auditEntryImpl.resetOriginalValues();

        return auditEntryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        auditEntryId = objectInput.readInt();
        auditType = objectInput.readUTF();
        entityType = objectInput.readUTF();
        entityId = objectInput.readInt();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        dateOfChange = objectInput.readLong();
        metadata = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(auditEntryId);

        if (auditType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(auditType);
        }

        if (entityType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(entityType);
        }

        objectOutput.writeInt(entityId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(dateOfChange);

        if (metadata == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(metadata);
        }
    }
}
