package ru.akimov.audit.messaging.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.servlet.SessionMessages;
import ru.akimov.audit.AuditEntryWrapper;

import javax.portlet.PortletRequest;

/**
 * @author akimov
 * created at 23.01.20 16:42
 */
public class AuditMessageListenerImpl implements MessageListener {

	private static Log _log = LogFactoryUtil.getLog(AuditMessageListenerImpl.class);

	@Override
	public void receive(Message message) {
		try {
			doReceive(message);
		} catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	private void doReceive(Message message) throws Exception {
		// Receives message...
		AuditEntryWrapper auditEntry = (AuditEntryWrapper) message.get("audit_entry");

		// Create a new audit entry item...
		auditEntry.persist();

		// Response...
		Message responseMessage = MessageBusUtil.createResponseMessage(message);
		responseMessage.setPayload("RECEIVED");
		MessageBusUtil.sendMessage(responseMessage.getDestinationName(), responseMessage);
	}


	void syncMethod(PortletRequest request) {
		// Begin Message Bus
		String name = "name123";

		Message message = new Message();
		message.put("name", name);
		message.put("description", "description");
		message.put("status", "status");
		message.setResponseId("1111");
		message.setResponseDestinationName("tour/manager/task");

		try {
			String roadieResponse =
					(String) MessageBusUtil
							.sendSynchronousMessage("tour/roadie/setup", message, 10000);

			if (roadieResponse.equals("RECEIVED")) {
				SessionMessages.add(request, "success");
			}

			System.out.println("Tour manager received response from roadie for " + name + ": " + roadieResponse);
		} catch (MessageBusException mbe) {
			_log.error(mbe);
		}

		// End Message Bus
	}


	void response(Message message) {
		// Response...
		Message responseMessage = MessageBusUtil.createResponseMessage(message);
		//responseMessage.put("name", name);
		//responseMessage.put("description", description);
		responseMessage.setPayload("RECEIVED");
		MessageBusUtil.sendMessage(responseMessage.getDestinationName(), responseMessage);
	}

}
