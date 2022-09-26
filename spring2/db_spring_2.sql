create database if not exists book_store;

use book_store;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT primary key,
  `role_name` varchar(45) DEFAULT NULL
);

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);

create table promotion (
`id` int NOT NULL AUTO_INCREMENT primary key,
promotion_name varchar(30) DEFAULT NULL,
is_delete bit(1) default 0
);

create table category (
`id` int NOT NULL AUTO_INCREMENT primary key,
`category_name` varchar(30) DEFAULT NULL
);

create table book (
`id` int NOT NULL AUTO_INCREMENT primary key,
book_code varchar(30) DEFAULT NULL,
publishing_company varchar(30) DEFAULT NULL,
translator varchar(30) DEFAULT NULL,
author varchar(30) DEFAULT NULL,
number_pages int DEFAULT NULL,
size varchar(100) DEFAULT NULL,
release_date date,
amount int,
price int,
is_delete bit(1) default 0,
category_id int,
promotion_id int,
translator_id int,
foreign key (category_id) references category (id),
foreign key (promotion_id) references promotion (id)
);

create table contact (
`id` int NOT NULL AUTO_INCREMENT,
`address` varchar(45) DEFAULT NULL,
`content` varchar(255) DEFAULT NULL,
`date` date DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
`is_deleted` bit(1) DEFAULT 0,
`name` varchar(45) DEFAULT NULL,
`phone` varchar(45) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT 0,
  `submitted_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

create table customer (
`id` int NOT NULL AUTO_INCREMENT primary key,
`customer_name` varchar(30) DEFAULT NULL,
date_of_birth date,
id_card varchar(30) DEFAULT NULL,
gender varchar(30) DEFAULT NULL,
is_delete bit(1) default 0,
user_id int,
foreign key (user_id) references `user` (id)
);

CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_deleted` bit(1) DEFAULT 0,
  purchase_date date,
  total double,
  amount int,
  customer_id int,
  book_id int,
  PRIMARY KEY (`id`),
  foreign key (customer_id) references customer (id),
  foreign key (book_id) references book (id)
)
