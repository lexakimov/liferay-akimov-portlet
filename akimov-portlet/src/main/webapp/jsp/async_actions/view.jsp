<%@ page import="ru.isands.akimov.search.PersonSearchHelper" %>
<%@ page import="ru.isands.akimov.enums.Gender" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Async Actions Portlet</h3>

<liferay-ui:search-container iteratorURL="<%=thisURL%>" delta="10">
	<liferay-ui:search-container-results>
		<%
			PersonSearchHelper searchHelper = new PersonSearchHelper();

			int start = searchContainer.getStart();
			int end = searchContainer.getEnd();

			searchContainer.setResults(searchHelper.getResult(start, end));
			searchContainer.setTotal(searchHelper.getTotal());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="ru.isands.akimov.model.Person">

		<liferay-ui:search-container-column-text name="lastName" property="lastName"/>
		<liferay-ui:search-container-column-text name="firstName" property="firstName"/>
		<liferay-ui:search-container-column-text name="middleName" property="middleName"/>

		<liferay-ui:search-container-column-text name="gender">
			<%= Gender.getByOrdinal(model.getGender()).getLabel()%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="address" property="address"/>
		<liferay-ui:search-container-column-text name="birthDate">
			<fmt:formatDate value="${model.birthDate}" pattern="dd.MM.yyyy"/>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" />
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="approximate"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="more"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="regular"/>

</liferay-ui:search-container>