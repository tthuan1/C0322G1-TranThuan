create database if not exists student_management;

use student_management;

CREATE TABLE class (
	id int primary key,
    `name` varchar(50)
) ;

CREATE TABLE teacher (
id int primary key,
`name` varchar(50),
age int,
country varchar(50)
) ;