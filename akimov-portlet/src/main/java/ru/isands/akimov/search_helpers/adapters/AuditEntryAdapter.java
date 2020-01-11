package ru.isands.akimov.search_helpers.adapters;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import ru.isands.akimov.audit.enums.ActionType;
import ru.isands.akimov.model.EntityEditingHistory;

import javax.portlet.PortletException;
import java.util.Date;

public class AuditEntryAdapter extends EntryAdapter<EntityEditingHistory> {

	private User user;

	public AuditEntryAdapter(EntityEditingHistory model) throws PortletException {
		super(model);
		long userId = model.getUserId();
		try {
			this.user = UserLocalServiceUtil.fetchUser(userId);
		} catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	public Date getDateOfChange() {
		return model.getDateOfChange();
	}

	public String getUserFullName() {
		return user != null ? user.getFullName() : "[пользователь не найден]";
	}

	public String getDescription() {
		try {
			ActionType actionType = ActionType.valueOf(model.getDescription());
			return actionType.getDescription(user);
		} catch (IllegalArgumentException e) {
			return model.getDescription();
		}
	}

}
