package ru.isands.akimov.search_helpers;

public interface OrderableSearchHelper<T> extends SearchHelper<T> {

	String getOrderByCol();

	String getOrderByType();

	void setOrderByCol(String orderByCol);

	void setOrderByType(String orderByType);

}
