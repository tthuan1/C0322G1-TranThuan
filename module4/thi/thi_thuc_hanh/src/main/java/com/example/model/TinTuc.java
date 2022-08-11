package com.example.model;

import javax.persistence.*;

@Entity(name = "tin_tuc")
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maTinTuc;
    private String tieuDe;
    private String noiDung;
    private String ngayDangTin;
    private String phongVien;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "danh_muc_id",referencedColumnName = "id")
    private DanhMuc danhMuc;

    public TinTuc() {
    }

    public TinTuc(Integer maTinTuc, String tieuDe, String noiDung, String ngayDangTin, String phongVien, DanhMuc danhMuc) {
        this.maTinTuc = maTinTuc;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
    }

    public Integer getMaTinTuc() {
        return maTinTuc;
    }

    public void setMaTinTuc(Integer maTinTuc) {
        this.maTinTuc = maTinTuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(String ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
