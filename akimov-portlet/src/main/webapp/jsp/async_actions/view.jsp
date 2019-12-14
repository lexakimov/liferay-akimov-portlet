<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="ru.isands.akimov.enums.Gender" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.isands.akimov.search_helpers.impl.PersonSearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Async Actions Portlet</h3>

<portlet:renderURL var="addParamsURL">
	<portlet:param name="wrongParam1" value="value_3234344"/>
	<portlet:param name="wrongParam2" value="value_esfsdgd"/>
</portlet:renderURL>

<aui:a href="${addParamsURL}">
	add wrong params
</aui:a>
<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<div id="messageBox1"></div>

<portlet:resourceURL var="urlName1" id="<%=ASYNC_ACTION_RESOURCE_ID%>">
	<portlet:param name="<%=ASYNC_ACTION_METHOD_PARAM%>" value="simpleAsyncAction"/>
	<portlet:param name="custom_param1" value="value 1233"/>
</portlet:resourceURL>

<script>
	$(function () {
		var callback = function () {
			console.log('this is callback');
		};

		$("button#<portlet:namespace/>execAction1").click(function () {
			asyncAction('${urlName1}', {messageBox: 'div#messageBox1', callback: callback});
		});
	});
</script>

<aui:button name="execAction1" value="Execute action" primary="true"/>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<div id="messageBox2"></div>

<portlet:resourceURL var="urlName2" id="<%=ASYNC_ACTION_RESOURCE_ID%>">
	<portlet:param name="<%=ASYNC_ACTION_METHOD_PARAM%>" value="simpleAsyncActionWithErrors"/>
</portlet:resourceURL>

<script>
	$(function () {
		var callback = function () {
			console.log('this is callback');
		};

		$("button#<portlet:namespace/>execAction2").click(function () {
			asyncAction('${urlName2}', {messageBox: 'div#messageBox2', callback: callback});
		});
	});
</script>

<aui:button name="execAction2" value="Execute action with errors" primary="true"/>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>reload by button</h4>

<div id="reloadableElement" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloadingURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<aui:button name="reload1" value="ReloadContent" primary="true"/>

<script>
	$(function () {
		var reloadableElement = $('div#reloadableElement');

		$("button#<portlet:namespace/>reload1").click(function () {
			reloadElementContent(reloadableElement, '${reloadingURL}');
		});
	});
</script>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>auto reload by setInterval</h4>

<div id="reloadableElement2" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloading2URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<script>
	$(function () {
		var reloadableElement = $('div#reloadableElement2');

		setInterval(function () {
			reloadElementContent(reloadableElement, '${reloading2URL}');
		}, 500);
	});
</script>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>reload with effects by button</h4>

<div id="reloadableElement3" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloading3URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<aui:button name="reload3" value="ReloadContent" primary="true"/>

<script>
	$(function () {
		$("button#<portlet:namespace/>reload3").click(function () {
			var reloadableElement = $('div#reloadableElement3');
			reloadElementContentAdvanced(reloadableElement, '${reloading3URL}');
		});
	});
</script>


<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>reload (longtime) with effects by button</h4>

<div id="reloadableElement4" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloading4URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
	<portlet:param name="long_time_render" value="true"/>
</portlet:renderURL>

<aui:button name="reload4" value="ReloadContent" primary="true"/>

<script>
	$(function () {
		$("button#<portlet:namespace/>reload4").click(function () {
			var reloadableElement = $('div#reloadableElement4');
			reloadElementContentAdvanced(reloadableElement, '${reloading4URL}');
		});
	});
</script>