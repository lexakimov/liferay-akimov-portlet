package ru.isands.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.isands.akimov.model.Foo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Foo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooCacheModel implements CacheModel<Foo>, Externalizable {
    public int fooId;
    public boolean booleanField;
    public short shortField;
    public int intField;
    public long longField;
    public double doubleField;
    public float floatField;
    public String stringField;
    public long dateField;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{fooId=");
        sb.append(fooId);
        sb.append(", booleanField=");
        sb.append(booleanField);
        sb.append(", shortField=");
        sb.append(shortField);
        sb.append(", intField=");
        sb.append(intField);
        sb.append(", longField=");
        sb.append(longField);
        sb.append(", doubleField=");
        sb.append(doubleField);
        sb.append(", floatField=");
        sb.append(floatField);
        sb.append(", stringField=");
        sb.append(stringField);
        sb.append(", dateField=");
        sb.append(dateField);

        return sb.toString();
    }

    @Override
    public Foo toEntityModel() {
        FooImpl fooImpl = new FooImpl();

        fooImpl.setFooId(fooId);
        fooImpl.setBooleanField(booleanField);
        fooImpl.setShortField(shortField);
        fooImpl.setIntField(intField);
        fooImpl.setLongField(longField);
        fooImpl.setDoubleField(doubleField);
        fooImpl.setFloatField(floatField);

        if (stringField == null) {
            fooImpl.setStringField(StringPool.BLANK);
        } else {
            fooImpl.setStringField(stringField);
        }

        if (dateField == Long.MIN_VALUE) {
            fooImpl.setDateField(null);
        } else {
            fooImpl.setDateField(new Date(dateField));
        }

        fooImpl.resetOriginalValues();

        return fooImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        fooId = objectInput.readInt();
        booleanField = objectInput.readBoolean();
        shortField = objectInput.readShort();
        intField = objectInput.readInt();
        longField = objectInput.readLong();
        doubleField = objectInput.readDouble();
        floatField = objectInput.readFloat();
        stringField = objectInput.readUTF();
        dateField = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(fooId);
        objectOutput.writeBoolean(booleanField);
        objectOutput.writeShort(shortField);
        objectOutput.writeInt(intField);
        objectOutput.writeLong(longField);
        objectOutput.writeDouble(doubleField);
        objectOutput.writeFloat(floatField);

        if (stringField == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stringField);
        }

        objectOutput.writeLong(dateField);
    }
}
