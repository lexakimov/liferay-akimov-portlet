package ru.isands.akimov.search.helpers;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.portlet.PortletException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Объект для поиска сущностей в базе данных с помощью SQL запроса.
 * Рекомендуется использовать, когда нужно выполнить поиск в базе с нестандартной логикой (join-ы, функции и.т.д);
 *
 * @author akimov
 * created at 10.01.20 9:27
 * @see SearchHelper
 */
public abstract class SqlBasedSearchHelper<T> implements SearchHelper<T> {

	private final ResultSetHandler<List<T>> rsHandler;
	private final QueryRunner queryRunner;

	public SqlBasedSearchHelper(Class<T> type) {
		this(new BeanListHandler<T>(type));
	}

	public SqlBasedSearchHelper(ResultSetHandler<List<T>> rsHandler) {
		this.rsHandler = rsHandler;
		DataSource dataSource = (DataSource) PortalBeanLocatorUtil.locate("liferayDataSource");
		this.queryRunner = new QueryRunner(dataSource);
	}

	@Override
	public int getTotal() throws PortletException {
		String sqlQuery = getSqlQueryCount();
		ScalarHandler<Integer> scalarHandler = new ScalarHandler<>();
		try {
			return queryRunner.query(sqlQuery, scalarHandler);
		} catch (SQLException e) {
			throw new PortletException(e);
		}
	}

	@Override
	public List<T> getResult(int start, int end) throws PortletException {
		String sqlQuery = getSqlQuery(start, end);
		try {
			return queryRunner.query(sqlQuery, rsHandler);
		} catch (SQLException e) {
			throw new PortletException(e);
		}
	}

	protected abstract String getSqlQuery(int start, int end);

	protected abstract String getSqlQueryCount();

}
