package ru.akimov.notifications;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;

/**
 * @author akimov
 * created at 15.04.2020 19:25
 */
public class CustomUserNotificationsHandler extends BaseUserNotificationHandler {

	public static final String PORTLET_ID = "notificationsTest_WAR_akimovportlet";

	public CustomUserNotificationsHandler() {
		setPortletId(CustomUserNotificationsHandler.PORTLET_ID);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String notificationText = jsonObject.getString("notificationText");
		String title = "<strong>" + jsonObject.getString("userId") + "</strong>";

		return StringUtil.replace(getBodyTemplate(),
				new String[]{"[$TITLE$]", "[$BODY_TEXT$]"},
				new String[]{title, notificationText});
	}

	protected String getBodyTemplate() throws Exception {
		return "<div class=\"title\">[$TITLE$]</div><div class=\"body\">[$BODY_TEXT$]</div>";
	}
}
