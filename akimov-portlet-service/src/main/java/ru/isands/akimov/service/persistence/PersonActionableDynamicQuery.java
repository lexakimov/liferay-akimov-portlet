package ru.isands.akimov.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.akimov.model.Person;
import ru.isands.akimov.service.PersonLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class PersonActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PersonActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PersonLocalServiceUtil.getService());
        setClass(Person.class);

        setClassLoader(ru.isands.akimov.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("personId");
    }
}
