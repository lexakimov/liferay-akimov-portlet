package ru.isands.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.isands.akimov.model.AuditEntry;

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
    public int id;
    public int entityId;
    public String entityType;
    public long companyId;
    public long userId;
    public String userName;
    public String description;
    public long dateOfChange;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(id);
        sb.append(", entityId=");
        sb.append(entityId);
        sb.append(", entityType=");
        sb.append(entityType);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", description=");
        sb.append(description);
        sb.append(", dateOfChange=");
        sb.append(dateOfChange);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AuditEntry toEntityModel() {
        AuditEntryImpl auditEntryImpl = new AuditEntryImpl();

        auditEntryImpl.setId(id);
        auditEntryImpl.setEntityId(entityId);

        if (entityType == null) {
            auditEntryImpl.setEntityType(StringPool.BLANK);
        } else {
            auditEntryImpl.setEntityType(entityType);
        }

        auditEntryImpl.setCompanyId(companyId);
        auditEntryImpl.setUserId(userId);

        if (userName == null) {
            auditEntryImpl.setUserName(StringPool.BLANK);
        } else {
            auditEntryImpl.setUserName(userName);
        }

        if (description == null) {
            auditEntryImpl.setDescription(StringPool.BLANK);
        } else {
            auditEntryImpl.setDescription(description);
        }

        if (dateOfChange == Long.MIN_VALUE) {
            auditEntryImpl.setDateOfChange(null);
        } else {
            auditEntryImpl.setDateOfChange(new Date(dateOfChange));
        }

        auditEntryImpl.resetOriginalValues();

        return auditEntryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readInt();
        entityId = objectInput.readInt();
        entityType = objectInput.readUTF();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        description = objectInput.readUTF();
        dateOfChange = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(id);
        objectOutput.writeInt(entityId);

        if (entityType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(entityType);
        }

        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(dateOfChange);
    }
}
