package model;

public class SoTietKiemCoThoiHan extends SoTietKiem {
    private String kiHan;

    public SoTietKiemCoThoiHan() {
    }

    public SoTietKiemCoThoiHan(String maSoSo, Integer maKhachHang, String ngayMoSo, String thoiGianGui, String soTien, String laiXuat, String kiHan) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTien, laiXuat);
        this.kiHan = kiHan;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String covertoString() {
        return getMaSoSo() +
                "," + getMaKhachHang() +
                "," + getNgayMoSo() +
                "," + getThoiGianGui() +
                "," + getSoTien() +
                "," + getLaiXuat() +
                "," + kiHan;
    }

    @Override
    public String toString() {
        return "Số tiết kiệm có thời hạn- " + super.toString() +
                ", kì hạn: " + kiHan;
    }
}
