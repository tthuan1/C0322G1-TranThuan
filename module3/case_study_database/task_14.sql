-- task 14
-- Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (được tính dựa trên việc count các ma_dich_vu_di_kem).

use manager_furama;

select 
	hd.ma_hop_dong, 
	ldv.ten_loai_dich_vu, 
	dvdk.ten_dich_vu_di_kem, 
	count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung 
from hop_dong hd
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
group by hdct.ma_dich_vu_di_kem
having so_lan_su_dung = 1
order by so_lan_su_dung
;



