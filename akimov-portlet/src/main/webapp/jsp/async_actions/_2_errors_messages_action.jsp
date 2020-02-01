<%@ page import="static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<div id="messageBox2"></div>

<akimov:async-actionURL var="urlName2" asyncActionMethod="simpleAsyncActionWithErrors"/>

<script>
	$(function () {
		var callback = function (jsonResponse) {
			openSimpleMessageWindow({
				headerLabel: 'Заголовок окна',
				bodyContent: buildActionResultHtml(jsonResponse)
			});
		};

		$("button#<portlet:namespace/>execAction2").click(function () {
			asyncAction('${urlName2}', {messageBox: 'div#messageBox2', callback: callback});
		});
	});
</script>

<aui:button name="execAction2" value="Execute action with errors and messages" primary="true"/>
