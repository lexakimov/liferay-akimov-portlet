package ru.akimov.audit.description.impl;

import com.liferay.portal.kernel.exception.PortalException;
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
 * created at 25.01.20 21:04
 */
public class FooStatusChangeActionDescriptionAdapter implements DescriptionAdapter {

	private static final String DESCRIPTION_PATTERN = "%s сменил статус Foo(%s) на %s";

	private Log log = LogFactoryUtil.getLog(FooStatusChangeActionDescriptionAdapter.class);

	@Override
	public String adapt(AuditEntry entry) {
		try {
			int fooId = entry.getEntityId();
			long userId = entry.getUserId();
			User user = UserLocalServiceUtil.fetchUser(userId);
			return String.format(DESCRIPTION_PATTERN, user.getFullName(), fooId, "some_status");
		} catch (SystemException | PortalException e) {
			log.error(e);
			return WebPageUtil.setColor(entry.getAuditType(), "red");
		}
	}
}
