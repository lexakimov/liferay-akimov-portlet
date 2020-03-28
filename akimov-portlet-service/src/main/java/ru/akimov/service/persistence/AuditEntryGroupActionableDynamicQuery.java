package ru.akimov.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.akimov.model.AuditEntryGroup;

import ru.akimov.service.AuditEntryGroupLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AuditEntryGroupActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AuditEntryGroupActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AuditEntryGroupLocalServiceUtil.getService());
        setClass(AuditEntryGroup.class);

        setClassLoader(ru.akimov.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("entryGroupId");
    }
}
