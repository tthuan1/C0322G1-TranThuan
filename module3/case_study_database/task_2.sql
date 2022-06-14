use manager_furama;

-- task 2
select * from nhan_vien
where ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%' and character_length(ho_ten)< 15;