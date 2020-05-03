<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<div class="container">
	<h3>Notifications Test</h3>
	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<portlet:actionURL var="sendNotificationURL" name="sendNotifications"/>
	<div class="text-center">
		<aui:form action="${sendNotificationURL}" method="post">
			<aui:input name="notification-text" label="Текст уведомления" type="textarea"/>
			<aui:button type="submit" value="notificate user(s)"/>
		</aui:form>
	</div>
</div>