<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<div class="container">
	<legend>Async Actions Portlet</legend>

	<jsp:include page="_1_success_action.jsp"/>

	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<jsp:include page="_2_errors_messages_action.jsp"/>

	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<jsp:include page="_3_reload_with_button.jsp"/>

	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<jsp:include page="_4_auto_reload.jsp"/>

	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<jsp:include page="_5_reload_with_effects.jsp"/>

	<%----------------------------------------------------------------------------------------------------------------%>
	<div class="separator"></div>
	<jsp:include page="_6_reload_longtime.jsp"/>
</div>