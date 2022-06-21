-- task 12
-- Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách
-- hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

use manager_furama;

SELECT 
    hd.ngay_lam_hop_dong,
    hd.ma_hop_dong,
    nv.ho_ten AS ho_ten_nhan_vien,
    kh.ho_ten AS ho_ten_khach_hang,
    kh.so_dien_thoai AS sdt_khach_hang,
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    IFNULL(SUM(hdct.so_luong), 0) AS so_luong_dich_vu_di_kem,
    hd.tien_dat_coc
FROM
    hop_dong hd 
    LEFT JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang 
    LEFT JOIN nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
	LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
	LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
WHERE
    (hd.ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-30')
        AND hd.ma_hop_dong NOT IN (SELECT 
            hop_dong.ma_hop_dong
        FROM
            hop_dong
        WHERE
            YEAR(ngay_lam_hop_dong) = '2021'
                AND MONTH(ngay_lam_hop_dong) BETWEEN 01 AND 6)
GROUP BY hd.ma_hop_dong;


