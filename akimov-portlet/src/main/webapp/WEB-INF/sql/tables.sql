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
	fileName VARCHAR(75) null,
	extension VARCHAR(75) null,
	size_ INTEGER,
	mimeType VARCHAR(75) null,
	data_ BLOB,
	uploaded DATE null,
	userId INTEGER
);

create table akimov_audit_entry (
	auditEntryId INTEGER not null primary key,
	auditType VARCHAR(75) null,
	entityType VARCHAR(75) null,
	entityId INTEGER,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	dateOfChange DATE null,
	metadata TEXT null
);

create table akimov_entity_field_change (
	id_ INTEGER not null primary key,
	auditEntryId INTEGER,
	fieldName VARCHAR(75) null,
	oldValue VARCHAR(75) null,
	newValue VARCHAR(75) null
);