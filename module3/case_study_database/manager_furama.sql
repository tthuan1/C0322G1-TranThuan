CREATE DATABASE if not exists manager_furama;
use manager_furama;

CREATE TABLE if not exists vi_tri(
	ma_vi_tri int primary key,
    ten_vi_tri varchar(50)
);

CREATE TABLE if not exists trinh_do(
	ma_trinh_do int primary key,
	ten_trinh_do varchar(50)
);
CREATE TABLE if not exists bo_phan(
	ma_bo_phan int primary key,
    ten_bo_phan varchar(50)
);

CREATE TABLE if not exists nhan_vien(
	ma_nhan_vien int primary key,
    ho_ten VARCHAR(50),
    ngay_sinh DATE,
    so_cmnd VARCHAR(45),
    luong DOUBLE,
    so_dien_thoai VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    
    ma_vi_tri int,
    ma_trinh_do int,
    ma_bo_phan int,
    
    foreign key(ma_vi_tri) references vi_tri(ma_vi_tri), -- khoá ngoại
    foreign key(ma_trinh_do) references trinh_do(ma_trinh_do), -- khoá ngoại
    foreign key(ma_bo_phan) references bo_phan(ma_bo_phan) -- khoá ngoại
);

CREATE TABLE if not exists loai_khach(
	ma_loai_khach int PRIMARY KEY,
    ten_loai_khach varchar(45)
);

CREATE TABLE if not exists khach_hang(
	ma_khach_hang int primary key,
    loai_khach_hang int,
	ho_ten varchar(45),
    ngay_sinh date,
    gioi_tinh bit(1),
    so_cnnd varchar(45),
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    
    foreign key(loai_khach_hang) references loai_khach(loai_khach_hang) -- khoá ngoại
);

CREATE TABLE if not exists hop_dong_chi_tiet(
	ma_hop_dong_chi_tiet int primary key,
    ma_hop_dong int,
	ma_dich_vu_di_kem int,
    so_luong int,
    
    foreign key(loai_khach_hang) references loai_khach(loai_khach_hang) -- khoá ngoại
);


