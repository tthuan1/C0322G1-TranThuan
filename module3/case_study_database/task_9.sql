-- tast 9
-- Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

use manager_furama;

select month(ngay_lam_hop_dong) as `thang`, count(ngay_lam_hop_dong) as so_luong_khach_hang from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by `thang`
order by `thang`;







