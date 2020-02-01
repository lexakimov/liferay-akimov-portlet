<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>auto reload by setInterval</h4>

<div id="reloadableElement2" class="bordered-block-1" style="width: 400px; display: inline-block;">
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