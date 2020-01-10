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
	blobField BLOB
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

create table akimov_entity_editing_history (
	id_ INTEGER not null primary key,
	entityId INTEGER,
	entityType VARCHAR(75) null,
	userId LONG,
	description VARCHAR(75) null,
	dateOfChange DATE null
);

create table akimov_entity_field_change (
	id_ INTEGER not null primary key,
	historyId INTEGER,
	fieldName VARCHAR(75) null,
	oldValue VARCHAR(75) null,
	newValue VARCHAR(75) null
);