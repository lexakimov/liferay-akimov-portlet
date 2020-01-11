package ru.isands.akimov.audit.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import ru.isands.akimov.audit.AuditEntryWrapper;
import ru.isands.akimov.audit.enums.ActionType;
import ru.isands.akimov.audit.enums.EntityType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class UserPostLogoutAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {
			handleEvent(request, response);
		} catch (Exception e) {
			throw new ActionException(e);
		}
	}

	private void handleEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long companyId = PortalUtil.getCompanyId(request);
		long userId = PortalUtil.getUserId(request);
		User user = PortalUtil.getUser(request);

		AuditEntryWrapper auditEntry =
				new AuditEntryWrapper((int) userId, EntityType.USER, ActionType.USER_LOGOUT.toString(), userId, new Date());

		auditEntry.persist();
	}

}