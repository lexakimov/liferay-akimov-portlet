package ru.isands.akimov.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.isands.akimov.NoSuchPersonException;
import ru.isands.akimov.model.Person;
import ru.isands.akimov.model.impl.PersonImpl;
import ru.isands.akimov.model.impl.PersonModelImpl;
import ru.isands.akimov.service.persistence.PersonPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the person service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonPersistence
 * @see PersonUtil
 * @generated
 */
public class PersonPersistenceImpl extends BasePersistenceImpl<Person>
    implements PersonPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PersonUtil} to access the person persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PersonImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonModelImpl.FINDER_CACHE_ENABLED, PersonImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonModelImpl.FINDER_CACHE_ENABLED, PersonImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonModelImpl.FINDER_CACHE_ENABLED, PersonImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonModelImpl.FINDER_CACHE_ENABLED, PersonImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            PersonModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "person.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "person.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(person.uuid IS NULL OR person.uuid = '')";
    private static final String _SQL_SELECT_PERSON = "SELECT person FROM Person person";
    private static final String _SQL_SELECT_PERSON_WHERE = "SELECT person FROM Person person WHERE ";
    private static final String _SQL_COUNT_PERSON = "SELECT COUNT(person) FROM Person person";
    private static final String _SQL_COUNT_PERSON_WHERE = "SELECT COUNT(person) FROM Person person WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "person.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Person exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Person exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PersonPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Person _nullPerson = new PersonImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Person> toCacheModel() {
                return _nullPersonCacheModel;
            }
        };

    private static CacheModel<Person> _nullPersonCacheModel = new CacheModel<Person>() {
            @Override
            public Person toEntityModel() {
                return _nullPerson;
            }
        };

    public PersonPersistenceImpl() {
        setModelClass(Person.class);
    }

    /**
     * Returns all the persons where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Person> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the persons where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of persons
     * @param end the upper bound of the range of persons (not inclusive)
     * @return the range of matching persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Person> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the persons where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of persons
     * @param end the upper bound of the range of persons (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Person> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Person> list = (List<Person>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Person person : list) {
                if (!Validator.equals(uuid, person.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PERSON_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PersonModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Person>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Person>(list);
                } else {
                    list = (List<Person>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first person in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching person
     * @throws ru.isands.akimov.NoSuchPersonException if a matching person could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPersonException, SystemException {
        Person person = fetchByUuid_First(uuid, orderByComparator);

        if (person != null) {
            return person;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPersonException(msg.toString());
    }

    /**
     * Returns the first person in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching person, or <code>null</code> if a matching person could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Person> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last person in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching person
     * @throws ru.isands.akimov.NoSuchPersonException if a matching person could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPersonException, SystemException {
        Person person = fetchByUuid_Last(uuid, orderByComparator);

        if (person != null) {
            return person;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPersonException(msg.toString());
    }

    /**
     * Returns the last person in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching person, or <code>null</code> if a matching person could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Person> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the persons before and after the current person in the ordered set where uuid = &#63;.
     *
     * @param personId the primary key of the current person
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next person
     * @throws ru.isands.akimov.NoSuchPersonException if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person[] findByUuid_PrevAndNext(int personId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPersonException, SystemException {
        Person person = findByPrimaryKey(personId);

        Session session = null;

        try {
            session = openSession();

            Person[] array = new PersonImpl[3];

            array[0] = getByUuid_PrevAndNext(session, person, uuid,
                    orderByComparator, true);

            array[1] = person;

            array[2] = getByUuid_PrevAndNext(session, person, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Person getByUuid_PrevAndNext(Session session, Person person,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PERSON_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PersonModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(person);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Person> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the persons where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Person person : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(person);
        }
    }

    /**
     * Returns the number of persons where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PERSON_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the person in the entity cache if it is enabled.
     *
     * @param person the person
     */
    @Override
    public void cacheResult(Person person) {
        EntityCacheUtil.putResult(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonImpl.class, person.getPrimaryKey(), person);

        person.resetOriginalValues();
    }

    /**
     * Caches the persons in the entity cache if it is enabled.
     *
     * @param persons the persons
     */
    @Override
    public void cacheResult(List<Person> persons) {
        for (Person person : persons) {
            if (EntityCacheUtil.getResult(
                        PersonModelImpl.ENTITY_CACHE_ENABLED, PersonImpl.class,
                        person.getPrimaryKey()) == null) {
                cacheResult(person);
            } else {
                person.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all persons.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PersonImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PersonImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the person.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Person person) {
        EntityCacheUtil.removeResult(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonImpl.class, person.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Person> persons) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Person person : persons) {
            EntityCacheUtil.removeResult(PersonModelImpl.ENTITY_CACHE_ENABLED,
                PersonImpl.class, person.getPrimaryKey());
        }
    }

    /**
     * Creates a new person with the primary key. Does not add the person to the database.
     *
     * @param personId the primary key for the new person
     * @return the new person
     */
    @Override
    public Person create(int personId) {
        Person person = new PersonImpl();

        person.setNew(true);
        person.setPrimaryKey(personId);

        String uuid = PortalUUIDUtil.generate();

        person.setUuid(uuid);

        return person;
    }

    /**
     * Removes the person with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param personId the primary key of the person
     * @return the person that was removed
     * @throws ru.isands.akimov.NoSuchPersonException if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person remove(int personId)
        throws NoSuchPersonException, SystemException {
        return remove((Serializable) personId);
    }

    /**
     * Removes the person with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the person
     * @return the person that was removed
     * @throws ru.isands.akimov.NoSuchPersonException if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person remove(Serializable primaryKey)
        throws NoSuchPersonException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Person person = (Person) session.get(PersonImpl.class, primaryKey);

            if (person == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPersonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(person);
        } catch (NoSuchPersonException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Person removeImpl(Person person) throws SystemException {
        person = toUnwrappedModel(person);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(person)) {
                person = (Person) session.get(PersonImpl.class,
                        person.getPrimaryKeyObj());
            }

            if (person != null) {
                session.delete(person);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (person != null) {
            clearCache(person);
        }

        return person;
    }

    @Override
    public Person updateImpl(ru.isands.akimov.model.Person person)
        throws SystemException {
        person = toUnwrappedModel(person);

        boolean isNew = person.isNew();

        PersonModelImpl personModelImpl = (PersonModelImpl) person;

        if (Validator.isNull(person.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            person.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (person.isNew()) {
                session.save(person);

                person.setNew(false);
            } else {
                session.merge(person);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PersonModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((personModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { personModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { personModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }
        }

        EntityCacheUtil.putResult(PersonModelImpl.ENTITY_CACHE_ENABLED,
            PersonImpl.class, person.getPrimaryKey(), person);

        return person;
    }

    protected Person toUnwrappedModel(Person person) {
        if (person instanceof PersonImpl) {
            return person;
        }

        PersonImpl personImpl = new PersonImpl();

        personImpl.setNew(person.isNew());
        personImpl.setPrimaryKey(person.getPrimaryKey());

        personImpl.setUuid(person.getUuid());
        personImpl.setPersonId(person.getPersonId());
        personImpl.setLastName(person.getLastName());
        personImpl.setFirstName(person.getFirstName());
        personImpl.setMiddleName(person.getMiddleName());
        personImpl.setGender(person.getGender());
        personImpl.setBirthDate(person.getBirthDate());
        personImpl.setAddress(person.getAddress());

        return personImpl;
    }

    /**
     * Returns the person with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the person
     * @return the person
     * @throws ru.isands.akimov.NoSuchPersonException if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPersonException, SystemException {
        Person person = fetchByPrimaryKey(primaryKey);

        if (person == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPersonException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return person;
    }

    /**
     * Returns the person with the primary key or throws a {@link ru.isands.akimov.NoSuchPersonException} if it could not be found.
     *
     * @param personId the primary key of the person
     * @return the person
     * @throws ru.isands.akimov.NoSuchPersonException if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person findByPrimaryKey(int personId)
        throws NoSuchPersonException, SystemException {
        return findByPrimaryKey((Serializable) personId);
    }

    /**
     * Returns the person with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the person
     * @return the person, or <code>null</code> if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Person person = (Person) EntityCacheUtil.getResult(PersonModelImpl.ENTITY_CACHE_ENABLED,
                PersonImpl.class, primaryKey);

        if (person == _nullPerson) {
            return null;
        }

        if (person == null) {
            Session session = null;

            try {
                session = openSession();

                person = (Person) session.get(PersonImpl.class, primaryKey);

                if (person != null) {
                    cacheResult(person);
                } else {
                    EntityCacheUtil.putResult(PersonModelImpl.ENTITY_CACHE_ENABLED,
                        PersonImpl.class, primaryKey, _nullPerson);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PersonModelImpl.ENTITY_CACHE_ENABLED,
                    PersonImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return person;
    }

    /**
     * Returns the person with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param personId the primary key of the person
     * @return the person, or <code>null</code> if a person with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Person fetchByPrimaryKey(int personId) throws SystemException {
        return fetchByPrimaryKey((Serializable) personId);
    }

    /**
     * Returns all the persons.
     *
     * @return the persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Person> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Person> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the persons.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of persons
     * @param end the upper bound of the range of persons (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Person> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Person> list = (List<Person>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PERSON);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PERSON;

                if (pagination) {
                    sql = sql.concat(PersonModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Person>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Person>(list);
                } else {
                    list = (List<Person>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the persons from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Person person : findAll()) {
            remove(person);
        }
    }

    /**
     * Returns the number of persons.
     *
     * @return the number of persons
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PERSON);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the person persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.isands.akimov.model.Person")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Person>> listenersList = new ArrayList<ModelListener<Person>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Person>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PersonImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
