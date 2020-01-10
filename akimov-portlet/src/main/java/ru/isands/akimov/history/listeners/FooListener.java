package ru.isands.akimov.history.listeners;

import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.history.change_detectors.ChangeDetector;
import ru.isands.akimov.history.change_detectors.FooChangeDetector;
import ru.isands.akimov.history.enums.EntityType;
import ru.isands.akimov.history.exceptions.EntityFieldChangeDetectorException;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

public class FooListener extends ModelHistoryListener<Foo> {

	@Override
	public EntityType getEntityType() {
		return EntityType.FOO;
	}

	@Override
	public Foo fetchOldModel(long entityId) throws SystemException {
		return FooLocalServiceUtil.fetchFoo((int) entityId);
	}

	@Override
	public ChangeDetector<Foo> getChangeDetector(Foo oldModel, Foo updatedModel) throws EntityFieldChangeDetectorException {
		return new FooChangeDetector(oldModel, updatedModel);
	}

}

