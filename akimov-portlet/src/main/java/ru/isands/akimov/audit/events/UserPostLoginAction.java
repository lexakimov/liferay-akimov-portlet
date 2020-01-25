package ru.isands.akimov.audit.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import ru.isands.akimov.audit.AuditEntryWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static ru.isands.akimov.audit.enums.AuditType.USER_LOGIN;
import static ru.isands.akimov.audit.enums.EntityType.USER;

/**
 * Обработчик события при входе пользователя в систему. Прописан в resources/hook.properties.
 *
 * @author akimov
 * created at 11.01.20 20:59
 */
public class UserPostLoginAction extends Action {

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
		User user = PortalUtil.getUser(request);
		AuditEntryWrapper auditEntry =
				new AuditEntryWrapper((int) user.getUserId(), USER, USER_LOGIN, companyId, user, new Date());
		auditEntry.persist();
	}

}