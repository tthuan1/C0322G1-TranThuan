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