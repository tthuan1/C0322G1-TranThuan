use manager_furama;
-- task 3
select * from khach_hang
where (year(curdate())-year(ngay_sinh) between 18 and 50) and dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%'; 