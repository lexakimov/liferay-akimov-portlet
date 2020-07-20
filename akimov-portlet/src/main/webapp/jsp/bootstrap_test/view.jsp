<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<legend>Bootstrap test</legend>

<aui:nav-bar cssClass="navbar-inverse">
	<aui:nav cssClass="nav-tabs nav-stacked">
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
