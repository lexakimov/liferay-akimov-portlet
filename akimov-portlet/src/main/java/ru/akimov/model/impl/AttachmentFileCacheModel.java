package ru.akimov.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.akimov.model.AttachmentFile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AttachmentFile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentFile
 * @generated
 */
public class AttachmentFileCacheModel implements CacheModel<AttachmentFile>,
    Externalizable {
    public int id;
    public String fileName;
    public String extension;
    public int size;
    public String mimeType;
    public long uploaded;
    public int userId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", fileName=");
        sb.append(fileName);
        sb.append(", extension=");
        sb.append(extension);
        sb.append(", size=");
        sb.append(size);
        sb.append(", mimeType=");
        sb.append(mimeType);
        sb.append(", uploaded=");
        sb.append(uploaded);
        sb.append(", userId=");
        sb.append(userId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AttachmentFile toEntityModel() {
        AttachmentFileImpl attachmentFileImpl = new AttachmentFileImpl();

        attachmentFileImpl.setId(id);

        if (fileName == null) {
            attachmentFileImpl.setFileName(StringPool.BLANK);
        } else {
            attachmentFileImpl.setFileName(fileName);
        }

        if (extension == null) {
            attachmentFileImpl.setExtension(StringPool.BLANK);
        } else {
            attachmentFileImpl.setExtension(extension);
        }

        attachmentFileImpl.setSize(size);

        if (mimeType == null) {
            attachmentFileImpl.setMimeType(StringPool.BLANK);
        } else {
            attachmentFileImpl.setMimeType(mimeType);
        }

        if (uploaded == Long.MIN_VALUE) {
            attachmentFileImpl.setUploaded(null);
        } else {
            attachmentFileImpl.setUploaded(new Date(uploaded));
        }

        attachmentFileImpl.setUserId(userId);

        attachmentFileImpl.resetOriginalValues();

        return attachmentFileImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readInt();
        fileName = objectInput.readUTF();
        extension = objectInput.readUTF();
        size = objectInput.readInt();
        mimeType = objectInput.readUTF();
        uploaded = objectInput.readLong();
        userId = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(id);

        if (fileName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fileName);
        }

        if (extension == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(extension);
        }

        objectOutput.writeInt(size);

        if (mimeType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mimeType);
        }

        objectOutput.writeLong(uploaded);
        objectOutput.writeInt(userId);
    }
}
