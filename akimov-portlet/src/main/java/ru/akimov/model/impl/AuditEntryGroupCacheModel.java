package ru.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.akimov.model.AuditEntryGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuditEntryGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryGroup
 * @generated
 */
public class AuditEntryGroupCacheModel implements CacheModel<AuditEntryGroup>,
    Externalizable {
    public int entryGroupId;
    public long companyId;
    public long userId;
    public String userName;
    public long eventDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{entryGroupId=");
        sb.append(entryGroupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", eventDate=");
        sb.append(eventDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AuditEntryGroup toEntityModel() {
        AuditEntryGroupImpl auditEntryGroupImpl = new AuditEntryGroupImpl();

        auditEntryGroupImpl.setEntryGroupId(entryGroupId);
        auditEntryGroupImpl.setCompanyId(companyId);
        auditEntryGroupImpl.setUserId(userId);

        if (userName == null) {
            auditEntryGroupImpl.setUserName(StringPool.BLANK);
        } else {
            auditEntryGroupImpl.setUserName(userName);
        }

        if (eventDate == Long.MIN_VALUE) {
            auditEntryGroupImpl.setEventDate(null);
        } else {
            auditEntryGroupImpl.setEventDate(new Date(eventDate));
        }

        auditEntryGroupImpl.resetOriginalValues();

        return auditEntryGroupImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        entryGroupId = objectInput.readInt();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        eventDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(entryGroupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(eventDate);
    }
}
