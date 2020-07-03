SELECT groups.userId,
       groups.eventdate,
       entries.entryId,
       entries.entityId,
       entries.entityType,
       array_agg_arrays(ARRAY [ ARRAY [ changes.fieldName, changes.oldValue, changes.newValue ] ]) changes

FROM akimov_audit_action_groups groups
	     LEFT JOIN akimov_audit_action_entries entries ON groups.entrygroupid = entries.entrygroupid
	     LEFT JOIN akimov_audit_field_changes changes ON entries.entryId = changes.entryId
WHERE entries.entityType = 'foo'
GROUP BY groups.eventdate, groups.userId, entries.entryId
ORDER BY groups.eventdate DESC;