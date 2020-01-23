<%@ page import="ru.isands.akimov.search_helpers.impl.FooHistorySearchHelper" %>
<%@ page import="ru.isands.akimov.audit.attribute_adapters.FooAttributeAdapter" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<%
	FooHistorySearchHelper searchHelper = new FooHistorySearchHelper();
%>

<c:set var="historyEntries" value="<%=searchHelper.getResult()%>"/>

<%--request attribute: ${historyEntries}--%>

<h4>"Foo" change history</h4>

<div class="container-fluid">
	<div class="row">
		<div class="span12">
			<table class="table table-bordered table-hover table-striped">
				<thead class="table-columns">
				<tr>
					<th>Дата и время</th>
					<th>Пользователь</th>
					<th>Действие</th>
					<th>Атрибут</th>
					<th>Старое значение</th>
					<th>Новое значение</th>
				</tr>
				</thead>

				<tbody class="table-data">
				<c:if test="${empty historyEntries}">
					<tr>
						<td colspan="6" class="table-cell" style="color: gray; text-align: center; font-style: italic;">
							История изменений отсутствует
						</td>
					</tr>
				</c:if>

				<c:if test="${not empty historyEntries}">
					<c:forEach var="historyEntry" items="${historyEntries}">
						<tr>
							<td class="table-cell" rowspan="${historyEntry.changes.size() + 1}">
								<fmt:formatDate value="${historyEntry.dateOfChanges}"
												pattern="dd.MM.yyyy HH:mm:ss"
												timeZone="${timeZone}"/>
							</td>
							<td class="table-cell" rowspan="${historyEntry.changes.size() + 1}">
									${historyEntry.user.fullName}
							</td>
							<td class="table-cell" rowspan="${historyEntry.changes.size() + 1}">
									${historyEntry.description}
							</td>
						</tr>

						<c:set var="adapter" value="<%= new FooAttributeAdapter() %>"/>

						<c:forEach var="change" items="${historyEntry.changes}">
							<tr>
								<td class="table-cell">
									<liferay-ui:message key="${historyEntry.entityType}.field.${change.key}"/>
								</td>
								<td class="table-cell">${adapter.adapt(change.key, change.value.oldValue)}</td>
								<td class="table-cell">${adapter.adapt(change.key, change.value.newValue)}</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>