package ru.akimov.search.helpers;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.akimov.search.entry_dto.SearchEntryDTO;

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
public abstract class SqlBasedSearchHelper<T extends SearchEntryDTO> implements SearchHelper<T> {

	private final Log log = LogFactoryUtil.getLog(SqlBasedSearchHelper.class);

	private final ResultSetHandler<List<T>> rsHandler;
	private final QueryRunner queryRunner;

	public SqlBasedSearchHelper(Class<T> type) {
		DataSource dataSource = (DataSource) PortalBeanLocatorUtil.locate("liferayDataSource");
		this.rsHandler = getResultSetHandler(type);
		this.queryRunner = new QueryRunner(dataSource);
	}

	protected ResultSetHandler<List<T>> getResultSetHandler(Class<T> type) {
		return new BeanListHandler<T>(type);
	}

	@Override
	public int getTotal() throws PortletException {
		String sqlQuery = getSqlQueryCount();
		log.debug("\ncount query :\n\n" + sqlQuery);
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
		log.debug("\nresults query :\n\n" + sqlQuery);
		try {
			return queryRunner.query(sqlQuery, rsHandler);
		} catch (SQLException e) {
			throw new PortletException(e);
		}
	}

	protected String makeLimits(int start, int end) {
		if (start == QueryUtil.ALL_POS && end == QueryUtil.ALL_POS) {
			return StringPool.BLANK;
		}
		if (start > end) {
			throw new IllegalArgumentException("start index must be lower or equal than end index");
		}
		String ret = "";
		if (start == QueryUtil.ALL_POS) {
			start = 0;
		}
		if (end != QueryUtil.ALL_POS) {
			ret += String.format("LIMIT %d ", end - start);
		}
		if (start != 0) {
			ret += String.format("OFFSET %d", start);
		}
		return ret;

	}

	protected abstract String getSqlQuery(int start, int end);

	protected abstract String getSqlQueryCount();

}
