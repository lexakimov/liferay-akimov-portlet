<%@ page import="ru.akimov.model.AuditEntry" %>
<%@ page import="ru.akimov.model.AuditEntryGroup" %>
<%@ page import="ru.akimov.search.helpers.impl.AuditGroupSearchHelper" %>
<%@ page import="ru.akimov.service.AuditEntryLocalServiceUtil" %>
<%@ page import="ru.akimov.search.SearchResultsBinder" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>User actions history</h4>

<div class="row-fluid">
	<div class="span12">
		<liferay-ui:search-container delta="20" iteratorURL="<%=thisURL%>"
									 emptyResultsMessage="Журнал действий пуст">
			<%
				SearchResultsBinder.bind(searchContainer, new AuditGroupSearchHelper());
			%>
			<liferay-ui:search-container-row
					className="ru.akimov.search.entry_adapters.impl.AuditGroupSearchEntryAdapter">
				<liferay-ui:search-container-column-text name="Дата и время">
					<fmt:formatDate value="${model.dateTime}"
									pattern="dd.MM.yyyy HH:mm:ss"
									timeZone="${timeZone}"/>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="Пользователь" property="userFullName"/>
				<liferay-ui:search-container-column-text name="Действия">
					<%
						final AuditEntryGroup wrappedModel = model.getWrappedModel();
						final List<AuditEntry> auditEntries =
								AuditEntryLocalServiceUtil.getByEntryGroupId(wrappedModel.getEntryGroupId());
						if (auditEntries.size() == 2) {
							out.println(auditEntries.get(0).getMetadata());
							out.println("<br>");
							out.println(auditEntries.get(1).getMetadata());
						} else {
							out.println(auditEntries.get(0).getAuditType());
						}
					%>

				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false"/>
			<liferay-ui:search-paginator searchContainer="${searchContainer}" type="regular"/>
		</liferay-ui:search-container>
	</div>
</div>
