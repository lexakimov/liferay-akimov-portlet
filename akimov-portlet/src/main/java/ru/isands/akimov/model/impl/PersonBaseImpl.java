package ru.isands.akimov.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.akimov.model.Person;
import ru.isands.akimov.service.PersonLocalServiceUtil;

/**
 * The extended model base implementation for the Person service. Represents a row in the &quot;akimov_Person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PersonImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonImpl
 * @see ru.isands.akimov.model.Person
 * @generated
 */
public abstract class PersonBaseImpl extends PersonModelImpl implements Person {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a person model instance should use the {@link Person} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PersonLocalServiceUtil.addPerson(this);
        } else {
            PersonLocalServiceUtil.updatePerson(this);
        }
    }
}
