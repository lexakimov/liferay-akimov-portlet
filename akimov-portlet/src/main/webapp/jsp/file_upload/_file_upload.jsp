<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_METHOD_PARAM" %>
<%@ page import="static ru.akimov.constants.PortletConstants.ASYNC_ACTION_RESOURCE_ID" %>
<%@ page import="static ru.akimov.constants.PortletConstants.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/jsp/init.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

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


<div id="app">

	<div v-bind:class="['drop-zone', isDragZoneActive ? 'active' : '']"
		 v-on:dragenter="isDragZoneActive = true"
		 v-on:dragleave="isDragZoneActive = false"
		 v-on:dragover.prevent
		 v-on:drop.prevent="addFile"
	>
		Перетащите файлы на эту область
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

			<input name="<portlet:namespace/>temp-file" v-bind:value="file.id" type="hidden"/>
			<td class="table-cell">{{ file.name }}</td>
			<td class="table-cell">{{ getSize(file) }}</td>
			<td class="table-cell">
				<button type="button" class="btn btn-block btn-success" title="скачать" v-on:click="downloadFile(file)">
					<i class="icon-download-alt"></i>
				</button>
			</td>
			<td class="table-cell">
				<button type="button" class="btn btn-block btn-danger" title="удалить" v-on:click="deleteFile(file)">
					<i class="icon-remove"></i>
				</button>
			</td>

		</tr>
		</tbody>
	</table>

	<pre>{{ $data }}</pre>

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
				let uploadedFiles = this.files;
				let droppedFiles = e.dataTransfer.files;
				if (!droppedFiles) {
					return;
				}

				let formData = new FormData();
				([...droppedFiles]).forEach(f => formData.append(f.name, f));

				axios
					.post(TEMP_FILE_UPLOAD_ENDPOINT, formData,
						{
							headers: {
								'Content-Type': 'multipart/form-data'
							}
						})
					.then(function (response) {
						([...response.data]).forEach(entry => {
							let newFileEntry = {
								id: entry.id,
								name: entry.name,
								size: entry.size,
								temporary: true
							};
							uploadedFiles.push(newFileEntry);
							console.log("uploaded file " + newFileEntry.name);
						});
					})
					.catch(function (error) {
						console.log("error: " + error);
					});
			},
			deleteFile: function (file) {
				console.log("deleteFile " + file.name);
				let confirmed = confirm("Удалить файл \"" + file.name + "\"");
				if (confirmed) {
					let uploadedFiles = this.files;
					axios
						.delete(TEMP_FILE_UPLOAD_ENDPOINT + "?fileId=" + file.id)
						.then(function (response) {
							console.log(response);
							uploadedFiles.splice(uploadedFiles.indexOf(file), 1);
						})
						.catch(function (error) {
							console.log("error: " + error);
						});
				}
			},
			downloadFile: function (file) {
				console.log("downloadFile " + file.name);
				window.location = TEMP_FILE_UPLOAD_ENDPOINT + "?fileId=" + file.id;
			}
		}
	});
</script>