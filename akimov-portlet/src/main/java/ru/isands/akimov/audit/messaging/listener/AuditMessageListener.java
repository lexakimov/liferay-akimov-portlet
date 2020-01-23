package ru.isands.akimov.audit.messaging.listener;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import ru.isands.akimov.audit.AuditEntryWrapper;

/**
 * @author akimov
 * created at 23.01.20 16:42
 */
public class AuditMessageListener implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {

		//AuditEntryWrapper auditEntry = new AuditEntryWrapper();

	}

}
