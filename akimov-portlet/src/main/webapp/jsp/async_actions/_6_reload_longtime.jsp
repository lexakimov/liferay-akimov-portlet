<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>reload (longtime) with effects by button</h4>

<div id="reloadableElement4" class="bordered-block-1" style="width: 400px; display: inline-block;">
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