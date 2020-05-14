<%@ page import="ru.akimov.enums.Gender" %>
<%@ page import="ru.akimov.search.helpers.impl.AdaptedPersonSearchHelper" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.akimov.search.helpers.impl.BasicSqlSearchHelper" %>
<%@ page import="ru.akimov.search.helpers.impl.PersonSearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<div class="container">
	<legend>Async Search Container</legend>
	<jsp:include page="async_search_container.jsp"/>
	<%--------------------------------------------------------------------------------------------------------------------%>

	<legend>Search Helpers</legend>
	<liferay-ui:search-container delta="5" iteratorURL="<%=thisURL%>" curParam="general">
		<%
			new PersonSearchHelper(searchContainer);
		%>
		<liferay-ui:search-container-row className="ru.akimov.model.Person">
			<liferay-ui:search-container-column-text name="Фамилия" property="lastName"/>
			<liferay-ui:search-container-column-text name="Имя" property="firstName"/>
			<liferay-ui:search-container-column-text name="Отчество" property="middleName"/>
			<liferay-ui:search-container-column-text name="gender"
													 value="<%= Gender.getByOrdinal(model.getGender()).getLabel()%>"/>
			<liferay-ui:search-container-column-text name="Дата рождения">
				<fmt:formatDate value="${model.birthDate}" pattern="dd.MM.yyyy"/>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Адрес проживания" property="address"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="false"/>
		<liferay-ui:search-paginator searchContainer="${searchContainer}" type="approximate"/>
		<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>
		<liferay-ui:search-paginator searchContainer="${searchContainer}" type="more"/>
		<liferay-ui:search-paginator searchContainer="${searchContainer}" type="regular"/>
	</liferay-ui:search-container>
	<%--------------------------------------------------------------------------------------------------------------------%>

	<legend>Adapted Search Helpers</legend>
	<liferay-ui:search-container delta="5" iteratorURL="<%=thisURL%>" curParam="adapted">
		<%
			new AdaptedPersonSearchHelper(searchContainer);
		%>
		<liferay-ui:search-container-row className="ru.akimov.search.entry_adapters.impl.PersonSearchEntryAdapter">
			<liferay-ui:search-container-column-text name="ФИО" property="fio"/>
			<liferay-ui:search-container-column-text name="gender" property="gender"/>
			<liferay-ui:search-container-column-text name="Дата рождения" property="birthDate"/>
			<liferay-ui:search-container-column-text name="Адрес проживания" property="address"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="false"/>
		<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>
	</liferay-ui:search-container>
	<%--------------------------------------------------------------------------------------------------------------------%>

	<legend>SQL-Based Search Helpers</legend>
	<liferay-ui:search-container delta="5" iteratorURL="<%=thisURL%>" curParam="sql-based">
		<%
			new BasicSqlSearchHelper(searchContainer);
		%>
		<liferay-ui:search-container-row className="ru.akimov.search.entry_adapters.impl.SqlEntity">
			<liferay-ui:search-container-column-text name="Имя" property="firstName"
													 orderable="true" orderableProperty="firstName"/>
			<liferay-ui:search-container-column-text name="Фамилия" property="lastName"
													 orderable="true" orderableProperty="lastName"/>
			<liferay-ui:search-container-column-text name="Дата рождения"
													 orderable="true" orderableProperty="birthDate">
				<fmt:formatDate value="${model.birthDate}" pattern="dd.MM.yyyy"/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="false"/>
		<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>
	</liferay-ui:search-container>
</div>

<%--

<%
	SearchContainer<SqlEntity> searchContainer222 = new BasicSqlSearchContainer(new BasicSqlSearchHelper());
%>

<liferay-ui:search-container searchContainer="<%= searchContainer222 %>">
	<liferay-ui:search-container-row className="SqlEntity">
		<liferay-ui:search-container-column-text name="Имя" property="firstName"
												 orderable="true" orderableProperty="firstName"/>
		<liferay-ui:search-container-column-text name="Фамилия" property="lastName"
												 orderable="true" orderableProperty="lastName"/>
		<liferay-ui:search-container-column-text name="Дата рождения"
												 orderable="true" orderableProperty="birthDate">
			<fmt:formatDate value="${model.birthDate}" pattern="dd.MM.yyyy"/>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="false"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>
</liferay-ui:search-container>--%>
