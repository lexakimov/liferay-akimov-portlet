package ru.akimov.audit.description;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import ru.akimov.audit.description.impl.*;
import ru.akimov.audit.description.impl.*;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.model.AuditEntry;
import ru.akimov.utils.WebPageUtil;

import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;

/**
 * @author akimov
 * created at 25.01.20 18:06
 */
public class DescriptionManager {

	private static final Log log = LogFactoryUtil.getLog(DescriptionManager.class);

	private static final Map<AuditType, DescriptionAdapter> ADAPTER_MAP;

	static {
		ADAPTER_MAP = new HashMap<>();

		ADAPTER_MAP.put(AuditType.USER_LOGIN, new UserLoginActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.USER_LOGOUT, new UserLogoutActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.USER_REGISTRATION, new UserRegistrationActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.USER_REMOVE, new UserRemoveActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.USER_ROLE_GRANT, new UserRoleGrantActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.USER_ROLE_REMOVE, new UserRoleRemoveActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.USER_ORG_JOINED, new UserOrgJoinedActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.USER_ORG_LEFT, new UserOrgLeftActionDescriptionAdapter());

		ADAPTER_MAP.put(AuditType.FOO_CREATE, new FooCreateActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.FOO_EDIT, new FooEditActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.FOO_DELETE, new FooDeleteActionDescriptionAdapter());
		ADAPTER_MAP.put(AuditType.FOO_STATUS_CHANGE, new FooStatusChangeActionDescriptionAdapter());
	}

	public static DescriptionAdapter get(AuditType auditType) {
		return ADAPTER_MAP.get(auditType);
	}

	public static DescriptionAdapter get(String auditEntryType) {
		AuditType auditType = AuditType.valueOf(auditEntryType);
		return get(auditType);
	}

	public static String formDescription(AuditEntry auditEntry) {
		try {
			AuditType auditType = AuditType.valueOf(auditEntry.getAuditType());

			DescriptionAdapter adapter = get(auditType);
			if (adapter == null) {
				return WebPageUtil.setColor("[no adapter found] " + auditEntry.getAuditType(), "red");
			}
			return adapter.adapt(auditEntry);
		} catch (IllegalArgumentException e) {
			if (e instanceof IllegalFormatException) {
				log.error("Action type: " + auditEntry.getAuditType() + "; " + e.toString());
				log.error(e);
			} else {
				log.error("No enum constant AuditType for string '" + auditEntry.getAuditType() + "'");
			}
			return WebPageUtil.setColor("[error] " + auditEntry.getAuditType(), "red");
		}
	}

	/**
	 * 	private final String description;
	 *
	 * 	AuditType(String description) {
	 * 		this.description = description;
	 *        }
	 *
	 * 	public String getDescription(User user) {
	 * 		try {
	 * 			return String.format(description, user != null ? user.getFullName() : "[пользователь не найден]");
	 *        } catch (MissingFormatArgumentException e) {
	 * 			return WebPageUtil.setColor(description, "red");
	 *        }
	 *    }
	 *
	 */

}
