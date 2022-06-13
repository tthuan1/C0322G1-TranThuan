package model;

public abstract class SoTietKiem {
    private String maSoSo;
    private Integer maKhachHang;
    private String ngayMoSo;
    private String thoiGianGui;
    private String soTien;
    private String laiXuat;

    public SoTietKiem() {
    }

    public SoTietKiem(String maSoSo, Integer maKhachHang, String ngayMoSo, String thoiGianGui, String soTien, String laiXuat) {
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianGui = thoiGianGui;
        this.soTien = soTien;
        this.laiXuat = laiXuat;
    }

    public String getMaSoSo() {
        return maSoSo;
    }

    public void setMaSoSo(String maSoSo) {
        this.maSoSo = maSoSo;
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public String getLaiXuat() {
        return laiXuat;
    }

    public void setLaiXuat(String laiXuat) {
        this.laiXuat = laiXuat;
    }

    abstract String covertoString();

    @Override
    public String toString() {
        return "mã số sổ: " + maSoSo +
                ", mã khách hàng: " + maKhachHang +
                ", ngày mở sổ: " + ngayMoSo +
                ", thời gian gửi: " + thoiGianGui +
                ", số tiền gửi: " + soTien +
                ", lãi xuất: " + laiXuat;
    }
}
