-- task 18
-- Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
use manager_furama;

-- create view hop_dong_truoc_2021 as
-- select kh.ma_khach_hang from khach_hang kh
-- 		join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
-- 		where year(hd.ngay_lam_hop_dong) < 2021;

	SET SQL_SAFE_UPDATES = 0; 
update khach_hang
SET delete_at = curdate()
where ma_khach_hang in (
select * from (
	select * from hop_dong_truoc_2021  ) abc
);

select * from khach_hang
-- where isnull(delete_at)
where delete_at iS NOT null
;
