package ru.isands.akimov.search_helpers;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.portlet.PortletException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public abstract class SqlBasedSearchHelper<T> implements SearchHelper<T> {

	private final Class<T> type;
	private final DataSource dataSource;

	public SqlBasedSearchHelper(Class<T> type) {
		this.type = type;
		this.dataSource = (DataSource) PortalBeanLocatorUtil.locate("liferayDataSource");
	}

	@Override
	public int getTotal() throws PortletException {
		String sqlQuery = getSqlQueryCount();
		ScalarHandler<Integer> scalarHandler = new ScalarHandler<>();
		QueryRunner run = new QueryRunner(dataSource);
		try {
			return run.query(sqlQuery, scalarHandler);
		} catch (SQLException e) {
			throw new PortletException(e);
		}
	}

	@Override
	public List<T> getResult(int start, int end) throws PortletException {
		String sqlQuery = getSqlQuery(start, end);
		ResultSetHandler<List<T>> h = new BeanListHandler<T>(type);
		QueryRunner run = new QueryRunner(dataSource);
		try {
			return run.query(sqlQuery, h);
		} catch (SQLException e) {
			throw new PortletException(e);
		}
	}

	protected abstract String getSqlQuery(int start, int end);

	protected abstract String getSqlQueryCount();

}
