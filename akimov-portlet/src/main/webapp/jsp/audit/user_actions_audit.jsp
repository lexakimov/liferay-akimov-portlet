<%@ page import="ru.akimov.search.helpers.impl.FooHistorySearchHelper" %>
<%@ page import="ru.akimov.search.helpers.impl.AuditSearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>


<%
	AuditSearchHelper searchHelper = new AuditSearchHelper();
%>

<c:set var="auditEntries" value="<%=searchHelper.getAdaptedResult()%>"/>

<%--request attribute: ${historyEntries}--%>

<h4>Users actions audit</h4>

<div class="container">
	<div class="row">
		<div class="span12">
			<table class="table table-bordered table-hover table-striped">
				<thead class="table-columns">
				<tr>
					<th>Дата и время</th>
					<th>Пользователь</th>
					<th>Действие</th>
				</tr>
				</thead>

				<tbody class="table-data">
				<c:if test="${empty auditEntries}">
					<tr>
						<td colspan="3" class="table-cell" style="color: gray; text-align: center; font-style: italic;">
							Журнал действий пуст
						</td>
					</tr>
				</c:if>

				<c:if test="${not empty auditEntries}">
					<c:forEach var="historyEntry" items="${auditEntries}">
						<tr>
							<td class="table-cell">
								<fmt:formatDate value="${historyEntry.dateOfChange}"
												pattern="dd.MM.yyyy HH:mm:ss"
												timeZone="${timeZone}"/>
							</td>
							<td class="table-cell">${historyEntry.userFullName}</td>
							<td class="table-cell">${historyEntry.description}</td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>