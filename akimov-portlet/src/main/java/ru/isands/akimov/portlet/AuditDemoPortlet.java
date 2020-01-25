package ru.isands.akimov.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import ru.isands.akimov.model.Foo;
import ru.isands.akimov.service.FooLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import java.io.IOException;

import static ru.isands.akimov.utils.DateUtil.DD_MM_YYYY__HH_MM;

public class AuditDemoPortlet extends ExtendedMVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(AuditDemoPortlet.class);

	/**
	 * TODO blobField
	 *
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws IOException
	 */
	public void updateFoo(ActionRequest request, ActionResponse response) throws SystemException, IOException {

		log.debug("");
		System.out.println(_getRequestParamsMessage(request));

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
		foo.setDateField(ParamUtil.getDate(request, "dateField", DD_MM_YYYY__HH_MM, null));
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
