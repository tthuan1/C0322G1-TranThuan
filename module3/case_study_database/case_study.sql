use manager_furama;

-- task 2
select * from nhan_vien
where ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%' and character_length(ho_ten)< 15;

-- task 3
select * from khach_hang
where (year(curdate())-year(ngay_sinh) between 18 and 50) and dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%'; 

-- task 4
select ma_khach_hang,ho_ten, count (hop_dong.ma_khach_hang) as so_lan_dat_phong from khach_hang

