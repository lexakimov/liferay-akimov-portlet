package ru.isands.akimov.search_helpers;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.model.BaseModel;
import ru.isands.akimov.search_helpers.adapters.EntryAdapter;

import javax.portlet.PortletException;

public abstract class AdaptedDynamicQuerySearchHelper<ADAPTER extends EntryAdapter<T>, T extends BaseModel<T>>
		extends DynamicQuerySearchHelper<T> implements AdaptedSearchHelper<ADAPTER, T> {

	protected AdaptedDynamicQuerySearchHelper(Class<T> modelClass) {
		super(modelClass);
	}
}
