package ru.akimov.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author akimov
 * created at 18.01.20 22:44
 *
 * зачем этот класс?
 */
public class AkimovModelPermission {

	public static final String RESOURCE_NAME = "ru.akimov.model";

	public static void check(PermissionChecker permissionChecker, long groupId, String actionId) throws PortalException {
		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {
		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId, actionId);
	}
}