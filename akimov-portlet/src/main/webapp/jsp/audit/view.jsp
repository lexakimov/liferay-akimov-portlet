<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<div class="container-fluid">
	<legend>Audit Framework Demo</legend>
	<jsp:include page="foo_list.jsp"/>
	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<jsp:include page="foo_change_history.jsp"/>
	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<jsp:include page="user_actions_audit.jsp"/>
</div>