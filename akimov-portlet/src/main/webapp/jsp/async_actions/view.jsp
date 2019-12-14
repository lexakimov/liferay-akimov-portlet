<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="ru.isands.akimov.enums.Gender" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="ru.isands.akimov.search_helpers.PersonSearchHelper" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h3>Async Actions Portlet</h3>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>

<aui:button name="execAction1" value="Execute action" primary="true"/>

<portlet:resourceURL var="urlName" id="<%=ASYNC_ACTION_RESOURCE_ID%>">
	<portlet:param name="<%=ASYNC_ACTION_METHOD_PARAM%>" value="simpleAsyncAction"/>
	<portlet:param name="custom_param1" value="value 1233"/>
</portlet:resourceURL>

<script>
	$(function () {
		var callback = function () {
			alert("done!");
		};

		var $button = $("button#<portlet:namespace/>execAction1");

		$button.click(function () {
			asyncAction('${urlName}', {callback: callback});
		});
	});
</script>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>reload by button</h4>

<div id="reloadableElement" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloadingURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<aui:button name="reload1" value="ReloadContent" primary="true"/>

<script>
	$(function () {
		var reloadableElement = $('div#reloadableElement');

		var $button = $("button#<portlet:namespace/>reload1");

		$button.click(function () {
			reloadElementContent(reloadableElement, '${reloadingURL}');
		});
	});
</script>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>auto reload by setInterval</h4>

<div id="reloadableElement2" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloading2URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<script>
	$(function () {
		var reloadableElement = $('div#reloadableElement2');

		setInterval(function () {
			reloadElementContent(reloadableElement, '${reloading2URL}');
		}, 500);
	});
</script>

<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>reload with effects by button</h4>

<div id="reloadableElement3" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloading3URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
</portlet:renderURL>

<aui:button name="reload3" value="ReloadContent" primary="true"/>

<script>
	$(function () {
		var reloadableElement = $('div#reloadableElement3');

		var $button = $("button#<portlet:namespace/>reload3");

		$button.click(function () {
			reloadElementContentAdvanced(reloadableElement, '${reloading3URL}');
		});
	});
</script>


<%--------------------------------------------------------------------------------------------------------------------%>
<div class="separator"></div><%---------------------------------------------------------------------------------------%>
<%--------------------------------------------------------------------------------------------------------------------%>
<h4>reload (longtime) with effects by button</h4>

<div id="reloadableElement4" class="bordered" style="width: 400px; display: inline-block;">
	<jsp:include page="reloadable_element.jsp"/>
</div>

<portlet:renderURL var="reloading4URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
	<portlet:param name="long_time_render" value="true"/>
</portlet:renderURL>

<aui:button name="reload4" value="ReloadContent" primary="true"/>

<script>
	$(function () {
		var reloadableElement = $('div#reloadableElement4');

		var $button = $("button#<portlet:namespace/>reload4");

		$button.click(function () {
			reloadElementContentAdvanced(reloadableElement, '${reloading4URL}');
		});
	});
</script>

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