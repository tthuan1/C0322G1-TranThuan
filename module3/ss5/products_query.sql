CREATE DATABASE if not exists demo;
use demo;
CREATE table if not exists products(
id int auto_increment primary key,
product_code varchar(40),
product_name varchar(40),
product_price double,
product_amount int,
product_description varchar(40),
product_status varchar(40)
);
insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
values  ('DT-001','iphone', 10, 12,'chính hảng', 'new' ),
		('DT-002','sasung', 9, 6,'chính hảng', 'new' ),
		('DT-003','bphone', 5, 14,'xách tay', 'new' ) ;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create index unique_index on products(product_code);


-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index  composite_index 
on products(product_name , product_price);


-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN select * from products where product_name = 'iphone';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW view_products AS
SELECT product_code, product_name, product_price, product_status
FROM products;

SELECT * from view_products;

-- Tiến hành sửa đổi view
update  view_products SET product_code = "DT-001"
where product_name = "iphone";
SELECT * from view_products;

-- Tiến hành xoá view
drop VIEW view_products;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure store_procedure()
begin
	select * from products; 
end
// delimiter ;

call store_procedure();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure new_store_procedure(
product_code varchar(40),
product_name varchar(40),
product_price double,
product_amount int,
product_description varchar(40),
product_status varchar(40)
)
begin
	insert into products (product_code, product_name, product_price, product_amount, product_description,product_status) 
    values (product_code, product_name, product_price, product_amount, product_description,product_status);
end
// delimiter ;

call new_store_procedure('DT-005','iphonee', 10, 12,'chính hảng', 'new');

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_store_procedure(edit_product_price double)
begin
	update products set product_price = edit_product_price where id = 5;
end
// delimiter ;

call edit_store_procedure(8);

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_store_procedure(delete_product_id int)
begin
	delete from products where id = delete_product_id;
end
// delimiter ;

call delete_store_procedure(5);