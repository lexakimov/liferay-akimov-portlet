<%@ page import="static ru.akimov.constants.URLParams.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.URLParams.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="static ru.akimov.constants.URLParams.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<h4>Async File Upload</h4>

<portlet:resourceURL var="uploadFileURL" id="<%=ASYNC_FILE_UPLOAD%>"/>
<%--
<form action="${uploadFileURL}" class="dropzone" id="my-awesome-dropzone">

</form>
--%>
<style>
	.drop-zone {
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

	.drop-zone.active {
		border-color: #50a2f5;
		background-color: #b3d8ed;
		transition-duration: 0.5s;
	}

	.uploader-filename {
		min-width: 200px;
	}
</style>

<div id="app" style="width: 500px;">

	<pre>{{ $data }}</pre>

	<div v-bind:class="['drop-zone', isDragZoneActive ? 'active' : '']"
		 v-on:dragenter="isDragZoneActive = true"
		 v-on:dragleave="isDragZoneActive = false"
		 v-on:dragover.prevent
		 v-on:drop.prevent="addFile"
	>

		Перетащите файл на эту область
		<%--<br/><br/>
		<input id="fileElem" type="hidden">
		<label class="btn btn-small" for="fileElem">Выбрать файлы</label>--%>
	</div>

	<table v-show="files.length > 0" class="table table-bordered table-hover table-striped">
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


		<tr v-for="file in files">
			<input v-show="file.id" v-bind:name="file.id" type="hidden"/>
			<td class="table-cell">{{ file.name }}</td>
			<td class="table-cell">{{ getSize(file) }}</td>
			<td class="table-cell">
				<button class="btn btn-block btn-success" title="скачать" v-on:click="downloadFile(file)">
					<i class="icon-download-alt"></i>
				</button>
			</td>
			<td class="table-cell">
				<button class="btn btn-block btn-danger" title="удалить" v-on:click="deleteFile(file)">
					<i class="icon-remove"></i>
				</button>
			</td>
		</tr>

		</tbody>
	</table>

</div>

<script>
	let vm = new Vue({
		el: '#app',
		data: {
			isDragZoneActive: false,
			files: []
		},
		computed: {},
		methods: {
			getSize: function (file) {
				return fileSizeHumanReadable(file.size);
			},
			addFile: function (e) {
				this.isDragZoneActive = false;

				let formData = new FormData();

				// <input name="temp-file--input-name" value="uuid"

				let droppedFiles = e.dataTransfer.files;
				if (!droppedFiles) return;
				([...droppedFiles]).forEach(f => {

					let uuid = uuidv4();

					formData.append('file', this.file);

					let entry = {
						id: uuid,
						name: f.name,
						size: f.size,
						temporary: true
					};
					this.files.push(entry);
				});
			},
			deleteFile: function (file) {
				let confirmed = confirm("Удалить файл \"" + file.name + "\"");
				if (confirmed)
					this.files.splice(this.files.indexOf(file), 1);
			},
			downloadFile: function (file) {
				console.log("downloadFile");
			},

		}
	});


	function fileSizeHumanReadable(bytes) {
		let thresh = 1024;
		if (Math.abs(bytes) < thresh) {
			return bytes + ' Б';
		}
		let units = ['кб', 'мб', 'гб'];
		let u = -1;
		do {
			bytes /= thresh;
			++u;
		} while (Math.abs(bytes) >= thresh && u < units.length - 1);
		return bytes.toFixed(2) + ' ' + units[u];
	}

	function uuidv4() {
		return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
			let r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
			return v.toString(16);
		});
	}

</script>