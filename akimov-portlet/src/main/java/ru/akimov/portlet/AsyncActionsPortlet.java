package ru.akimov.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import ru.akimov.annotations.AsyncActionMethod;
import ru.akimov.utils.PortletRequestUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class AsyncActionsPortlet extends MVCExtendedPortlet {

	private Log log = LogFactoryUtil.getLog(AsyncActionsPortlet.class);

	@AsyncActionMethod
	public void simpleAsyncAction(PortletRequest request, PortletResponse response) {
		System.out.println(PortletRequestUtil.paramsList(request));
		System.out.println(PortletRequestUtil.attrsList(request));
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
