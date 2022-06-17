-- task 8
-- Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.

use manager_furama;

-- cách 1 sử dụng DISTINCT loại bỏ trùng lặp
select DISTINCT kh.ho_ten 
from khach_hang kh;

-- cách 2 gộp nhóm để loại bỏ trùng lặp
select kh.ho_ten 
from khach_hang kh
group by ho_ten
order by ho_ten;

-- cách 3 union gộp các câu truy vấn  và loại bỏ trùng lặp
select kh.ho_ten from khach_hang kh
union
select kh.ho_ten from khach_hang kh;
