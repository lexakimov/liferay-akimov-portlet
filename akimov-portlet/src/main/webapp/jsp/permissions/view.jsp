<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="ru.isands.akimov.model.Foo" %>
<%@ page import="ru.isands.akimov.service.FooLocalServiceUtil" %>
<%@ page import="ru.isands.akimov.service.permission.FooPermission" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Permissions Test</h3>
<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<%
	List<Foo> foos = FooLocalServiceUtil.getFoos(0, 1);
	Foo foo = foos.get(0);
	String accessInControlPanel = ActionKeys.ACCESS_IN_CONTROL_PANEL;
%>

<liferay-security:permissionsURL var="permissionsURL" windowState="POP_UP"
								 modelResource="<%= Foo.class.getName() %>"
								 modelResourceDescription="<%= String.valueOf(foo.getFooId()) %>"
								 resourcePrimKey="<%= String.valueOf(foo.getFooId()) %>"/>
<aui:button-row>
	<aui:button value="permissions" primary="true" href="<%= permissionsURL %>" useDialog="true"/>
</aui:button-row>

<c:if test='<%= FooPermission.contains(permissionChecker, foo.getFooId(), "VIEW") %>'>
	Permission: VIEW<br>
</c:if>

<c:if test='<%= FooPermission.contains(permissionChecker, foo.getFooId(), "ADD_FOO") %>'>
	Permission: ADD_FOO<br>
</c:if>
