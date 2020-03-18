package ru.akimov.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.*;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.permission.GroupPermissionUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author akimov
 * created at 18.01.20 21:33
 */
public class PermissionsTestPortlet extends MVCExtendedPortlet {

	private Log log = LogFactoryUtil.getLog(PermissionsTestPortlet.class);

	public void test(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			// RoleConstants.ADMINISTRATOR;
			// RoleConstants.SITE_OWNER;

			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			log.debug(serviceContext.getTimeZone());

			User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());

			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
			// PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();

			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			PermissionCacheUtil.clearCache(user.getUserId());

			try {
				GroupPermissionUtil.check(permissionChecker, 0L, ActionKeys.ASSIGN_MEMBERS);
			} catch (PrincipalException ignored) {
			}

		} catch (Exception e) {
			log.error(e);
		}

	}

}
