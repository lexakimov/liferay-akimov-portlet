package ru.isands.akimov.search_helpers.impl;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import ru.isands.akimov.search_helpers.SqlBasedSearchHelper;
import ru.isands.akimov.search_helpers.adapters.SqlEntity;

import javax.portlet.PortletException;
import java.util.StringJoiner;

public class BasicSqlSearchHelper extends SqlBasedSearchHelper<SqlEntity> {

	private static final Log log = LogFactoryUtil.getLog(BasicSqlSearchHelper.class);

	public BasicSqlSearchHelper() throws PortletException {
		super(SqlEntity.class);
	}

	public BasicSqlSearchHelper(SearchContainer<SqlEntity> searchContainer) throws PortletException {
		this();
		searchContainer.setResults(this.getResult(searchContainer.getStart(), searchContainer.getEnd()));
		searchContainer.setTotal(this.getTotal());
	}

	@Override
	protected String getSqlQuery(int start, int end) {
		StringBuilder builder = new StringBuilder();

		builder.append("SELECT personid as id, firstName, lastName, birthDate \n");
		builder.append("FROM akimov_person\n");

		StringJoiner orderBy = new StringJoiner(" ", "ORDER BY ", "\n");
		orderBy.add("personid");
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
