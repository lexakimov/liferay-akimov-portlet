package ru.isands.akimov.audit.events;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.isands.akimov.audit.AuditEntryWrapper;
import ru.isands.akimov.audit.enums.AuditType;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.audit.exceptions.AuditEntryCreateException;

import java.util.Date;

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

	private void process(User model, AuditType description) throws AuditEntryCreateException {
		try {
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			long companyId = model.getCompanyId();
			int entityId = (int) model.getUserId();
			User userAuthor = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
			if (userAuthor == null) {
				userAuthor = model;
			}
			String metadata = "";
			new AuditEntryWrapper(entityId, EntityType.USER, description, companyId, userAuthor, new Date(), metadata).persist();

		} catch (SystemException e) {
			throw new AuditEntryCreateException(e);
		}
	}

}
