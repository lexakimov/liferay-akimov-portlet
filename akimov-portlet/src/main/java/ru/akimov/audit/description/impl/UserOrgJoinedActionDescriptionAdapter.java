package ru.akimov.audit.description.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.akimov.audit.description.DescriptionAdapter;
import ru.akimov.model.AuditEntry;

/**
 * @author akimov
 * created at 25.01.20 21:32
 */
public class UserOrgJoinedActionDescriptionAdapter implements DescriptionAdapter {

	private static final String DESCRIPTION_PATTERN = "%s зачислил %s в организацию %s";

	private Log log = LogFactoryUtil.getLog(UserLogoutActionDescriptionAdapter.class);

	@Override
	public String adapt(AuditEntry entry) {
		long userId = 0L;// TODO entry.getUserId();
		String userName = null;
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);
			/*userName = user != null ? user.getFullName() : entry.getUserName();*/
		} catch (SystemException e) {
			log.error(e);
		}
		if (userName == null) {
			userName = String.valueOf(userId);
		}

		int entityId = entry.getEntityId();
		String entryUserName = null;
		try {
			User user = UserLocalServiceUtil.fetchUser(entityId);
			entryUserName = user != null ? user.getFullName() : null;
		} catch (SystemException e) {
			log.error(e);
		}
		if (entryUserName == null) {
			entryUserName = String.valueOf(entityId);
		}

		return String.format(DESCRIPTION_PATTERN, userName, entryUserName, "org_123");
	}
}
