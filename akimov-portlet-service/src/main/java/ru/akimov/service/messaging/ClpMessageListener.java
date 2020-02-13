package ru.akimov.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import ru.akimov.service.ClpSerializer;
import ru.akimov.service.EntityFieldChangeLocalServiceUtil;
import ru.akimov.service.FooLocalServiceUtil;
import ru.akimov.service.AuditEntryLocalServiceUtil;
import ru.akimov.service.PersonLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            AuditEntryLocalServiceUtil.clearService();

            EntityFieldChangeLocalServiceUtil.clearService();

            FooLocalServiceUtil.clearService();

            PersonLocalServiceUtil.clearService();
        }
    }
}
