package ru.isands.akimov.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.model.EntityFieldChange;
import ru.isands.akimov.service.base.AuditEntryLocalServiceBaseImpl;

import java.util.List;

public class AuditEntryLocalServiceImpl extends AuditEntryLocalServiceBaseImpl {

	/**
	 * Удалить записи истории для сущности.
	 *
	 * @param entityType тип сущности
	 * @param entityId   ключ
	 * @throws SystemException
	 */
	public void deleteFor(String entityType, int entityId) throws SystemException {
		DynamicQuery dynamicQuery = auditEntryLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityType", entityType));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityId", entityId));
		List<AuditEntry> list = auditEntryLocalService.dynamicQuery(dynamicQuery);
		for (AuditEntry history : list) {
			auditEntryLocalService.deleteAuditEntry(history);
		}
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
		dynamicQuery.add(RestrictionsFactoryUtil.eq("auditEntryId", auditEntry.getId()));
		List<EntityFieldChange> list = entityFieldChangeLocalService.dynamicQuery(dynamicQuery);
		for (EntityFieldChange efc : list) {
			entityFieldChangeLocalService.deleteEntityFieldChange(efc);
		}

		return super.deleteAuditEntry(auditEntry);
	}
}
