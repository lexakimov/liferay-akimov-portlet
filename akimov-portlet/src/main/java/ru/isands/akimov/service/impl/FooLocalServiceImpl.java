package ru.isands.akimov.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.base.FooLocalServiceBaseImpl;

public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {

	@Override
	public Foo addFoo(Foo foo) throws SystemException {

		Foo foo1 = super.addFoo(foo);

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();

		try {
			resourceLocalService.addResources(
					companyId, groupId, userId, Foo.class.getName(), foo.getFooId(),
					false, true, true);

		} catch (PortalException e) {
			throw new SystemException(e);
		}

		return foo1;
	}
}
