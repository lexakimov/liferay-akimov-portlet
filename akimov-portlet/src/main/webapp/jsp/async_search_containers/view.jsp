<%@ page import="ru.akimov.enums.Gender" %>
<%@ page import="ru.akimov.search.helpers.impl.AdaptedPersonSearchHelper" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.akimov.search.helpers.impl.BasicSqlSearchHelper" %>
<%@ page import="ru.akimov.search.helpers.impl.PersonSearchHelper" %>
<%@ page import="ru.akimov.search.SearchResultsBinder" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<div class="container">
	<legend>Async Search Container</legend>
	<jsp:include page="async_search_container.jsp"/>
	<%--------------------------------------------------------------------------------------------------------------------%>

	<legend>Search Helpers</legend>
	<liferay-ui:search-container delta="5" iteratorURL="<%=thisURL%>" curParam="general">
		<%
			SearchResultsBinder.bind(searchContainer, new PersonSearchHelper());
		%>
		<liferay-ui:search-container-row className="ru.akimov.model.Person">
			<liferay-ui:search-container-column-text name="Фамилия" property="lastName" cssClass="no-hover no-stripes"/>
			<liferay-ui:search-container-column-text name="Имя" property="firstName" cssClass="no-hover no-stripes"/>
			<liferay-ui:search-container-column-text name="Отчество" property="middleName" cssClass="no-hover no-stripes"/>
			<liferay-ui:search-container-column-text name="gender"
													 value="<%= Gender.getByOrdinal(model.getGender()).getLabel()%>"
													 cssClass="no-hover no-stripes"/>
			<liferay-ui:search-container-column-text name="Дата рождения" cssClass="no-hover no-stripes">
				<fmt:formatDate value="${model.birthDate}" pattern="dd.MM.yyyy"/>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Адрес проживания" property="address"
													 cssClass="no-hover no-stripes"/>
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
			SearchResultsBinder.bind(searchContainer, new AdaptedPersonSearchHelper());
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
			SearchResultsBinder.bind(searchContainer, new BasicSqlSearchHelper());
		%>
		<liferay-ui:search-container-row className="ru.akimov.search.entry_dto.impl.SqlEntity">
			<liferay-ui:search-container-column-text name="Имя" property="firstName"
													 orderable="true" orderableProperty="firstName"/>
			<liferay-ui:search-container-column-text name="Фамилия" property="lastName"
													 orderable="true" orderableProperty="lastName"/>
			<liferay-ui:search-container-column-text name="Дата рождения"
													 orderable="true" orderableProperty="birthDate">
				<fmt:formatDate value="${model.birthDate}" pattern="dd.MM.yyyy"/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</div>