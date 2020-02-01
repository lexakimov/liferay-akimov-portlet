<%@ page import="static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="static ru.isands.akimov.constants.URLParams.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<h4>Async File Upload</h4>

<portlet:resourceURL var="uploadFileURL" id="<%=ASYNC_FILE_UPLOAD%>"/>
<%--
<form action="${uploadFileURL}" class="dropzone" id="my-awesome-dropzone">

</form>
--%>
<style>
	.uploader-filename {
		min-width: 200px;
	}

	#drop-area {
		border: 2px dashed #ccc;
		border-radius: 10px;
		box-sizing: border-box;
		text-align: center;
		font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
		font-size: 18px;
		margin: 20px auto;
		padding: 20px;
		transition-duration: 0.5s;
	}

	#drop-area.drag-and-drop-highlight {
		border-color: #50a2f5;
		background-color: #b3d8ed;
		transition-duration: 0.5s;
	}

	#fileElem {
		display: none;
	}
</style>


<div style="width: 500px;">
	<div id="drop-area">
		Перетащите файл на эту область
		<br/><br/>
		<label class="btn btn-small" for="fileElem">Выбрать файлы</label>
	</div>

	<progress id="progress-bar" max=100 value=0></progress>

	<input type="file" id="fileElem" multiple accept="image/*" onchange="handleFiles(this.files)">

	<table class="uploader table table-bordered table-hover table-striped">
		<thead class="table-columns">
		<tr>
			<th colspan="4">Загруженные файлы</th>
		</tr>
		<tr>
			<th class="uploader-filename">Файл</th>
			<th>Размер</th>
			<th colspan="3">Действия</th>
		</tr>
		</thead>
		<tbody class="table-data">
		<tr>
			<td class="table-cell">Пример.pdf</td>
			<td class="table-cell">12,3 мб</td>
			<td class="table-cell">
				<button class="btn btn-block btn-success" title="скачать">
					<i class="icon-download-alt"></i>
				</button>
			</td>
			<td class="table-cell">
				<button class="btn btn-block btn-danger" title="удалить">
					<i class="icon-remove"></i>
				</button>
			</td>
		</tr>

		</tbody>
	</table>
</div>

<script>
	var filesDone = 0;
	var filesToDo = 0;
	var progressBar = document.getElementById('progress-bar');

	function initializeProgress(numfiles) {
		progressBar.value = 0;
		filesDone = 0;
		filesToDo = numfiles;
	}

	function progressDone() {
		filesDone++;
		progressBar.value = filesDone / filesToDo * 100;
	}

	var dropArea = document.getElementById('drop-area');
	/*	dropArea.addEventListener('dragenter', handlerFunction, false);
		dropArea.addEventListener('dragleave', handlerFunction, false);
		dropArea.addEventListener('dragover', handlerFunction, false);
		dropArea.addEventListener('drop', handlerFunction, false);*/

	['dragenter', 'dragover', 'dragleave', 'drop'].forEach(function (eventName) {
		dropArea.addEventListener(eventName, preventDefaults, false)
	});

	;['dragenter', 'dragover'].forEach(function (eventName) {
		dropArea.addEventListener(eventName, highlight, false)
	});

	['dragleave', 'drop'].forEach(function (eventName) {
		dropArea.addEventListener(eventName, unhighlight, false)
	});

	function highlight(e) {
		dropArea.classList.add('drag-and-drop-highlight')
	}

	function unhighlight(e) {
		dropArea.classList.remove('drag-and-drop-highlight')
	}

	function preventDefaults(e) {
		e.preventDefault();
		e.stopPropagation()
	}


	dropArea.addEventListener('drop', handleDrop, false)


	function handleDrop(e) {
		var dt = e.dataTransfer;
		var files = dt.files;
		handleFiles(files)
	}

	function handleFiles(files) {
		initializeProgress(files.length);

		Array.prototype.forEach.call(files, function (file) {
			uploadFile(file);
		});
	}

	function uploadFile(file) {
		var url = '${uploadFileURL}';
		var formData = new FormData();
		formData.append('file', file);

		fetch(url, {
			method: 'POST',
			body: formData
		})
			.then(function () {
				console.log("файл " + file + " загружен");
				progressDone();
				/* Готово. Информируем пользователя */
			})
			.catch(function () {
				console.log("файл " + file + "не загружен");
				/* Ошибка. Информируем пользователя */
			})
	}

</script>
