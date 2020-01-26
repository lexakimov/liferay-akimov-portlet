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
 * created at 25.01.20 21:04
 */
public class FooStatusChangeActionDescriptionAdapter implements ru.isands.akimov.audit.description.DescriptionAdapter {

	private static final String DESCRIPTION_PATTERN = "%s сменил статус Foo(%s) на %s";

	private Log log = LogFactoryUtil.getLog(FooStatusChangeActionDescriptionAdapter.class);

	@Override
	public String adapt(AuditEntry entry) {
		long userId = entry.getUserId();
		int fooId = entry.getEntityId();
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);
			return String.format(DESCRIPTION_PATTERN, user.getFullName(), fooId, "some_status");
		} catch (SystemException e) {
			log.error(e);
			return WebPageUtil.setColor(entry.getAuditType(), "red");
		}
	}
}
