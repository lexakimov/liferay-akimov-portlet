package ru.isands.akimov.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.service.AuditEntryLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AuditEntryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AuditEntryActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AuditEntryLocalServiceUtil.getService());
        setClass(AuditEntry.class);

        setClassLoader(ru.isands.akimov.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("auditEntryId");
    }
}
