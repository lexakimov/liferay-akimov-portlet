package ru.isands.akimov.portlet;

import ru.isands.akimov.annotations.AsyncActionMethod;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class AsyncActionsPortlet extends ExtendedMVCPortlet {

	@AsyncActionMethod
	public void simpleAsyncAction(PortletRequest request, PortletResponse response) {
		_debugPrintParams(request);
		_debugPrintAttrs(request);
	}


}
