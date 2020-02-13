package ru.akimov.model.impl;

import ru.akimov.model.Person;

/**
 * The extended model implementation for the Person service. Represents a row in the &quot;akimov_Person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link Person} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class PersonImpl extends PersonBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a person model instance should use the {@link ru.akimov.model.Person} interface instead.
     */
    public PersonImpl() {
    }
}
