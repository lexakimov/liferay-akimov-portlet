package ru.isands.akimov.audit.listeners;

import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.audit.diff_finders.ModelDifferenceFinder;
import ru.isands.akimov.audit.diff_finders.FooDifferenceFinder;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.EntityFieldChangeDetectorException;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

public class FooAuditListener extends ModelAuditListener<Foo> {

	@Override
	public EntityType getEntityType() {
		return EntityType.FOO;
	}

	@Override
	public Foo fetchOldModel(int entityId) throws SystemException {
		return FooLocalServiceUtil.fetchFoo(entityId);
	}

	@Override
	public ModelDifferenceFinder<Foo> getChangeDetector(Foo oldModel, Foo updatedModel) throws EntityFieldChangeDetectorException {
		return new FooDifferenceFinder(oldModel, updatedModel);
	}

}

