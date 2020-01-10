package ru.isands.akimov.history;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import ru.isands.akimov.history.enums.EntityType;
import ru.isands.akimov.model.EntityEditingHistory;
import ru.isands.akimov.model.EntityFieldChange;
import ru.isands.akimov.service.EntityEditingHistoryLocalServiceUtil;
import ru.isands.akimov.service.EntityFieldChangeLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntityEditingHistoryWrapper {

	private EntityEditingHistory editingHistoryEntry;

	private List<EntityFieldChange> fieldChanges;

	public EntityEditingHistoryWrapper(long entityId, EntityType entityType, long userId, Date dateOfChange)
			throws SystemException {

		int historyEntryId = (int) CounterLocalServiceUtil.increment(EntityEditingHistory.class.getName());

		editingHistoryEntry = EntityEditingHistoryLocalServiceUtil.createEntityEditingHistory(historyEntryId);
		editingHistoryEntry.setEntityId((int) entityId);
		editingHistoryEntry.setEntityType(entityType.toString());
		editingHistoryEntry.setUserId(userId);
		editingHistoryEntry.setDateOfChange(dateOfChange);

		fieldChanges = new ArrayList<>();
	}

	public void addFieldChange(String fieldName, Object oldValue, Object newValue) throws SystemException {
		int fieldChangeId = (int) CounterLocalServiceUtil.increment(EntityFieldChange.class.getName());

		EntityFieldChange fieldChange = EntityFieldChangeLocalServiceUtil.createEntityFieldChange(fieldChangeId);
		fieldChange.setHistoryId(editingHistoryEntry.getId());
		fieldChange.setFieldName(fieldName);
		fieldChange.setOldValue(oldValue != null ? oldValue.toString() : StringPool.BLANK);
		fieldChange.setNewValue(newValue != null ? newValue.toString() : StringPool.BLANK);

		fieldChanges.add(fieldChange);
	}

	public void persist() throws SystemException {
		for (EntityFieldChange fieldChange : fieldChanges) {
			fieldChange.persist();
		}
		editingHistoryEntry.persist();
	}
}
