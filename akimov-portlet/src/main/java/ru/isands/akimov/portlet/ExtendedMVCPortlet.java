package ru.isands.akimov.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.isands.akimov.annotations.AsyncActionMethod;
import ru.isands.akimov.util.MessagesRU;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static ru.isands.akimov.constants.Param.ASYNC_ACTION_METHOD_PARAM;
import static ru.isands.akimov.constants.Param.ASYNC_ACTION_RESOURCE_ID;

/**
 * MVC портлет, расширенный дополнительными возможностями:
 * выполнение асинхронных действий портлета.
 * @author akimov
 */
public abstract class ExtendedMVCPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(ExtendedMVCPortlet.class);

	private final Map<String, Method> asyncActionMethods = new HashMap<>();

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		initAsyncActionAnnotatedMethods();
	}

	private void initAsyncActionAnnotatedMethods() {
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

			log.debug(String.format("Invocation of async action method '%s.%s'", methodClass, actionMethod));

			method.invoke(this, request, response);

		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			throw new PortletException(e);
		}

		JSONObject responseJson = JSONFactoryUtil.createJSONObject();

		if (!SessionMessages.isEmpty(request)) {
			Set<String> messages = SessionMessages.keySet(request);
			JSONObject messagesJson = JSONFactoryUtil.createJSONObject();
			for (String messageKey : messages) {
				//Object errorObject = SessionErrors.get(request, errorKey);
				messagesJson.put(messageKey, MessagesRU.getMessage(messageKey));
			}
			responseJson.put("messages", messagesJson);
		}

		if (SessionErrors.isEmpty(request)) {
			responseJson.put("success", true);
		} else {
			Set<String> errors = SessionErrors.keySet(request);
			JSONObject errorsJson = JSONFactoryUtil.createJSONObject();
			for (String errorKey : errors) {
				//Object errorObject = SessionErrors.get(request, errorKey);
				errorsJson.put(errorKey, MessagesRU.getMessage(errorKey));
			}
			responseJson.put("errors", errorsJson);
		}

		response.setContentType(ContentTypes.APPLICATION_JSON);
		PrintWriter writer = response.getWriter();
		writer.write(responseJson.toString());
	}

	void hideDefaultErrorMessage(ActionRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	void hideDefaultSuccessMessage(ActionRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	LiferayPortletURL createPortletURL(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletId = PortalUtil.getPortletId(request);
		return PortletURLFactoryUtil.create(request, portletId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	}

	@SuppressWarnings("unused")
	void _debugPrintAttrs(PortletRequest request) {
		if (!log.isDebugEnabled()) {
			return;
		}
		Enumeration pageAttrs = request.getAttributeNames();
		Map<String, Object> attributesMap = new TreeMap<>();
		while (pageAttrs.hasMoreElements()) {
			String key = (String) pageAttrs.nextElement();
			attributesMap.put(key, request.getAttribute(key));
		}
		printDebugMessage(attributesMap, "attributes");

	}

	@SuppressWarnings("unused")
	void _debugPrintParams(PortletRequest request) {
		if (!log.isDebugEnabled()) {
			return;
		}
		Enumeration params = request.getParameterNames();
		Map<String, Object> paramMap = new TreeMap<>();
		while (params.hasMoreElements()) {
			String key = (String) params.nextElement();
			paramMap.put(key, request.getParameter(key));
		}
		printDebugMessage(paramMap, "params");
	}

	private void printDebugMessage(Map<String, Object> paramMap, String prefix) {
		StringJoiner joiner2 = new StringJoiner(", \n\t", prefix + ":\n{\n\t", "\n}");
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			joiner2.add(entry.getKey() + " = " + entry.getValue());
		}
		log.debug("");
		System.out.println("--------------------------");
		System.out.println(joiner2);
		System.out.println("--------------------------");
	}


/*	// завершить асинхнронный action
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

}
