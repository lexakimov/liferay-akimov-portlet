<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h1>Заголовок первого уровня</h1>
<h2>Заголовок второго уровня</h2>
<h3>Заголовок третьего уровня</h3>
<h4>Заголовок четвертого уровня</h4>

<p>
	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend
	lectus sed nisi posuere venenatis. Aenean a dapibus tortor. Aliquam erat volutpat. Cras ut dui elementum quam
	ultrices malesuada ac eu orci. Mauris malesuada risus sit amet lorem tempus, elementum porttitor mauris
</p>

<div class="separator"></div>


<liferay-ui:toggle-area id="toggle_id_message_boards_view_message_thread">
	<div class="toggle_id_message_boards_view_message_thread">
		table
	</div>
</liferay-ui:toggle-area>
<div
		class="toggle_id_message_boards_view_message_thread"
		id="toggle_id_message_boards_view_message_thread"
		style="display: <liferay-ui:toggle-value id="toggle_id_message_boards_view_message_thread"/>;">
	hhhjhjjjh
</div>

<div class="separator"></div>

<div>
	<liferay-ui:toggle
			id="toggleId-123"
			hideMessage='hide-syntax-help&raquo;'
			showMessage='&laquo;show-message'
			defaultShowContent="false"
	/>
</div>

<div id="toggleId-123">
	<aui:row>
		<aui:col span="3">32323</aui:col>
		<aui:col span="3">32323</aui:col>
		<aui:col span="3">32323</aui:col>
	</aui:row>
</div>

<%--<script>
	AUI().use("aui-base", function () {
		var CSS_EDITOR_WIDTH = 'span8';

		var CSS_EDITOR_WIDTH_EXPANDED = 'span12';

		Liferay.on(
			'toggle:stateChange',
			function (event) {
				var id = event.id;

				if (id === 'toggleId-123') {
					var state = event.state;

					var classSrc = CSS_EDITOR_WIDTH;
					var classDest = CSS_EDITOR_WIDTH_EXPANDED;

					var visible = (state === 1);

					if (visible) {
						classSrc = CSS_EDITOR_WIDTH_EXPANDED;
						classDest = CSS_EDITOR_WIDTH;
					}

					var editorContainer = A.one('#<portlet:namespace/>wikiEditorContainer');

					editorContainer.replaceClass(classSrc, classDest);

					if (visible && A.UA.webkit) {
						var editorFrame = editorContainer.one('iframe');

						if (editorFrame) {
							editorFrame.hide();

							A.later(0, editorFrame, 'show');
						}
					}

					var editorInstance = window['<portlet:namespace/>editor'];

					if (editorInstance) {
						editorInstance.focus();
					}
				}
			}
		);
	});
</script>--%>

<%--<aui:component module="aui-button-item" name="ButtonItem" tagPageContext="<%= pageContext %>"/>--%>

<div class="separator"></div>

<aui:nav-bar>
	<aui:nav cssClass="nav-tabs<%-- nav-stacked--%>">
		<aui:nav-item id="testtest1" dropdown="true" label="actions">
			<aui:nav-item iconCssClass="icon-remove" label="delete"/>
			<aui:nav-item iconCssClass="icon-random" label="merge"/>

			<aui:nav-item id="testtest2" dropdown="true" label="actions">
				<aui:nav-item iconCssClass="icon-remove" label="delete"/>

				<aui:nav-item id="testtest3" dropdown="true" label="actions">
					<aui:nav-item iconCssClass="icon-remove" label="delete"/>
					<aui:nav-item iconCssClass="icon-random" label="merge"/>

					<aui:nav-item id="testtest4" dropdown="true" label="actions">
						<aui:nav-item iconCssClass="icon-remove" label="delete"/>
						<aui:nav-item iconCssClass="icon-random" label="merge"/>
						<aui:nav-item iconCssClass="icon-random" label="merge"/>
						<aui:nav-item iconCssClass="icon-random" label="merge"/>
					</aui:nav-item>

					<aui:nav-item iconCssClass="icon-random" label="merge"/>
					<aui:nav-item iconCssClass="icon-random" label="merge"/>

				</aui:nav-item>

				<aui:nav-item iconCssClass="icon-random" label="merge"/>
			</aui:nav-item>

		</aui:nav-item>

		<aui:nav-item id="testtest5" dropdown="true" label="actions">
			<aui:nav-item iconCssClass="icon-remove" label="delete"/>
			<aui:nav-item iconCssClass="icon-random" label="merge"/>
		</aui:nav-item>

		<aui:nav-item anchorId='controlPanelSubNav12Link' href="#" label="1231231" selected="false"/>

		<aui:nav-item label="1231231" href="#"/>
		<aui:nav-item label="1231231" href="#"/>
		<aui:nav-item label="1231231" href="#"/>
	</aui:nav>
</aui:nav-bar>

<div class="separator"></div>

<div id="toggler-1">

	<div class="toggler-header-1 has-child">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit.
	</div>
	<div class="toggler-content-1">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend
		lectus sed nisi posuere venenatis. Aenean a dapibus tortor. Aliquam erat volutpat. Cras ut dui elementum quam
		ultrices malesuada ac eu orci. Mauris malesuada risus sit amet lorem tempus, elementum porttitor mauris
		pulvinar. Vestibulum laoreet ante orci, sit amet viverra dolor pretium non. Cras lacus dolor, dignissim
		convallis lacinia ac, mattis sit amet augue. In tincidunt elit ac augue porttitor tempor a eget lectus. Ut
		eleifend odio est, nec ullamcorper purus venenatis vitae. Vestibulum et odio mauris. Interdum et malesuada fames
		ac ante ipsum primis in faucibus. Sed laoreet consequat pharetra. Cras sit amet elit non eros faucibus
		euismod.
	</div>

	<div class="toggler-header-1 toggler-header">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit.
	</div>

	<div class="toggler-header-1 has-child">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit.
	</div>
	<div class="toggler-content-1" id="toggler-2">
		<div class="toggler-header-2 has-child">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit.
		</div>
		<div class="toggler-content-2">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend
			lectus sed nisi posuere venenatis. Aenean a dapibus tortor. Aliquam erat volutpat. Cras ut dui elementum
			quam
			ultrices malesuada ac eu orci. Mauris malesuada risus sit amet lorem tempus, elementum porttitor mauris
			pulvinar. Vestibulum laoreet ante orci, sit amet viverra dolor pretium non. Cras lacus dolor, dignissim
			convallis lacinia ac, mattis sit amet augue. In tincidunt elit ac augue porttitor tempor a eget lectus. Ut
			eleifend odio est, nec ullamcorper purus venenatis vitae. Vestibulum et odio mauris. Interdum et malesuada
			fames
			ac ante ipsum primis in faucibus. Sed laoreet consequat pharetra. Cras sit amet elit non eros faucibus
			euismod.
		</div>

		<div class="toggler-header-2 has-child">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit.
		</div>
		<div class="toggler-content-2">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend
			lectus sed nisi posuere venenatis. Aenean a dapibus tortor. Aliquam erat volutpat. Cras ut dui elementum
			quam
			ultrices malesuada ac eu orci. Mauris malesuada risus sit amet lorem tempus, elementum porttitor mauris
			pulvinar. Vestibulum laoreet ante orci, sit amet viverra dolor pretium non. Cras lacus dolor, dignissim
			convallis lacinia ac, mattis sit amet augue. In tincidunt elit ac augue porttitor tempor a eget lectus. Ut
			eleifend odio est, nec ullamcorper purus venenatis vitae. Vestibulum et odio mauris. Interdum et malesuada
			fames
			ac ante ipsum primis in faucibus. Sed laoreet consequat pharetra. Cras sit amet elit non eros faucibus
			euismod.
		</div>

	</div>

	<div class="toggler-header-1 has-child">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit.
	</div>
	<div class="toggler-content-1">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend
		lectus sed nisi posuere venenatis. Aenean a dapibus tortor. Aliquam erat volutpat. Cras ut dui elementum quam
		ultrices malesuada ac eu orci. Mauris malesuada risus sit amet lorem tempus, elementum porttitor mauris
		pulvinar. Vestibulum laoreet ante orci, sit amet viverra dolor pretium non. Cras lacus dolor, dignissim
		convallis lacinia ac, mattis sit amet augue. In tincidunt elit ac augue porttitor tempor a eget lectus. Ut
		eleifend odio est, nec ullamcorper purus venenatis vitae. Vestibulum et odio mauris. Interdum et malesuada fames
		ac ante ipsum primis in faucibus. Sed laoreet consequat pharetra. Cras sit amet elit non eros faucibus
		euismod.
	</div>

</div>

<script>
	YUI().use(
		'aui-toggler',
		function (Y) {
			new Y.TogglerDelegate(
				{
					container: '#toggler-1',
					header: '.toggler-header-1.has-child',
					content: '.toggler-content-1',
					animated: true,
					expanded: false,
					closeAllOnExpand: true
				}
			);

			new Y.TogglerDelegate(
				{
					container: '#toggler-2',
					header: '.toggler-header-2.has-child',
					content: '.toggler-content-2',
					animated: true,
					expanded: false,
					closeAllOnExpand: true
				}
			);
		}
	);
</script>

<h3>Bootstrap test</h3>

<style>
	.show-grid {
		margin-top: 10px;
		margin-bottom: 20px;
	}

	.show-grid [class*="span"] {
		background-color: #eee;
		text-align: center;
		-webkit-border-radius: 3px;
		-moz-border-radius: 3px;
		border-radius: 3px;
		min-height: 40px;
		line-height: 40px;
	}

	.show-grid [class*="span"]:hover {
		background-color: #ddd;
	}

	.show-grid .show-grid {
		margin-top: 0;
		margin-bottom: 0;
	}

	.show-grid .show-grid [class*="span"] {
		margin-top: 5px;
	}

	.show-grid [class*="span"] [class*="span"] {
		background-color: #ccc;
	}

	.show-grid [class*="span"] [class*="span"] [class*="span"] {
		background-color: #999;
	}
</style>

<div class="separator"></div>

<aui:container>
	<aui:row cssClass="show-grid">
		<aui:col span="3">123123123</aui:col>
		<aui:col span="3">123123123</aui:col>
		<aui:col span="3">123123123</aui:col>
		<aui:col span="3">123123123</aui:col>
	</aui:row>
	<aui:row cssClass="show-grid">
		<aui:col span="3">123123123</aui:col>
		<aui:col span="2" offset="3">123123123</aui:col>
		<aui:col span="3">123123123</aui:col>
	</aui:row>
	<aui:row cssClass="show-grid">
		<aui:col span="3">123123123</aui:col>
		<aui:col span="3">123123123</aui:col>
		<aui:col span="3" offset="1">123123123</aui:col>
	</aui:row>
</aui:container>

<h3>row fluid</h3>

<div class="row-fluid show-grid">
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
	<div class="span1">span1</div>
</div>
<div class="row-fluid show-grid">
	<div class="span4">span4</div>
	<div class="span4">span4</div>
	<div class="span4">span4</div>
</div>
<div class="row-fluid show-grid">
	<div class="span4">span4</div>
	<div class="span8">span8</div>
</div>
<div class="row-fluid show-grid">
	<div class="span6">span6</div>
	<div class="span6">span6</div>
</div>
<div class="row-fluid show-grid">
	<div class="span12">span12</div>
</div>

<h3>container</h3>
<div class="container">
	<h4>row fluid</h4>
	<div class="row-fluid show-grid">
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span4">span4</div>
		<div class="span4">span4</div>
		<div class="span4">span4</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span4">span4</div>
		<div class="span8">span8</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span6">span6</div>
		<div class="span6">span6</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span12">span12</div>
	</div>
</div>

<h3>container-fluid</h3>
<div class="container-fluid">
	<h4>row fluid</h4>
	<div class="row-fluid show-grid">
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
		<div class="span1">span1</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span4">span4</div>
		<div class="span4">span4</div>
		<div class="span4">span4</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span4">span4</div>
		<div class="span8">span8</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span6">span6</div>
		<div class="span6">span6</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span12">span12</div>
	</div>
</div>
