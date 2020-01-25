package ru.isands.akimov.search.helpers.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.commons.dbutils.ResultSetHandler;
import ru.isands.akimov.audit.pojo.EntityHistoryEntryWithChanges;
import ru.isands.akimov.audit.enums.EntityType;
import ru.isands.akimov.search.helpers.SqlBasedSearchHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FooHistorySearchHelper extends SqlBasedSearchHelper<EntityHistoryEntryWithChanges> {

	public FooHistorySearchHelper() {
		super(new HistoryResultSetHandler());
	}

	@Override
	protected String getSqlQuery(int start, int end) {
		return "SELECT\n" +
				"\taudit.dateOfChange,\n" +
				"\tarray_agg_arrays ( ARRAY [ ARRAY [ changes.fieldName, changes.oldValue, changes.newValue ] ] ) changes,\n" +
				"\taudit.entityId,\n" +
				"\taudit.entityType,\n" +
				"\taudit.userId,\n" +
				"\taudit.description\n" +
				"\t\n" +
				"FROM\n" +
				"\takimov_audit_entry audit\n" +
				"\tLEFT JOIN akimov_entity_field_change changes ON audit.id_ = changes.auditEntryId \n" +
				"WHERE\n" +
				"\taudit.entityType = 'foo' \n" +
				"GROUP BY\n" +
				"\taudit.entityId, audit.entityType, audit.userId, audit.description, audit.dateOfChange \n" +
				"ORDER BY\n" +
				"\taudit.dateOfChange DESC;";
	}

	@Override
	protected String getSqlQueryCount() {
		return null; // not used
	}

	private static class HistoryResultSetHandler implements ResultSetHandler<List<EntityHistoryEntryWithChanges>> {

		@Override
		public List<EntityHistoryEntryWithChanges> handle(ResultSet rs) throws SQLException {
			List<EntityHistoryEntryWithChanges> result = new ArrayList<>();

			while (rs.next()) {
				Timestamp dateOfChangeTs = rs.getTimestamp("dateOfChange");
				Date dateOfChange = new Date(dateOfChangeTs.getTime());

				long userId = rs.getLong("userId");
				User user;
				try {
					user = UserLocalServiceUtil.fetchUser(userId);
				} catch (SystemException e) {
					throw new SQLException(e);
				}
				String description = rs.getString("description");

				Array changes = rs.getArray("changes");
				String[][] changesArray = (String[][]) changes.getArray();

				result.add(new EntityHistoryEntryWithChanges(EntityType.FOO, user, description, dateOfChange, changesArray));
			}

			return result;
		}
	}
}
