package ru.isands.akimov.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EntityEditingHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityEditingHistory
 * @generated
 */
public class EntityEditingHistoryWrapper implements EntityEditingHistory,
    ModelWrapper<EntityEditingHistory> {
    private EntityEditingHistory _entityEditingHistory;

    public EntityEditingHistoryWrapper(
        EntityEditingHistory entityEditingHistory) {
        _entityEditingHistory = entityEditingHistory;
    }

    @Override
    public Class<?> getModelClass() {
        return EntityEditingHistory.class;
    }

    @Override
    public String getModelClassName() {
        return EntityEditingHistory.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("entityId", getEntityId());
        attributes.put("entityType", getEntityType());
        attributes.put("userId", getUserId());
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

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
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

    /**
    * Returns the primary key of this entity editing history.
    *
    * @return the primary key of this entity editing history
    */
    @Override
    public int getPrimaryKey() {
        return _entityEditingHistory.getPrimaryKey();
    }

    /**
    * Sets the primary key of this entity editing history.
    *
    * @param primaryKey the primary key of this entity editing history
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _entityEditingHistory.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this entity editing history.
    *
    * @return the ID of this entity editing history
    */
    @Override
    public int getId() {
        return _entityEditingHistory.getId();
    }

    /**
    * Sets the ID of this entity editing history.
    *
    * @param id the ID of this entity editing history
    */
    @Override
    public void setId(int id) {
        _entityEditingHistory.setId(id);
    }

    /**
    * Returns the entity ID of this entity editing history.
    *
    * @return the entity ID of this entity editing history
    */
    @Override
    public int getEntityId() {
        return _entityEditingHistory.getEntityId();
    }

    /**
    * Sets the entity ID of this entity editing history.
    *
    * @param entityId the entity ID of this entity editing history
    */
    @Override
    public void setEntityId(int entityId) {
        _entityEditingHistory.setEntityId(entityId);
    }

    /**
    * Returns the entity type of this entity editing history.
    *
    * @return the entity type of this entity editing history
    */
    @Override
    public java.lang.String getEntityType() {
        return _entityEditingHistory.getEntityType();
    }

    /**
    * Sets the entity type of this entity editing history.
    *
    * @param entityType the entity type of this entity editing history
    */
    @Override
    public void setEntityType(java.lang.String entityType) {
        _entityEditingHistory.setEntityType(entityType);
    }

    /**
    * Returns the user ID of this entity editing history.
    *
    * @return the user ID of this entity editing history
    */
    @Override
    public long getUserId() {
        return _entityEditingHistory.getUserId();
    }

    /**
    * Sets the user ID of this entity editing history.
    *
    * @param userId the user ID of this entity editing history
    */
    @Override
    public void setUserId(long userId) {
        _entityEditingHistory.setUserId(userId);
    }

    /**
    * Returns the user uuid of this entity editing history.
    *
    * @return the user uuid of this entity editing history
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entityEditingHistory.getUserUuid();
    }

    /**
    * Sets the user uuid of this entity editing history.
    *
    * @param userUuid the user uuid of this entity editing history
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _entityEditingHistory.setUserUuid(userUuid);
    }

    /**
    * Returns the description of this entity editing history.
    *
    * @return the description of this entity editing history
    */
    @Override
    public java.lang.String getDescription() {
        return _entityEditingHistory.getDescription();
    }

    /**
    * Sets the description of this entity editing history.
    *
    * @param description the description of this entity editing history
    */
    @Override
    public void setDescription(java.lang.String description) {
        _entityEditingHistory.setDescription(description);
    }

    /**
    * Returns the date of change of this entity editing history.
    *
    * @return the date of change of this entity editing history
    */
    @Override
    public java.util.Date getDateOfChange() {
        return _entityEditingHistory.getDateOfChange();
    }

    /**
    * Sets the date of change of this entity editing history.
    *
    * @param dateOfChange the date of change of this entity editing history
    */
    @Override
    public void setDateOfChange(java.util.Date dateOfChange) {
        _entityEditingHistory.setDateOfChange(dateOfChange);
    }

    @Override
    public boolean isNew() {
        return _entityEditingHistory.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _entityEditingHistory.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _entityEditingHistory.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _entityEditingHistory.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _entityEditingHistory.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _entityEditingHistory.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _entityEditingHistory.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _entityEditingHistory.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _entityEditingHistory.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _entityEditingHistory.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _entityEditingHistory.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EntityEditingHistoryWrapper((EntityEditingHistory) _entityEditingHistory.clone());
    }

    @Override
    public int compareTo(
        ru.isands.akimov.model.EntityEditingHistory entityEditingHistory) {
        return _entityEditingHistory.compareTo(entityEditingHistory);
    }

    @Override
    public int hashCode() {
        return _entityEditingHistory.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ru.isands.akimov.model.EntityEditingHistory> toCacheModel() {
        return _entityEditingHistory.toCacheModel();
    }

    @Override
    public ru.isands.akimov.model.EntityEditingHistory toEscapedModel() {
        return new EntityEditingHistoryWrapper(_entityEditingHistory.toEscapedModel());
    }

    @Override
    public ru.isands.akimov.model.EntityEditingHistory toUnescapedModel() {
        return new EntityEditingHistoryWrapper(_entityEditingHistory.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _entityEditingHistory.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _entityEditingHistory.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _entityEditingHistory.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityEditingHistoryWrapper)) {
            return false;
        }

        EntityEditingHistoryWrapper entityEditingHistoryWrapper = (EntityEditingHistoryWrapper) obj;

        if (Validator.equals(_entityEditingHistory,
                    entityEditingHistoryWrapper._entityEditingHistory)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public EntityEditingHistory getWrappedEntityEditingHistory() {
        return _entityEditingHistory;
    }

    @Override
    public EntityEditingHistory getWrappedModel() {
        return _entityEditingHistory;
    }

    @Override
    public void resetOriginalValues() {
        _entityEditingHistory.resetOriginalValues();
    }
}
