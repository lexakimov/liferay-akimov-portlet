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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.isands.akimov.NoSuchEntityEditingHistoryException;
import ru.isands.akimov.model.EntityEditingHistory;
import ru.isands.akimov.model.impl.EntityEditingHistoryImpl;
import ru.isands.akimov.model.impl.EntityEditingHistoryModelImpl;
import ru.isands.akimov.service.persistence.EntityEditingHistoryPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the entity editing history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityEditingHistoryPersistence
 * @see EntityEditingHistoryUtil
 * @generated
 */
public class EntityEditingHistoryPersistenceImpl extends BasePersistenceImpl<EntityEditingHistory>
    implements EntityEditingHistoryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EntityEditingHistoryUtil} to access the entity editing history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EntityEditingHistoryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
            EntityEditingHistoryModelImpl.FINDER_CACHE_ENABLED,
            EntityEditingHistoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
            EntityEditingHistoryModelImpl.FINDER_CACHE_ENABLED,
            EntityEditingHistoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
            EntityEditingHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ENTITYEDITINGHISTORY = "SELECT entityEditingHistory FROM EntityEditingHistory entityEditingHistory";
    private static final String _SQL_COUNT_ENTITYEDITINGHISTORY = "SELECT COUNT(entityEditingHistory) FROM EntityEditingHistory entityEditingHistory";
    private static final String _ORDER_BY_ENTITY_ALIAS = "entityEditingHistory.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EntityEditingHistory exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EntityEditingHistoryPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static EntityEditingHistory _nullEntityEditingHistory = new EntityEditingHistoryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<EntityEditingHistory> toCacheModel() {
                return _nullEntityEditingHistoryCacheModel;
            }
        };

    private static CacheModel<EntityEditingHistory> _nullEntityEditingHistoryCacheModel =
        new CacheModel<EntityEditingHistory>() {
            @Override
            public EntityEditingHistory toEntityModel() {
                return _nullEntityEditingHistory;
            }
        };

    public EntityEditingHistoryPersistenceImpl() {
        setModelClass(EntityEditingHistory.class);
    }

    /**
     * Caches the entity editing history in the entity cache if it is enabled.
     *
     * @param entityEditingHistory the entity editing history
     */
    @Override
    public void cacheResult(EntityEditingHistory entityEditingHistory) {
        EntityCacheUtil.putResult(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
            EntityEditingHistoryImpl.class,
            entityEditingHistory.getPrimaryKey(), entityEditingHistory);

        entityEditingHistory.resetOriginalValues();
    }

    /**
     * Caches the entity editing histories in the entity cache if it is enabled.
     *
     * @param entityEditingHistories the entity editing histories
     */
    @Override
    public void cacheResult(List<EntityEditingHistory> entityEditingHistories) {
        for (EntityEditingHistory entityEditingHistory : entityEditingHistories) {
            if (EntityCacheUtil.getResult(
                        EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
                        EntityEditingHistoryImpl.class,
                        entityEditingHistory.getPrimaryKey()) == null) {
                cacheResult(entityEditingHistory);
            } else {
                entityEditingHistory.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all entity editing histories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EntityEditingHistoryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EntityEditingHistoryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the entity editing history.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(EntityEditingHistory entityEditingHistory) {
        EntityCacheUtil.removeResult(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
            EntityEditingHistoryImpl.class, entityEditingHistory.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<EntityEditingHistory> entityEditingHistories) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (EntityEditingHistory entityEditingHistory : entityEditingHistories) {
            EntityCacheUtil.removeResult(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
                EntityEditingHistoryImpl.class,
                entityEditingHistory.getPrimaryKey());
        }
    }

    /**
     * Creates a new entity editing history with the primary key. Does not add the entity editing history to the database.
     *
     * @param id the primary key for the new entity editing history
     * @return the new entity editing history
     */
    @Override
    public EntityEditingHistory create(int id) {
        EntityEditingHistory entityEditingHistory = new EntityEditingHistoryImpl();

        entityEditingHistory.setNew(true);
        entityEditingHistory.setPrimaryKey(id);

        return entityEditingHistory;
    }

    /**
     * Removes the entity editing history with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the entity editing history
     * @return the entity editing history that was removed
     * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityEditingHistory remove(int id)
        throws NoSuchEntityEditingHistoryException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the entity editing history with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the entity editing history
     * @return the entity editing history that was removed
     * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityEditingHistory remove(Serializable primaryKey)
        throws NoSuchEntityEditingHistoryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            EntityEditingHistory entityEditingHistory = (EntityEditingHistory) session.get(EntityEditingHistoryImpl.class,
                    primaryKey);

            if (entityEditingHistory == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEntityEditingHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(entityEditingHistory);
        } catch (NoSuchEntityEditingHistoryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected EntityEditingHistory removeImpl(
        EntityEditingHistory entityEditingHistory) throws SystemException {
        entityEditingHistory = toUnwrappedModel(entityEditingHistory);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(entityEditingHistory)) {
                entityEditingHistory = (EntityEditingHistory) session.get(EntityEditingHistoryImpl.class,
                        entityEditingHistory.getPrimaryKeyObj());
            }

            if (entityEditingHistory != null) {
                session.delete(entityEditingHistory);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (entityEditingHistory != null) {
            clearCache(entityEditingHistory);
        }

        return entityEditingHistory;
    }

    @Override
    public EntityEditingHistory updateImpl(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory)
        throws SystemException {
        entityEditingHistory = toUnwrappedModel(entityEditingHistory);

        boolean isNew = entityEditingHistory.isNew();

        Session session = null;

        try {
            session = openSession();

            if (entityEditingHistory.isNew()) {
                session.save(entityEditingHistory);

                entityEditingHistory.setNew(false);
            } else {
                session.merge(entityEditingHistory);
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

        EntityCacheUtil.putResult(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
            EntityEditingHistoryImpl.class,
            entityEditingHistory.getPrimaryKey(), entityEditingHistory);

        return entityEditingHistory;
    }

    protected EntityEditingHistory toUnwrappedModel(
        EntityEditingHistory entityEditingHistory) {
        if (entityEditingHistory instanceof EntityEditingHistoryImpl) {
            return entityEditingHistory;
        }

        EntityEditingHistoryImpl entityEditingHistoryImpl = new EntityEditingHistoryImpl();

        entityEditingHistoryImpl.setNew(entityEditingHistory.isNew());
        entityEditingHistoryImpl.setPrimaryKey(entityEditingHistory.getPrimaryKey());

        entityEditingHistoryImpl.setId(entityEditingHistory.getId());
        entityEditingHistoryImpl.setEntityId(entityEditingHistory.getEntityId());
        entityEditingHistoryImpl.setEntityType(entityEditingHistory.getEntityType());
        entityEditingHistoryImpl.setUserId(entityEditingHistory.getUserId());
        entityEditingHistoryImpl.setDescription(entityEditingHistory.getDescription());
        entityEditingHistoryImpl.setDateOfChange(entityEditingHistory.getDateOfChange());

        return entityEditingHistoryImpl;
    }

    /**
     * Returns the entity editing history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the entity editing history
     * @return the entity editing history
     * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityEditingHistory findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEntityEditingHistoryException, SystemException {
        EntityEditingHistory entityEditingHistory = fetchByPrimaryKey(primaryKey);

        if (entityEditingHistory == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEntityEditingHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return entityEditingHistory;
    }

    /**
     * Returns the entity editing history with the primary key or throws a {@link ru.isands.akimov.NoSuchEntityEditingHistoryException} if it could not be found.
     *
     * @param id the primary key of the entity editing history
     * @return the entity editing history
     * @throws ru.isands.akimov.NoSuchEntityEditingHistoryException if a entity editing history with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityEditingHistory findByPrimaryKey(int id)
        throws NoSuchEntityEditingHistoryException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the entity editing history with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the entity editing history
     * @return the entity editing history, or <code>null</code> if a entity editing history with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityEditingHistory fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        EntityEditingHistory entityEditingHistory = (EntityEditingHistory) EntityCacheUtil.getResult(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
                EntityEditingHistoryImpl.class, primaryKey);

        if (entityEditingHistory == _nullEntityEditingHistory) {
            return null;
        }

        if (entityEditingHistory == null) {
            Session session = null;

            try {
                session = openSession();

                entityEditingHistory = (EntityEditingHistory) session.get(EntityEditingHistoryImpl.class,
                        primaryKey);

                if (entityEditingHistory != null) {
                    cacheResult(entityEditingHistory);
                } else {
                    EntityCacheUtil.putResult(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
                        EntityEditingHistoryImpl.class, primaryKey,
                        _nullEntityEditingHistory);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EntityEditingHistoryModelImpl.ENTITY_CACHE_ENABLED,
                    EntityEditingHistoryImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return entityEditingHistory;
    }

    /**
     * Returns the entity editing history with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the entity editing history
     * @return the entity editing history, or <code>null</code> if a entity editing history with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EntityEditingHistory fetchByPrimaryKey(int id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the entity editing histories.
     *
     * @return the entity editing histories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EntityEditingHistory> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the entity editing histories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityEditingHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of entity editing histories
     * @param end the upper bound of the range of entity editing histories (not inclusive)
     * @return the range of entity editing histories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EntityEditingHistory> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the entity editing histories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.EntityEditingHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of entity editing histories
     * @param end the upper bound of the range of entity editing histories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of entity editing histories
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EntityEditingHistory> findAll(int start, int end,
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

        List<EntityEditingHistory> list = (List<EntityEditingHistory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ENTITYEDITINGHISTORY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ENTITYEDITINGHISTORY;

                if (pagination) {
                    sql = sql.concat(EntityEditingHistoryModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<EntityEditingHistory>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EntityEditingHistory>(list);
                } else {
                    list = (List<EntityEditingHistory>) QueryUtil.list(q,
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
     * Removes all the entity editing histories from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (EntityEditingHistory entityEditingHistory : findAll()) {
            remove(entityEditingHistory);
        }
    }

    /**
     * Returns the number of entity editing histories.
     *
     * @return the number of entity editing histories
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

                Query q = session.createQuery(_SQL_COUNT_ENTITYEDITINGHISTORY);

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
     * Initializes the entity editing history persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.isands.akimov.model.EntityEditingHistory")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<EntityEditingHistory>> listenersList = new ArrayList<ModelListener<EntityEditingHistory>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<EntityEditingHistory>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EntityEditingHistoryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
