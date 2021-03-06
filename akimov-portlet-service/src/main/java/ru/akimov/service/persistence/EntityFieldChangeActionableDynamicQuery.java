package ru.akimov.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.akimov.model.EntityFieldChange;

import ru.akimov.service.EntityFieldChangeLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class EntityFieldChangeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EntityFieldChangeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EntityFieldChangeLocalServiceUtil.getService());
        setClass(EntityFieldChange.class);

        setClassLoader(ru.akimov.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fieldChangeId");
    }
}
