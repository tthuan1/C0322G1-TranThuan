create database if not exists furama;
use furama;

create table  `position`(
	id int primary key auto_increment,
    `name` varchar(45)
);
create table education_degree(
	id int primary key auto_increment,
    `name` varchar(45)
);
create table division(
	id int primary key auto_increment,
    `name` varchar(45)
);
create table `role`(
	role_id int primary key auto_increment,
    `name` varchar(255)    
);
create table `user`(
	`username` varchar(255) primary key,
    password varchar(255)
);
create table user_role(
	role_id int,
    username varchar(255),
    foreign key(role_id) references role(role_id), -- khoá ngoại
    foreign key(username) references user(username) -- khoá ngoại
);
create table employee(
	id int primary key auto_increment,
    `name` varchar(45),
    date_of_birth date,
    id_card varchar(45),
    salary double,
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    
    position_id int,
    education_degree_id int,
    division_id int,
    username varchar(255),
    
    delete_at varchar(25),
    update_at varchar(25),
    create_at varchar(25),
    foreign key(position_id) references `position`(id), 
    foreign key(education_degree_id) references `education_degree`(id),
    foreign key(division_id) references `division`(id), 
    foreign key(username) references `user`(username)
);
create table customer_type(
	id int primary key auto_increment,
    `name`varchar(45)
);


create table customer(
	id int primary key auto_increment,
    customer_type_id int,
    `name` varchar(45),
    date_of_birth date,
    gender bit(1),
    id_card varchar(45),
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    
    delete_at varchar(25),
    update_at varchar(25),
    create_at varchar(25),
    foreign key(customer_type_id) references `customer_type`(id)
);
create table facility_type(
	id int primary key auto_increment,
    `name` varchar(45)
);
create table rent_type(
	id int primary key auto_increment,
    `name` varchar(45)
);
create table facility(
	id int primary key auto_increment,
    `name` varchar(45),
    area int,
    cost double,
    max_people int,
    rent_type_id int,
    facility_type_id int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    facility_free text,
    
    foreign key(rent_type_id) references `rent_type`(id),
    foreign key(facility_type_id) references `facility_type`(id)
);
create table contract(
	id int primary key auto_increment,
    start_date datetime,
    end_date datetime,
    deposit double,
    employee_id int,
    customer_id int,
    facility_id int,
    
    foreign key(employee_id) references `employee`(id),
    foreign key(customer_id) references `customer`(id),
    foreign key(facility_id) references `facility`(id)
);
create table attach_facility(
	id int primary key auto_increment,
    `name` varchar(45),
    cost double,
    unit varchar(10),
    `status` varchar(45)
);
create table contract_detail(
	id int primary key auto_increment,
    contract_id int,
    attach_facility_id int,
    quantity int,
    
    foreign key(contract_id) references `contract`(id),
    foreign key(attach_facility_id) references `attach_facility`(id)
);

insert into `position`(id,name)
values
(1,"Lễ tân"),
(2,"Phục vụ"),
(3,"Chuyên viên"),
(4,"Giám sát"),
(5,"Quản lý"),
(6,"Giám đốc");

insert into education_degree(id,`name`)
values
(1,"Trung cấp"),
(2,"Cao đẳng"),
(3,"Đại học"),
(4,"Sau đại học");

insert into division(id, `name`)
values
(1,"Sale – Marketing"),
(2,"Hành Chính"),
(3,"Phục vụ"),
(4,"Quản lý");
   
insert into employee(`name`,date_of_birth,id_card,salary,phone_number,email,address,position_id,education_degree_id,division_id,create_at)
values
('Nguyễn Văn An', '1994-01-08','456231786','10000000','0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1,curdate()),
('Lê Văn Bình', '1997-04-09','654231234','7000000','0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2,curdate()),
('Hồ Thị Yến','1995-12-12','999231723','14000000','0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2,curdate()),
('Võ Công Toản','1980-04-04','123231365','17000000','0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4,curdate()),
('Nguyễn Bỉnh Phát','1999-12-09','454363232','6000000','0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1,curdate()),
('Khúc Nguyễn An Nghi','2000-11-08','964542311','7000000','0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,3,3,curdate()),
('Nguyễn Hữu Hà','1993-01-01','534323231','8000000','0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2,curdate()),
('Nguyễn Hà Đông','1989-09-03','234414123','9000000','0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4,curdate()),
('Tòng Hoang','1982-09-03','256781231','6000000','0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4,curdate()),
('Nguyễn Công Đạo','1994-01-08','755434343','8000000','0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2,curdate());

insert into customer_type(`name`)
values
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');

insert into customer(customer_type_id,`name`,date_of_birth,gender,id_card,phone_number,email,address,create_at)
values (5,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',curdate()),
(3,'Phạm Xuân Diệu','1992-08-08',1,865342123,0954333333,'xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',curdate()),
(1,'Trương Đình Nghệ','1990-02-27',1,488645199,0373213122,'nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',curdate()),
(1,'Dương Văn Quan','1981-07-08',1,543432111,0490039241,'duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',curdate()),
(4,'Hoàng Trần Nhi Nhi','1995-12-09',0,795453345,0312345678,'nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',curdate()),
(4,'Tôn Nữ Mộc Châu','2005-12-06',0,732434215,0988888844,'tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',curdate()),
(1,'Nguyễn Mỹ Kim','1984-04-08',0,856453123,0912345698,'kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',curdate()),
(3,'Nguyễn Thị Hào','1999-04-08',0,965656433,0763212345,'haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',curdate()),
(1,'Trần Đại Danh','1994-07-01',1,432341235,0643343433,'danhhai99@gmail.com','24 Lý Thường Kiệt,Quảng Ngãi',curdate()),
(2,'Nguyễn Tâm Đắc','1989-07-01',1,344343432,0987654321,'dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',curdate());

insert into rent_type( `name`)
values
("Năm"),
("Tháng"),
("Ngày"),
("Giờ");

insert into facility_type(`name`)
values
("Villa"),
("House"),
("Room");

insert into facility(`name`,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floors,facility_free,rent_type_id,facility_type_id)
values
('Villa Beach Front','25000','10000000',10,'vip','Có hồ bơi',500,4,'không có',1,1),
('House Princess 01','14000','5000000',7,'vip','Có thêm bếp nướng',null,3,2,2,2),
('Room Twin 01','5000','1000000',2,'vip','Có tivi',null,null,4,3,3);

insert into contract(start_date,end_date,deposit,employee_id,customer_id,facility_id)
values
('2020-12-08','2020-12-08','0',3,1,3),
('2020-07-14','2020-07-21','0',7,3,1),
('2021-03-15','2021-03-17','0',3,4,2),
('2021-01-14','2021-01-18','0',7,5,2),
('2021-07-14','2021-07-15','0',7,2,1);
