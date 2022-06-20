-- task 16
-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

use manager_furama;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM nhan_vien
WHERE
    ma_nhan_vien NOT IN (SELECT * FROM(SELECT nhan_vien.ma_nhan_vien FROM nhan_vien
        JOIN hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
            AND YEAR(ngay_lam_hop_dong) BETWEEN '2019' AND '2021') temp_table);
 SET SQL_SAFE_UPDATES = 1;
 
 select * from nhan_vien;

