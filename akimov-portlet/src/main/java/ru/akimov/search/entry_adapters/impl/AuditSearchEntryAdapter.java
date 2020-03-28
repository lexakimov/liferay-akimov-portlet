package ru.akimov.search.entry_adapters.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.akimov.audit.description.DescriptionManager;
import ru.akimov.model.AuditEntry;
import ru.akimov.search.entry_adapters.SearchEntryAdapter;

import javax.portlet.PortletException;
import java.util.Date;

public class AuditSearchEntryAdapter extends SearchEntryAdapter<AuditEntry> {

	private static final Log log = LogFactoryUtil.getLog(AuditSearchEntryAdapter.class);

	private User user;

	public AuditSearchEntryAdapter(AuditEntry model) throws PortletException {
		super(model);
		long userId = 0L;// TODO model.getUserId();
		try {
			this.user = UserLocalServiceUtil.fetchUser(userId);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	public Date getDateOfChange() {
		return null ; // TODO model.getDateOfChange();
	}

	public String getUserFullName() {
		return user != null ? user.getFullName() : "[пользователь не найден]";
	}

	public String getDescription() {
		return DescriptionManager.formDescription(model);
	}

}
