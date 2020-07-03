<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.akimov.messaging.Destinations" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<div class="container">
	<legend>Messaging Test</legend>

	<h4>Dynamic listener registration (for send-and-forget destinations)</h4>
	<portlet:actionURL var="registerURL" name="registerListener"/>
	<portlet:actionURL var="unregisterURL" name="unregisterListener"/>
	<aui:button name="act4" value="Register" href="${registerURL}"/>
	<aui:button name="act5" value="Unregister" href="${unregisterURL}"/>

	<%--------------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<h4>Synchronous</h4>
	<portlet:actionURL var="send1URL" name="sync"/>
	<aui:button name="act2" value="Send" href="${send1URL}"/>

	<%--------------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<h4>Async send and forget</h4>
	<portlet:actionURL var="send2URL" name="asyncSendAndForget"/>
	<aui:form action="${send2URL}" name="fthdrfv">
		<aui:field-wrapper label="Destination">
			<aui:input name="dest" type="radio"
					   label="<%=Destinations.ASYNC_SEND_AND_FORGET_SERIAL_DEST%>"
					   value="<%=Destinations.ASYNC_SEND_AND_FORGET_SERIAL_DEST%>"/>
			<aui:input name="dest" type="radio"
					   label="<%=Destinations.ASYNC_SEND_AND_FORGET_PARALLEL_DEST%>"
					   value="<%=Destinations.ASYNC_SEND_AND_FORGET_PARALLEL_DEST%>"/>
		</aui:field-wrapper>
		<aui:button name="act1" type="submit" value="Send"/>
	</aui:form>

	<%--------------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<h4>Async with callback</h4>
	<portlet:actionURL var="send3URL" name="asyncWithCallback"/>
	<aui:form action="${send3URL}" name="fthdrfvsa">
		<aui:field-wrapper label="Destination">
			<aui:input name="dest" type="radio"
					   label="<%=Destinations.ASYNC_WITH_CALLBACK_SERIAL_DEST%>"
					   value="<%=Destinations.ASYNC_WITH_CALLBACK_SERIAL_DEST%>"/>
			<aui:input name="dest" type="radio"
					   label="<%=Destinations.ASYNC_WITH_CALLBACK_PARALLEL_DEST%>"
					   value="<%=Destinations.ASYNC_WITH_CALLBACK_PARALLEL_DEST%>"/>
		</aui:field-wrapper>
		<aui:button name="act2" type="submit" value="Send"/>
	</aui:form>
</div>