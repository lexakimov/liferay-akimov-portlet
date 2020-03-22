<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>reload with effects by button</h4>

<div id="reloadableElement3" class="bordered-block-1" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloading3URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<aui:button name="reload3" value="ReloadContent" primary="true"/>

<script>
	$(function () {
		$("button#<portlet:namespace/>reload3").click(function () {
			let reloadableElement = $('div#reloadableElement3');
			reloadElementContentAdvanced(reloadableElement, '${reloading3URL}');
		});
	});
</script>