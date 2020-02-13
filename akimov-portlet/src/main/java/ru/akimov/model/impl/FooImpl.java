package ru.akimov.model.impl;

import ru.akimov.model.Foo;

/**
 * The extended model implementation for the Foo service. Represents a row in the &quot;akimov_Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link Foo} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class FooImpl extends FooBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a foo model instance should use the {@link ru.akimov.model.Foo} interface instead.
     */
    public FooImpl() {
    }
}
