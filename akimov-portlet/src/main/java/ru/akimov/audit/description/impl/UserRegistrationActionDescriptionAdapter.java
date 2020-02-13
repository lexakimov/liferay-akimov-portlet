package ru.akimov.audit.description.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.akimov.audit.description.DescriptionAdapter;
import ru.akimov.utils.WebPageUtil;
import ru.akimov.model.AuditEntry;

/**
 * @author akimov
 * created at 25.01.20 18:10
 */
public class UserRegistrationActionDescriptionAdapter implements DescriptionAdapter {

	private static final String DESCRIPTION_PATTERN = "%s зарегистрировался в системе";

	private Log log = LogFactoryUtil.getLog(UserRegistrationActionDescriptionAdapter.class);

	@Override
	public String adapt(AuditEntry entry) {
		int userId = entry.getEntityId();
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (user == null) {
				return String.format(DESCRIPTION_PATTERN, entry.getEntityId());
			}
			return String.format(DESCRIPTION_PATTERN, user.getFullName());
		} catch (SystemException e) {
			log.error(e);
			return WebPageUtil.setColor(entry.getAuditType(), "red");
		}
	}

}
