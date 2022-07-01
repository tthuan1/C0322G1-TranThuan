-- create database ss12_c03;
use ss12_c03;

create table student(
	id int primary key auto_increment,
	`name` varchar(50),
    class_name varchar(20),
    gender int,
    score int
);


