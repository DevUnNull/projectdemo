

create table Employee
(
	empCode varchar(20) primary key,
	name nvarchar(50),
	jobTitle text
)

create table Project
(
	code varchar(30) primary key,
	title text,
	managerEmpCode VARCHAR(20),
	FOREIGN KEY (managerEmpCode) REFERENCES Employee(empCode)
)

create table Tasks
(
	taskNumber int primary key,
	description nvarchar(100),
	projectCode varchar(30),
	FOREIGN KEY (projectCode) REFERENCES Project(code)
)

create table Employee_tasks
(
	hours int,
	empCode varchar(20),
	taskNumber int,
	primary key(empCode,taskNumber),
	FOREIGN KEY (empCode) REFERENCES Employee(empCode),
	FOREIGN KEY (taskNumber) REFERENCES Tasks(taskNumber),
)
