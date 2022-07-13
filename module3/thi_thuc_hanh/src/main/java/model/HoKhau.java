package model;

public class HoKhau {
    private String maHoKhau;
    private String tenChuHo;
    private Integer soLuong;
    private String ngayLapHoKhau;
    private String diaChiNha;
    private Integer maThanhVien;

    public HoKhau() {
    }

    public HoKhau(String maHoKhau, String tenChuHo, Integer soLuong, String ngayLapHoKhau, String diaChiNha) {
        this.maHoKhau = maHoKhau;
        this.tenChuHo = tenChuHo;
        this.soLuong = soLuong;
        this.ngayLapHoKhau = ngayLapHoKhau;
        this.diaChiNha = diaChiNha;
    }

    public HoKhau(String maHoKhau, String tenChuHo, Integer soLuong, String ngayLapHoKhau, String diaChiNha, Integer maThanhVien) {
        this.maHoKhau = maHoKhau;
        this.tenChuHo = tenChuHo;
        this.soLuong = soLuong;
        this.ngayLapHoKhau = ngayLapHoKhau;
        this.diaChiNha = diaChiNha;
        this.maThanhVien = maThanhVien;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayLapHoKhau() {
        return ngayLapHoKhau;
    }

    public void setNgayLapHoKhau(String ngayLapHoKhau) {
        this.ngayLapHoKhau = ngayLapHoKhau;
    }

    public String getDiaChiNha() {
        return diaChiNha;
    }

    public void setDiaChiNha(String diaChiNha) {
        this.diaChiNha = diaChiNha;
    }

    public Integer getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(Integer maThanhVien) {
        this.maThanhVien = maThanhVien;
    }
}
