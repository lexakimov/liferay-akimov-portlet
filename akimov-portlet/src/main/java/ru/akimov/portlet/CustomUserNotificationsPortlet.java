package ru.akimov.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import ru.akimov.notifications.CustomUserNotificationsHandler;
import ru.akimov.utils.PortletRequestUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;
import java.util.List;

/**
 * @author akimov
 * created at 15.04.2020 19:16
 * @see https://brandnameboredom.github.io/liferay/notifications/2016/06/27/liferaycustomnotifications.html
 * @see http://www.liferaysavvy.com/2014/12/liferay-dockbar-custom-user.html
 */
public class CustomUserNotificationsPortlet extends MVCExtendedPortlet {

	private Log log = LogFactoryUtil.getLog(CustomUserNotificationsPortlet.class);

	public void sendNotifications(ActionRequest request, ActionResponse response) {
		log.debug("notificate!");
		System.out.println(PortletRequestUtil.paramsList(request));

		try {
			List<User> users = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			String notificationText =
					ParamUtil.getString(request, "notification-text", "Текст уведомления!");
			for (User user : users) {
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
				payloadJSON.put("userId", user.getUserId());
				// payloadJSON.put("customEntityId",user.getUserId());
				payloadJSON.put("notificationText", notificationText);
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
						user.getUserId(),
						CustomUserNotificationsHandler.PORTLET_ID,
						(new Date()).getTime(), user.getUserId(),
						payloadJSON.toString(), false, serviceContext);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
}
