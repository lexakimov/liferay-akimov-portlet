package ru.isands.akimov.search_helpers;

import java.util.Map;

public interface RestrictableSearchHelper<T> extends SearchHelper<T> {

	Map<String, Object> getRestrictions();

	void setRestrictions(Map<String, Object> restrictions);

}
