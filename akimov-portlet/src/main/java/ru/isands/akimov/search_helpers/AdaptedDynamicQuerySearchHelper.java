package ru.isands.akimov.search_helpers;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.model.BaseModel;
import ru.isands.akimov.search_helpers.adapters.PersonEntryAdapter;

import javax.portlet.PortletException;

public abstract class AdaptedDynamicQuerySearchHelper<ADAPTER extends PersonEntryAdapter, ADAPTABLE extends BaseModel<ADAPTABLE>>
		extends DynamicQuerySearchHelper<ADAPTABLE> implements AdaptedSearchHelper<ADAPTER, ADAPTABLE> {

	protected AdaptedDynamicQuerySearchHelper(Class<ADAPTABLE> modelClass) {
		super(modelClass);
	}

	protected AdaptedDynamicQuerySearchHelper(Class<ADAPTABLE> modelClass, SearchContainer<ADAPTER> container) throws PortletException {
		this(modelClass);
		container.setResults(this.getAdaptedResult(container.getStart(), container.getEnd()));
		container.setTotal(this.getTotal());
	}
}
