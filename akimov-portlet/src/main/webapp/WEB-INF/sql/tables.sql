create table akimov_Person (
	personId INTEGER not null primary key,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	gender INTEGER,
	birthDate DATE null,
	address VARCHAR(75) null
);