<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Notifications Test</h3>
<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<portlet:actionURL var="sendNotificationURL" name="sendNotifications"/>

<aui:button name="send" value="notificate user(s)" href="${sendNotificationURL}"/>