package ru.isands.akimov.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.isands.akimov.annotations.AsyncActionMethod;

import javax.portlet.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_METHOD_PARAM;
import static ru.isands.akimov.constants.URLParams.ASYNC_ACTION_RESOURCE_ID;

/**
 * MVC портлет, расширенный дополнительными возможностями:
 *
 * @author akimov
 * created at 14.12.19 9:09
 * @see #processAsyncAction(ResourceRequest, ResourceResponse) выполнение асинхронных действий портлета.
 * @see #createPortletURL(PortletRequest) создать новый урл.
 * @see #_getRequestParamsMessage(PortletRequest) получить сообщение с параметрами запроса для вывода в консоль.
 * @see #_getRequestAttrsMessage(PortletRequest) получить сообщение с аттрибутами запроса для вывода в консоль.
 */
public abstract class ExtendedMVCPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(ExtendedMVCPortlet.class);

	private final Map<String, Method> asyncActionMethods = new HashMap<>();

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		cacheAsyncActionAnnotatedMethods();
	}

	private void cacheAsyncActionAnnotatedMethods() {
		Class<?> klass = getClass();
		while (klass != MVCPortlet.class) {
			final List<Method> allMethods = new ArrayList<>(Arrays.asList(klass.getDeclaredMethods()));
			for (final Method method : allMethods) {
				if (method.isAnnotationPresent(AsyncActionMethod.class)) {
					asyncActionMethods.put(method.getName(), method);
					log.debug("async action method: " + method.getName());
				}
			}
			klass = klass.getSuperclass();
		}
	}

	/*
	// Try to make async action method
	// <portlet:actionURL var="actURL" name="A_actionMethodName" >
	//		<portlet:param name="param1" value="value1"/>
	// </portlet:actionURL>

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String actionName = ParamUtil.getString(actionRequest, ActionRequest.ACTION_NAME);
		if (actionName.startsWith("A_")) {
			log.info("success!");
			_debugPrintParams(actionRequest);
			return;
		}
		super.processAction(actionRequest, actionResponse);
	}
	*/

	/*
	// завершить асинхнронный action
	void completeAsyncAction(ActionRequest request, ActionResponse response) {
		LiferayPortletURL portletURL = createPortletURL(request);
		Map<String, String[]> parameterMap = new HashMap<>(request.getParameterMap());
		String mvcPath = getPath(request);
		if (mvcPath != null) {
			parameterMap.remove("jspPage");
			parameterMap.put("mvcPath", new String[]{mvcPath});
		}
		parameterMap.remove("javax.portlet.action");
		portletURL.setParameters(parameterMap);

		try {
			portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
			response.sendRedirect(portletURL.toString());
		} catch (WindowStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}*/


	public void tempFileUpload(ThemeDisplay themeDisplay, PortletRequest portletRequest) {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(portletRequest);

		//uploadPortletRequest.file

		String fileName = uploadPortletRequest.getFileName("uploadedFile");
		File file = uploadPortletRequest.getFile("uploadedFile");
		String mimeType = uploadPortletRequest.getContentType("uploadedFile");
		String title = fileName;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("Title=>" + title);
		try {
			//Folder folder = getFolder(themeDisplay);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), portletRequest);
			InputStream is = new FileInputStream(file);
			//DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType,
			//title, description, "", is, file.getTotalSpace(), serviceContext);

		} catch (Exception e) {
			log.error(e);
		}

	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		String resourceId = request.getResourceID();
		if (resourceId != null && resourceId.equals(ASYNC_ACTION_RESOURCE_ID)) {
			processAsyncAction(request, response);
			return;
		}
		super.serveResource(request, response);
	}

	/**
	 * Basic usage on async methods:
	 * <p>
	 * <portlet:resourceURL var="urlName" id="async_action">
	 * <portlet:param name="async_action_method" value="methodName"/>
	 * <portlet:param ... (other params)
	 * </portlet:resourceURL>
	 * or like this:
	 * <portlet:resourceURL var="urlName" id="<%=ASYNC_ACTION_RESOURCE_ID%>">
	 * <portlet:param name="<%=ASYNC_ACTION_METHOD_PARAM%>" value="methodName"/>
	 * <portlet:param ... (other params)
	 * </portlet:resourceURL>
	 * <p>
	 * portlet method 'public void methodName(PortletRequest request, PortletResponse response)' must be annotated with
	 * {@link AsyncActionMethod}.
	 */
	private void processAsyncAction(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		String actionMethod = ParamUtil.getString(request, ASYNC_ACTION_METHOD_PARAM);
		try {
			if (actionMethod.isEmpty()) {
				throw new NoSuchMethodException("Async action method name not specified!");
			}

			Method method = asyncActionMethods.get(actionMethod);
			if (method == null) {
				throw new NoSuchMethodException(actionMethod);
			}

			String methodClass = method.getDeclaringClass().getSimpleName();
			log.debug(String.format("Invocation of async action method '%s.%s()'", methodClass, actionMethod));
			method.invoke(this, request, response);

		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			throw new PortletException(e);
		}

		JSONObject json = JSONFactoryUtil.createJSONObject();

		if (!SessionMessages.isEmpty(request)) {
			processRequestErrors(request, json);
		}

		if (SessionErrors.isEmpty(request)) {
			json.put("success", true);
		} else {
			processRequestMessages(request, json);
		}

		writeJSON(request, response, json);
	}

	private void processRequestErrors(ResourceRequest request, JSONObject json) {
		Set<String> messages = SessionMessages.keySet(request);
		JSONObject messagesJson = JSONFactoryUtil.createJSONObject();
		for (String messageKey : messages) {
			Object messageObject = SessionMessages.get(request, messageKey);
			if (messageObject != null && messageObject.getClass().isArray()) {
				messagesJson.put(messageKey, translate(request, messageKey, (Object[]) messageObject));
			} else {
				messagesJson.put(messageKey, translate(request, messageKey, messageObject));
			}
		}
		json.put("messages", messagesJson);
	}

	private void processRequestMessages(ResourceRequest request, JSONObject json) {
		Set<String> errors = SessionErrors.keySet(request);
		JSONObject errorsJson = JSONFactoryUtil.createJSONObject();
		for (String errorKey : errors) {
			Object errorObject = SessionErrors.get(request, errorKey);
			if (errorObject != null && errorObject.getClass().isArray()) {
				errorsJson.put(errorKey, translate(request, errorKey, (Object[]) errorObject));
			} else {
				errorsJson.put(errorKey, translate(request, errorKey, errorObject));
			}
		}
		json.put("errors", errorsJson);
	}

	protected void hideDefaultErrorMessage(ActionRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	protected void hideDefaultSuccessMessage(ActionRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	protected LiferayPortletURL createPortletURL(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletId = PortalUtil.getPortletId(request);
		return PortletURLFactoryUtil.create(request, portletId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	}

	@SuppressWarnings("unused")
	protected String _getRequestAttrsMessage(PortletRequest request) {
		Enumeration<String> pageAttrs = request.getAttributeNames();
		Map<String, Object> attributesMap = new TreeMap<>();
		while (pageAttrs.hasMoreElements()) {
			String key = pageAttrs.nextElement();
			attributesMap.put(key, request.getAttribute(key));
		}
		return makeDebugMessage(attributesMap, "attributes");
	}

	@SuppressWarnings("unused")
	protected String _getRequestParamsMessage(PortletRequest request) {
		Enumeration<String> params = request.getParameterNames();
		Map<String, Object> paramMap = new TreeMap<>();
		while (params.hasMoreElements()) {
			String key = params.nextElement();
			paramMap.put(key, request.getParameter(key));
		}
		return makeDebugMessage(paramMap, "params");
	}

	private String makeDebugMessage(Map<String, Object> paramMap, String prefix) {
		StringJoiner joiner = new StringJoiner(", \n\t", prefix + ":\n{\n\t", "\n}");
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			joiner.add(entry.getKey() + " = " + entry.getValue());
		}
		return joiner.toString();
	}

}
