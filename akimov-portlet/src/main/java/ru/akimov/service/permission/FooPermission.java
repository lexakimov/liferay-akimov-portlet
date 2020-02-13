package ru.akimov.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import ru.akimov.model.Foo;
import ru.akimov.service.FooLocalServiceUtil;

/**
 * @author akimov
 * created at 18.01.20 22:49
 */
public class FooPermission {

	public static void check(PermissionChecker permissionChecker, int fooId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, fooId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, int fooId, String actionId)
			throws PortalException, SystemException {

		long groupId = permissionChecker.getUser().getGroupId();
		Foo foo = FooLocalServiceUtil.getFoo(fooId);

		return permissionChecker.hasPermission(groupId, Foo.class.getName(), foo.getFooId(), actionId);
	}
}
