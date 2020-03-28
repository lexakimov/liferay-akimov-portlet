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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.akimov.NoSuchAuditEntryGroupException;

import ru.akimov.model.AuditEntryGroup;
import ru.akimov.model.impl.AuditEntryGroupImpl;
import ru.akimov.model.impl.AuditEntryGroupModelImpl;

import ru.akimov.service.persistence.AuditEntryGroupPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Группа записей аудита service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryGroupPersistence
 * @see AuditEntryGroupUtil
 * @generated
 */
public class AuditEntryGroupPersistenceImpl extends BasePersistenceImpl<AuditEntryGroup>
    implements AuditEntryGroupPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AuditEntryGroupUtil} to access the Группа записей аудита persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AuditEntryGroupImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryGroupModelImpl.FINDER_CACHE_ENABLED,
            AuditEntryGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryGroupModelImpl.FINDER_CACHE_ENABLED,
            AuditEntryGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_AUDITENTRYGROUP = "SELECT auditEntryGroup FROM AuditEntryGroup auditEntryGroup";
    private static final String _SQL_COUNT_AUDITENTRYGROUP = "SELECT COUNT(auditEntryGroup) FROM AuditEntryGroup auditEntryGroup";
    private static final String _ORDER_BY_ENTITY_ALIAS = "auditEntryGroup.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuditEntryGroup exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AuditEntryGroupPersistenceImpl.class);
    private static AuditEntryGroup _nullAuditEntryGroup = new AuditEntryGroupImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AuditEntryGroup> toCacheModel() {
                return _nullAuditEntryGroupCacheModel;
            }
        };

    private static CacheModel<AuditEntryGroup> _nullAuditEntryGroupCacheModel = new CacheModel<AuditEntryGroup>() {
            @Override
            public AuditEntryGroup toEntityModel() {
                return _nullAuditEntryGroup;
            }
        };

    public AuditEntryGroupPersistenceImpl() {
        setModelClass(AuditEntryGroup.class);
    }

    /**
     * Caches the Группа записей аудита in the entity cache if it is enabled.
     *
     * @param auditEntryGroup the Группа записей аудита
     */
    @Override
    public void cacheResult(AuditEntryGroup auditEntryGroup) {
        EntityCacheUtil.putResult(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryGroupImpl.class, auditEntryGroup.getPrimaryKey(),
            auditEntryGroup);

        auditEntryGroup.resetOriginalValues();
    }

    /**
     * Caches the Группа записей аудитаs in the entity cache if it is enabled.
     *
     * @param auditEntryGroups the Группа записей аудитаs
     */
    @Override
    public void cacheResult(List<AuditEntryGroup> auditEntryGroups) {
        for (AuditEntryGroup auditEntryGroup : auditEntryGroups) {
            if (EntityCacheUtil.getResult(
                        AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
                        AuditEntryGroupImpl.class,
                        auditEntryGroup.getPrimaryKey()) == null) {
                cacheResult(auditEntryGroup);
            } else {
                auditEntryGroup.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all Группа записей аудитаs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AuditEntryGroupImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AuditEntryGroupImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the Группа записей аудита.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AuditEntryGroup auditEntryGroup) {
        EntityCacheUtil.removeResult(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryGroupImpl.class, auditEntryGroup.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AuditEntryGroup> auditEntryGroups) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AuditEntryGroup auditEntryGroup : auditEntryGroups) {
            EntityCacheUtil.removeResult(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
                AuditEntryGroupImpl.class, auditEntryGroup.getPrimaryKey());
        }
    }

    /**
     * Creates a new Группа записей аудита with the primary key. Does not add the Группа записей аудита to the database.
     *
     * @param entryGroupId the primary key for the new Группа записей аудита
     * @return the new Группа записей аудита
     */
    @Override
    public AuditEntryGroup create(int entryGroupId) {
        AuditEntryGroup auditEntryGroup = new AuditEntryGroupImpl();

        auditEntryGroup.setNew(true);
        auditEntryGroup.setPrimaryKey(entryGroupId);

        return auditEntryGroup;
    }

    /**
     * Removes the Группа записей аудита with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param entryGroupId the primary key of the Группа записей аудита
     * @return the Группа записей аудита that was removed
     * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntryGroup remove(int entryGroupId)
        throws NoSuchAuditEntryGroupException, SystemException {
        return remove((Serializable) entryGroupId);
    }

    /**
     * Removes the Группа записей аудита with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the Группа записей аудита
     * @return the Группа записей аудита that was removed
     * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntryGroup remove(Serializable primaryKey)
        throws NoSuchAuditEntryGroupException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AuditEntryGroup auditEntryGroup = (AuditEntryGroup) session.get(AuditEntryGroupImpl.class,
                    primaryKey);

            if (auditEntryGroup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAuditEntryGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(auditEntryGroup);
        } catch (NoSuchAuditEntryGroupException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AuditEntryGroup removeImpl(AuditEntryGroup auditEntryGroup)
        throws SystemException {
        auditEntryGroup = toUnwrappedModel(auditEntryGroup);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(auditEntryGroup)) {
                auditEntryGroup = (AuditEntryGroup) session.get(AuditEntryGroupImpl.class,
                        auditEntryGroup.getPrimaryKeyObj());
            }

            if (auditEntryGroup != null) {
                session.delete(auditEntryGroup);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (auditEntryGroup != null) {
            clearCache(auditEntryGroup);
        }

        return auditEntryGroup;
    }

    @Override
    public AuditEntryGroup updateImpl(
        ru.akimov.model.AuditEntryGroup auditEntryGroup)
        throws SystemException {
        auditEntryGroup = toUnwrappedModel(auditEntryGroup);

        boolean isNew = auditEntryGroup.isNew();

        Session session = null;

        try {
            session = openSession();

            if (auditEntryGroup.isNew()) {
                session.save(auditEntryGroup);

                auditEntryGroup.setNew(false);
            } else {
                session.merge(auditEntryGroup);
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

        EntityCacheUtil.putResult(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryGroupImpl.class, auditEntryGroup.getPrimaryKey(),
            auditEntryGroup);

        return auditEntryGroup;
    }

    protected AuditEntryGroup toUnwrappedModel(AuditEntryGroup auditEntryGroup) {
        if (auditEntryGroup instanceof AuditEntryGroupImpl) {
            return auditEntryGroup;
        }

        AuditEntryGroupImpl auditEntryGroupImpl = new AuditEntryGroupImpl();

        auditEntryGroupImpl.setNew(auditEntryGroup.isNew());
        auditEntryGroupImpl.setPrimaryKey(auditEntryGroup.getPrimaryKey());

        auditEntryGroupImpl.setEntryGroupId(auditEntryGroup.getEntryGroupId());
        auditEntryGroupImpl.setCompanyId(auditEntryGroup.getCompanyId());
        auditEntryGroupImpl.setUserId(auditEntryGroup.getUserId());
        auditEntryGroupImpl.setUserName(auditEntryGroup.getUserName());
        auditEntryGroupImpl.setEventDate(auditEntryGroup.getEventDate());

        return auditEntryGroupImpl;
    }

    /**
     * Returns the Группа записей аудита with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the Группа записей аудита
     * @return the Группа записей аудита
     * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntryGroup findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAuditEntryGroupException, SystemException {
        AuditEntryGroup auditEntryGroup = fetchByPrimaryKey(primaryKey);

        if (auditEntryGroup == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAuditEntryGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return auditEntryGroup;
    }

    /**
     * Returns the Группа записей аудита with the primary key or throws a {@link ru.akimov.NoSuchAuditEntryGroupException} if it could not be found.
     *
     * @param entryGroupId the primary key of the Группа записей аудита
     * @return the Группа записей аудита
     * @throws ru.akimov.NoSuchAuditEntryGroupException if a Группа записей аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntryGroup findByPrimaryKey(int entryGroupId)
        throws NoSuchAuditEntryGroupException, SystemException {
        return findByPrimaryKey((Serializable) entryGroupId);
    }

    /**
     * Returns the Группа записей аудита with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the Группа записей аудита
     * @return the Группа записей аудита, or <code>null</code> if a Группа записей аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntryGroup fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AuditEntryGroup auditEntryGroup = (AuditEntryGroup) EntityCacheUtil.getResult(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
                AuditEntryGroupImpl.class, primaryKey);

        if (auditEntryGroup == _nullAuditEntryGroup) {
            return null;
        }

        if (auditEntryGroup == null) {
            Session session = null;

            try {
                session = openSession();

                auditEntryGroup = (AuditEntryGroup) session.get(AuditEntryGroupImpl.class,
                        primaryKey);

                if (auditEntryGroup != null) {
                    cacheResult(auditEntryGroup);
                } else {
                    EntityCacheUtil.putResult(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
                        AuditEntryGroupImpl.class, primaryKey,
                        _nullAuditEntryGroup);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AuditEntryGroupModelImpl.ENTITY_CACHE_ENABLED,
                    AuditEntryGroupImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return auditEntryGroup;
    }

    /**
     * Returns the Группа записей аудита with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param entryGroupId the primary key of the Группа записей аудита
     * @return the Группа записей аудита, or <code>null</code> if a Группа записей аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntryGroup fetchByPrimaryKey(int entryGroupId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) entryGroupId);
    }

    /**
     * Returns all the Группа записей аудитаs.
     *
     * @return the Группа записей аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntryGroup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the Группа записей аудитаs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of Группа записей аудитаs
     * @param end the upper bound of the range of Группа записей аудитаs (not inclusive)
     * @return the range of Группа записей аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntryGroup> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the Группа записей аудитаs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of Группа записей аудитаs
     * @param end the upper bound of the range of Группа записей аудитаs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of Группа записей аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntryGroup> findAll(int start, int end,
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

        List<AuditEntryGroup> list = (List<AuditEntryGroup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AUDITENTRYGROUP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AUDITENTRYGROUP;

                if (pagination) {
                    sql = sql.concat(AuditEntryGroupModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AuditEntryGroup>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AuditEntryGroup>(list);
                } else {
                    list = (List<AuditEntryGroup>) QueryUtil.list(q,
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
     * Removes all the Группа записей аудитаs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AuditEntryGroup auditEntryGroup : findAll()) {
            remove(auditEntryGroup);
        }
    }

    /**
     * Returns the number of Группа записей аудитаs.
     *
     * @return the number of Группа записей аудитаs
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

                Query q = session.createQuery(_SQL_COUNT_AUDITENTRYGROUP);

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
     * Initializes the Группа записей аудита persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.akimov.model.AuditEntryGroup")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AuditEntryGroup>> listenersList = new ArrayList<ModelListener<AuditEntryGroup>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AuditEntryGroup>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AuditEntryGroupImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
