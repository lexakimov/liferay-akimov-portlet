package ru.akimov.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.akimov.model.AttachmentFile;

import ru.akimov.service.AttachmentFileLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AttachmentFileActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AttachmentFileActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AttachmentFileLocalServiceUtil.getService());
        setClass(AttachmentFile.class);

        setClassLoader(ru.akimov.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
