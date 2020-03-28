package ru.akimov.audit.events;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.audit.exceptions.AuditEntryCreateException;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.AuditEntryGroup;
import ru.akimov.service.AuditEntryGroupLocalServiceUtil;
import ru.akimov.service.AuditEntryLocalServiceUtil;

/**
 * Перехват события о регистрации или удалении пользователя. Прописан в resources/service-ext.properties.
 *
 * @author akimov
 * created at 23.01.20 16:34
 */
public class UserListener extends BaseModelListener<User> {

	private Log log = LogFactoryUtil.getLog(UserListener.class);

	@Override
	public void onAfterCreate(User model) throws ModelListenerException {
		log.trace("onAfterCreate()");
		process(model, AuditType.USER_REGISTRATION);
	}

	@Override
	public void onAfterRemove(User model) throws ModelListenerException {
		log.trace("onAfterRemove()");
		process(model, AuditType.USER_REMOVE);
	}

	private void process(User model, AuditType auditType) throws AuditEntryCreateException {
		String entityType = String.valueOf(EntityType.USER);
		String auditTypeStr = String.valueOf(auditType);
		String metadata = StringPool.BLANK;

		try {
			int entityId = (int) model.getUserId();
			AuditEntryGroup auditEntryGroup = AuditEntryGroupLocalServiceUtil.create();
			AuditEntry auditEntry = AuditEntryLocalServiceUtil.create(entityId, entityType, auditTypeStr, metadata);
			auditEntryGroup.addEntry(auditEntry);
			auditEntryGroup.persist();
		} catch (SystemException | PortalException e) {
			throw new AuditEntryCreateException(e);
		}
	}

}
