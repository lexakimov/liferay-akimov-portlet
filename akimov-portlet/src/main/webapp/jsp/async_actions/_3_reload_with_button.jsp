<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>Reload by button</h4>
<aui:button name="reload1" value="Reload Content" primary="true"/><br><br>
<div id="reloadableElement" class="bordered-block-1" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloadingURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<script>
	$(function () {
		let reloadableElement = $('div#reloadableElement');

		$("button#<portlet:namespace/>reload1").click(function () {
			reloadElementContent(reloadableElement, '${reloadingURL}');
		});
	});
</script>
