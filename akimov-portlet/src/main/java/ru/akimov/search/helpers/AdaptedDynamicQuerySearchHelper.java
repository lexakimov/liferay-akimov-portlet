package ru.akimov.search.helpers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.model.BaseModel;
import ru.akimov.search.entry_adapters.SearchEntryAdapter;

/**
 * Объект для поиска моделей с использованием объекта {@link DynamicQuery} с адаптацией результатов.
 *
 * @author akimov
 * created at 14.12.19 18:55
 * @see AdaptedSearchHelper
 */
public abstract class AdaptedDynamicQuerySearchHelper<ADAPTER extends SearchEntryAdapter<T>, T extends BaseModel<T>>
		extends DynamicQuerySearchHelper<T>
		implements AdaptedSearchHelper<ADAPTER, T> {

	public AdaptedDynamicQuerySearchHelper(Class<T> modelClass) {
		super(modelClass);
	}

}
