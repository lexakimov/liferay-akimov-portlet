package ru.isands.akimov.search_helpers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.model.BaseModel;
import ru.isands.akimov.search_helpers.adapters.EntryAdapter;
import ru.isands.akimov.util.ModelServiceUtil;

import javax.portlet.PortletException;
import java.util.List;

/**
 * Объект для поиска моделей с использованием объекта {@link DynamicQuery}.
 *
 * @param <T> тип модели, экземпляры которой будем искать.
 * @author akimov
 * created at 14.12.19 18:55
 */
public abstract class DynamicQuerySearchHelper<T extends BaseModel<T>> implements SearchHelper<T> {

	private final Class<T> modelClass;

	public DynamicQuerySearchHelper(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	protected DynamicQuery buildDynamicQuery() throws PortletException {
		DynamicQuery query = ModelServiceUtil.getDynamicQuery(modelClass);
		query = addRestrictions(query);
		return query;
	}

	protected DynamicQuery addRestrictions(DynamicQuery query) {
		return query;
	}

	@Override
	public final int getTotal() throws PortletException {
		DynamicQuery query = buildDynamicQuery();
		return (int) ModelServiceUtil.doDynamicQueryCount(modelClass, query);
	}

	@Override
	public final List<T> getResult(int start, int end) throws PortletException {
		DynamicQuery query = buildDynamicQuery();
		query = addOrdering(query);
		return ModelServiceUtil.doDynamicQuery(modelClass, query, start, end);

	}

	protected DynamicQuery addOrdering(DynamicQuery query) {
		return query;
	}

}
