<%@ page import="ru.isands.akimov.audit.attribute_adapters.FooAttributeValueAdapter" %>
<%@ page import="ru.isands.akimov.search.helpers.impl.FooHistorySearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<%
	FooHistorySearchHelper searchHelper = new FooHistorySearchHelper();
%>

<c:set var="historyEntries" value="<%=searchHelper.getResult()%>"/>

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
					<c:set var="adapter" value="<%= new FooAttributeValueAdapter() %>"/>

					<c:forEach var="historyEntry" items="${historyEntries}">
						<c:set var="rowSpan"
							   value="${historyEntry.changes.size() > 1 ? historyEntry.changes.size() : 1}"/>
						<tr>
						<td class="table-cell" rowspan="${rowSpan}">
							<fmt:formatDate value="${historyEntry.dateOfChanges}"
											pattern="dd.MM.yyyy HH:mm:ss"
											timeZone="${timeZone}"/>
						</td>

						<td class="table-cell" rowspan="${rowSpan}">${historyEntry.user.fullName}</td>

						<td class="table-cell" rowspan="${rowSpan}">${historyEntry.description}</td>

						<c:forEach var="change" items="${historyEntry.changes}">
							<td class="table-cell">
								<liferay-ui:message key="${historyEntry.entityType}.field.${change.key}"/>
							</td>
							<td class="table-cell">${adapter.adapt(change.key, change.value.oldValue)}</td>
							<td class="table-cell">${adapter.adapt(change.key, change.value.newValue)}</td>
							<tr/>
						</c:forEach>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>