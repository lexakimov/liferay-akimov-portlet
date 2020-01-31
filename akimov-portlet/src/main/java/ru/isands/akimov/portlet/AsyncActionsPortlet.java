package ru.isands.akimov.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import ru.isands.akimov.annotations.AsyncActionMethod;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class AsyncActionsPortlet extends ExtendedMVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(AsyncActionsPortlet.class);

	@AsyncActionMethod
	public void simpleAsyncAction(PortletRequest request, PortletResponse response) {
		System.out.println(_getRequestParamsMessage(request));
		System.out.println(_getRequestAttrsMessage(request));
	}

	@AsyncActionMethod
	public void simpleAsyncActionWithErrors(PortletRequest request, PortletResponse response) {
		SessionErrors.add(request, "error.message.key.1");
		SessionErrors.add(request, "error.message.key.2");
		SessionErrors.add(request, "error.message.key.3");

		SessionMessages.add(request, "error.message.key");
		SessionMessages.add(request, "info.message.key");
		SessionMessages.add(request, "success.message.key");
		SessionMessages.add(request, "block.message.key");
		SessionMessages.add(request, "simple.message.key");
		SessionMessages.add(request, "simple.message.key.fmt.1", new String[]{"Чук", "Гек"});
		SessionMessages.add(request, "simple.message.key.fmt.2", "param from backend");
	}

}
