package ru.isands.akimov.audit.description_adapters;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import ru.isands.akimov.audit.description_adapters.impl.UserLoginActionDescriptionAdapter;
import ru.isands.akimov.audit.description_adapters.impl.UserLogoutActionDescriptionAdapter;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.utils.WebPageUtil;

import java.util.HashMap;
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

			return get(auditType).adapt(auditEntry);
		} catch (NullPointerException e) {
			return WebPageUtil.setColor("[no adapter found] " + auditEntry.getAuditType(), "red");
		} catch (IllegalArgumentException e) {
			log.error("No enum constant AuditType for string '" + auditEntry.getAuditType() + "'");
			return WebPageUtil.setColor("[error] " + auditEntry.getAuditType(), "red");
		}
	}
	/**
	 *,
	 *
	 * 	USER_REGISTRATION("%s зарегистрировался в системе"),
	 * 	USER_REMOVE("%s удалён из системы"),
	 *
	 * 	USER_ROLE_GRANT("%s выдал %s роль %s"),
	 * 	USER_ROLE_REMOVE("%s забрал у %s роль %s"),
	 *
	 * 	USER_ORG_JOINED("Пользователь %s зачислен в организацию %s"),
	 * 	USER_ORG_LEFT("Пользователь %s вышел из организации %s"),
	 *
	 * 	FOO_CREATE("%s создал Foo"),
	 * 	FOO_EDIT("%s отредактировал Foo"),
	 * 	FOO_DELETE("%s удалил Foo"),
	 * 	FOO_STATUS("%s сменил статус Foo на %s");
	 *
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
