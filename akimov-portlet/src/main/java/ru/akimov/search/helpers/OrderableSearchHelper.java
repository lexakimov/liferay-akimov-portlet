package ru.akimov.search.helpers;

/**
 * SearchHelper со поддержкой сортировки выборки.
 *
 * @param <T>
 */
public interface OrderableSearchHelper<T> extends SearchHelper<T> {

	/**
	 * Указать параметр наименования колонки для сортировки.
	 */
	void setOrderByCol(String orderByCol);

	/**
	 * Указать параметр типа сортировки (asc \ desc).
	 */
	void setOrderByType(String orderByType);

	/**
	 * @return наименование колонки для сортировки по умолчанию.
	 */
	String getDefaultOrderByCol();

	/**
	 * @return тип сортировки по умолчанию.
	 */
	String getDefaultOrderByType();

}
