package ru.akimov.audit.events;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.AuditEntryGroup;
import ru.akimov.service.AuditEntryGroupLocalServiceUtil;
import ru.akimov.service.AuditEntryLocalServiceUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

		long[] rolesBefore = fetchUser(userId).getRoleIds();
		long[] orgsBefore = fetchUser(userId).getOrganizationIds();

		User userAfter = super.updateUser(userId, oldPassword, newPassword1, newPassword2, passwordReset,
				reminderQueryQuestion, reminderQueryAnswer, screenName, emailAddress, facebookId, openId, languageId,
				timeZoneId, greeting, comments, firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn, facebookSn, icqSn, jabberSn, msnSn, mySpaceSn,
				skypeSn, twitterSn, ymSn, jobTitle, groupIds, organizationIds, roleIds, userGroupRoles, userGroupIds,
				serviceContext);

		long[] rolesAfter = userAfter.getRoleIds();
		long[] orgsAfter = userAfter.getOrganizationIds();

		log.debug("roles: " + Arrays.toString(rolesBefore));
		log.debug("roles: " + Arrays.toString(rolesAfter));

		log.debug("orgs: " + Arrays.toString(orgsBefore));
		log.debug("orgs: " + Arrays.toString(orgsAfter));

		AuditEntryGroup auditEntryGroup = AuditEntryGroupLocalServiceUtil.create();

		String auditTypeRoleGrant = String.valueOf(AuditType.USER_ROLE_GRANT);
		String auditTypeRoleRemove = String.valueOf(AuditType.USER_ROLE_REMOVE);
		processDifferences((int) userId, rolesBefore, rolesAfter, auditTypeRoleGrant, auditTypeRoleRemove, auditEntryGroup);

		String auditTypeOrgJoin = String.valueOf(AuditType.USER_ORG_JOINED);
		String auditTypeOrgLeft = String.valueOf(AuditType.USER_ORG_LEFT);
		processDifferences((int) userId, orgsBefore, orgsAfter, auditTypeOrgJoin, auditTypeOrgLeft, auditEntryGroup);

		if (auditEntryGroup.hasEntries()) {
			auditEntryGroup.persist();
		}

		return userAfter;
	}

	private void processDifferences(
			int userId,
			long[] idsBefore,
			long[] idsAfter,
			String additionType,
			String substractionType,
			AuditEntryGroup auditEntryGroup
	) throws SystemException {

		Set<Long> before = SetUtil.fromArray(idsBefore);
		Set<Long> after = SetUtil.fromArray(idsAfter);
		Set<Long> all = SetUtil.intersect(idsBefore, idsAfter);

		String metadata = StringPool.BLANK;
		String entityType = String.valueOf(EntityType.USER);

		for (Long id : all) {
			AuditEntry entry = null;
			if (!before.contains(id) && after.contains(id)) {
				entry = AuditEntryLocalServiceUtil.create(userId, entityType, additionType, metadata);
			} else if (before.contains(id) && !after.contains(id)) {
				entry = AuditEntryLocalServiceUtil.create(userId, entityType, substractionType, metadata);
			}
			if (entry != null) {
				auditEntryGroup.addEntry(entry);
			}
		}
	}

}
