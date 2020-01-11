<%@ page import="ru.isands.akimov.model.Foo" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.isands.akimov.model.impl.FooImpl" %>
<%@ page import="ru.isands.akimov.service.FooLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<%
	int fooId = ParamUtil.getInteger(request, "fooId");

	Foo foo = FooLocalServiceUtil.fetchFoo(fooId);
	if (foo == null) {
		foo = new FooImpl();
	}
%>

<portlet:actionURL var="submitFooFormURL" name="updateFoo"/>


<aui:form name="fooForm" action="${submitFooFormURL}" method="POST">
	<aui:input name="fooId"
			   value="<%=foo.getFooId()%>" type="hidden"/>


	<aui:input name="booleanField"
			   label="foo.field.booleanField"
			   value="<%=foo.getBooleanField()%>" type="checkbox"/>

	<aui:input name="shortField"
			   label="foo.field.shortField"
			   value="<%=foo.getShortField()%>" type="number" inlineField="true"/>
	<aui:input name="intField"
			   label="foo.field.intField"
			   value="<%=foo.getIntField()%>" type="number" inlineField="true"/>
	<aui:input name="longField"
			   label="foo.field.longField"
			   value="<%=foo.getLongField()%>" type="number"/>

	<aui:input name="floatField"
			   label="foo.field.floatField"
			   value="<%=foo.getFloatField()%>" type="number" inlineField="true"/>
	<aui:input name="doubleField"
			   label="foo.field.doubleField"
			   value="<%=foo.getDoubleField()%>" type="number" inlineField="true"/>

	<aui:input name="stringField"
			   label="foo.field.stringField"
			   value="<%=foo.getStringField()%>" inlineField="true"/>

	<aui:input name="dateField"
			   label="foo.field.dateField"
			   value="<%=foo.getDateField()%>" type="date" inlineField="true"/>
</aui:form>