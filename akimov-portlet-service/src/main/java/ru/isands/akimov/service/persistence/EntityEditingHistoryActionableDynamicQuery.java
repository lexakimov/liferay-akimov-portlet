package ru.isands.akimov.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.akimov.model.EntityEditingHistory;
import ru.isands.akimov.service.EntityEditingHistoryLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class EntityEditingHistoryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EntityEditingHistoryActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(EntityEditingHistoryLocalServiceUtil.getService());
        setClass(EntityEditingHistory.class);

        setClassLoader(ru.isands.akimov.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
