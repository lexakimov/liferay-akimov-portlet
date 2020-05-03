<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="static ru.akimov.constants.PortletConstants.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Async file uploading</h3>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div>
<portlet:actionURL var="updateEntityURL" name="updateEntity"/>

<div class="container">
	<aui:form
			name="uploadForm"
			action="${updateEntityURL}"
			method="post"
			style="width: 500px; margin: 0 auto;"
	>
		<jsp:include page="_file_upload.jsp"/>
		<div class="text-center">
			<aui:button type="submit" value="save"/>
		</div>
	</aui:form>
</div>