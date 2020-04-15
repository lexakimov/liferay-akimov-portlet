<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

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


<div class="container">
	<h3>Bootstrap test</h3>

	<form>
		<fieldset>
			<legend>Legend</legend>
			<label>Label name</label>
			<input type="text" placeholder="Type something…">
			<span class="help-block">Example block-level help text here.</span>
			<label class="checkbox">
				<input type="checkbox"> Check me out
			</label>
			<button type="submit" class="btn">Submit</button>
		</fieldset>
	</form>

	<form class="form-horizontal">
		<div class="control-group">
			<label class="control-label" for="inputEmail">Email</label>
			<div class="controls">
				<input type="text" id="inputEmail" placeholder="Email">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">Password</label>
			<div class="controls">
				<input type="password" id="inputPassword" placeholder="Password">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox"> Remember me
				</label>
				<button type="submit" class="btn">Sign in</button>
			</div>
		</div>
	</form>

	<div class="input-prepend">
		<span class="add-on">@</span>
		<input class="span2" id="prependedInput" type="text" placeholder="Username">
	</div>
	<div class="input-append">
		<input class="span2" id="appendedInput" type="text">
		<span class="add-on">.00</span>
	</div>


	<div class="input-prepend input-append">
		<span class="add-on">$</span>
		<input class="span2" id="appendedPrependedInput" type="text">
		<span class="add-on">.00</span>
	</div>

	<div class="input-append">
		<input class="span2" id="appendedInputButton" type="text">
		<button class="btn" type="button">Go!</button>
	</div>

	<div class="input-append">
		<input class="span2" id="appendedInputButtons" type="text">
		<button class="btn" type="button">Search</button>
		<button class="btn" type="button">Options</button>
	</div>


	<div class="input-append">
		<input class="span2" id="appendedDropdownButton" type="text">
		<div class="btn-group">
			<button class="btn dropdown-toggle" data-toggle="dropdown">
				Action
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				...
			</ul>
		</div>
	</div>


	<input class="input-mini" type="text" placeholder=".input-mini">
	<input class="input-small" type="text" placeholder=".input-small">
	<input class="input-medium" type="text" placeholder=".input-medium">
	<input class="input-large" type="text" placeholder=".input-large">
	<input class="input-xlarge" type="text" placeholder=".input-xlarge">
	<input class="input-xxlarge" type="text" placeholder=".input-xxlarge">

	<input class="span1" type="text" placeholder=".span1">
	<input class="span2" type="text" placeholder=".span2">
	<input class="span3" type="text" placeholder=".span3">
	<select class="span1">
		...
	</select>
	<select class="span2">
		...
	</select>
	<select class="span3">
		...
	</select>

	<div class="control-group warning">
		<label class="control-label" for="inputWarning">Input with warning</label>
		<div class="controls">
			<input type="text" id="inputWarning">
			<span class="help-inline">Something may have gone wrong</span>
		</div>
	</div>

	<div class="control-group error">
		<label class="control-label" for="inputError">Input with error</label>
		<div class="controls">
			<input type="text" id="inputError">
			<span class="help-inline">Please correct the error</span>
		</div>
	</div>

	<div class="control-group info">
		<label class="control-label" for="inputInfo">Input with info</label>
		<div class="controls">
			<input type="text" id="inputInfo">
			<span class="help-inline">Username is already taken</span>
		</div>
	</div>

	<div class="control-group success">
		<label class="control-label" for="inputSuccess">Input with success</label>
		<div class="controls">
			<input type="text" id="inputSuccess">
			<span class="help-inline">Woohoo!</span>
		</div>
	</div>

	<div class="row show-grid">
		<div class="span2">span2</div>
		<div class="span2">span2</div>
		<div class="span2">span2</div>
		<div class="span2">span2</div>
		<div class="span2">span2</div>
		<div class="span2">span2</div>
	</div>

	<div class="row show-grid">
		<div class="span4">span4</div>
		<div class="span4">span4</div>
		<div class="span4">span4</div>
	</div>
	<div class="row show-grid">
		<div class="span6">span6</div>
		<div class="span6">span6</div>
	</div>
	<div class="row show-grid">
		<div class="span12">span12</div>
	</div>


	<h4>row</h4>
	<div class="row show-grid">
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
	<div class="row show-grid">
		<div class="span2">span2</div>
		<div class="span3">span3</div>
		<div class="span4">span4</div>
	</div>
	<div class="row show-grid">
		<div class="span4">span4</div>
		<div class="span5">span5</div>
	</div>
	<div class="row show-grid">
		<div class="span9">span9</div>
	</div>


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
