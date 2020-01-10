package ru.isands.akimov.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.model.EntityEditingHistory;
import ru.isands.akimov.model.EntityFieldChange;
import ru.isands.akimov.service.base.EntityEditingHistoryLocalServiceBaseImpl;

import java.util.List;


public class EntityEditingHistoryLocalServiceImpl extends EntityEditingHistoryLocalServiceBaseImpl {

	/**
	 * Удалить записи истории для сущности.
	 *
	 * @param entityType тип сущности
	 * @param entityId   ключ
	 * @throws SystemException
	 */
	public void deleteFor(String entityType, int entityId) throws SystemException {
		DynamicQuery dynamicQuery = entityEditingHistoryLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityType", entityType));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("entityId", entityId));
		List<EntityEditingHistory> list = entityEditingHistoryLocalService.dynamicQuery(dynamicQuery);
		for (EntityEditingHistory history : list) {
			entityEditingHistoryLocalService.deleteEntityEditingHistory(history);
		}
	}

	@Override
	public EntityEditingHistory deleteEntityEditingHistory(int id) throws PortalException, SystemException {
		DynamicQuery dynamicQuery = entityFieldChangeLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("historyId", id));
		List<EntityFieldChange> list = entityFieldChangeLocalService.dynamicQuery(dynamicQuery);
		for (EntityFieldChange efc : list) {
			entityFieldChangeLocalService.deleteEntityFieldChange(efc);
		}

		return super.deleteEntityEditingHistory(id);
	}

	@Override
	public EntityEditingHistory deleteEntityEditingHistory(EntityEditingHistory entityEditingHistory) throws SystemException {
		DynamicQuery dynamicQuery = entityFieldChangeLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("historyId", entityEditingHistory.getId()));
		List<EntityFieldChange> list = entityFieldChangeLocalService.dynamicQuery(dynamicQuery);
		for (EntityFieldChange efc : list) {
			entityFieldChangeLocalService.deleteEntityFieldChange(efc);
		}

		return super.deleteEntityEditingHistory(entityEditingHistory);
	}
}
