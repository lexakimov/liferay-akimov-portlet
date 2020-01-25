package ru.isands.akimov.audit.description.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.utils.WebPageUtil;

/**
 * @author akimov
 * created at 25.01.20 21:00
 */
public class UserRemoveActionDescriptionAdapter implements ru.isands.akimov.audit.description.DescriptionAdapter {

	private static final String DESCRIPTION_PATTERN = "%s удалён из системы";

	private Log log = LogFactoryUtil.getLog(UserRemoveActionDescriptionAdapter.class);

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
			return String.format(DESCRIPTION_PATTERN, WebPageUtil.setColor("[ошибка]", "red"));
		}
	}
}
