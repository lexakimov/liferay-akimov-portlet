package ru.akimov.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import ru.akimov.model.EntityFieldChange;
import ru.akimov.service.base.EntityFieldChangeLocalServiceBaseImpl;

import java.util.List;

public class EntityFieldChangeLocalServiceImpl extends EntityFieldChangeLocalServiceBaseImpl {
	@Override
	public EntityFieldChange addEntityFieldChange(EntityFieldChange entityFieldChange) throws SystemException {
		checkParent(entityFieldChange);
		return super.addEntityFieldChange(entityFieldChange);
	}

	@Override
	public EntityFieldChange updateEntityFieldChange(EntityFieldChange entityFieldChange) throws SystemException {
		checkParent(entityFieldChange);
		return super.updateEntityFieldChange(entityFieldChange);
	}

	private void checkParent(EntityFieldChange entityFieldChange) throws SystemException {
		if (entityFieldChange.getEntryId() == 0) {
			final String msg = String.format(
					"audit field change %d not attached to any audit entry!",
					entityFieldChange.getFieldChangeId()
			);
			throw new SystemException(msg);
		}
	}

	public List<EntityFieldChange> getByEntryId(int entryId) throws SystemException {
		return entityFieldChangePersistence.findByEntryId(entryId);
	}
}
