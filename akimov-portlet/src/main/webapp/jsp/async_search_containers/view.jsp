<%@ page import="ru.isands.akimov.enums.Gender" %>
<%@ page import="ru.isands.akimov.search_helpers.impl.AdaptedPersonSearchHelper" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.isands.akimov.search_helpers.impl.PersonSearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Async Search Container</h3>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<liferay-ui:search-container iteratorURL="<%=thisURL%>">
	<%
		new PersonSearchHelper(searchContainer);
	%>
	<liferay-ui:search-container-row className="ru.isands.akimov.model.Person">
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


<liferay-ui:search-container iteratorURL="<%=thisURL%>">
	<%
		new AdaptedPersonSearchHelper(searchContainer);
	%>
	<liferay-ui:search-container-row className="ru.isands.akimov.search_helpers.adapters.PersonEntryAdapter">
		<liferay-ui:search-container-column-text name="ФИО" property="fio"/>
		<liferay-ui:search-container-column-text name="gender" property="gender"/>
		<liferay-ui:search-container-column-text name="Дата рождения" property="birthDate"/>
		<liferay-ui:search-container-column-text name="Адрес проживания" property="address"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="false"/>
	<liferay-ui:search-paginator searchContainer="${searchContainer}" type="article"/>
</liferay-ui:search-container>