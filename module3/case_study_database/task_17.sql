-- task 17

-- Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
use manager_furama;

UPDATE khach_hang 
SET 
    ma_loai_khach = 1
WHERE ma_loai_khach = 2 and
    ma_khach_hang in (
    select * from v_khach_hang
    );

-- create view v_khach_hang as 
select kh.ma_khach_hang
FROM khach_hang kh
	left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
    left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
    left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
    left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
    left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
    where kh.ma_loai_khach = 2
GROUP BY kh.ma_Khach_hang
having SUM(dv.chi_phi_thue + IFNULL((hdct.so_luong * dvdk.gia), 0)) >= 10000000;




