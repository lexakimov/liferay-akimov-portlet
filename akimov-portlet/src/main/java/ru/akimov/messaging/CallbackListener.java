package ru.akimov.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * @author akimov
 * created at 30.03.2020 11:36
 */
public class CallbackListener implements MessageListener {

	private static final Log log = LogFactoryUtil.getLog(CallbackListener.class);

	@Override
	public void receive(Message message) throws MessageListenerException {
		log.info("received: " + message);
	}
}
