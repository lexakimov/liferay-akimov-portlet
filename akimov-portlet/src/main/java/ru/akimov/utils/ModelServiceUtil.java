package ru.akimov.utils;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.util.bean.PortletBeanLocatorUtil;

import javax.portlet.PortletException;
import java.util.List;

/**
 * Класс упрощающий рефлексивные вызовы сервисов для работы с сущностями.
 *
 * @author akimov
 * created at 14.12.19 18:55
 */
public final class ModelServiceUtil {

	private static final String PORTLET_PACKAGE_NAME = "ru.akimov";

	private static final String SERVICES_PACKAGE_NAME = PORTLET_PACKAGE_NAME + ".service";

	public static <T extends BaseModel<T>> DynamicQuery getDynamicQuery(Class<T> modelClass) throws PortletException {
		try {
			return (DynamicQuery) getLocalService(modelClass)
					.invokeMethod("dynamicQuery", new String[]{}, new Object[]{});
		} catch (Throwable throwable) {
			throw new PortletException("can't get dynamic query object", throwable);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends BaseModel<T>> List<T> doDynamicQuery(
			Class<T> modelClass, DynamicQuery dynamicQuery, int start, int end) throws PortletException {
		try {
			return (List<T>) getLocalService(modelClass).invokeMethod(
					"dynamicQuery",
					new String[]{"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"},
					new Object[]{dynamicQuery, start, end}
			);
		} catch (Throwable throwable) {
			throw new PortletException("can't execute dynamic query", throwable);
		}
	}

	public static <T extends BaseModel<T>> long doDynamicQueryCount(
			Class<T> modelClass, DynamicQuery dynamicQuery) throws PortletException {
		try {
			return (long) getLocalService(modelClass).invokeMethod(
					"dynamicQueryCount",
					new String[]{"com.liferay.portal.kernel.dao.orm.DynamicQuery"},
					new Object[]{dynamicQuery}
			);
		} catch (Throwable throwable) {
			throw new PortletException("can't execute dynamic query count", throwable);
		}
	}

	private static <T extends BaseModel<T>> InvokableLocalService getLocalService(Class<T> modelClass) {
		String serviceBeanName = SERVICES_PACKAGE_NAME + "." + modelClass.getSimpleName() + "LocalService";
		return (InvokableLocalService) PortletBeanLocatorUtil.locate(serviceBeanName);
	}
}