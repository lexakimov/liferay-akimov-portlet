package ru.isands.akimov.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.isands.akimov.NoSuchFooException;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.model.impl.FooImpl;
import ru.isands.akimov.model.impl.FooModelImpl;
import ru.isands.akimov.service.persistence.FooPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the foo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FooPersistence
 * @see FooUtil
 * @generated
 */
public class FooPersistenceImpl extends BasePersistenceImpl<Foo>
    implements FooPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FooUtil} to access the foo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FooImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_FOO = "SELECT foo FROM Foo foo";
    private static final String _SQL_COUNT_FOO = "SELECT COUNT(foo) FROM Foo foo";
    private static final String _ORDER_BY_ENTITY_ALIAS = "foo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Foo exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FooPersistenceImpl.class);
    private static Foo _nullFoo = new FooImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Foo> toCacheModel() {
                return _nullFooCacheModel;
            }
        };

    private static CacheModel<Foo> _nullFooCacheModel = new CacheModel<Foo>() {
            @Override
            public Foo toEntityModel() {
                return _nullFoo;
            }
        };

    public FooPersistenceImpl() {
        setModelClass(Foo.class);
    }

    /**
     * Caches the foo in the entity cache if it is enabled.
     *
     * @param foo the foo
     */
    @Override
    public void cacheResult(Foo foo) {
        EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey(), foo);

        foo.resetOriginalValues();
    }

    /**
     * Caches the foos in the entity cache if it is enabled.
     *
     * @param foos the foos
     */
    @Override
    public void cacheResult(List<Foo> foos) {
        for (Foo foo : foos) {
            if (EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                        FooImpl.class, foo.getPrimaryKey()) == null) {
                cacheResult(foo);
            } else {
                foo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all foos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FooImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FooImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the foo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Foo foo) {
        EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Foo> foos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Foo foo : foos) {
            EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                FooImpl.class, foo.getPrimaryKey());
        }
    }

    /**
     * Creates a new foo with the primary key. Does not add the foo to the database.
     *
     * @param fooId the primary key for the new foo
     * @return the new foo
     */
    @Override
    public Foo create(int fooId) {
        Foo foo = new FooImpl();

        foo.setNew(true);
        foo.setPrimaryKey(fooId);

        return foo;
    }

    /**
     * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param fooId the primary key of the foo
     * @return the foo that was removed
     * @throws ru.isands.akimov.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo remove(int fooId) throws NoSuchFooException, SystemException {
        return remove((Serializable) fooId);
    }

    /**
     * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo that was removed
     * @throws ru.isands.akimov.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo remove(Serializable primaryKey)
        throws NoSuchFooException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Foo foo = (Foo) session.get(FooImpl.class, primaryKey);

            if (foo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(foo);
        } catch (NoSuchFooException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Foo removeImpl(Foo foo) throws SystemException {
        foo = toUnwrappedModel(foo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(foo)) {
                foo = (Foo) session.get(FooImpl.class, foo.getPrimaryKeyObj());
            }

            if (foo != null) {
                session.delete(foo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (foo != null) {
            clearCache(foo);
        }

        return foo;
    }

    @Override
    public Foo updateImpl(ru.isands.akimov.model.Foo foo)
        throws SystemException {
        foo = toUnwrappedModel(foo);

        boolean isNew = foo.isNew();

        Session session = null;

        try {
            session = openSession();

            if (foo.isNew()) {
                session.save(foo);

                foo.setNew(false);
            } else {
                session.evict(foo);
                session.saveOrUpdate(foo);
            }

            session.flush();
            session.clear();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey(), foo);

        foo.resetOriginalValues();

        return foo;
    }

    protected Foo toUnwrappedModel(Foo foo) {
        if (foo instanceof FooImpl) {
            return foo;
        }

        FooImpl fooImpl = new FooImpl();

        fooImpl.setNew(foo.isNew());
        fooImpl.setPrimaryKey(foo.getPrimaryKey());

        fooImpl.setFooId(foo.getFooId());
        fooImpl.setBooleanField(foo.isBooleanField());
        fooImpl.setShortField(foo.getShortField());
        fooImpl.setIntField(foo.getIntField());
        fooImpl.setLongField(foo.getLongField());
        fooImpl.setDoubleField(foo.getDoubleField());
        fooImpl.setFloatField(foo.getFloatField());
        fooImpl.setStringField(foo.getStringField());
        fooImpl.setDateField(foo.getDateField());
        fooImpl.setBlobField(foo.getBlobField());

        return fooImpl;
    }

    /**
     * Returns the foo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo
     * @throws ru.isands.akimov.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByPrimaryKey(primaryKey);

        if (foo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return foo;
    }

    /**
     * Returns the foo with the primary key or throws a {@link ru.isands.akimov.NoSuchFooException} if it could not be found.
     *
     * @param fooId the primary key of the foo
     * @return the foo
     * @throws ru.isands.akimov.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByPrimaryKey(int fooId)
        throws NoSuchFooException, SystemException {
        return findByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo, or <code>null</code> if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Foo foo = (Foo) EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                FooImpl.class, primaryKey);

        if (foo == _nullFoo) {
            return null;
        }

        if (foo == null) {
            Session session = null;

            try {
                session = openSession();

                foo = (Foo) session.get(FooImpl.class, primaryKey);

                if (foo != null) {
                    cacheResult(foo);
                } else {
                    EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                        FooImpl.class, primaryKey, _nullFoo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                    FooImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return foo;
    }

    /**
     * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param fooId the primary key of the foo
     * @return the foo, or <code>null</code> if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByPrimaryKey(int fooId) throws SystemException {
        return fetchByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns all the foos.
     *
     * @return the foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the foos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of foos
     * @param end the upper bound of the range of foos (not inclusive)
     * @return the range of foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the foos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of foos
     * @param end the upper bound of the range of foos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findAll(int start, int end,
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

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FOO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FOO;

                if (pagination) {
                    sql = sql.concat(FooModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the foos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Foo foo : findAll()) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos.
     *
     * @return the number of foos
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

                Query q = session.createQuery(_SQL_COUNT_FOO);

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

    /**
     * Initializes the foo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.isands.akimov.model.Foo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Foo>> listenersList = new ArrayList<ModelListener<Foo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Foo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FooImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
