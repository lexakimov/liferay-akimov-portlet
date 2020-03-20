package ru.akimov.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import ru.akimov.audit.AuditEntryWrapper;
import ru.akimov.audit.enums.AuditType;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.audit.messaging.AuditMessagingUtil;
import ru.akimov.model.Foo;
import ru.akimov.service.FooLocalServiceUtil;
import ru.akimov.utils.PortletRequestUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import java.io.IOException;
import java.util.Date;

import static ru.akimov.utils.DateUtil.DD_MM_YYYY__HH_MM;

public class AuditDemoPortlet extends MVCExtendedPortlet {

	private Log log = LogFactoryUtil.getLog(AuditDemoPortlet.class);

	/**
	 * TODO blobField
	 *
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws IOException
	 */
	@ProcessAction(name = "updateFoo")
	public void updateFoo(ActionRequest request, ActionResponse response) throws SystemException, IOException {

		boolean isCustomAudit = ParamUtil.getBoolean(request, "isCustomAudit");
		if (isCustomAudit) {
			AuditMessagingUtil.preventDefaultAudit();
		}

		if (log.isDebugEnabled()) {
			log.debug("");
			System.out.println(PortletRequestUtil.paramsList(request));
		}

		int fooId = ParamUtil.getInteger(request, "fooId");
		Foo foo;
		if (fooId > 0) {
			foo = FooLocalServiceUtil.fetchFoo(fooId);
		} else {
			fooId = (int) CounterLocalServiceUtil.increment(Foo.class.getName());
			foo = FooLocalServiceUtil.createFoo(fooId);
		}

		foo.setStatus(ParamUtil.getShort(request, "status"));
		foo.setBooleanField(ParamUtil.getBoolean(request, "booleanField"));
		foo.setShortField(ParamUtil.getShort(request, "shortField"));
		foo.setIntField(ParamUtil.getInteger(request, "intField"));
		foo.setLongField(ParamUtil.getLong(request, "longField"));
		foo.setDoubleField(ParamUtil.getDouble(request, "doubleField"));
		foo.setFloatField(ParamUtil.getFloat(request, "floatField"));
		foo.setStringField(ParamUtil.getString(request, "stringField"));
		foo.setDateField(ParamUtil.getDate(request, "dateField", DD_MM_YYYY__HH_MM, null));
		foo.persist();

		if (isCustomAudit) {
			AuditEntryWrapper auditEntry =
					new AuditEntryWrapper(fooId, EntityType.FOO, AuditType.FOO_CUSTOM, new Date(), StringPool.BLANK);
			auditEntry.addFieldChange("customized_param_1", "val1", "val2");
			auditEntry.persist();
		}

		PortletURL redirect = PortletRequestUtil.createPortletURL(request);
		response.sendRedirect(redirect.toString());
	}

	public static void deleteFoo(ActionRequest request, ActionResponse response) throws SystemException, PortalException, IOException {
		int fooId = ParamUtil.getInteger(request, "fooId");

		if (fooId > 0) {
			FooLocalServiceUtil.deleteFoo(fooId);
		}

		PortletURL redirect = PortletRequestUtil.createPortletURL(request);
		response.sendRedirect(redirect.toString());
	}

}
