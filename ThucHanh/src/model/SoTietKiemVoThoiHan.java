package model;

public class SoTietKiemVoThoiHan extends SoTietKiem {
    public SoTietKiemVoThoiHan() {
    }

    public SoTietKiemVoThoiHan(String maSoSo, Integer maKhachHang, String ngayMoSo, String thoiGianGui, String soTien, String laiXuat) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTien, laiXuat);
    }

    @Override
    public String covertoString() {
        return getMaSoSo() +
                "," + getMaKhachHang() +
                "," + getNgayMoSo() +
                "," + getThoiGianGui() +
                "," + getSoTien() +
                "," + getLaiXuat();
    }
    @Override
    public String toString() {
        return "Số tiền gửi vô thời hạn-"+
                " mã số sổ: " + getMaSoSo() +
                ", mã khách hàng: " + getMaKhachHang() +
                ", ngày mở sổ: " + getNgayMoSo() +
                ", thời gian gửi: " + getThoiGianGui() +
                ", số tiền gửi: " + getSoTien() +
                ", lãi xuất: " + getLaiXuat();
    }
}
