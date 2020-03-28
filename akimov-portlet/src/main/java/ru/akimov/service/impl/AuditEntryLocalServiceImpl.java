package ru.akimov.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.EntityFieldChange;
import ru.akimov.service.base.AuditEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

public class AuditEntryLocalServiceImpl extends AuditEntryLocalServiceBaseImpl {

	@Override
	public AuditEntry addAuditEntry(AuditEntry auditEntry) throws SystemException {
		final Date dateOfChange = auditEntry.getDateOfChange();
		if (dateOfChange == null) {
			auditEntry.setDateOfChange(new Date());
		}
		return super.addAuditEntry(auditEntry);
	}

	@Override
	public AuditEntry updateAuditEntry(AuditEntry auditEntry) throws SystemException {
		final Date dateOfChange = auditEntry.getDateOfChange();
		if (dateOfChange == null) {
			auditEntry.setDateOfChange(new Date());
		}
		return super.updateAuditEntry(auditEntry);
	}

	@Override
	public AuditEntry deleteAuditEntry(int id) throws PortalException, SystemException {
		DynamicQuery dynamicQuery = entityFieldChangeLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("auditEntryId", id));
		List<EntityFieldChange> list = entityFieldChangeLocalService.dynamicQuery(dynamicQuery);
		for (EntityFieldChange efc : list) {
			entityFieldChangeLocalService.deleteEntityFieldChange(efc);
		}
		return super.deleteAuditEntry(id);
	}

	@Override
	public AuditEntry deleteAuditEntry(AuditEntry auditEntry) throws SystemException {
		DynamicQuery dynamicQuery = entityFieldChangeLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("auditEntryId", auditEntry.getAuditEntryId()));
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
	public void deleteFor(String entityType, int entityId) throws SystemException {
		DynamicQuery dynamicQuery = auditEntryLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityType", entityType.toLowerCase()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityId", entityId));
		List<AuditEntry> list = auditEntryLocalService.dynamicQuery(dynamicQuery);
		for (AuditEntry history : list) {
			auditEntryLocalService.deleteAuditEntry(history);
		}
	}

}
