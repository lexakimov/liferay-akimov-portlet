package ru.akimov.audit.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import ru.akimov.model.AuditEntryGroup;

/**
 * @author akimov
 * created at 23.01.20 16:37
 */
public class AuditMessagingUtil {

	private static Log log = LogFactoryUtil.getLog(AuditMessagingUtil.class);

	private static final String ATTR_PREVENT_AUDITION = "PREVENT_AUDITION";

	/**
	 * перед тем как создавать кастомную запись аудита, нужно вызвать этот метод.
	 */
	public static void preventDefaultAudit() {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		serviceContext.setAttribute(ATTR_PREVENT_AUDITION, true);
	}

	/**
	 * @return true  если не нужно создавать записи аудита через ModelListener.
	 */
	public static boolean isPreventDefaultAudit() {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		return GetterUtil.getBoolean(serviceContext.getAttribute(ATTR_PREVENT_AUDITION));
	}

	public static void auditMessage(AuditEntryGroup auditEntryGroup) {
		Message message = new Message();
		message.put("audit_entry_group", auditEntryGroup);

		//message.setResponseId("1111");
		//message.setResponseDestinationName("tour/manager/task");

		MessageBusUtil.sendMessage(Destinations.AUDIT_CREATE, message);

		// Sends the message to the destination with a timeout value of 10,000 milliseconds. This is how long the
		// sender blocks for while waiting for a response. If no response is received, then a MessageBusException is
		// thrown.
		try {
			String response = (String) MessageBusUtil
					.sendSynchronousMessage(Destinations.AUDIT_CREATE, message, 10000);
		} catch (MessageBusException e) {
			log.error(e);
		}
	}

}
