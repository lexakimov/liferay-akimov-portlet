<%@ page import="static ru.akimov.constants.URLParams.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.URLParams.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Async file uploading</h3>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<portlet:actionURL var="updateEntityURL" name="updateEntity">

</portlet:actionURL>

<aui:form name="uploadForm" action="${updateEntityURL}" method="post">
	<jsp:include page="_file_upload.jsp"/>

	<aui:button type="submit" value="save"/>
</aui:form>
