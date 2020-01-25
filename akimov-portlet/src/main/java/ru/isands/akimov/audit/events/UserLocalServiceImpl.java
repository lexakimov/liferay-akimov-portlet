package ru.isands.akimov.audit.events;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceWrapper;
import ru.isands.akimov.audit.AuditEntryWrapper;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.audit.enums.EntityType;

import java.util.*;

/**
 * Перехват событий добавления/удаления ролей пользователя. Прописан в liferay-hook.xml.
 *
 * @author akimov
 * created at 25.01.20 15:07
 */
public class UserLocalServiceImpl extends UserLocalServiceWrapper {

	private static final Log log = LogFactoryUtil.getLog(UserLocalServiceImpl.class);

	public UserLocalServiceImpl(UserLocalService userLocalService) {
		super(userLocalService);
	}

	@Override
	public void addRoleUser(long roleId, long userId) throws SystemException {
		log.info("invoke");
		super.addRoleUser(roleId, userId);
	}

	@Override
	public void addRoleUser(long roleId, User user) throws SystemException {
		log.info("invoke");
		super.addRoleUser(roleId, user);
	}

	@Override
	public void addRoleUsers(long roleId, long[] userIds) throws PortalException, SystemException {
		log.info("invoke");
		super.addRoleUsers(roleId, userIds);
	}

	@Override
	public void addRoleUsers(long roleId, List<User> Users) throws PortalException, SystemException {
		log.info("invoke");
		super.addRoleUsers(roleId, Users);
	}

	@Override
	public void clearRoleUsers(long roleId) throws SystemException {
		log.info("invoke");
		super.clearRoleUsers(roleId);
	}

	@Override
	public void deleteRoleUser(long roleId, long userId) throws PortalException, SystemException {
		log.info("invoke");
		super.deleteRoleUser(roleId, userId);
	}

	@Override
	public void deleteRoleUser(long roleId, User user) throws PortalException, SystemException {
		log.info("invoke");
		super.deleteRoleUser(roleId, user);
	}

	@Override
	public void deleteRoleUsers(long roleId, long[] userIds) throws SystemException {
		log.info("invoke");
		super.deleteRoleUsers(roleId, userIds);
	}

	@Override
	public void deleteRoleUsers(long roleId, List<User> Users) throws SystemException {
		log.info("invoke");
		super.deleteRoleUsers(roleId, Users);
	}

	@Override
	public void setRoleUsers(long roleId, long[] userIds) throws PortalException, SystemException {
		log.info("invoke");
		super.setRoleUsers(roleId, userIds);
	}

	@Override
	public void addDefaultRoles(long userId) throws PortalException, SystemException {
		log.info("invoke");
		super.addDefaultRoles(userId);
	}

	@Override
	public void unsetRoleUsers(long roleId, List<User> users) throws PortalException, SystemException {
		log.info("invoke");
		super.unsetRoleUsers(roleId, users);
	}

	@Override
	public void unsetRoleUsers(long roleId, long[] userIds) throws PortalException, SystemException {
		log.info("invoke");
		super.unsetRoleUsers(roleId, userIds);
	}

	@Override
	public User updateUser(long userId, String oldPassword, String newPassword1, String newPassword2,
						   boolean passwordReset, String reminderQueryQuestion, String reminderQueryAnswer,
						   String screenName, String emailAddress, long facebookId, String openId, String languageId,
						   String timeZoneId, String greeting, String comments, String firstName, String middleName,
						   String lastName, int prefixId, int suffixId, boolean male, int birthdayMonth,
						   int birthdayDay, int birthdayYear, String smsSn, String aimSn, String facebookSn,
						   String icqSn, String jabberSn, String msnSn, String mySpaceSn, String skypeSn,
						   String twitterSn, String ymSn, String jobTitle, long[] groupIds, long[] organizationIds,
						   long[] roleIds, List<UserGroupRole> userGroupRoles, long[] userGroupIds,
						   ServiceContext serviceContext) throws PortalException, SystemException {

		log.trace("invoke");

		long[] roleIdsBefore = fetchUser(userId).getRoleIds();

		User userAfter = super.updateUser(userId, oldPassword, newPassword1, newPassword2, passwordReset,
				reminderQueryQuestion, reminderQueryAnswer, screenName, emailAddress, facebookId, openId, languageId,
				timeZoneId, greeting, comments, firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn, facebookSn, icqSn, jabberSn, msnSn, mySpaceSn,
				skypeSn, twitterSn, ymSn, jobTitle, groupIds, organizationIds, roleIds, userGroupRoles, userGroupIds,
				serviceContext);

		long[] roleIdsAfter = userAfter.getRoleIds();

		log.debug("roles: " + Arrays.toString(roleIdsBefore));
		log.debug("roles: " + Arrays.toString(roleIdsAfter));

		long initiatorUserId = PrincipalThreadLocal.getUserId();
		User initiator = UserLocalServiceUtil.fetchUser(initiatorUserId);
		long companyId = serviceContext.getCompanyId();
		Date dateOfChange = new Date();

		Set<Long> rolesBefore = new HashSet<>(toLongList(roleIdsBefore));
		Set<Long> rolesAfter = new HashSet<>(toLongList(roleIdsAfter));

		Set<Long> allRoles = new HashSet<>();
		allRoles.addAll(rolesBefore);
		allRoles.addAll(rolesAfter);

		for (Long roleId : allRoles) {
			if (!rolesBefore.contains(roleId) && rolesAfter.contains(roleId)) {
				new AuditEntryWrapper(
						(int) userId, EntityType.USER, AuditType.USER_ROLE_GRANT, companyId, initiator,
						dateOfChange).persist();

			} else if (rolesBefore.contains(roleId) && !rolesAfter.contains(roleId)) {
				new AuditEntryWrapper(
						(int) userId, EntityType.USER, AuditType.USER_ROLE_REMOVE, companyId, initiator,
						dateOfChange).persist();
			}
		}

		return userAfter;
	}

	private List<Long> toLongList(long[] argument) {
		List<Long> result = new ArrayList<>(argument.length);
		for (long temp : argument) {
			result.add(temp);
		}
		return result;
	}
}
