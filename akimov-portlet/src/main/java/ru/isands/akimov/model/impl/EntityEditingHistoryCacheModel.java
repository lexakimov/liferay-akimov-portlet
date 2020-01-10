package ru.isands.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.isands.akimov.model.EntityEditingHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EntityEditingHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EntityEditingHistory
 * @generated
 */
public class EntityEditingHistoryCacheModel implements CacheModel<EntityEditingHistory>,
    Externalizable {
    public int id;
    public int entityId;
    public String entityType;
    public long userId;
    public String description;
    public long dateOfChange;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", entityId=");
        sb.append(entityId);
        sb.append(", entityType=");
        sb.append(entityType);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", description=");
        sb.append(description);
        sb.append(", dateOfChange=");
        sb.append(dateOfChange);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public EntityEditingHistory toEntityModel() {
        EntityEditingHistoryImpl entityEditingHistoryImpl = new EntityEditingHistoryImpl();

        entityEditingHistoryImpl.setId(id);
        entityEditingHistoryImpl.setEntityId(entityId);

        if (entityType == null) {
            entityEditingHistoryImpl.setEntityType(StringPool.BLANK);
        } else {
            entityEditingHistoryImpl.setEntityType(entityType);
        }

        entityEditingHistoryImpl.setUserId(userId);

        if (description == null) {
            entityEditingHistoryImpl.setDescription(StringPool.BLANK);
        } else {
            entityEditingHistoryImpl.setDescription(description);
        }

        if (dateOfChange == Long.MIN_VALUE) {
            entityEditingHistoryImpl.setDateOfChange(null);
        } else {
            entityEditingHistoryImpl.setDateOfChange(new Date(dateOfChange));
        }

        entityEditingHistoryImpl.resetOriginalValues();

        return entityEditingHistoryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readInt();
        entityId = objectInput.readInt();
        entityType = objectInput.readUTF();
        userId = objectInput.readLong();
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

        objectOutput.writeLong(userId);

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(dateOfChange);
    }
}
