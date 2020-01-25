package ru.isands.akimov.search.helpers;

import ru.isands.akimov.search.entry_adapters.SearchEntryAdapter;

import javax.portlet.PortletException;
import java.util.ArrayList;
import java.util.List;

/**
 * Базовый интерфейс объекта для поиска каких-либо сущностей с адаптированием. Позволяет получить как обычный
 * {@link #getResult()}, так и адаптированный {@link #getAdaptedResult()} результат.
 *
 * @param <ADAPTER> класс адаптера, должен быть потомком {@link SearchEntryAdapter}.
 * @param <T>       тип объекта, экземпляры которого будем искать.
 * @author akimov
 * created at 14.12.19 18:55
 * @see SearchEntryAdapter
 */
public interface AdaptedSearchHelper<ADAPTER extends SearchEntryAdapter<T>, T> extends SearchHelper<T> {

	ADAPTER adapt(T model) throws PortletException;

	default List<ADAPTER> getAdaptedResult() throws PortletException {
		return getAdaptedResult(-1, -1);
	}

	default List<ADAPTER> getAdaptedResult(int start, int end) throws PortletException {
		List<T> result = getResult(start, end);

		List<ADAPTER> adapted = new ArrayList<>(result.size());
		for (T t : result) {
			adapted.add(adapt(t));
		}
		return adapted;
	}
}
