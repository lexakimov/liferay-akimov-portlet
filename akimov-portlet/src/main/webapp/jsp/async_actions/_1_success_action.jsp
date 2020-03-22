<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<akimov:async-actionURL var="actURL" asyncActionMethod="simpleAsyncAction">
	<portlet:param name="custom_param1" value="value 1233"/>
</akimov:async-actionURL>

<div id="messageBox1"></div>

<aui:button name="execAction1" value="Execute success action" primary="true"/>

<script>
	$(function () {
		let callback = function () {
			console.log('this is callback');
		};

		$("button#<portlet:namespace/>execAction1").click(function () {
			asyncAction('${actURL}', {messageBox: 'div#messageBox1', callback: callback});
		});
	});
</script>