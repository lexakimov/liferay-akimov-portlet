<%@ page import="ru.isands.akimov.model.Foo" %>
<%@ page import="static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.isands.akimov.service.FooLocalServiceUtil" %>
<%@ page import="ru.isands.akimov.utils.DateUtil" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<%
	int fooId = ParamUtil.getInteger(request, "fooId");
	Foo foo = FooLocalServiceUtil.fetchFoo(fooId);
%>

<c:set var="foo" value="<%=foo%>"/>

<portlet:actionURL var="submitFooFormURL" name="updateFoo"/>

<aui:form name="fooForm" action="${submitFooFormURL}" method="POST">
	<aui:fieldset>

		<aui:input name="fooId" value="${foo.fooId}" type="hidden"/>

		<aui:input name="booleanField"
				   label="foo.field.booleanField"
				   value="${foo.booleanField}"
				   type="checkbox"/>

		<aui:input name="shortField"
				   label="foo.field.shortField"
				   value="${foo.shortField}"
				   cssClass="width-auto numeric-decimal"
				   inlineField="true"
				   required="true"/>

		<aui:input name="intField"
				   label="foo.field.intField"
				   value="${foo.intField}"
				   cssClass="width-auto numeric-decimal"
				   inlineField="true"/>

		<aui:input name="longField"
				   label="foo.field.longField"
				   value="${foo.longField}"
				   cssClass="width-auto numeric-decimal"
				   inlineField="true"/>

		<aui:input name="floatField"
				   label="foo.field.floatField"
				   value="${foo.floatField}"
				   cssClass="width-auto numeric-float"
				   inlineField="true"/>

		<aui:input name="doubleField"
				   label="foo.field.doubleField"
				   value="${foo.doubleField}"
				   cssClass="width-auto numeric-float"
				   inlineField="true"/>

		<aui:input name="stringField"
				   label="foo.field.stringField"
				   value="${foo.stringField}" inlineField="true"/>

		<%
			String dateField = "";
			if (foo != null && foo.getDateField() != null) {
				dateField = DateUtil.DD_MM_YYYY__HH_MM.format(foo.getDateField());
			}
		%>
		<aui:input name="dateField"
				   label="foo.field.dateField"
				   value="<%=dateField%>"
				   cssClass="date-dd-mm-yyyy-MM-HH"
				   inlineField="true"/>


	</aui:fieldset>
</aui:form>

<script>
	$(function () {
		initInputMasks();
	})
</script>