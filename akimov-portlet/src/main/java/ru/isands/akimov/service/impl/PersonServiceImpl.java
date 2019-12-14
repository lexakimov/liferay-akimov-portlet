package ru.isands.akimov.service.impl;

import ru.isands.akimov.service.base.PersonServiceBaseImpl;

/**
 * The implementation of the person remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.isands.akimov.service.PersonService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ru.isands.akimov.service.base.PersonServiceBaseImpl
 * @see ru.isands.akimov.service.PersonServiceUtil
 */
public class PersonServiceImpl extends PersonServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ru.isands.akimov.service.PersonServiceUtil} to access the person remote service.
     */
}
