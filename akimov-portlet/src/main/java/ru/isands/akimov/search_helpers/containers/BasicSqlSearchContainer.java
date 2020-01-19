package ru.isands.akimov.search_helpers.containers;

import ru.isands.akimov.search_helpers.adapters.SqlEntity;
import ru.isands.akimov.search_helpers.impl.BasicSqlSearchHelper;

import javax.portlet.PortletException;

/**
 * @author akimov
 * created at 18.01.20 18:11
 */
public class BasicSqlSearchContainer extends SearchContainer<SqlEntity> {

	public BasicSqlSearchContainer(BasicSqlSearchHelper searchHelper) throws PortletException {
		super(searchHelper);
	}

}
