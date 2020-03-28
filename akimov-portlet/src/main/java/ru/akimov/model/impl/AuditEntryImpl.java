package ru.akimov.model.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import ru.akimov.model.EntityFieldChange;
import ru.akimov.service.EntityFieldChangeLocalServiceUtil;
import ru.akimov.utils.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.akimov.utils.DateUtil.ISO_8601;

public class AuditEntryImpl extends AuditEntryBaseImpl {

	public List<EntityFieldChange> fieldChanges = new ArrayList<>();

	public AuditEntryImpl() {
	}

	/**
	 * Добавить к текущей записи аудита запись об изменении атрибута сущности.
	 *
	 * @param fieldName имя атрибута.
	 * @param oldValue  старое значение.
	 * @param newValue  новое значение.
	 * @throws SystemException
	 */
	public void addFieldChange(String fieldName, Object oldValue, Object newValue) throws SystemException {
		int fieldChangeId = (int) CounterLocalServiceUtil.increment(EntityFieldChange.class.getName());

		EntityFieldChange fieldChange = EntityFieldChangeLocalServiceUtil.createEntityFieldChange(fieldChangeId);
		fieldChange.setEntryId(this.getEntryId());
		fieldChange.setFieldName(fieldName);
		fieldChange.setOldValue(attributeToString(oldValue));
		fieldChange.setNewValue(attributeToString(newValue));

		fieldChanges.add(fieldChange);
	}

	/**
	 * format date attributes to ISO 8601 before storing it to database
	 *
	 * @param attrValue raw attribute value
	 * @return attribute value string, ready to store into database.
	 */
	private String attributeToString(Object attrValue) {
		String oldValueString = StringPool.BLANK;
		if (attrValue != null) {
			oldValueString = (attrValue instanceof Date)
					? DateUtil.showDate((Date) attrValue, ISO_8601)
					: attrValue.toString();
		}
		return oldValueString;
	}

	/**
	 * @return true если запись истории изменения имеет закрепленные за собой записи об изменениях атрибутов сущности.
	 */
	public boolean hasFieldChanges() {
		return !fieldChanges.isEmpty();
	}
}
