package com.example.dto;

import com.example.model.DanhMuc;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TinTucDto implements Validator {
    private Integer maTinTuc;
    @NotBlank(message = "Không được để trống")
    @Size(max = 50,message = "Tiêu đề không được quá 50 kí tự")
    private String tieuDe;
    @NotBlank(message = "Không được để trống")
    @Size(max = 500,message = "Nội dung không được quá 500 kí tự")
    private String noiDung;
    @NotBlank(message = "Không được để trống")
    private String ngayDangTin;
    @NotBlank(message = "Không được để trống")
    private String phongVien;
    private DanhMuc danhMuc;

    public TinTucDto() {
    }

    public TinTucDto(Integer maTinTuc, String tieuDe, String noiDung, String ngayDangTin, String phongVien, DanhMuc danhMuc) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
