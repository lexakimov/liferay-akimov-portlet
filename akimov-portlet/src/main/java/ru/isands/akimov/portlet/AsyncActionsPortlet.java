package ru.isands.akimov.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import ru.isands.akimov.annotations.AsyncActionMethod;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class AsyncActionsPortlet extends ExtendedMVCPortlet {

	@AsyncActionMethod
	public void simpleAsyncAction(PortletRequest request, PortletResponse response) {
		_debugPrintParams(request);
		_debugPrintAttrs(request);
	}

	@AsyncActionMethod
	public void simpleAsyncActionWithErrors(PortletRequest request, PortletResponse response) {

		SessionErrors.add(request, "error.message.key.1");
		SessionErrors.add(request, "error.message.key.2");
		SessionErrors.add(request, "error.message.key.3");

		SessionMessages.add(request, "message.1");
		SessionMessages.add(request, "message.2");
		SessionMessages.add(request, "message.3");
	}


}
