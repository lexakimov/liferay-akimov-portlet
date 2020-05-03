package ru.akimov.search.entry_adapters.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.akimov.model.AuditEntryGroup;
import ru.akimov.search.entry_adapters.SearchEntryAdapter;
import ru.akimov.utils.WebPageUtil;

import javax.portlet.PortletException;
import java.util.Date;

public class AuditGroupSearchEntryAdapter extends SearchEntryAdapter<AuditEntryGroup> {

	private static final Log log = LogFactoryUtil.getLog(AuditGroupSearchEntryAdapter.class);

	private User user;

	public AuditGroupSearchEntryAdapter(AuditEntryGroup model) throws PortletException {
		super(model);
		long userId = model.getUserId();
		try {
			this.user = UserLocalServiceUtil.fetchUser(userId);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	public Date getDateTime() {
		return model.getEventDate();
	}

	public String getUserFullName() {
		return (user != null)
				? user.getFullName()
				: (model.getUserId() == -1)
					? WebPageUtil.setColor(model.getUserName(), "blue")
					: WebPageUtil.setColor(model.getUserName(), "red");
	}

}
