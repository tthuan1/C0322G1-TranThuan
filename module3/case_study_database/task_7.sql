-- tast 7
-- Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của 
-- tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

use manager_furama;

SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
        JOIN
    hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
WHERE
    YEAR(hd.ngay_lam_hop_dong) = 2020
GROUP BY dv.ma_dich_vu , dv.ten_dich_vu , dv.dien_tich , dv.so_nguoi_toi_da , dv.chi_phi_thue , ldv.ten_loai_dich_vu
HAVING dv.ma_dich_vu NOT IN (SELECT 
        dich_vu.ma_dich_vu
    FROM
        dich_vu
            JOIN
        hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
    WHERE
        YEAR(hop_dong.ngay_lam_hop_dong) = 2021);
;