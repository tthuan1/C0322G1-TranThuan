-- task 21
-- Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
use manager_furama;

create view v_nhan_vien as
select nv.*, hd.ngay_lam_hop_dong from nhan_vien nv
left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where ngay_lam_hop_dong ="2019/12/12" and dia_chi like "%Hải Châu%"
group by ma_nhan_vien ;


