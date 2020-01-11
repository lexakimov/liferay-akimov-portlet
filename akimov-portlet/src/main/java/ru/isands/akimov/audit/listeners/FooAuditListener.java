package ru.isands.akimov.audit.listeners;

import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.audit.diff_finders.FooDifferenceFinder;
import ru.isands.akimov.audit.diff_finders.ModelDifferenceFinder;
import ru.isands.akimov.audit.enums.ActionType;
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
	ModelDifferenceFinder<Foo> getChangeDetector(Foo oldModel, Foo updatedModel) throws NoSuchModelAttributeException {
		return new FooDifferenceFinder(oldModel, updatedModel);
	}

	@Override
	ActionType getCreateType() {
		return ActionType.FOO_CREATE;
	}

	@Override
	ActionType getEditType() {
		return ActionType.FOO_EDIT;
	}

	@Override
	ActionType getDeleteType() {
		return ActionType.FOO_DELETE;
	}

}

