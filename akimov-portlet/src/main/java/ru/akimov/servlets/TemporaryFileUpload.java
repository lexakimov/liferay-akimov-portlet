package ru.akimov.servlets;

import com.liferay.portal.kernel.servlet.FileTimestampUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.TempFileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author akimov
 * created at 08.02.2020 11:01
 */
@WebServlet(name = "tempFileUpload", urlPatterns = "/api/temp-file-upload")
@MultipartConfig
public class TemporaryFileUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
		Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">
		String fileName = Paths.get(filePart.getName()).getFileName().toString(); // MSIE fix.
		InputStream fileContent = filePart.getInputStream();

		List<Part> fileParts = req.getParts().stream()
				.filter(part -> "file".equals(part.getName()) && part.getSize() > 0)
				.collect(Collectors.toList());
		// Retrieves <input type="file" name="file" multiple="true">

		HttpSession session = req.getSession();
		String sessionTempStorage = SystemProperties.get(SystemProperties.TMP_DIR) + File.separator + session.getId() + File.separator;
		File tmpDir = new File(sessionTempStorage);
		FileUtil.mkdirs(tmpDir);
		FileUtil.copyFile();


		for (Part filePart : fileParts) {
			String fileName = Paths.get(filePart.getName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
			// ... (do your job here)
		}*/
	}
}
