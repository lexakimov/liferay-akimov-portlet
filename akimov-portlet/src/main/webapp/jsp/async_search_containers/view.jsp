<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="ru.isands.akimov.enums.Gender" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.isands.akimov.search_helpers.PersonSearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Async Search Container</h3>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<liferay-ui:search-container iteratorURL="<%=thisURL%>">
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

		<liferay-ui:search-container-column-text name="Фамилия" property="lastName"/>
		<liferay-ui:search-container-column-text name="Имя" property="firstName"/>
		<liferay-ui:search-container-column-text name="Отчество" property="middleName"/>

		<liferay-ui:search-container-column-text name="gender">
			<%= Gender.getByOrdinal(model.getGender()).getLabel()%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Дата рождения">
			<fmt:formatDate value="${model.birthDate}" pattern="dd.MM.yyyy"/>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="address" property="address"/>


	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="approximate"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="more"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="regular"/>

</liferay-ui:search-container>