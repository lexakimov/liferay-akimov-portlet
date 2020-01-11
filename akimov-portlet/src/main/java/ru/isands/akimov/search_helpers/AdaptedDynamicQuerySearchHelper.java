package ru.isands.akimov.search_helpers;

import com.liferay.portal.model.BaseModel;
import ru.isands.akimov.model.Person;
import ru.isands.akimov.search_helpers.adapters.EntryAdapter;
import ru.isands.akimov.search_helpers.adapters.PersonEntryAdapter;

import javax.portlet.PortletException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AdaptedDynamicQuerySearchHelper<ADAPTER extends EntryAdapter<T>, T extends BaseModel<T>>
		extends DynamicQuerySearchHelper<T>
		implements AdaptedSearchHelper<ADAPTER, T> {

	public AdaptedDynamicQuerySearchHelper(Class<T> modelClass) {
		super(modelClass);
	}

}
