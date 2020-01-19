package ru.isands.akimov.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletRequest;

/**
 * @author akimov
 * created at 18.01.20 19:42
 */
public final class ExpandoUtil {

	private static final Log _log = LogFactoryUtil.getLog(ExpandoUtil.class);

/*	public static String getOrgMunTypeField(PortletRequest request) throws SystemException, PortalException {
		User user = getUser(request);
		Organization organization = user.getOrganizations().get(0);
		return (String) organization.getExpandoBridge().getAttribute("MunType");
	}

	public static long getOrgMunIdField(PortletRequest request) throws SystemException, PortalException {
		return (long) getUser(request)
				.getOrganizations().get(0).getExpandoBridge().getAttribute("MunId");
		return (long) user
				.getOrganizations().get(0).getExpandoBridge().getAttribute("MunId");

	}

	public static long getUserMrMunIdField(long userId) throws SystemException, PortalException {
		return (long) user.getExpandoBridge().getAttribute("mrMunId");
	}

	private static User getUser(PortletRequest request) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return UserLocalServiceUtil.getUser(themeDisplay.getUserId());
	}

	private static boolean hasRoleNew(String role) throws PortalException, SystemException {
		ServiceContext context = ServiceContextThreadLocal.getServiceContext();
		if (!context.isSignedIn()) {
			return false;
		}
		long userId = context.getUserId();
		long groupId = context.getScopeGroupId();
		return UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, groupId, role, true);
	}*/

	/**
	 * @deprecated use {@link #hasRoleNew(String)}
	 */
	public static boolean hasRole(long userId, PortletRequest request, String role)
			throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, themeDisplay.getSiteGroupId(), role, true);
	}


}
