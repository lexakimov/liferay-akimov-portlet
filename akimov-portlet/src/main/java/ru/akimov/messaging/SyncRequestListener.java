package ru.akimov.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * @author akimov
 * created at 30.03.2020 12:50
 */
public class SyncRequestListener implements MessageListener {

	private static final Log log = LogFactoryUtil.getLog(SyncRequestListener.class);

	@Override
	public void receive(Message message) throws MessageListenerException {
		log.info("received: " + message);

		Message responseMessage = MessageBusUtil.createResponseMessage(message);
		responseMessage.setPayload("RECEIVED");
		MessageBusUtil.sendMessage(responseMessage.getDestinationName(), responseMessage);
	}
}
