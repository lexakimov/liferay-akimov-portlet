package ru.akimov.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.akimov.model.Person;
import ru.akimov.service.ClpSerializer;
import ru.akimov.service.PersonLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class PersonActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PersonActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PersonLocalServiceUtil.getService());
        setClass(Person.class);

        setClassLoader(ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("personId");
    }
}
