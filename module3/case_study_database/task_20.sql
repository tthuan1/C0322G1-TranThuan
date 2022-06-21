-- task 20
-- Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

use manager_furama;

select kh.ma_khach_hang as id ,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi from khach_hang kh
union
select nv.ma_nhan_vien as id ,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi from nhan_vien nv;