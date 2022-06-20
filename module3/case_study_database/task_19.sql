-- task 19
-- Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
use manager_furama;

create view v_gia as
select dvdk.ma_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
where year(hd.ngay_lam_hop_dong) = 2020 
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong) >= 10;

SET SQL_SAFE_UPDATES = 0;
UPDATE dich_vu_di_kem 
SET gia = gia + gia
WHERE ma_dich_vu_di_kem  in (
    select * from v_gia);
    
select * from dich_vu_di_kem;

