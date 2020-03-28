package ru.akimov.service.persistence;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.akimov.NoSuchAuditEntryException;

import ru.akimov.model.AuditEntry;
import ru.akimov.model.impl.AuditEntryImpl;
import ru.akimov.model.impl.AuditEntryModelImpl;

import ru.akimov.service.persistence.AuditEntryPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Запись аудита service.
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
     * Never modify or reference this class directly. Always use {@link AuditEntryUtil} to access the Запись аудита persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
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
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTRYGROUPID =
        new FinderPath(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryModelImpl.FINDER_CACHE_ENABLED, AuditEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEntryGroupId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRYGROUPID =
        new FinderPath(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryModelImpl.FINDER_CACHE_ENABLED, AuditEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEntryGroupId",
            new String[] { Integer.class.getName() },
            AuditEntryModelImpl.ENTRYGROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ENTRYGROUPID = new FinderPath(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntryGroupId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_ENTRYGROUPID_ENTRYGROUPID_2 = "auditEntry.entryGroupId = ?";
    private static final String _SQL_SELECT_AUDITENTRY = "SELECT auditEntry FROM AuditEntry auditEntry";
    private static final String _SQL_SELECT_AUDITENTRY_WHERE = "SELECT auditEntry FROM AuditEntry auditEntry WHERE ";
    private static final String _SQL_COUNT_AUDITENTRY = "SELECT COUNT(auditEntry) FROM AuditEntry auditEntry";
    private static final String _SQL_COUNT_AUDITENTRY_WHERE = "SELECT COUNT(auditEntry) FROM AuditEntry auditEntry WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "auditEntry.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuditEntry exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AuditEntry exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AuditEntryPersistenceImpl.class);
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
     * Returns all the Запись аудитаs where entryGroupId = &#63;.
     *
     * @param entryGroupId the entry group ID
     * @return the matching Запись аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findByEntryGroupId(int entryGroupId)
        throws SystemException {
        return findByEntryGroupId(entryGroupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the Запись аудитаs where entryGroupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param entryGroupId the entry group ID
     * @param start the lower bound of the range of Запись аудитаs
     * @param end the upper bound of the range of Запись аудитаs (not inclusive)
     * @return the range of matching Запись аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findByEntryGroupId(int entryGroupId, int start,
        int end) throws SystemException {
        return findByEntryGroupId(entryGroupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the Запись аудитаs where entryGroupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param entryGroupId the entry group ID
     * @param start the lower bound of the range of Запись аудитаs
     * @param end the upper bound of the range of Запись аудитаs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching Запись аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findByEntryGroupId(int entryGroupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRYGROUPID;
            finderArgs = new Object[] { entryGroupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTRYGROUPID;
            finderArgs = new Object[] {
                    entryGroupId,
                    
                    start, end, orderByComparator
                };
        }

        List<AuditEntry> list = (List<AuditEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AuditEntry auditEntry : list) {
                if ((entryGroupId != auditEntry.getEntryGroupId())) {
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

            query.append(_SQL_SELECT_AUDITENTRY_WHERE);

            query.append(_FINDER_COLUMN_ENTRYGROUPID_ENTRYGROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(entryGroupId);

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
     * Returns the first Запись аудита in the ordered set where entryGroupId = &#63;.
     *
     * @param entryGroupId the entry group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching Запись аудита
     * @throws ru.akimov.NoSuchAuditEntryException if a matching Запись аудита could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry findByEntryGroupId_First(int entryGroupId,
        OrderByComparator orderByComparator)
        throws NoSuchAuditEntryException, SystemException {
        AuditEntry auditEntry = fetchByEntryGroupId_First(entryGroupId,
                orderByComparator);

        if (auditEntry != null) {
            return auditEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entryGroupId=");
        msg.append(entryGroupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAuditEntryException(msg.toString());
    }

    /**
     * Returns the first Запись аудита in the ordered set where entryGroupId = &#63;.
     *
     * @param entryGroupId the entry group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching Запись аудита, or <code>null</code> if a matching Запись аудита could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry fetchByEntryGroupId_First(int entryGroupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AuditEntry> list = findByEntryGroupId(entryGroupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last Запись аудита in the ordered set where entryGroupId = &#63;.
     *
     * @param entryGroupId the entry group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching Запись аудита
     * @throws ru.akimov.NoSuchAuditEntryException if a matching Запись аудита could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry findByEntryGroupId_Last(int entryGroupId,
        OrderByComparator orderByComparator)
        throws NoSuchAuditEntryException, SystemException {
        AuditEntry auditEntry = fetchByEntryGroupId_Last(entryGroupId,
                orderByComparator);

        if (auditEntry != null) {
            return auditEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entryGroupId=");
        msg.append(entryGroupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAuditEntryException(msg.toString());
    }

    /**
     * Returns the last Запись аудита in the ordered set where entryGroupId = &#63;.
     *
     * @param entryGroupId the entry group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching Запись аудита, or <code>null</code> if a matching Запись аудита could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry fetchByEntryGroupId_Last(int entryGroupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEntryGroupId(entryGroupId);

        if (count == 0) {
            return null;
        }

        List<AuditEntry> list = findByEntryGroupId(entryGroupId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the Запись аудитаs before and after the current Запись аудита in the ordered set where entryGroupId = &#63;.
     *
     * @param entryId the primary key of the current Запись аудита
     * @param entryGroupId the entry group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next Запись аудита
     * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry[] findByEntryGroupId_PrevAndNext(int entryId,
        int entryGroupId, OrderByComparator orderByComparator)
        throws NoSuchAuditEntryException, SystemException {
        AuditEntry auditEntry = findByPrimaryKey(entryId);

        Session session = null;

        try {
            session = openSession();

            AuditEntry[] array = new AuditEntryImpl[3];

            array[0] = getByEntryGroupId_PrevAndNext(session, auditEntry,
                    entryGroupId, orderByComparator, true);

            array[1] = auditEntry;

            array[2] = getByEntryGroupId_PrevAndNext(session, auditEntry,
                    entryGroupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AuditEntry getByEntryGroupId_PrevAndNext(Session session,
        AuditEntry auditEntry, int entryGroupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AUDITENTRY_WHERE);

        query.append(_FINDER_COLUMN_ENTRYGROUPID_ENTRYGROUPID_2);

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
            query.append(AuditEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(entryGroupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(auditEntry);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AuditEntry> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the Запись аудитаs where entryGroupId = &#63; from the database.
     *
     * @param entryGroupId the entry group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEntryGroupId(int entryGroupId)
        throws SystemException {
        for (AuditEntry auditEntry : findByEntryGroupId(entryGroupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(auditEntry);
        }
    }

    /**
     * Returns the number of Запись аудитаs where entryGroupId = &#63;.
     *
     * @param entryGroupId the entry group ID
     * @return the number of matching Запись аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEntryGroupId(int entryGroupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTRYGROUPID;

        Object[] finderArgs = new Object[] { entryGroupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AUDITENTRY_WHERE);

            query.append(_FINDER_COLUMN_ENTRYGROUPID_ENTRYGROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(entryGroupId);

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
     * Caches the Запись аудита in the entity cache if it is enabled.
     *
     * @param auditEntry the Запись аудита
     */
    @Override
    public void cacheResult(AuditEntry auditEntry) {
        EntityCacheUtil.putResult(AuditEntryModelImpl.ENTITY_CACHE_ENABLED,
            AuditEntryImpl.class, auditEntry.getPrimaryKey(), auditEntry);

        auditEntry.resetOriginalValues();
    }

    /**
     * Caches the Запись аудитаs in the entity cache if it is enabled.
     *
     * @param auditEntries the Запись аудитаs
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
     * Clears the cache for all Запись аудитаs.
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
     * Clears the cache for the Запись аудита.
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
     * Creates a new Запись аудита with the primary key. Does not add the Запись аудита to the database.
     *
     * @param entryId the primary key for the new Запись аудита
     * @return the new Запись аудита
     */
    @Override
    public AuditEntry create(int entryId) {
        AuditEntry auditEntry = new AuditEntryImpl();

        auditEntry.setNew(true);
        auditEntry.setPrimaryKey(entryId);

        return auditEntry;
    }

    /**
     * Removes the Запись аудита with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param entryId the primary key of the Запись аудита
     * @return the Запись аудита that was removed
     * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry remove(int entryId)
        throws NoSuchAuditEntryException, SystemException {
        return remove((Serializable) entryId);
    }

    /**
     * Removes the Запись аудита with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the Запись аудита
     * @return the Запись аудита that was removed
     * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
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
    public AuditEntry updateImpl(ru.akimov.model.AuditEntry auditEntry)
        throws SystemException {
        auditEntry = toUnwrappedModel(auditEntry);

        boolean isNew = auditEntry.isNew();

        AuditEntryModelImpl auditEntryModelImpl = (AuditEntryModelImpl) auditEntry;

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

        if (isNew || !AuditEntryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((auditEntryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRYGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        auditEntryModelImpl.getOriginalEntryGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRYGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRYGROUPID,
                    args);

                args = new Object[] { auditEntryModelImpl.getEntryGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRYGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRYGROUPID,
                    args);
            }
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

        auditEntryImpl.setEntryId(auditEntry.getEntryId());
        auditEntryImpl.setEntryGroupId(auditEntry.getEntryGroupId());
        auditEntryImpl.setAuditType(auditEntry.getAuditType());
        auditEntryImpl.setEntityType(auditEntry.getEntityType());
        auditEntryImpl.setEntityId(auditEntry.getEntityId());
        auditEntryImpl.setMetadata(auditEntry.getMetadata());

        return auditEntryImpl;
    }

    /**
     * Returns the Запись аудита with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the Запись аудита
     * @return the Запись аудита
     * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
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
     * Returns the Запись аудита with the primary key or throws a {@link ru.akimov.NoSuchAuditEntryException} if it could not be found.
     *
     * @param entryId the primary key of the Запись аудита
     * @return the Запись аудита
     * @throws ru.akimov.NoSuchAuditEntryException if a Запись аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry findByPrimaryKey(int entryId)
        throws NoSuchAuditEntryException, SystemException {
        return findByPrimaryKey((Serializable) entryId);
    }

    /**
     * Returns the Запись аудита with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the Запись аудита
     * @return the Запись аудита, or <code>null</code> if a Запись аудита with the primary key could not be found
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
     * Returns the Запись аудита with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param entryId the primary key of the Запись аудита
     * @return the Запись аудита, or <code>null</code> if a Запись аудита with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AuditEntry fetchByPrimaryKey(int entryId) throws SystemException {
        return fetchByPrimaryKey((Serializable) entryId);
    }

    /**
     * Returns all the Запись аудитаs.
     *
     * @return the Запись аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the Запись аудитаs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of Запись аудитаs
     * @param end the upper bound of the range of Запись аудитаs (not inclusive)
     * @return the range of Запись аудитаs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AuditEntry> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the Запись аудитаs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AuditEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of Запись аудитаs
     * @param end the upper bound of the range of Запись аудитаs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of Запись аудитаs
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
     * Removes all the Запись аудитаs from the database.
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
     * Returns the number of Запись аудитаs.
     *
     * @return the number of Запись аудитаs
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

    /**
     * Initializes the Запись аудита persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.akimov.model.AuditEntry")));

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
