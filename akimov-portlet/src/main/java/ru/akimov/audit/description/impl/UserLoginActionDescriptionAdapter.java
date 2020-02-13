package ru.akimov.audit.description.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.akimov.audit.description.DescriptionAdapter;
import ru.akimov.model.AuditEntry;
import ru.akimov.utils.WebPageUtil;

/**
 * @author akimov
 * created at 25.01.20 18:10
 */
public class UserLoginActionDescriptionAdapter implements DescriptionAdapter {

	private static final String DESCRIPTION_PATTERN = "%s вошёл в систему";

	private Log log = LogFactoryUtil.getLog(UserLoginActionDescriptionAdapter.class);

	@Override
	public String adapt(AuditEntry entry) {
		int userId = entry.getEntityId();
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (user == null) {
				return String.format(DESCRIPTION_PATTERN, entry.getUserName());
			}
			return String.format(DESCRIPTION_PATTERN, user.getFullName());
		} catch (SystemException e) {
			log.error(e);
			return WebPageUtil.setColor(entry.getAuditType(), "red");
		}
	}

}
