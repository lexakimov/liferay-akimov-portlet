<%@ page import="ru.akimov.search.helpers.impl.AuditSearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>User actions history</h4>

<div class="container">
	<div class="row">
		<div class="span12">
			<liferay-ui:search-container delta="20" iteratorURL="<%=thisURL%>"
										 emptyResultsMessage="Журнал действий пуст">
				<%
					new AuditSearchHelper(searchContainer);
				%>
				<liferay-ui:search-container-row
						className="ru.akimov.search.entry_adapters.impl.AuditSearchEntryAdapter">
					<liferay-ui:search-container-column-text name="Дата и время">
						<fmt:formatDate value="${model.dateOfChange}"
										pattern="dd.MM.yyyy HH:mm:ss"
										timeZone="${timeZone}"/>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Пользователь" property="userFullName"/>
					<liferay-ui:search-container-column-text name="Действие" property="description"/>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator paginate="false"/>
				<liferay-ui:search-paginator searchContainer="${searchContainer}" type="regular"/>
			</liferay-ui:search-container>
		</div>
	</div>
</div>