package ru.isands.akimov.search_helpers.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.commons.dbutils.ResultSetHandler;
import ru.isands.akimov.history.dto.EntityHistoryEntryWithChanges;
import ru.isands.akimov.history.enums.ActionType;
import ru.isands.akimov.history.enums.EntityType;
import ru.isands.akimov.search_helpers.SqlBasedSearchHelper;

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
				"\thistory.dateOfChange,\n" +
				"\tarray_agg_arrays ( ARRAY [ ARRAY [ changes.fieldName, changes.oldValue, changes.newValue ] ] ) changes,\n" +
				"\thistory.entityId,\n" +
				"\thistory.entityType,\n" +
				"\thistory.userId,\n" +
				"\thistory.description\n" +
				"\t\n" +
				"FROM\n" +
				"\takimov_entity_editing_history history\n" +
				"\tLEFT JOIN akimov_entity_field_change changes ON history.id_ = changes.historyid \n" +
				"WHERE\n" +
				"\thistory.entityType = 'foo' \n" +
				"GROUP BY\n" +
				"\thistory.entityId, history.entityType, history.userId, history.description, history.dateOfChange \n" +
				"ORDER BY\n" +
				"\thistory.dateOfChange DESC;";
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
				User user = null;
				try {
					user = UserLocalServiceUtil.fetchUser(userId);
				} catch (SystemException e) {
					throw new SQLException(e);
				}
				String description = rs.getString("description");

				Array changes = rs.getArray("changes");
				String[][] changesArray = (String[][]) changes.getArray();


				EntityHistoryEntryWithChanges entry =
						new EntityHistoryEntryWithChanges(EntityType.FOO, user, description, dateOfChange, changesArray);
				result.add(entry);
			}

			return result;
		}
	}
}
