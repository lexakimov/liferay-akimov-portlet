package ru.isands.akimov.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.util.bean.PortletBeanLocatorUtil;

import javax.portlet.PortletException;
import java.util.List;

/**
 * Класс упрощающий рефлексивные вывовы сервисов для работы с сущностями.
 *
 * @author akimov
 */
public final class ModelServiceUtil {

	private static final String PORTLET_PACKAGE_NAME = "ru.isands.akimov";

	private static final String SERVICES_PACKAGE_NAME = PORTLET_PACKAGE_NAME + ".service";

	private static <T extends BaseModel<T>> InvokableLocalService getLocalService(Class<T> modelClass) {
		String serviceBeanName = SERVICES_PACKAGE_NAME + "." + modelClass.getSimpleName() + "LocalService";
		//return Class.forName(serviceBeanName + "Util");
		return (InvokableLocalService) PortletBeanLocatorUtil.locate(serviceBeanName);
	}

	public static <T extends BaseModel<T>> DynamicQuery getDynamicQuery(Class<T> modelClass) throws PortletException {
		//return (DynamicQuery) getLocalService(modelClass).getMethod("dynamicQuery").invoke(null);
		try {
			return (DynamicQuery) getLocalService(modelClass)
					.invokeMethod("dynamicQuery", new String[]{}, new Object[]{});
		} catch (Throwable throwable) {
			throw new PortletException("can't get dynamic query object", throwable);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends BaseModel<T>> List<T>
	doDynamicQuery(Class<T> modelClass, DynamicQuery dynamicQuery, int start, int end) throws PortletException {
		//return (List<T>) getLocalService(modelClass).getMethod("dynamicQuery", DynamicQuery.class).invoke(null, dynamicQuery);
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

	public static <T extends BaseModel<T>> long
	doDynamicQueryCount(Class<T> modelClass, DynamicQuery dynamicQuery) throws PortletException {
		//return (long) getLocalService(modelClass).getMethod("dynamicQueryCount", DynamicQuery.class).invoke(null, dynamicQuery);
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


//	public static <T extends BaseModel<T>> List<String> getModelFieldNames(Class<T> modelClass)
//			throws ReflectiveOperationException {
//
//		Class<T> modelImplClass = getModelImpl(modelClass);
//
//		Field table_columns = modelImplClass.getField("TABLE_COLUMNS");
//
//		List<String> result = new ArrayList<>();
//
//		Object[][] tableColumns = (Object[][]) table_columns.get(null);
//		for (Object[] objects : tableColumns) {
//			String fieldName = (String) objects[0];
//			//Integer fieldType = (Integer) objects[1]; /**@see java.sql.Types */
//			result.add(fieldName);
//		}
//
//		return result;
//	}

//	private static <T extends BaseModel<T>> Class<T> getModelImpl(Class<T> modelClass) throws ClassNotFoundException {
//		return (Class<T>) Class.forName(PORTLET_PACKAGE_NAME + ".model.impl." + modelClass.getSimpleName() + "ModelImpl");
//	}


}