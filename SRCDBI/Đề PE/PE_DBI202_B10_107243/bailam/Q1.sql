create table Employees
(
	empID decimal(18,0)PRIMARY KEY,
	name nvarchar(200),
	phone decimal(10,0),
	address nvarchar(200)
)

create table Projects
(
	projtID int primary key,
	projName nvarchar(200)
)


create table JoinProject
(
	startDate date,
	empID decimal(18,0),
	projtID int,
	primary key(empID,projtID),
	FOREIGN KEY (empID) REFERENCES Employees(empID),
    FOREIGN KEY (projtID) REFERENCES Projects(projtID)
)

create table PermanentEm
(
	empID decimal(18,0)PRIMARY KEY,
	FOREIGN KEY (empID) REFERENCES Employees(empID)
)

create table Contract
(
	empID decimal(18,0)PRIMARY KEY,
	FOREIGN KEY (empID) REFERENCES Employees(empID)
)