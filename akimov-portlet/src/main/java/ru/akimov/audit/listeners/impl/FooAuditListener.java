package ru.akimov.audit.listeners.impl;

import com.liferay.portal.kernel.exception.SystemException;
import ru.akimov.audit.comparators.ModelComparator;
import ru.akimov.audit.comparators.impl.FooComparator;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.audit.listeners.AuditModelListener;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.akimov.model.Foo;
import ru.akimov.service.FooLocalServiceUtil;

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

