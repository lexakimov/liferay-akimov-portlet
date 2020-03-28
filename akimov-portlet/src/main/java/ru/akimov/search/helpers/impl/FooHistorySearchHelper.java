package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.commons.dbutils.ResultSetHandler;
import ru.akimov.audit.enums.EntityType;
import ru.akimov.search.helpers.SqlBasedSearchHelper;
import ru.akimov.model.AuditEntry;
import ru.akimov.search.entry_dto.EntityAuditEntryWithChanges;
import ru.akimov.service.AuditEntryLocalServiceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FooHistorySearchHelper extends SqlBasedSearchHelper<EntityAuditEntryWithChanges> {

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
				"\taudit.auditEntryId\n" +
				"\t\n" +
				"FROM\n" +
				"\takimov_audit_entries audit\n" +
				"\tLEFT JOIN akimov_audit_field_changes changes ON audit.auditEntryId = changes.auditEntryId \n" +
				"WHERE\n" +
				"\taudit.entityType = 'foo' \n" +
				"GROUP BY\n" +
				"\taudit.auditEntryId \n" +
				"ORDER BY\n" +
				"\taudit.dateOfChange DESC;";
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

				int auditEntryId = rs.getInt("auditEntryId");
				AuditEntry auditEntry;
				try {
					auditEntry = AuditEntryLocalServiceUtil.getAuditEntry(auditEntryId);
				} catch (PortalException | SystemException e) {
					throw new SQLException(e);
				}

				Timestamp dateOfChangeTs = rs.getTimestamp("dateOfChange");
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
