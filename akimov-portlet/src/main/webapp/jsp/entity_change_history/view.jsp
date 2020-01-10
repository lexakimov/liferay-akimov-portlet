<%@ page import="ru.isands.akimov.search_helpers.impl.FooSearchHelper" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Entity Change History Framework</h3>
<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<h4>List of entities</h4>

<aui:button-row>
	<aui:button name="openFooCardBtn" value="Create" primary="true"/>
</aui:button-row>

<liferay-ui:search-container delta="5" iteratorURL="<%=thisURL%>" emptyResultsMessage="empty">
	<%
		new FooSearchHelper(searchContainer);
	%>
	<liferay-ui:search-container-row className="ru.isands.akimov.model.Foo">
		<liferay-ui:search-container-column-text property="fooId"/>
		<liferay-ui:search-container-column-text property="booleanField"/>
		<liferay-ui:search-container-column-text property="shortField"/>
		<liferay-ui:search-container-column-text property="intField"/>
		<liferay-ui:search-container-column-text property="longField"/>
		<liferay-ui:search-container-column-text property="doubleField"/>
		<liferay-ui:search-container-column-text property="floatField"/>
		<liferay-ui:search-container-column-text property="stringField"/>
		<liferay-ui:search-container-column-text property="dateField"/>

		<liferay-ui:search-container-column-text>
			<aui:button value="Edit" name="edit" primary="true" onClick="openDialog(${model.fooId});"/>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	<%--<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>--%>
</liferay-ui:search-container>

<portlet:renderURL var="cardURL" windowState="EXCLUSIVE">
	<portlet:param name="mvcPath" value="/jsp/entity_change_history/card.jsp"/>
</portlet:renderURL>

<script>
	$(function () {
		$("button#<portlet:namespace/>openFooCardBtn").click(function () {
			openDialog(0);
		});
	});

	function openDialog(id) {

		AUI().ready('aui-modal', 'aui-io-plugin-deprecated', function (A) {
			var modal = new A.Modal({
				modal: true,
				headerContent: 'Foo',
				destroyOnHide: true,
				centered: true,
				width: 700,
				height: 500,
				resizable: false,
				zIndex: 1000
			});
			modal.plug(
				A.Plugin.IO,
				{
					autoLoad: true,
					uri: '${cardURL}&<portlet:namespace/>fooId=' + id
				});

			modal.addToolbar(
				[
					{
						label: 'Cancel',
						on: {
							click: function () {
								modal.hide();
							}
						}
					},
					{
						label: 'Save',
						icon: 'icon-save',
						primary: true,
						on: {
							click: function () {
								$('form#<portlet:namespace/>fooForm').submit();
							}
						}
					}
				], 'footer'
			);

			modal.render();
		});


	}
</script>
<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<h4>History of Changes</h4>
