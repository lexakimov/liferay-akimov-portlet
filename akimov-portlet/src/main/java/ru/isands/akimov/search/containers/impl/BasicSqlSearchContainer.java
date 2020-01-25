package ru.isands.akimov.search.containers.impl;

import ru.isands.akimov.search.containers.SearchContainer;
import ru.isands.akimov.search.entry_adapters.impl.SqlEntity;
import ru.isands.akimov.search.helpers.impl.BasicSqlSearchHelper;

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
