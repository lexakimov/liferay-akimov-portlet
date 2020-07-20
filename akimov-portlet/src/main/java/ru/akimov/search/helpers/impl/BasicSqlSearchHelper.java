package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import lombok.Getter;
import lombok.Setter;
import ru.akimov.search.entry_dto.impl.SqlEntity;
import ru.akimov.search.helpers.OrderableSearchHelper;
import ru.akimov.search.helpers.SqlBasedSearchHelper;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import java.util.StringJoiner;

public class BasicSqlSearchHelper extends SqlBasedSearchHelper<SqlEntity> implements OrderableSearchHelper<SqlEntity> {

	private static final Log log = LogFactoryUtil.getLog(BasicSqlSearchHelper.class);

	@Getter @Setter	private String orderByCol;
	@Getter @Setter private String orderByType;

	public BasicSqlSearchHelper() {
		super(SqlEntity.class);
	}

	@Override
	protected String getSqlQuery(int start, int end) {
		StringBuilder builder = new StringBuilder();

		builder.append("SELECT personid as id, firstName, lastName, birthDate \n");
		builder.append("FROM akimov_person \n");

		StringJoiner orderBy = new StringJoiner(", ", "ORDER BY ", "\n");
		orderBy.add(orderByCol + " " + orderByType);

		builder.append(orderBy.toString());
		builder.append(makeLimits(start, end));

		return builder.toString();
	}

	@Override
	protected String getSqlQueryCount() {
		return "SELECT count(*)::int FROM akimov_person";
	}

	@Override
	public String getDefaultOrderByCol() {
		return "personid";
	}

	@Override
	public String getDefaultOrderByType() {
		return "asc";
	}
}
