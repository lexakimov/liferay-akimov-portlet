<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="ru.isands.akimov.enums.Gender" %>
<%@ page import="ru.isands.akimov.search.helpers.impl.PersonSearchHelper" %>
<%@ page import="static com.liferay.portal.kernel.util.JavaConstants.JAVAX_SERVLET_INCLUDE_SERVLET_PATH" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<%--
http://anilgurjar.blogspot.com/2012/08/search-container-with-pagination-on.html
--%>

<%
	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(LiferayWindowState.NORMAL);
	//current page path
	renderURL.setParameter("mvcPath", (String) request.getAttribute(JAVAX_SERVLET_INCLUDE_SERVLET_PATH));
	//renderURL.setParameter("username", username);
	//renderURL.setParameter("firstname", firstname);
	//renderURL.setParameter("lastname", lastname);
	//PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
%>

<div id="searchUsersWrapper" class="bordered-block-2">
	<liferay-ui:search-container delta="5" iteratorURL="<%= renderURL %>">
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
		<liferay-ui:search-iterator type="article"/>
	</liferay-ui:search-container>
</div>

<%--<script>
	// AUI - style
	AUI().use("aui-io-plugin-deprecated", function (A) {
		var searchUsers = A.one('#searchUsersWrapper');
		searchUsers.plug(A.Plugin.IO, {
			autoLoad: false,
			showLoading: false
		});

		searchUsers.all('a').on('click', function (event) {
			event.preventDefault();
			var uri = event.currentTarget.get('href').replace(/p_p_state=normal/i, 'p_p_state=exclusive');
			searchUsers.io.set('uri', uri);
			searchUsers.io.on('success', function (e) {
				console.log(e);
				searchUsers.get('children').unwrap();
			});
			searchUsers.io.start();
		});
	});
</script>--%>

<script>
	// jQuery - style
	$('#searchUsersWrapper a').on('click', function (event) {
		event.preventDefault();
		var $searchContainerDiv = $('#searchUsersWrapper');
		var uri = event.target.href.replace(/p_p_state=normal/i, 'p_p_state=exclusive');
		// bug: script section is duplicates each click
		$searchContainerDiv.load(uri, null, function (data) {
			$searchContainerDiv.children().unwrap();
		});

		/*$.get(uri, null, function (data) {
			$searchContainerDiv.html($(data).get(0));
			//$searchContainerDiv.children().children().unwrap();
		});*/
	});
</script>
