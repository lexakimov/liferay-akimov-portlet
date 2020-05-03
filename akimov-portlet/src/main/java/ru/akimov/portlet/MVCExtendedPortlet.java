package ru.akimov.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.akimov.annotations.AsyncActionMethod;
import ru.akimov.functional.ResourceActionMethod;
import ru.akimov.utils.PortletRequestUtil;

import javax.portlet.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static ru.akimov.constants.PortletConstants.*;

/**
 * MVC портлет, расширенный дополнительными возможностями.
 *
 * @author akimov
 * created at 14.12.19 9:09
 * @see #processAsyncAction(ResourceRequest, ResourceResponse) выполнение асинхронных действий портлета.
 * @see PortletRequestUtil#createPortletURL(PortletRequest) создать новый урл.
 * @see PortletRequestUtil#paramsList(PortletRequest) получить сообщение с параметрами запроса для вывода в консоль.
 * @see PortletRequestUtil#attrsList(PortletRequest) получить сообщение с аттрибутами запроса для вывода в консоль.
 */
public abstract class MVCExtendedPortlet extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(MVCExtendedPortlet.class);

	private final Map<String, Method> asyncActionMethods = new HashMap<>();

	private final Map<String, ResourceActionMethod> resourceActionMethods = new HashMap<>();

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		log.debug("initialization of portlet: '" + getPortletName() + "'");
		cacheResourceActionMethods();
		cacheAsyncActionAnnotatedMethods();
	}

	@Override
	public void destroy() {
		super.destroy();
		log.debug("destroying portlet '" + getPortletName() + "'");
	}

	/* ---------------------------------------- resource actions ---------------------------------------------------- */

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		String resourceId = GetterUtil.getString(request.getResourceID());
		log.debug("RESOURCE ACTION: " + resourceId);
		ResourceActionMethod resourceAction = resourceActionMethods.get(resourceId);
		if (resourceAction != null) {
			resourceAction.execute(request, response);
		} else {
			super.serveResource(request, response);
		}
	}

	private void cacheResourceActionMethods() {
		resourceActionMethods.put(ASYNC_ACTION_RESOURCE_ID, this::processAsyncAction);
		resourceActionMethods.put(ASYNC_FILE_UPLOAD, this::uploadTemporaryFile);
		initResourceActions(resourceActionMethods);
	}

	private void uploadTemporaryFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String method = resourceRequest.getMethod();
		PortletSession portletSession = resourceRequest.getPortletSession();
		portletSession.getId();

	}

	/**
	 * В этом методе можно добавить ссылки на resourceAction методы. например так
	 * resourceActionMethods.put(ASYNC_FILE_UPLOAD, this::uploadTemporaryFile);
	 * где ASYNC_FILE_UPLOAD - resourceId, this::uploadTempFile ссылка на метод
	 *
	 * @param resourceActionMethods
	 */
	protected void initResourceActions(Map<String, ResourceActionMethod> resourceActionMethods) {
		// implement this method in portlet if necessary
	}

	/* ---------------------------------------- async actions handling -----------------------------------------------*/

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
			processRequestMessages(request, json);
		}

		if (SessionErrors.isEmpty(request)) {
			json.put("success", true);
		} else {
			processRequestErrors(request, json);
		}

		writeJSON(request, response, json);
	}

	private void processRequestMessages(ResourceRequest request, JSONObject json) {
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

	private void processRequestErrors(ResourceRequest request, JSONObject json) {
		Set<String> errors = SessionErrors.keySet(request);
		JSONObject errorsJson = JSONFactoryUtil.createJSONObject();
		for (String errorKey : errors) {
			Object errorObject = SessionErrors.get(request, errorKey);
			if ((errorObject != null) && errorObject.getClass().isArray()) {
				errorsJson.put(errorKey, translate(request, errorKey, (Object[]) errorObject));
			} else {
				errorsJson.put(errorKey, translate(request, errorKey, errorObject));
			}
		}
		json.put("errors", errorsJson);
	}

}
