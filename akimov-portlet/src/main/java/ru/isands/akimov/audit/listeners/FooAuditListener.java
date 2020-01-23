package ru.isands.akimov.audit.listeners;

import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.audit.comparators.FooComparator;
import ru.isands.akimov.audit.comparators.ModelComparator;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.NoSuchModelAttributeException;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

public class FooAuditListener extends ModelAuditListener<Foo> {

	@Override
	EntityType getEntityType() {
		return EntityType.FOO;
	}

	@Override
	Foo fetchOldModel(int entityId) throws SystemException {
		return FooLocalServiceUtil.fetchFoo(entityId);
	}

	@Override
	ModelComparator<Foo> getChangeDetector(Foo oldModel, Foo updatedModel) throws NoSuchModelAttributeException {
		return new FooComparator(oldModel, updatedModel);
	}

	@Override
	AuditType getCreateType() {
		return AuditType.FOO_CREATE;
	}

	@Override
	AuditType getEditType() {
		return AuditType.FOO_EDIT;
	}

	@Override
	AuditType getDeleteType() {
		return AuditType.FOO_DELETE;
	}

}

