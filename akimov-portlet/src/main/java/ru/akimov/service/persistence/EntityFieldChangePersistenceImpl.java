package ru.akimov.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.akimov.NoSuchEntityFieldChangeException;
import ru.akimov.model.EntityFieldChange;
import ru.akimov.model.impl.EntityFieldChangeImpl;
import ru.akimov.model.impl.EntityFieldChangeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the entity field change service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityFieldChangePersistence
 * @see EntityFieldChangeUtil
 * @generated
 */
public class EntityFieldChangePersistenceImpl extends BasePersistenceImpl<EntityFieldChange>
    implements EntityFieldChangePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EntityFieldChangeUtil} to access the entity field change persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EntityFieldChangeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
            EntityFieldChangeModelImpl.FINDER_CACHE_ENABLED,
            EntityFieldChangeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
            EntityFieldChangeModelImpl.FINDER_CACHE_ENABLED,
            EntityFieldChangeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
            EntityFieldChangeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ENTITYFIELDCHANGE = "SELECT entityFieldChange FROM EntityFieldChange entityFieldChange";
    private static final String _SQL_COUNT_ENTITYFIELDCHANGE = "SELECT COUNT(entityFieldChange) FROM EntityFieldChange entityFieldChange";
    private static final String _ORDER_BY_ENTITY_ALIAS = "entityFieldChange.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EntityFieldChange exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EntityFieldChangePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static EntityFieldChange _nullEntityFieldChange = new EntityFieldChangeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<EntityFieldChange> toCacheModel() {
                return _nullEntityFieldChangeCacheModel;
            }
        };

    private static CacheModel<EntityFieldChange> _nullEntityFieldChangeCacheModel =
        new CacheModel<EntityFieldChange>() {
            @Override
            public EntityFieldChange toEntityModel() {
                return _nullEntityFieldChange;
            }
        };

    public EntityFieldChangePersistenceImpl() {
        setModelClass(EntityFieldChange.class);
    }

    /**
     * Caches the entity field change in the entity cache if it is enabled.
     *
     * @param entityFieldChange the entity field change
     */
    @Override
    public void cacheResult(EntityFieldChange entityFieldChange) {
        EntityCacheUtil.putResult(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
            EntityFieldChangeImpl.class, entityFieldChange.getPrimaryKey(),
            entityFieldChange);

        entityFieldChange.resetOriginalValues();
    }

    /**
     * Caches the entity field changes in the entity cache if it is enabled.
     *
     * @param entityFieldChanges the entity field changes
     */
    @Override
    public void cacheResult(List<EntityFieldChange> entityFieldChanges) {
        for (EntityFieldChange entityFieldChange : entityFieldChanges) {
            if (EntityCacheUtil.getResult(
                        EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
                        EntityFieldChangeImpl.class,
                        entityFieldChange.getPrimaryKey()) == null) {
                cacheResult(entityFieldChange);
            } else {
                entityFieldChange.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all entity field changes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EntityFieldChangeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EntityFieldChangeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the entity field change.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(EntityFieldChange entityFieldChange) {
        EntityCacheUtil.removeResult(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
            EntityFieldChangeImpl.class, entityFieldChange.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<EntityFieldChange> entityFieldChanges) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (EntityFieldChange entityFieldChange : entityFieldChanges) {
            EntityCacheUtil.removeResult(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
                EntityFieldChangeImpl.class, entityFieldChange.getPrimaryKey());
        }
    }

    /**
     * Creates a new entity field change with the primary key. Does not add the entity field change to the database.
     *
     * @param id the primary key for the new entity field change
     * @return the new entity field change
     */
    @Override
    public EntityFieldChange create(int id) {
        EntityFieldChange entityFieldChange = new EntityFieldChangeImpl();

        entityFieldChange.setNew(true);
        entityFieldChange.setPrimaryKey(id);

        return entityFieldChange;
    }

    /**
     * Removes the entity field change with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the entity field change
     * @return the entity field change that was removed
     * @throws NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityFieldChange remove(int id)
        throws NoSuchEntityFieldChangeException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the entity field change with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the entity field change
     * @return the entity field change that was removed
     * @throws NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityFieldChange remove(Serializable primaryKey)
        throws NoSuchEntityFieldChangeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            EntityFieldChange entityFieldChange = (EntityFieldChange) session.get(EntityFieldChangeImpl.class,
                    primaryKey);

            if (entityFieldChange == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEntityFieldChangeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(entityFieldChange);
        } catch (NoSuchEntityFieldChangeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected EntityFieldChange removeImpl(EntityFieldChange entityFieldChange)
        throws SystemException {
        entityFieldChange = toUnwrappedModel(entityFieldChange);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(entityFieldChange)) {
                entityFieldChange = (EntityFieldChange) session.get(EntityFieldChangeImpl.class,
                        entityFieldChange.getPrimaryKeyObj());
            }

            if (entityFieldChange != null) {
                session.delete(entityFieldChange);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (entityFieldChange != null) {
            clearCache(entityFieldChange);
        }

        return entityFieldChange;
    }

    @Override
    public EntityFieldChange updateImpl(
        EntityFieldChange entityFieldChange)
        throws SystemException {
        entityFieldChange = toUnwrappedModel(entityFieldChange);

        boolean isNew = entityFieldChange.isNew();

        Session session = null;

        try {
            session = openSession();

            if (entityFieldChange.isNew()) {
                session.save(entityFieldChange);

                entityFieldChange.setNew(false);
            } else {
                session.merge(entityFieldChange);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
            EntityFieldChangeImpl.class, entityFieldChange.getPrimaryKey(),
            entityFieldChange);

        return entityFieldChange;
    }

    protected EntityFieldChange toUnwrappedModel(
        EntityFieldChange entityFieldChange) {
        if (entityFieldChange instanceof EntityFieldChangeImpl) {
            return entityFieldChange;
        }

        EntityFieldChangeImpl entityFieldChangeImpl = new EntityFieldChangeImpl();

        entityFieldChangeImpl.setNew(entityFieldChange.isNew());
        entityFieldChangeImpl.setPrimaryKey(entityFieldChange.getPrimaryKey());

        entityFieldChangeImpl.setId(entityFieldChange.getId());
        entityFieldChangeImpl.setAuditEntryId(entityFieldChange.getAuditEntryId());
        entityFieldChangeImpl.setFieldName(entityFieldChange.getFieldName());
        entityFieldChangeImpl.setOldValue(entityFieldChange.getOldValue());
        entityFieldChangeImpl.setNewValue(entityFieldChange.getNewValue());

        return entityFieldChangeImpl;
    }

    /**
     * Returns the entity field change with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the entity field change
     * @return the entity field change
     * @throws NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityFieldChange findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEntityFieldChangeException, SystemException {
        EntityFieldChange entityFieldChange = fetchByPrimaryKey(primaryKey);

        if (entityFieldChange == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEntityFieldChangeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return entityFieldChange;
    }

    /**
     * Returns the entity field change with the primary key or throws a {@link NoSuchEntityFieldChangeException} if it could not be found.
     *
     * @param id the primary key of the entity field change
     * @return the entity field change
     * @throws NoSuchEntityFieldChangeException if a entity field change with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityFieldChange findByPrimaryKey(int id)
        throws NoSuchEntityFieldChangeException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the entity field change with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the entity field change
     * @return the entity field change, or <code>null</code> if a entity field change with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityFieldChange fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        EntityFieldChange entityFieldChange = (EntityFieldChange) EntityCacheUtil.getResult(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
                EntityFieldChangeImpl.class, primaryKey);

        if (entityFieldChange == _nullEntityFieldChange) {
            return null;
        }

        if (entityFieldChange == null) {
            Session session = null;

            try {
                session = openSession();

                entityFieldChange = (EntityFieldChange) session.get(EntityFieldChangeImpl.class,
                        primaryKey);

                if (entityFieldChange != null) {
                    cacheResult(entityFieldChange);
                } else {
                    EntityCacheUtil.putResult(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
                        EntityFieldChangeImpl.class, primaryKey,
                        _nullEntityFieldChange);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EntityFieldChangeModelImpl.ENTITY_CACHE_ENABLED,
                    EntityFieldChangeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return entityFieldChange;
    }

    /**
     * Returns the entity field change with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the entity field change
     * @return the entity field change, or <code>null</code> if a entity field change with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityFieldChange fetchByPrimaryKey(int id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the entity field changes.
     *
     * @return the entity field changes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EntityFieldChange> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the entity field changes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of entity field changes
     * @param end the upper bound of the range of entity field changes (not inclusive)
     * @return the range of entity field changes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EntityFieldChange> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the entity field changes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityFieldChangeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of entity field changes
     * @param end the upper bound of the range of entity field changes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of entity field changes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EntityFieldChange> findAll(int start, int end,
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

        List<EntityFieldChange> list = (List<EntityFieldChange>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ENTITYFIELDCHANGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ENTITYFIELDCHANGE;

                if (pagination) {
                    sql = sql.concat(EntityFieldChangeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<EntityFieldChange>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EntityFieldChange>(list);
                } else {
                    list = (List<EntityFieldChange>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the entity field changes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (EntityFieldChange entityFieldChange : findAll()) {
            remove(entityFieldChange);
        }
    }

    /**
     * Returns the number of entity field changes.
     *
     * @return the number of entity field changes
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

                Query q = session.createQuery(_SQL_COUNT_ENTITYFIELDCHANGE);

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
     * Initializes the entity field change persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.akimov.model.EntityFieldChange")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<EntityFieldChange>> listenersList = new ArrayList<ModelListener<EntityFieldChange>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<EntityFieldChange>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EntityFieldChangeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}