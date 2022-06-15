use quan_ly_ban_hang;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select * from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.c_name, product.p_name from customer
join `order` on customer.c_id = `order`.c_id
join order_detail on `order`.o_id = order_detail.o_idß
join product on order_detail.p_id = product.p_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.c_name from customer
left join `order` o on customer.c_id = o.c_id
where  o.c_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng 
-- tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.o_id, o.o_date,sum(od.od_qty * p.p_price) as tong_tien
from `order` o
join order_detail od on o.o_id = od.o_id
join product p       on p.p_id = od.p_id 
group by o.o_id;
