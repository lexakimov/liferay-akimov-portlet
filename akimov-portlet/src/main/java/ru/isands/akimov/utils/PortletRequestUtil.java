package ru.isands.akimov.utils;

import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import javax.portlet.PortletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * @author akimov
 * created at 13.02.2020 18:07
 */
public class PortletRequestUtil {

	public static LiferayPortletURL createPortletURL(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletId = PortalUtil.getPortletId(request);
		return PortletURLFactoryUtil.create(request, portletId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	}

	public static String attrsList(PortletRequest request) {
		Enumeration<String> pageAttrs = request.getAttributeNames();
		Map<String, Object> attributesMap = new TreeMap<>();
		while (pageAttrs.hasMoreElements()) {
			String key = pageAttrs.nextElement();
			attributesMap.put(key, request.getAttribute(key));
		}
		return makeDebugMessage(attributesMap, "attributes");
	}

	public static String paramsList(PortletRequest request) {
		Enumeration<String> params = request.getParameterNames();
		Map<String, Object> paramMap = new TreeMap<>();
		while (params.hasMoreElements()) {
			String key = params.nextElement();
			paramMap.put(key, request.getParameter(key));
		}
		return makeDebugMessage(paramMap, "params");
	}

	private static String makeDebugMessage(Map<String, Object> paramMap, String prefix) {
		StringJoiner joiner = new StringJoiner(", \n\t", prefix + ":\n{\n\t", "\n}");
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			joiner.add(entry.getKey() + " = " + entry.getValue());
		}
		return joiner.toString();
	}

	public static void hideDefaultErrorMessage(PortletRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	public static void hideDefaultSuccessMessage(PortletRequest request) {
		SessionMessages.add(request,
				PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
}
