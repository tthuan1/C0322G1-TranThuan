-- task 15
-- Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, 
-- ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

use manager_furama;

SELECT 
    nv.ma_nhan_vien,
    nv.ho_ten,
    td.ten_trinh_do,
    bp.ten_bo_phan,
    nv.so_dien_thoai,
    nv.dia_chi
FROM nhan_vien nv
        JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do
        JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan
        JOIN hop_dong hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
WHERE
    YEAR(hd.ngay_lam_hop_dong) BETWEEN 2020 AND 2021
GROUP BY nv.ma_nhan_vien
HAVING COUNT(hd.ma_hop_dong) <= 3
;





