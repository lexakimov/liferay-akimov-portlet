<%@ page import="ru.akimov.search.helpers.impl.FooSearchHelper" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.akimov.search.SearchResultsBinder" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>List of "Foo" entities</h4>

<aui:button-row>
	<aui:button name="openFooCardBtn" icon="icon-plus" value="Create new" primary="true"/>
</aui:button-row>

<liferay-ui:search-container iteratorURL="<%=thisURL%>" emptyResultsMessage="empty">
	<%
		SearchResultsBinder.bind(searchContainer, new FooSearchHelper());
	%>
	<liferay-ui:search-container-row className="ru.akimov.model.Foo">
		<liferay-ui:search-container-column-text property="fooId"/>
		<liferay-ui:search-container-column-text name="foo.field.booleanField" property="booleanField"/>
		<liferay-ui:search-container-column-text name="foo.field.shortField" property="shortField"/>
		<liferay-ui:search-container-column-text name="foo.field.intField" property="intField"/>
		<liferay-ui:search-container-column-text name="foo.field.longField" property="longField"/>
		<liferay-ui:search-container-column-text name="foo.field.doubleField" property="doubleField"/>
		<liferay-ui:search-container-column-text name="foo.field.floatField" property="floatField"/>
		<liferay-ui:search-container-column-text name="foo.field.stringField" property="stringField"/>
		<liferay-ui:search-container-column-text name="foo.field.status" property="status"/>
		<liferay-ui:search-container-column-text name="foo.field.dateField">
			<fmt:formatDate value="${model.dateField}" pattern="dd.MM.yyyy HH:mm"/>
		</liferay-ui:search-container-column-text>

		<portlet:actionURL var="deleteURL" name="deleteFoo">
			<portlet:param name="fooId" value="${model.fooId}"/>
		</portlet:actionURL>

		<liferay-ui:search-container-column-text>
			<div class="btn-group text-center" style="width: 100%">
				<aui:button value="Edit"
							name="edit"
							primary="true"
							cssClass="btn-small"
							onClick="openDialog(${model.fooId});"/>
				<aui:button value="Delete"
							name="delete"
							primary="true"
							cssClass="btn-small"
							href="${deleteURL}"/>
			</div>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	<%--<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>--%>
</liferay-ui:search-container>

<portlet:renderURL var="cardURL" windowState="EXCLUSIVE">
	<portlet:param name="mvcPath" value="/jsp/audit/foo_card.jsp"/>
</portlet:renderURL>

<script>
	$(function () {
		$("button#<portlet:namespace/>openFooCardBtn").click(function () {
			openDialog(0);
		});
	});

	function openDialog(id) {

		AUI().ready('aui-modal', 'aui-io-plugin-deprecated', function (A) {
			let modal = new A.Modal({
				modal: true,
				headerContent: '<h4>Foo</h4>',
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
