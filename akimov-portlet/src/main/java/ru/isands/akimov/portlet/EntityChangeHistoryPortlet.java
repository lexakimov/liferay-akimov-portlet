package ru.isands.akimov.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class EntityChangeHistoryPortlet extends ExtendedMVCPortlet {

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

	/**
	 * TODO blobField
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws IOException
	 */
	public void updateFoo(ActionRequest request, ActionResponse response) throws SystemException, IOException {

		_debugPrintParams(request);

		int fooId = ParamUtil.getInteger(request, "fooId");
		Foo foo;
		if (fooId > 0) {
			foo = FooLocalServiceUtil.fetchFoo(fooId);
		} else {
			fooId = (int) CounterLocalServiceUtil.increment(Foo.class.getName());
			foo = FooLocalServiceUtil.createFoo(fooId);
		}

		foo.setBooleanField(ParamUtil.getBoolean(request, "booleanField"));
		foo.setShortField(ParamUtil.getShort(request, "shortField"));
		foo.setIntField(ParamUtil.getInteger(request, "intField"));
		foo.setLongField(ParamUtil.getLong(request, "longField"));
		foo.setDoubleField(ParamUtil.getDouble(request, "doubleField"));
		foo.setFloatField(ParamUtil.getFloat(request, "floatField"));
		foo.setStringField(ParamUtil.getString(request, "stringField"));
		foo.setDateField(ParamUtil.getDate(request, "dateField", SIMPLE_DATE_FORMAT, null));
		foo.persist();

		PortletURL redirect = createPortletURL(request);
		response.sendRedirect(redirect.toString());
	}

	public void deleteFoo(ActionRequest request, ActionResponse response) throws SystemException, PortalException, IOException {
		int fooId = ParamUtil.getInteger(request, "fooId");

		if (fooId > 0) {
			FooLocalServiceUtil.deleteFoo(fooId);
		}

		PortletURL redirect = createPortletURL(request);
		response.sendRedirect(redirect.toString());
	}

}
