package ru.isands.akimov.audit.listeners.impl;

import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.audit.comparators.ModelComparator;
import ru.isands.akimov.audit.comparators.impl.FooComparator;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.isands.akimov.audit.listeners.AuditModelListener;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

import java.util.HashSet;
import java.util.Set;

public class FooAuditListener extends AuditModelListener<Foo> {

	@Override
	protected EntityType getEntityType() {
		return EntityType.FOO;
	}

	@Override
	protected Foo fetchOldModel(int entityId) throws SystemException {
		return FooLocalServiceUtil.fetchFoo(entityId);
	}

	@Override
	protected ModelComparator<Foo> getModelComparator(Foo oldModel, Foo updatedModel) throws NoSuchModelAttributeException {
		return new FooComparator(oldModel, updatedModel);
	}

	@Override
	protected AuditType getDefaultCreateType() {
		return AuditType.FOO_CREATE;
	}

	@Override
	protected AuditType getDefaultEditType() {
		return AuditType.FOO_EDIT;
	}

	@Override
	protected AuditType getDefaultDeleteType() {
		return AuditType.FOO_DELETE;
	}

	@Override
	protected AuditType getSpecialAuditType(Set<String> changedFields, AuditType defaultType) {
		HashSet<Object> fields = new HashSet<>();
		fields.add("status");

		if (changedFields.equals(fields)) {
			return AuditType.FOO_STATUS_CHANGE;
		}

		return super.getSpecialAuditType(changedFields, defaultType);
	}
}

