package ru.akimov.servlets;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import ru.akimov.utils.TemporaryFileUploadUtil;
import ru.akimov.utils.TemporaryFileUploadUtil.TempFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * @author akimov
 * created at 08.02.2020 11:01
 */
@WebServlet(name = "tempFileUpload", urlPatterns = "/api/temp-file-upload")
@MultipartConfig
public class TemporaryFileUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType(ContentTypes.APPLICATION_JSON);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();

		Collection<Part> parts = req.getParts();

		if (parts.isEmpty()) {
			writer.print("[]");
			return;
		}

		File sessionStorage = TemporaryFileUploadUtil.initTempSessionStorage(req);
		JSONArray array = JSONFactoryUtil.createJSONArray();

		for (Part part : parts) {
			JSONObject fileEntry = JSONFactoryUtil.createJSONObject();
			String uuid = TemporaryFileUploadUtil.generateFileId();
			fileEntry.put("id", uuid);
			fileEntry.put("name", part.getName());
			fileEntry.put("size", part.getSize());
			array.put(fileEntry);

			InputStream uploadingFile = part.getInputStream();
			Path tempFilePath = Paths.get(sessionStorage.getPath(), uuid);
			Files.copy(uploadingFile, tempFilePath);

			Path tempFileMetaPath = Paths.get(sessionStorage.getPath(), uuid + ".meta");
			FileUtil.write(tempFileMetaPath.toFile(), fileEntry.toString());

			log("uploaded file: " + part.getName() + " as " + uuid);
		}
		writer.print(array.toString());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String fileId = ParamUtil.getString(req, "fileId");
		try {
			TemporaryFileUploadUtil.deleteFile(session, fileId);
			log("file: " + fileId + " removed");
		} catch (IOException e) {
			resp.setStatus(500);
			return;
		}
		resp.setStatus(200);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileId = ParamUtil.getString(req, "fileId");
		HttpSession session = req.getSession(true);
		TempFile tempFile = TemporaryFileUploadUtil.getFile(session, fileId);
		ServletResponseUtil.sendFile(req, resp, tempFile.getFileName(), tempFile.getInputStream());
	}

}
