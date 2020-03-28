package ru.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.akimov.model.AuditEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AuditEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntry
 * @generated
 */
public class AuditEntryCacheModel implements CacheModel<AuditEntry>,
    Externalizable {
    public int entryId;
    public int entryGroupId;
    public String auditType;
    public String entityType;
    public int entityId;
    public String metadata;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{entryId=");
        sb.append(entryId);
        sb.append(", entryGroupId=");
        sb.append(entryGroupId);
        sb.append(", auditType=");
        sb.append(auditType);
        sb.append(", entityType=");
        sb.append(entityType);
        sb.append(", entityId=");
        sb.append(entityId);
        sb.append(", metadata=");
        sb.append(metadata);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AuditEntry toEntityModel() {
        AuditEntryImpl auditEntryImpl = new AuditEntryImpl();

        auditEntryImpl.setEntryId(entryId);
        auditEntryImpl.setEntryGroupId(entryGroupId);

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
        entryId = objectInput.readInt();
        entryGroupId = objectInput.readInt();
        auditType = objectInput.readUTF();
        entityType = objectInput.readUTF();
        entityId = objectInput.readInt();
        metadata = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(entryId);
        objectOutput.writeInt(entryGroupId);

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

        if (metadata == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(metadata);
        }
    }
}
