package ru.akimov.portlet;

import com.liferay.portal.util.PortalUtil;
import ru.akimov.utils.TemporaryFileUploadUtil;
import ru.akimov.utils.TemporaryFileUploadUtil.TempFile;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * @author akimov
 * created at 07.03.2020 12:24
 */
public class FileUploadTestPortlet extends MVCExtendedPortlet {

	public void updateEntity(ActionRequest request, ActionResponse response) throws IOException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);
		HttpSession session = servletRequest.getSession(true);
		String[] fileIds = request.getParameterValues("temp-file");
		Collection<TempFile> tempFiles = TemporaryFileUploadUtil.listStorage(session, fileIds);
		request.setAttribute("files", tempFiles);
		response.setRenderParameter("mvcPath", "/jsp/file_upload/upload_result.jsp");
	}
}
