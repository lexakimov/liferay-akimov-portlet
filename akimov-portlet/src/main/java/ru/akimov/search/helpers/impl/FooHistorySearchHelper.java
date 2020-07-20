package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.commons.dbutils.ResultSetHandler;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.model.AuditEntry;
import ru.akimov.search.entry_dto.impl.EntityAuditEntryWithChanges;
import ru.akimov.search.helpers.SqlBasedSearchHelper;
import ru.akimov.service.AuditEntryLocalServiceUtil;
import ru.akimov.utils.ResourcesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FooHistorySearchHelper extends SqlBasedSearchHelper<EntityAuditEntryWithChanges> {

	public FooHistorySearchHelper() {
		super(EntityAuditEntryWithChanges.class);
	}

	@Override
	protected ResultSetHandler<List<EntityAuditEntryWithChanges>> getResultSetHandler(Class<EntityAuditEntryWithChanges> type) {
		return new HistoryResultSetHandler();
	}

	@Override
	protected String getSqlQuery(int start, int end) {
		return ResourcesUtil.getContent("sql_queries/foo_history_search_query.sql") +
				" " + makeLimits(start, end);
	}

	@Override
	protected String getSqlQueryCount() {
		return null; // not used
	}

	private static class HistoryResultSetHandler implements ResultSetHandler<List<EntityAuditEntryWithChanges>> {

		@Override
		public List<EntityAuditEntryWithChanges> handle(ResultSet rs) throws SQLException {
			List<EntityAuditEntryWithChanges> result = new ArrayList<>();

			while (rs.next()) {

				int entryId = rs.getInt("entryId");
				AuditEntry auditEntry;
				try {
					auditEntry = AuditEntryLocalServiceUtil.getAuditEntry(entryId);
				} catch (PortalException | SystemException e) {
					throw new SQLException(e);
				}

				Timestamp dateOfChangeTs = rs.getTimestamp("eventDate");
				Date dateOfChange = new Date(dateOfChangeTs.getTime());

				long userId = rs.getLong("userId");
				User user;
				try {
					user = UserLocalServiceUtil.fetchUser(userId);
				} catch (SystemException e) {
					throw new SQLException(e);
				}

				Array changes = rs.getArray("changes");
				String[][] changesArray = (String[][]) changes.getArray();

				result.add(new EntityAuditEntryWithChanges(auditEntry, EntityType.FOO, user, dateOfChange, changesArray));
			}

			return result;
		}
	}
}
