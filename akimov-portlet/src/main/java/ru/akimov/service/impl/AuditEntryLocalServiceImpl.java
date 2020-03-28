package ru.akimov.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.EntityFieldChange;
import ru.akimov.model.impl.AuditEntryImpl;
import ru.akimov.service.AuditEntryLocalServiceUtil;
import ru.akimov.service.base.AuditEntryLocalServiceBaseImpl;

import java.util.List;

public class AuditEntryLocalServiceImpl extends AuditEntryLocalServiceBaseImpl {

	private static final Log log = LogFactoryUtil.getLog(AuditEntryLocalServiceImpl.class);

	/**
	 * Создать новую запись аудита.
	 */
	public AuditEntry create(int entityId, String entityType, String auditType, String metadata) throws SystemException {
		int newEntryId = (int) CounterLocalServiceUtil.increment(AuditEntry.class.getName());
		AuditEntry auditEntry = AuditEntryLocalServiceUtil.createAuditEntry(newEntryId);

		auditEntry.setEntityId(entityId);
		auditEntry.setEntityType(entityType);
		auditEntry.setAuditType(auditType);
		auditEntry.setMetadata(metadata);

		return auditEntry;
	}

	@Override
	public AuditEntry addAuditEntry(AuditEntry auditEntry) throws SystemException {
		checkParent(auditEntry);
		List<EntityFieldChange> fieldChanges = ((AuditEntryImpl) auditEntry).fieldChanges;
		AuditEntry entry = super.addAuditEntry(auditEntry);
		persistFieldChanges(entry, fieldChanges);

		return entry;
	}

	@Override
	public AuditEntry updateAuditEntry(AuditEntry auditEntry) throws SystemException {
		checkParent(auditEntry);
		List<EntityFieldChange> fieldChanges = ((AuditEntryImpl) auditEntry).fieldChanges;
		AuditEntry entry = super.updateAuditEntry(auditEntry);
		persistFieldChanges(entry, fieldChanges);

		return entry;
	}

	private void checkParent(AuditEntry auditEntry) throws SystemException {
		if (auditEntry.getEntryGroupId() == 0) {
			throw new SystemException("audit entry " + auditEntry.getEntryId() + " not in any audit entry group!");
		}
	}

	private void persistFieldChanges(AuditEntry entry, List<EntityFieldChange> fieldChanges) throws SystemException {
		for (EntityFieldChange fieldChange : fieldChanges) {
			fieldChange.setEntryId(entry.getEntryId());
			fieldChange.persist();
		}

		logFinish(entry, fieldChanges);
	}

	private void logFinish(AuditEntry entry, List<EntityFieldChange> fieldChanges) {
		if (log.isDebugEnabled()) {
			int entryId = entry.getEntryId();
			int groupId = entry.getEntryGroupId();
			int entityId = entry.getEntityId();
			String entityType = entry.getEntityType();
			log.debug(String.format(
					"AUDIT: entry [%d] of group[%d] for entity %s(%d) with %d field changes persisted in database",
					entryId, groupId, entityType, entityId, fieldChanges.size()
			));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public AuditEntry deleteAuditEntry(int id) throws PortalException, SystemException {
		DynamicQuery dynamicQuery = entityFieldChangeLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entryId", id));
		List<EntityFieldChange> list = entityFieldChangeLocalService.dynamicQuery(dynamicQuery);
		for (EntityFieldChange efc : list) {
			entityFieldChangeLocalService.deleteEntityFieldChange(efc);
		}
		return super.deleteAuditEntry(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AuditEntry deleteAuditEntry(AuditEntry auditEntry) throws SystemException {
		DynamicQuery dynamicQuery = entityFieldChangeLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entryId", auditEntry.getEntryId()));
		List<EntityFieldChange> list = entityFieldChangeLocalService.dynamicQuery(dynamicQuery);
		for (EntityFieldChange efc : list) {
			entityFieldChangeLocalService.deleteEntityFieldChange(efc);
		}
		return super.deleteAuditEntry(auditEntry);
	}

	/**
	 * Удалить записи истории для сущности.
	 *
	 * @param entityType тип сущности (any case)
	 * @param entityId   ключ
	 * @throws SystemException
	 */
	@SuppressWarnings("unchecked")
	public void deleteFor(String entityType, int entityId) throws SystemException {
		DynamicQuery dynamicQuery = auditEntryLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityType", entityType.toLowerCase()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityId", entityId));
		List<AuditEntry> list = auditEntryLocalService.dynamicQuery(dynamicQuery);
		for (AuditEntry history : list) {
			auditEntryLocalService.deleteAuditEntry(history);
		}
	}

	public List<AuditEntry> getByEntryGroupId(int entryGroupId) throws SystemException {
		return auditEntryPersistence.findByEntryGroupId(entryGroupId);
	}

}
