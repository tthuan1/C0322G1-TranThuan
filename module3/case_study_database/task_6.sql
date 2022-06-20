-- task 6

-- Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các 
-- loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
use manager_furama;
-- 
SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
        JOIN
    hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                JOIN
            hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) = '2021'
                AND MONTH(hop_dong.ngay_lam_hop_dong) BETWEEN 1 AND 3)
GROUP BY dv.ma_dich_vu
;
