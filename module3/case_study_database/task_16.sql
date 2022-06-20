-- task 16
-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

use manager_furama;

select  nv.ma_nhan_vien,nv.ho_ten  from nhan_vien nv
left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where isnull(year(hd.ngay_lam_hop_dong) between 2019 and 2021) 
;

