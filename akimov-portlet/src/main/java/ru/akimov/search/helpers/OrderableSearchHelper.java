package ru.akimov.search.helpers;

public interface OrderableSearchHelper<T> extends SearchHelper<T> {

	String getOrderByCol();

	String getOrderByType();

	void setOrderByCol(String orderByCol);

	void setOrderByType(String orderByType);

}
