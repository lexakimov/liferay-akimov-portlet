CREATE VIEW akimov_history_foo AS

SELECT history.entityId,
       history.entityType,
       history.dateOfChange,
       history.userId,
       history.description,

       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'booleanField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as booleanField,

       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'shortField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as shortField,
       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'intField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as intField,
       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'longField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as longField,
       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'doubleField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as doubleField,
       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'floatField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as floatField,
       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'stringField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as stringField,
       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'dateField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as dateField,
       (
	       SELECT changes.oldValue
	       FROM akimov_entity_field_change changes
	       WHERE history.id_ = changes.historyid AND changes.fieldName = 'blobField'
	       ORDER BY changes.id_ DESC
	       LIMIT 1
       ) as blobField


FROM akimov_entity_editing_history history
    /*LEFT JOIN akimov_foo foo ON history.entityid = foo.fooid AND history.entityType = 'foo'*/

ORDER BY history.entityId, history.entityType, history.dateOfChange DESC;