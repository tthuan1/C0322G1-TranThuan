create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table if not exists customer(
	c_id int primary key auto_increment,
    c_name varchar(40),
    c_age varchar(40)
);

create table if not exists `order`(
	o_id int primary key auto_increment,
    c_id int,
    o_date date,
    o_total_price double,
    foreign key (c_id) references customer(c_id)
);

create table if not exists product(
	p_id int primary key auto_increment,
    p_name varchar(40),
    p_price varchar(40)
);

create table if not exists order_detail(
	o_id int,
    p_id int,
    od_qty varchar(40),
    
    primary key(o_id,p_id),
    foreign key (o_id) references `order`(o_id),
    foreign key (p_id) references product(p_id)
);

insert into customer(c_name,c_age)
values ('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);

insert into product(p_name,p_price)
values ('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);

insert into `order`(c_id,o_date,o_total_price)
values ('1','2006-3-21',Null),
('2','2006/3/23',Null),
('1','2006/3/16',Null);


insert into order_detail(o_id,p_id,od_qty)
values (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
