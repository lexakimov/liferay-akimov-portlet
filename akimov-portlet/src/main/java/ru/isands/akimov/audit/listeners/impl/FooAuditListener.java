package ru.isands.akimov.audit.listeners.impl;

import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.audit.comparators.impl.FooComparator;
import ru.isands.akimov.audit.comparators.ModelComparator;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.isands.akimov.audit.listeners.AuditModelListener;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

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
	protected ModelComparator<Foo> getChangeDetector(Foo oldModel, Foo updatedModel) throws NoSuchModelAttributeException {
		return new FooComparator(oldModel, updatedModel);
	}

	@Override
	protected AuditType getCreateType() {
		return AuditType.FOO_CREATE;
	}

	@Override
	protected AuditType getEditType() {
		return AuditType.FOO_EDIT;
	}

	@Override
	protected AuditType getDeleteType() {
		return AuditType.FOO_DELETE;
	}

}

