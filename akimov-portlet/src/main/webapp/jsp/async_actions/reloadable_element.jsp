<%@ page import="static ru.akimov.constants.URLParams.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.URLParams.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>This is reloadable jsp content</h4>

<h5><%= UUID.randomUUID().toString()%></h5>


<c:if test="${param.long_time_render}">
	<%
		for (int i = 0; i < 10; i++) {
			System.out.println("long-time async request " + (i + 1) + "/10");
			Thread.sleep(200);
		}
	%>
</c:if>
