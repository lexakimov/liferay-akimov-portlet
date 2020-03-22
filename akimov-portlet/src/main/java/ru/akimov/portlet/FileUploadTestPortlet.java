package ru.akimov.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import ru.akimov.model.AttachmentFile;
import ru.akimov.service.AttachmentFileLocalServiceUtil;
import ru.akimov.utils.TemporaryFileUploadUtil;
import ru.akimov.utils.TemporaryFileUploadUtil.TempFile;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;

/**
 * @author akimov
 * created at 07.03.2020 12:24
 */
public class FileUploadTestPortlet extends MVCExtendedPortlet {

	private static Log log = LogFactoryUtil.getLog(FileUploadTestPortlet.class);

	private static final long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	private static final String ROOT_FOLDER_NAME = "uploaded_files";
	private static final String ROOT_FOLDER_DESCRIPTION = "Загруженные файлы";

	private Folder getOrCreateFolder(PortletRequest request, ThemeDisplay themeDisplay)
			throws SystemException, PortalException {
		try {
			return DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (PortalException | SystemException e) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
			return DLAppServiceUtil.addFolder(
					themeDisplay.getScopeGroupId(),
					PARENT_FOLDER_ID,
					ROOT_FOLDER_NAME,
					ROOT_FOLDER_DESCRIPTION,
					serviceContext
			);
		}
	}


	public void updateEntity(ActionRequest request, ActionResponse response)
			throws IOException, SystemException, PortalException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);
		HttpSession session = servletRequest.getSession(true);
		String[] fileIds = request.getParameterValues("temp-file");
		Collection<TempFile> tempFiles = TemporaryFileUploadUtil.listStorage(session, fileIds);
		request.setAttribute("files", tempFiles);
		response.setRenderParameter("mvcPath", "/jsp/file_upload/upload_result.jsp");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = getOrCreateFolder(request, themeDisplay);

		long repositoryId = themeDisplay.getScopeGroupId();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);

		for (TempFile file : tempFiles) {
			long id = CounterLocalServiceUtil.increment(AttachmentFile.class.getName());
			AttachmentFile attachmentFile = AttachmentFileLocalServiceUtil.createAttachmentFile((int) id);
			attachmentFile.setFileName(file.getFileName());
			attachmentFile.setExtension(null);
			attachmentFile.setSize(file.getSize());
			attachmentFile.setUploaded(new Date());
			attachmentFile.setUserId((int) serviceContext.getUserId());
			try (InputStream inputStream = file.getInputStream()) {
				Blob blob = new OutputBlob(inputStream, inputStream.available());
				attachmentFile.setData(blob);
				attachmentFile.persist();
			}

		/*	DLAppServiceUtil.addFileEntry(
					repositoryId,
					folder.getFolderId(),
					file.getFileName(),
					null,
					file.getFileName(),
					null,
					null,
					file.getInputStream(),
					file.getSize(),
					serviceContext
			);*/
		}


	}
}
