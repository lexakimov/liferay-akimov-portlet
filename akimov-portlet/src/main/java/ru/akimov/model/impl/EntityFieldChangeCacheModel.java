package ru.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.akimov.model.EntityFieldChange;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EntityFieldChange in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EntityFieldChange
 * @generated
 */
public class EntityFieldChangeCacheModel implements CacheModel<EntityFieldChange>,
    Externalizable {
    public int fieldChangeId;
    public int entryId;
    public String fieldName;
    public String oldValue;
    public String newValue;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{fieldChangeId=");
        sb.append(fieldChangeId);
        sb.append(", entryId=");
        sb.append(entryId);
        sb.append(", fieldName=");
        sb.append(fieldName);
        sb.append(", oldValue=");
        sb.append(oldValue);
        sb.append(", newValue=");
        sb.append(newValue);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public EntityFieldChange toEntityModel() {
        EntityFieldChangeImpl entityFieldChangeImpl = new EntityFieldChangeImpl();

        entityFieldChangeImpl.setFieldChangeId(fieldChangeId);
        entityFieldChangeImpl.setEntryId(entryId);

        if (fieldName == null) {
            entityFieldChangeImpl.setFieldName(StringPool.BLANK);
        } else {
            entityFieldChangeImpl.setFieldName(fieldName);
        }

        if (oldValue == null) {
            entityFieldChangeImpl.setOldValue(StringPool.BLANK);
        } else {
            entityFieldChangeImpl.setOldValue(oldValue);
        }

        if (newValue == null) {
            entityFieldChangeImpl.setNewValue(StringPool.BLANK);
        } else {
            entityFieldChangeImpl.setNewValue(newValue);
        }

        entityFieldChangeImpl.resetOriginalValues();

        return entityFieldChangeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        fieldChangeId = objectInput.readInt();
        entryId = objectInput.readInt();
        fieldName = objectInput.readUTF();
        oldValue = objectInput.readUTF();
        newValue = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(fieldChangeId);
        objectOutput.writeInt(entryId);

        if (fieldName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fieldName);
        }

        if (oldValue == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(oldValue);
        }

        if (newValue == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(newValue);
        }
    }
}
