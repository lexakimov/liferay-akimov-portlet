package ru.isands.akimov.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import ru.isands.akimov.model.Person;
import ru.isands.akimov.service.PersonLocalService;
import ru.isands.akimov.service.persistence.EntityEditingHistoryPersistence;
import ru.isands.akimov.service.persistence.EntityFieldChangePersistence;
import ru.isands.akimov.service.persistence.FooPersistence;
import ru.isands.akimov.service.persistence.PersonPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the person local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ru.isands.akimov.service.impl.PersonLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ru.isands.akimov.service.impl.PersonLocalServiceImpl
 * @see ru.isands.akimov.service.PersonLocalServiceUtil
 * @generated
 */
public abstract class PersonLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements PersonLocalService, IdentifiableBean {
    @BeanReference(type = ru.isands.akimov.service.EntityEditingHistoryLocalService.class)
    protected ru.isands.akimov.service.EntityEditingHistoryLocalService entityEditingHistoryLocalService;
    @BeanReference(type = EntityEditingHistoryPersistence.class)
    protected EntityEditingHistoryPersistence entityEditingHistoryPersistence;
    @BeanReference(type = ru.isands.akimov.service.EntityFieldChangeLocalService.class)
    protected ru.isands.akimov.service.EntityFieldChangeLocalService entityFieldChangeLocalService;
    @BeanReference(type = EntityFieldChangePersistence.class)
    protected EntityFieldChangePersistence entityFieldChangePersistence;
    @BeanReference(type = ru.isands.akimov.service.FooLocalService.class)
    protected ru.isands.akimov.service.FooLocalService fooLocalService;
    @BeanReference(type = FooPersistence.class)
    protected FooPersistence fooPersistence;
    @BeanReference(type = ru.isands.akimov.service.PersonLocalService.class)
    protected ru.isands.akimov.service.PersonLocalService personLocalService;
    @BeanReference(type = PersonPersistence.class)
    protected PersonPersistence personPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private PersonLocalServiceClpInvoker _clpInvoker = new PersonLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ru.isands.akimov.service.PersonLocalServiceUtil} to access the person local service.
     */

    /**
     * Adds the person to the database. Also notifies the appropriate model listeners.
     *
     * @param person the person
     * @return the person that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Person addPerson(Person person) throws SystemException {
        person.setNew(true);

        return personPersistence.update(person);
    }

    /**
     * Creates a new person with the primary key. Does not add the person to the database.
     *
     * @param personId the primary key for the new person
     * @return the new person
     */
    @Override
    public Person createPerson(int personId) {
        return personPersistence.create(personId);
    }

    /**
     * Deletes the person with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param personId the primary key of the person
     * @return the person that was removed
     * @throws PortalException if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Person deletePerson(int personId)
        throws PortalException, SystemException {
        return personPersistence.remove(personId);
    }

    /**
     * Deletes the person from the database. Also notifies the appropriate model listeners.
     *
     * @param person the person
     * @return the person that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Person deletePerson(Person person) throws SystemException {
        return personPersistence.remove(person);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Person.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return personPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return personPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return personPersistence.findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return personPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return personPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Person fetchPerson(int personId) throws SystemException {
        return personPersistence.fetchByPrimaryKey(personId);
    }

    /**
     * Returns the person with the primary key.
     *
     * @param personId the primary key of the person
     * @return the person
     * @throws PortalException if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person getPerson(int personId)
        throws PortalException, SystemException {
        return personPersistence.findByPrimaryKey(personId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return personPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the persons.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of persons
     * @param end the upper bound of the range of persons (not inclusive)
     * @return the range of persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Person> getPersons(int start, int end)
        throws SystemException {
        return personPersistence.findAll(start, end);
    }

    /**
     * Returns the number of persons.
     *
     * @return the number of persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getPersonsCount() throws SystemException {
        return personPersistence.countAll();
    }

    /**
     * Updates the person in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param person the person
     * @return the person that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Person updatePerson(Person person) throws SystemException {
        return personPersistence.update(person);
    }

    /**
     * Returns the entity editing history local service.
     *
     * @return the entity editing history local service
     */
    public ru.isands.akimov.service.EntityEditingHistoryLocalService getEntityEditingHistoryLocalService() {
        return entityEditingHistoryLocalService;
    }

    /**
     * Sets the entity editing history local service.
     *
     * @param entityEditingHistoryLocalService the entity editing history local service
     */
    public void setEntityEditingHistoryLocalService(
        ru.isands.akimov.service.EntityEditingHistoryLocalService entityEditingHistoryLocalService) {
        this.entityEditingHistoryLocalService = entityEditingHistoryLocalService;
    }

    /**
     * Returns the entity editing history persistence.
     *
     * @return the entity editing history persistence
     */
    public EntityEditingHistoryPersistence getEntityEditingHistoryPersistence() {
        return entityEditingHistoryPersistence;
    }

    /**
     * Sets the entity editing history persistence.
     *
     * @param entityEditingHistoryPersistence the entity editing history persistence
     */
    public void setEntityEditingHistoryPersistence(
        EntityEditingHistoryPersistence entityEditingHistoryPersistence) {
        this.entityEditingHistoryPersistence = entityEditingHistoryPersistence;
    }

    /**
     * Returns the entity field change local service.
     *
     * @return the entity field change local service
     */
    public ru.isands.akimov.service.EntityFieldChangeLocalService getEntityFieldChangeLocalService() {
        return entityFieldChangeLocalService;
    }

    /**
     * Sets the entity field change local service.
     *
     * @param entityFieldChangeLocalService the entity field change local service
     */
    public void setEntityFieldChangeLocalService(
        ru.isands.akimov.service.EntityFieldChangeLocalService entityFieldChangeLocalService) {
        this.entityFieldChangeLocalService = entityFieldChangeLocalService;
    }

    /**
     * Returns the entity field change persistence.
     *
     * @return the entity field change persistence
     */
    public EntityFieldChangePersistence getEntityFieldChangePersistence() {
        return entityFieldChangePersistence;
    }

    /**
     * Sets the entity field change persistence.
     *
     * @param entityFieldChangePersistence the entity field change persistence
     */
    public void setEntityFieldChangePersistence(
        EntityFieldChangePersistence entityFieldChangePersistence) {
        this.entityFieldChangePersistence = entityFieldChangePersistence;
    }

    /**
     * Returns the foo local service.
     *
     * @return the foo local service
     */
    public ru.isands.akimov.service.FooLocalService getFooLocalService() {
        return fooLocalService;
    }

    /**
     * Sets the foo local service.
     *
     * @param fooLocalService the foo local service
     */
    public void setFooLocalService(
        ru.isands.akimov.service.FooLocalService fooLocalService) {
        this.fooLocalService = fooLocalService;
    }

    /**
     * Returns the foo persistence.
     *
     * @return the foo persistence
     */
    public FooPersistence getFooPersistence() {
        return fooPersistence;
    }

    /**
     * Sets the foo persistence.
     *
     * @param fooPersistence the foo persistence
     */
    public void setFooPersistence(FooPersistence fooPersistence) {
        this.fooPersistence = fooPersistence;
    }

    /**
     * Returns the person local service.
     *
     * @return the person local service
     */
    public ru.isands.akimov.service.PersonLocalService getPersonLocalService() {
        return personLocalService;
    }

    /**
     * Sets the person local service.
     *
     * @param personLocalService the person local service
     */
    public void setPersonLocalService(
        ru.isands.akimov.service.PersonLocalService personLocalService) {
        this.personLocalService = personLocalService;
    }

    /**
     * Returns the person persistence.
     *
     * @return the person persistence
     */
    public PersonPersistence getPersonPersistence() {
        return personPersistence;
    }

    /**
     * Sets the person persistence.
     *
     * @param personPersistence the person persistence
     */
    public void setPersonPersistence(PersonPersistence personPersistence) {
        this.personPersistence = personPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("ru.isands.akimov.model.Person",
            personLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "ru.isands.akimov.model.Person");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Person.class;
    }

    protected String getModelClassName() {
        return Person.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = personPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
