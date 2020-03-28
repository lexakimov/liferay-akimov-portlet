package ru.akimov.audit.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.AuditEntryGroup;
import ru.akimov.service.AuditEntryGroupLocalServiceUtil;
import ru.akimov.service.AuditEntryLocalServiceUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		User user = PortalUtil.getUser(request);
		int userId = (int) user.getUserId();
		String metadata = StringPool.BLANK;

		String entityType = String.valueOf(EntityType.USER);
		String auditType = String.valueOf(AuditType.USER_LOGIN);

		AuditEntryGroup auditEntryGroup = AuditEntryGroupLocalServiceUtil.create();
		AuditEntry auditEntry = AuditEntryLocalServiceUtil.create(userId, entityType, auditType, metadata);
		auditEntryGroup.addEntry(auditEntry);
		auditEntryGroup.persist();
	}

}