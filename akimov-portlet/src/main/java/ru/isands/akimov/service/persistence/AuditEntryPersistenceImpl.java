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

import ru.isands.akimov.NoSuchAuditEntryException;
import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.model.impl.AuditEntryImpl;
import ru.isands.akimov.model.impl.AuditEntryModelImpl;
import ru.isands.akimov.service.persistence.AuditEntryPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the audit entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryPersistence
 * @see AuditEntryUtil
 * @generated
 */
public class AuditEntryPersistenceImpl extends BasePersistenceImpl<AuditEntry>
    implements AuditEntryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AuditEntryUtil} to access the audit entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AuditEntryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryModelImpl.FINDER_CACHE_ENABLED, AuditEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryModelImpl.FINDER_CACHE_ENABLED, AuditEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_AUDITENTRY = "SELECT auditEntry FROM AuditEntry auditEntry";
    private static final String _SQL_COUNT_AUDITENTRY = "SELECT COUNT(auditEntry) FROM AuditEntry auditEntry";
    private static final String _ORDER_BY_ENTITY_ALIAS = "auditEntry.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuditEntry exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AuditEntryPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static AuditEntry _nullAuditEntry = new AuditEntryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AuditEntry> toCacheModel() {
                return _nullAuditEntryCacheModel;
            }
        };

    private static CacheModel<AuditEntry> _nullAuditEntryCacheModel = new CacheModel<AuditEntry>() {
            @Override
            public AuditEntry toEntityModel() {
                return _nullAuditEntry;
            }
        };

    public AuditEntryPersistenceImpl() {
        setModelClass(AuditEntry.class);
    }

    /**
     * Caches the audit entry in the entity cache if it is enabled.
     *
     * @param auditEntry the audit entry
     */
    @Override
    public void cacheResult(AuditEntry auditEntry) {
        EntityCacheUtil.putResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryImpl.class, auditEntry.getPrimaryKey(), auditEntry);

        auditEntry.resetOriginalValues();
    }

    /**
     * Caches the audit entries in the entity cache if it is enabled.
     *
     * @param auditEntries the audit entries
     */
    @Override
    public void cacheResult(List<AuditEntry> auditEntries) {
        for (AuditEntry auditEntry : auditEntries) {
            if (EntityCacheUtil.getResult(
                        AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
                        AuditEntryImpl.class, auditEntry.getPrimaryKey()) == null) {
                cacheResult(auditEntry);
            } else {
                auditEntry.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all audit entries.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AuditEntryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AuditEntryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the audit entry.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AuditEntry auditEntry) {
        EntityCacheUtil.removeResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryImpl.class, auditEntry.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AuditEntry> auditEntries) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AuditEntry auditEntry : auditEntries) {
            EntityCacheUtil.removeResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
                AuditEntryImpl.class, auditEntry.getPrimaryKey());
        }
    }

    /**
     * Creates a new audit entry with the primary key. Does not add the audit entry to the database.
     *
     * @param id the primary key for the new audit entry
     * @return the new audit entry
     */
    @Override
    public AuditEntry create(int id) {
        AuditEntry auditEntry = new AuditEntryImpl();

        auditEntry.setNew(true);
        auditEntry.setPrimaryKey(id);

        return auditEntry;
    }

    /**
     * Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the audit entry
     * @return the audit entry that was removed
     * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry remove(int id)
        throws NoSuchAuditEntryException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the audit entry
     * @return the audit entry that was removed
     * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry remove(Serializable primaryKey)
        throws NoSuchAuditEntryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AuditEntry auditEntry = (AuditEntry) session.get(AuditEntryImpl.class,
                    primaryKey);

            if (auditEntry == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAuditEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(auditEntry);
        } catch (NoSuchAuditEntryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AuditEntry removeImpl(AuditEntry auditEntry)
        throws SystemException {
        auditEntry = toUnwrappedModel(auditEntry);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(auditEntry)) {
                auditEntry = (AuditEntry) session.get(AuditEntryImpl.class,
                        auditEntry.getPrimaryKeyObj());
            }

            if (auditEntry != null) {
                session.delete(auditEntry);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (auditEntry != null) {
            clearCache(auditEntry);
        }

        return auditEntry;
    }

    @Override
    public AuditEntry updateImpl(ru.isands.akimov.model.AuditEntry auditEntry)
        throws SystemException {
        auditEntry = toUnwrappedModel(auditEntry);

        boolean isNew = auditEntry.isNew();

        Session session = null;

        try {
            session = openSession();

            if (auditEntry.isNew()) {
                session.save(auditEntry);

                auditEntry.setNew(false);
            } else {
                session.merge(auditEntry);
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

        EntityCacheUtil.putResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryImpl.class, auditEntry.getPrimaryKey(), auditEntry);

        return auditEntry;
    }

    protected AuditEntry toUnwrappedModel(AuditEntry auditEntry) {
        if (auditEntry instanceof AuditEntryImpl) {
            return auditEntry;
        }

        AuditEntryImpl auditEntryImpl = new AuditEntryImpl();

        auditEntryImpl.setNew(auditEntry.isNew());
        auditEntryImpl.setPrimaryKey(auditEntry.getPrimaryKey());

        auditEntryImpl.setId(auditEntry.getId());
        auditEntryImpl.setEntityId(auditEntry.getEntityId());
        auditEntryImpl.setEntityType(auditEntry.getEntityType());
        auditEntryImpl.setUserId(auditEntry.getUserId());
        auditEntryImpl.setDescription(auditEntry.getDescription());
        auditEntryImpl.setDateOfChange(auditEntry.getDateOfChange());

        return auditEntryImpl;
    }

    /**
     * Returns the audit entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the audit entry
     * @return the audit entry
     * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAuditEntryException, SystemException {
        AuditEntry auditEntry = fetchByPrimaryKey(primaryKey);

        if (auditEntry == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAuditEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return auditEntry;
    }

    /**
     * Returns the audit entry with the primary key or throws a {@link ru.isands.akimov.NoSuchAuditEntryException} if it could not be found.
     *
     * @param id the primary key of the audit entry
     * @return the audit entry
     * @throws ru.isands.akimov.NoSuchAuditEntryException if a audit entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry findByPrimaryKey(int id)
        throws NoSuchAuditEntryException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the audit entry with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the audit entry
     * @return the audit entry, or <code>null</code> if a audit entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AuditEntry auditEntry = (AuditEntry) EntityCacheUtil.getResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
                AuditEntryImpl.class, primaryKey);

        if (auditEntry == _nullAuditEntry) {
            return null;
        }

        if (auditEntry == null) {
            Session session = null;

            try {
                session = openSession();

                auditEntry = (AuditEntry) session.get(AuditEntryImpl.class,
                        primaryKey);

                if (auditEntry != null) {
                    cacheResult(auditEntry);
                } else {
                    EntityCacheUtil.putResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
                        AuditEntryImpl.class, primaryKey, _nullAuditEntry);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
                    AuditEntryImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return auditEntry;
    }

    /**
     * Returns the audit entry with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the audit entry
     * @return the audit entry, or <code>null</code> if a audit entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry fetchByPrimaryKey(int id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the audit entries.
     *
     * @return the audit entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the audit entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of audit entries
     * @param end the upper bound of the range of audit entries (not inclusive)
     * @return the range of audit entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the audit entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.isands.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of audit entries
     * @param end the upper bound of the range of audit entries (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of audit entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findAll(int start, int end,
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

        List<AuditEntry> list = (List<AuditEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AUDITENTRY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AUDITENTRY;

                if (pagination) {
                    sql = sql.concat(AuditEntryModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AuditEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AuditEntry>(list);
                } else {
                    list = (List<AuditEntry>) QueryUtil.list(q, getDialect(),
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
     * Removes all the audit entries from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AuditEntry auditEntry : findAll()) {
            remove(auditEntry);
        }
    }

    /**
     * Returns the number of audit entries.
     *
     * @return the number of audit entries
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

                Query q = session.createQuery(_SQL_COUNT_AUDITENTRY);

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
     * Initializes the audit entry persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.isands.akimov.model.AuditEntry")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AuditEntry>> listenersList = new ArrayList<ModelListener<AuditEntry>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AuditEntry>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AuditEntryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
