package ru.akimov.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.*;
import com.liferay.portal.kernel.messaging.sender.MessageSender;
import com.liferay.portal.kernel.util.ParamUtil;
import ru.akimov.messaging.Destinations;
import ru.akimov.messaging.DynamicListener;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import java.util.Collection;
import java.util.Set;

import static ru.akimov.messaging.Destinations.*;

/**
 * @author akimov
 * created at 30.03.2020 11:13
 * @see https://portal.liferay.dev/docs/6-2/tutorials/-/knowledge_base/t/liferays-message-bus-system
 */
public class MessagingTestPortlet extends MVCExtendedPortlet {

	private static Log log = LogFactoryUtil.getLog(MessagingTestPortlet.class);

	private final DynamicListener dynamicallyRegisteredListener = new DynamicListener();

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		log.info("register listener " + dynamicallyRegisteredListener);
		MessageBusUtil.registerMessageListener(ASYNC_SEND_AND_FORGET_SERIAL_DEST, dynamicallyRegisteredListener);
		MessageBusUtil.registerMessageListener(ASYNC_SEND_AND_FORGET_PARALLEL_DEST, dynamicallyRegisteredListener);
	}

	@Override
	public void destroy() {
		super.destroy();
		log.info("unregister listener " + dynamicallyRegisteredListener);
		MessageBusUtil.unregisterMessageListener(ASYNC_SEND_AND_FORGET_SERIAL_DEST, dynamicallyRegisteredListener);
		MessageBusUtil.unregisterMessageListener(ASYNC_SEND_AND_FORGET_PARALLEL_DEST, dynamicallyRegisteredListener);
	}

	/**
	 * При регистрации/разрегистрации не нужны проверки на уже зарегистрированные слушатели.
	 */
	public void registerListener(ActionRequest request, ActionResponse response) {
		log.info("registerListener");
		MessageBusUtil.registerMessageListener(ASYNC_SEND_AND_FORGET_SERIAL_DEST, dynamicallyRegisteredListener);
		MessageBusUtil.registerMessageListener(ASYNC_SEND_AND_FORGET_PARALLEL_DEST, dynamicallyRegisteredListener);
	}

	/**
	 * При регистрации/анрегистрации не нужны проверки на уже зарегистрированные слушатели.
	 */
	public void unregisterListener(ActionRequest request, ActionResponse response) {
		log.info("unregisterListener");
		MessageBusUtil.unregisterMessageListener(ASYNC_SEND_AND_FORGET_SERIAL_DEST, dynamicallyRegisteredListener);
		MessageBusUtil.unregisterMessageListener(ASYNC_SEND_AND_FORGET_PARALLEL_DEST, dynamicallyRegisteredListener);
	}


	public void sync(ActionRequest request, ActionResponse response) {
		Message message = new Message();
		message.put("text", "messageText");
		message.setResponseDestinationName(SYNC_RESPONSE_DEST);

		log.info("sync : send message to " + SYNC_REQUEST_DEST);
		try {
			String mbResponse =
					(String) MessageBusUtil.sendSynchronousMessage(SYNC_REQUEST_DEST, message, 10000);

			log.info(mbResponse);
		} catch (MessageBusException e) {
			log.error(e);
		}
	}

	/**
	 * Can be serial or parallel.
	 */
	public void asyncSendAndForget(ActionRequest request, ActionResponse response) {
		String dest = ParamUtil.getString(request, "dest");
		String messageText = "some text...";

		Message message = new Message();
		message.put("text", messageText);

		log.info("Async SendAndForget: send message to " + dest);
		MessageBusUtil.sendMessage(dest, message);
	}

	/**
	 * Can be serial or parallel.
	 */
	public void asyncWithCallback(ActionRequest request, ActionResponse response) {
		Message message = new Message();
		message.put("text", "some text...");
		String dest = ParamUtil.getString(request, "dest");
		log.info("Async With callback: send message to " + dest);
		MessageBusUtil.sendMessage(dest, message);
	}

	public void tempMethod(ActionRequest request, ActionResponse response) {
		BaseDestination dest = new SerialDestination();
		dest.setName(Destinations.DESTINATION_TEMP);

		MessageBus messageBus = MessageBusUtil.getMessageBus();

		int destinationCount = messageBus.getDestinationCount();
		Collection<String> destinationNames = messageBus.getDestinationNames();
		Collection<Destination> destinations = messageBus.getDestinations();
		Destination destination = messageBus.getDestination(DESTINATION_TEMP);

		Set<MessageListener> messageListeners = destination.getMessageListeners();

		MessageBusUtil.addDestination(dest);
		boolean hasDestination = messageBus.hasDestination(DESTINATION_TEMP);
		MessageBusUtil.removeDestination(Destinations.DYNAMIC_DESTINATION);

		MessageListener listener = new DynamicListener();
		MessageBusUtil.registerMessageListener(DESTINATION_TEMP, listener);
		boolean hasListener = MessageBusUtil.hasMessageListener(Destinations.DYNAMIC_DESTINATION);
		MessageBusUtil.unregisterMessageListener(DESTINATION_TEMP, listener);

		DestinationEventListener destEventListener = new BaseDestinationEventListener();
		messageBus.addDestinationEventListener(destEventListener);
		messageBus.removeDestinationEventListener(destEventListener);


		MessageSender messageSender = MessageBusUtil.getMessageSender();

	}

}
