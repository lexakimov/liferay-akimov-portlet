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
public class FooEditActionDescriptionAdapter implements ru.isands.akimov.audit.description.DescriptionAdapter {

	private static final String DESCRIPTION_PATTERN = "%s изменил Foo(%s)";

	private Log log = LogFactoryUtil.getLog(FooEditActionDescriptionAdapter.class);

	@Override
	public String adapt(AuditEntry entry) {
		long userId = entry.getUserId();
		int fooId = entry.getEntityId();
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);
			return String.format(DESCRIPTION_PATTERN, user.getFullName(), fooId);
		} catch (SystemException e) {
			log.error(e);
			return WebPageUtil.setColor(entry.getAuditType(), "red");
		}
	}
}
