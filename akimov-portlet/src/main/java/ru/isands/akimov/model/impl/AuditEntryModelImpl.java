package ru.isands.akimov.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.model.AuditEntryModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AuditEntry service. Represents a row in the &quot;akimov_audit_entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ru.isands.akimov.model.AuditEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryImpl
 * @see ru.isands.akimov.model.AuditEntry
 * @see ru.isands.akimov.model.AuditEntryModel
 * @generated
 */
public class AuditEntryModelImpl extends BaseModelImpl<AuditEntry>
    implements AuditEntryModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a audit entry model instance should use the {@link ru.isands.akimov.model.AuditEntry} interface instead.
     */
    public static final String TABLE_NAME = "akimov_audit_entry";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.INTEGER },
            { "entityId", Types.INTEGER },
            { "entityType", Types.VARCHAR },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "dateOfChange", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table akimov_audit_entry (id_ INTEGER not null primary key,entityId INTEGER,entityType VARCHAR(75) null,companyId LONG,userId LONG,userName VARCHAR(75) null,description VARCHAR(75) null,dateOfChange DATE null)";
    public static final String TABLE_SQL_DROP = "drop table akimov_audit_entry";
    public static final String ORDER_BY_JPQL = " ORDER BY auditEntry.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY akimov_audit_entry.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.ru.isands.akimov.model.AuditEntry"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.ru.isands.akimov.model.AuditEntry"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.ru.isands.akimov.model.AuditEntry"));
    private static ClassLoader _classLoader = AuditEntry.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            AuditEntry.class
        };
    private int _id;
    private int _entityId;
    private String _entityType;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private String _description;
    private Date _dateOfChange;
    private AuditEntry _escapedModel;

    public AuditEntryModelImpl() {
    }

    @Override
    public int getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
    }

    @Override
    public Class<?> getModelClass() {
        return AuditEntry.class;
    }

    @Override
    public String getModelClassName() {
        return AuditEntry.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("entityId", getEntityId());
        attributes.put("entityType", getEntityType());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("description", getDescription());
        attributes.put("dateOfChange", getDateOfChange());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer id = (Integer) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer entityId = (Integer) attributes.get("entityId");

        if (entityId != null) {
            setEntityId(entityId);
        }

        String entityType = (String) attributes.get("entityType");

        if (entityType != null) {
            setEntityType(entityType);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Date dateOfChange = (Date) attributes.get("dateOfChange");

        if (dateOfChange != null) {
            setDateOfChange(dateOfChange);
        }
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public void setId(int id) {
        _id = id;
    }

    @Override
    public int getEntityId() {
        return _entityId;
    }

    @Override
    public void setEntityId(int entityId) {
        _entityId = entityId;
    }

    @Override
    public String getEntityType() {
        if (_entityType == null) {
            return StringPool.BLANK;
        } else {
            return _entityType;
        }
    }

    @Override
    public void setEntityType(String entityType) {
        _entityType = entityType;
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @Override
    public Date getDateOfChange() {
        return _dateOfChange;
    }

    @Override
    public void setDateOfChange(Date dateOfChange) {
        _dateOfChange = dateOfChange;
    }

    @Override
    public AuditEntry toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (AuditEntry) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        AuditEntryImpl auditEntryImpl = new AuditEntryImpl();

        auditEntryImpl.setId(getId());
        auditEntryImpl.setEntityId(getEntityId());
        auditEntryImpl.setEntityType(getEntityType());
        auditEntryImpl.setCompanyId(getCompanyId());
        auditEntryImpl.setUserId(getUserId());
        auditEntryImpl.setUserName(getUserName());
        auditEntryImpl.setDescription(getDescription());
        auditEntryImpl.setDateOfChange(getDateOfChange());

        auditEntryImpl.resetOriginalValues();

        return auditEntryImpl;
    }

    @Override
    public int compareTo(AuditEntry auditEntry) {
        int primaryKey = auditEntry.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AuditEntry)) {
            return false;
        }

        AuditEntry auditEntry = (AuditEntry) obj;

        int primaryKey = auditEntry.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<AuditEntry> toCacheModel() {
        AuditEntryCacheModel auditEntryCacheModel = new AuditEntryCacheModel();

        auditEntryCacheModel.id = getId();

        auditEntryCacheModel.entityId = getEntityId();

        auditEntryCacheModel.entityType = getEntityType();

        String entityType = auditEntryCacheModel.entityType;

        if ((entityType != null) && (entityType.length() == 0)) {
            auditEntryCacheModel.entityType = null;
        }

        auditEntryCacheModel.companyId = getCompanyId();

        auditEntryCacheModel.userId = getUserId();

        auditEntryCacheModel.userName = getUserName();

        String userName = auditEntryCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            auditEntryCacheModel.userName = null;
        }

        auditEntryCacheModel.description = getDescription();

        String description = auditEntryCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            auditEntryCacheModel.description = null;
        }

        Date dateOfChange = getDateOfChange();

        if (dateOfChange != null) {
            auditEntryCacheModel.dateOfChange = dateOfChange.getTime();
        } else {
            auditEntryCacheModel.dateOfChange = Long.MIN_VALUE;
        }

        return auditEntryCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", entityId=");
        sb.append(getEntityId());
        sb.append(", entityType=");
        sb.append(getEntityType());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", dateOfChange=");
        sb.append(getDateOfChange());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("ru.isands.akimov.model.AuditEntry");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entityId</column-name><column-value><![CDATA[");
        sb.append(getEntityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entityType</column-name><column-value><![CDATA[");
        sb.append(getEntityType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateOfChange</column-name><column-value><![CDATA[");
        sb.append(getDateOfChange());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}