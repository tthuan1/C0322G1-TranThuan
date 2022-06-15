create database if not exists material_management;
use material_management;

create table if not exists phieu_xuat(
	so_phieu_xuat int primary key auto_increment,
    ngay_xuat date
    
);

create table if not exists phieu_nhap(
	so_phieu_nhap int primary key auto_increment,
    ngay_nhap date
    
);

create table if not exists nha_cung_cap(
	ma_nha_cung_cap int primary key auto_increment,
    ten_nha_cung_cap varchar(40),
    dia_chi varchar(50),
    so_dien_thoai int
);

create table if not exists vat_tu(
	ma_vat_tu int primary key auto_increment,
    ten_vat_tu varchar(40)
);

create table if not exists don_hang(
	so_dat_hang int primary key,
    ma_nha_cung_cap int,
    ngay_dat_hang date,
    foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

-- chi tiết phiếu suất
create table if not exists chi_tiet_phieu_xuat(
	so_phieu_xuat int,
    ma_vat_tu int,
    d_g_xuat varchar(40),
    so_luong_xuat int,
    primary key(so_phieu_xuat,ma_vat_tu),
    foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);

-- chi tiết phiếu nhập
create table if not exists chi_tiet_phieu_nhap(
	so_phieu_nhap int,
    ma_vat_tu int,
    d_g_nhap varchar(40),
    so_luong_nhap int,
    primary key(so_phieu_nhap,ma_vat_tu),
    foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
-- chi tiết đơn đặt hàng
create table if not exists chi_tiet_don_dat_hang(
	ma_vat_tu int,
    so_dat_hang int,
    
    primary key(ma_vat_tu,so_dat_hang),
    foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
    foreign key(so_dat_hang) references don_hang(so_dat_hang)
);
