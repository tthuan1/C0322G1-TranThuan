-- task 13
-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
use manager_furama;

select  
	dvdk.ma_dich_vu_di_kem,	dvdk.ten_dich_vu_di_kem,
    ifnull(sum(hdct.so_luong),0) as so_luong_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem  >= all(
	select ifnull(sum(hop_dong_chi_tiet.so_luong),0)  from dich_vu_di_kem
    join hop_dong_chi_tiet  on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
    group by hop_dong_chi_tiet.ma_dich_vu_di_kem
);

