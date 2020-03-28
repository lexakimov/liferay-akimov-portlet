create table akimov_Foo (
	fooId INTEGER not null primary key,
	booleanField BOOLEAN,
	shortField INTEGER,
	intField INTEGER,
	longField LONG,
	doubleField DOUBLE,
	floatField DOUBLE,
	stringField VARCHAR(75) null,
	dateField DATE null,
	blobField BLOB,
	status INTEGER
);

create table akimov_Person (
	personId INTEGER not null primary key,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	gender INTEGER,
	birthDate DATE null,
	address VARCHAR(75) null
);

create table akimov_attachment_files (
	id_ INTEGER not null primary key,
	fileName TEXT null,
	extension VARCHAR(75) null,
	size_ INTEGER,
	mimeType VARCHAR(75) null,
	data_ BLOB,
	uploaded DATE null,
	userId INTEGER
);

create table akimov_audit_action_entries (
	entryId INTEGER not null primary key,
	entryGroupId INTEGER,
	auditType VARCHAR(75) null,
	entityType VARCHAR(75) null,
	entityId INTEGER,
	metadata TEXT null
);

create table akimov_audit_action_groups (
	entryGroupId INTEGER not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	eventDate DATE null
);

create table akimov_audit_field_changes (
	fieldChangeId INTEGER not null primary key,
	entryId INTEGER,
	fieldName VARCHAR(75) null,
	oldValue VARCHAR(75) null,
	newValue VARCHAR(75) null
);