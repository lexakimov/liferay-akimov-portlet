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

import ru.akimov.NoSuchAttachmentFileException;

import ru.akimov.model.AttachmentFile;
import ru.akimov.model.impl.AttachmentFileImpl;
import ru.akimov.model.impl.AttachmentFileModelImpl;

import ru.akimov.service.persistence.AttachmentFilePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the Вложения service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentFilePersistence
 * @see AttachmentFileUtil
 * @generated
 */
public class AttachmentFilePersistenceImpl extends BasePersistenceImpl<AttachmentFile>
    implements AttachmentFilePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AttachmentFileUtil} to access the Вложения persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AttachmentFileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachmentFileModelImpl.FINDER_CACHE_ENABLED,
            AttachmentFileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachmentFileModelImpl.FINDER_CACHE_ENABLED,
            AttachmentFileImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachmentFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ATTACHMENTFILE = "SELECT attachmentFile FROM AttachmentFile attachmentFile";
    private static final String _SQL_COUNT_ATTACHMENTFILE = "SELECT COUNT(attachmentFile) FROM AttachmentFile attachmentFile";
    private static final String _ORDER_BY_ENTITY_ALIAS = "attachmentFile.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AttachmentFile exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AttachmentFilePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "size", "data"
            });
    private static AttachmentFile _nullAttachmentFile = new AttachmentFileImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AttachmentFile> toCacheModel() {
                return _nullAttachmentFileCacheModel;
            }
        };

    private static CacheModel<AttachmentFile> _nullAttachmentFileCacheModel = new CacheModel<AttachmentFile>() {
            @Override
            public AttachmentFile toEntityModel() {
                return _nullAttachmentFile;
            }
        };

    public AttachmentFilePersistenceImpl() {
        setModelClass(AttachmentFile.class);
    }

    /**
     * Caches the Вложения in the entity cache if it is enabled.
     *
     * @param attachmentFile the Вложения
     */
    @Override
    public void cacheResult(AttachmentFile attachmentFile) {
        EntityCacheUtil.putResult(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachmentFileImpl.class, attachmentFile.getPrimaryKey(),
            attachmentFile);

        attachmentFile.resetOriginalValues();
    }

    /**
     * Caches the Вложенияs in the entity cache if it is enabled.
     *
     * @param attachmentFiles the Вложенияs
     */
    @Override
    public void cacheResult(List<AttachmentFile> attachmentFiles) {
        for (AttachmentFile attachmentFile : attachmentFiles) {
            if (EntityCacheUtil.getResult(
                        AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
                        AttachmentFileImpl.class, attachmentFile.getPrimaryKey()) == null) {
                cacheResult(attachmentFile);
            } else {
                attachmentFile.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all Вложенияs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AttachmentFileImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AttachmentFileImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the Вложения.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AttachmentFile attachmentFile) {
        EntityCacheUtil.removeResult(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachmentFileImpl.class, attachmentFile.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AttachmentFile> attachmentFiles) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AttachmentFile attachmentFile : attachmentFiles) {
            EntityCacheUtil.removeResult(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
                AttachmentFileImpl.class, attachmentFile.getPrimaryKey());
        }
    }

    /**
     * Creates a new Вложения with the primary key. Does not add the Вложения to the database.
     *
     * @param id the primary key for the new Вложения
     * @return the new Вложения
     */
    @Override
    public AttachmentFile create(int id) {
        AttachmentFile attachmentFile = new AttachmentFileImpl();

        attachmentFile.setNew(true);
        attachmentFile.setPrimaryKey(id);

        return attachmentFile;
    }

    /**
     * Removes the Вложения with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the Вложения
     * @return the Вложения that was removed
     * @throws ru.akimov.NoSuchAttachmentFileException if a Вложения with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AttachmentFile remove(int id)
        throws NoSuchAttachmentFileException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the Вложения with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the Вложения
     * @return the Вложения that was removed
     * @throws ru.akimov.NoSuchAttachmentFileException if a Вложения with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AttachmentFile remove(Serializable primaryKey)
        throws NoSuchAttachmentFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AttachmentFile attachmentFile = (AttachmentFile) session.get(AttachmentFileImpl.class,
                    primaryKey);

            if (attachmentFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAttachmentFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(attachmentFile);
        } catch (NoSuchAttachmentFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AttachmentFile removeImpl(AttachmentFile attachmentFile)
        throws SystemException {
        attachmentFile = toUnwrappedModel(attachmentFile);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(attachmentFile)) {
                attachmentFile = (AttachmentFile) session.get(AttachmentFileImpl.class,
                        attachmentFile.getPrimaryKeyObj());
            }

            if (attachmentFile != null) {
                session.delete(attachmentFile);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (attachmentFile != null) {
            clearCache(attachmentFile);
        }

        return attachmentFile;
    }

    @Override
    public AttachmentFile updateImpl(
        ru.akimov.model.AttachmentFile attachmentFile)
        throws SystemException {
        attachmentFile = toUnwrappedModel(attachmentFile);

        boolean isNew = attachmentFile.isNew();

        Session session = null;

        try {
            session = openSession();

            if (attachmentFile.isNew()) {
                session.save(attachmentFile);

                attachmentFile.setNew(false);
            } else {
                session.evict(attachmentFile);
                session.saveOrUpdate(attachmentFile);
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

        EntityCacheUtil.putResult(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachmentFileImpl.class, attachmentFile.getPrimaryKey(),
            attachmentFile);

        attachmentFile.resetOriginalValues();

        return attachmentFile;
    }

    protected AttachmentFile toUnwrappedModel(AttachmentFile attachmentFile) {
        if (attachmentFile instanceof AttachmentFileImpl) {
            return attachmentFile;
        }

        AttachmentFileImpl attachmentFileImpl = new AttachmentFileImpl();

        attachmentFileImpl.setNew(attachmentFile.isNew());
        attachmentFileImpl.setPrimaryKey(attachmentFile.getPrimaryKey());

        attachmentFileImpl.setId(attachmentFile.getId());
        attachmentFileImpl.setFileName(attachmentFile.getFileName());
        attachmentFileImpl.setExtension(attachmentFile.getExtension());
        attachmentFileImpl.setSize(attachmentFile.getSize());
        attachmentFileImpl.setMimeType(attachmentFile.getMimeType());
        attachmentFileImpl.setData(attachmentFile.getData());
        attachmentFileImpl.setUploaded(attachmentFile.getUploaded());
        attachmentFileImpl.setUserId(attachmentFile.getUserId());

        return attachmentFileImpl;
    }

    /**
     * Returns the Вложения with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the Вложения
     * @return the Вложения
     * @throws ru.akimov.NoSuchAttachmentFileException if a Вложения with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AttachmentFile findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAttachmentFileException, SystemException {
        AttachmentFile attachmentFile = fetchByPrimaryKey(primaryKey);

        if (attachmentFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAttachmentFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return attachmentFile;
    }

    /**
     * Returns the Вложения with the primary key or throws a {@link ru.akimov.NoSuchAttachmentFileException} if it could not be found.
     *
     * @param id the primary key of the Вложения
     * @return the Вложения
     * @throws ru.akimov.NoSuchAttachmentFileException if a Вложения with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AttachmentFile findByPrimaryKey(int id)
        throws NoSuchAttachmentFileException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the Вложения with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the Вложения
     * @return the Вложения, or <code>null</code> if a Вложения with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AttachmentFile fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AttachmentFile attachmentFile = (AttachmentFile) EntityCacheUtil.getResult(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
                AttachmentFileImpl.class, primaryKey);

        if (attachmentFile == _nullAttachmentFile) {
            return null;
        }

        if (attachmentFile == null) {
            Session session = null;

            try {
                session = openSession();

                attachmentFile = (AttachmentFile) session.get(AttachmentFileImpl.class,
                        primaryKey);

                if (attachmentFile != null) {
                    cacheResult(attachmentFile);
                } else {
                    EntityCacheUtil.putResult(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
                        AttachmentFileImpl.class, primaryKey,
                        _nullAttachmentFile);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AttachmentFileModelImpl.ENTITY_CACHE_ENABLED,
                    AttachmentFileImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return attachmentFile;
    }

    /**
     * Returns the Вложения with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the Вложения
     * @return the Вложения, or <code>null</code> if a Вложения with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AttachmentFile fetchByPrimaryKey(int id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the Вложенияs.
     *
     * @return the Вложенияs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AttachmentFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the Вложенияs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of Вложенияs
     * @param end the upper bound of the range of Вложенияs (not inclusive)
     * @return the range of Вложенияs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AttachmentFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the Вложенияs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.akimov.model.impl.AttachmentFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of Вложенияs
     * @param end the upper bound of the range of Вложенияs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of Вложенияs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AttachmentFile> findAll(int start, int end,
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

        List<AttachmentFile> list = (List<AttachmentFile>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ATTACHMENTFILE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ATTACHMENTFILE;

                if (pagination) {
                    sql = sql.concat(AttachmentFileModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AttachmentFile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AttachmentFile>(list);
                } else {
                    list = (List<AttachmentFile>) QueryUtil.list(q,
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
     * Removes all the Вложенияs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AttachmentFile attachmentFile : findAll()) {
            remove(attachmentFile);
        }
    }

    /**
     * Returns the number of Вложенияs.
     *
     * @return the number of Вложенияs
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

                Query q = session.createQuery(_SQL_COUNT_ATTACHMENTFILE);

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
     * Initializes the Вложения persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ru.akimov.model.AttachmentFile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AttachmentFile>> listenersList = new ArrayList<ModelListener<AttachmentFile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AttachmentFile>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AttachmentFileImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
