package model;

public class ThanhVien {
    private String CMND;
    private String hoVaTen;
    private String ngaySinh;
    private Integer maThanhVien;

    public ThanhVien(String CMND, String hoVaTen, String ngaySinh, Integer maThanhVien) {
        this.CMND = CMND;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.maThanhVien = maThanhVien;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(Integer maThanhVien) {
        this.maThanhVien = maThanhVien;
    }
}
