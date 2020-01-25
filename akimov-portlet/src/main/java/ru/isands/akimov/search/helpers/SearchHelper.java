package ru.isands.akimov.search.helpers;

import javax.portlet.PortletException;
import java.util.List;

/**
 * Базовый интерфейс объекта для поиска каких-либо сущностей.
 *
 * @param <T> тип объекта, экземпляры которого будем искать.
 * @author akimov
 * created at 14.12.19 18:55
 */
public interface SearchHelper<T> {

	int getTotal() throws PortletException;

	List<T> getResult(int start, int end) throws PortletException;

	default List<T> getResult() throws PortletException {
		return getResult(-1, -1);
	}

}
