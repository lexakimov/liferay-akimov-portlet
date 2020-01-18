package ru.isands.akimov.search_helpers.impl;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import ru.isands.akimov.search_helpers.SqlBasedSearchHelper;
import ru.isands.akimov.search_helpers.adapters.SqlEntity;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import java.util.StringJoiner;

public class BasicSqlSearchHelper extends SqlBasedSearchHelper<SqlEntity> {

	private static final Log log = LogFactoryUtil.getLog(BasicSqlSearchHelper.class);

	private String orderByCol;
	private String orderByType;

	public BasicSqlSearchHelper() throws PortletException {
		super(SqlEntity.class);
	}

	public BasicSqlSearchHelper(SearchContainer<SqlEntity> searchContainer) throws PortletException {
		this();

		PortletRequest request = searchContainer.getPortletRequest();
		this.orderByCol = ParamUtil.getString(request, searchContainer.getOrderByColParam());
		this.orderByType = ParamUtil.getString(request, searchContainer.getOrderByTypeParam(), "asc");

		searchContainer.setOrderByCol(orderByCol);
		searchContainer.setOrderByType(orderByType);

		searchContainer.setResults(this.getResult(searchContainer.getStart(), searchContainer.getEnd()));
		searchContainer.setTotal(this.getTotal());
	}

	@Override
	protected String getSqlQuery(int start, int end) {
		StringBuilder builder = new StringBuilder();

		builder.append("SELECT personid as id, firstName, lastName, birthDate \n");
		builder.append("FROM akimov_person\n");

		StringJoiner orderBy = new StringJoiner(", ", "ORDER BY ", "\n");
		orderBy.add(!orderByCol.isEmpty() ? (orderByCol + " " + orderByType) : "personid");

		builder.append(orderBy.toString());

		if (end > -1) {
			builder.append("LIMIT ").append(end - start).append("\n");
		}
		if (start > -1) {
			builder.append("OFFSET ").append(start);
		}


		log.debug(builder.toString());

		return builder.toString();
	}

	@Override
	protected String getSqlQueryCount() {
		return "SELECT count(*)::int FROM akimov_person";
	}

}
