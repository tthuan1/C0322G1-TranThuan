package model;

public class SoTietKiemDaiHan extends SoTietKiem {
    private String kiHan;
    private String uuDai;

    public SoTietKiemDaiHan() {
    }


    public SoTietKiemDaiHan(String maSoSo, Integer maKhachHang, String ngayMoSo, String thoiGianGui, String soTien, String laiXuat, String kiHan, String uuDai) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTien, laiXuat);
        this.kiHan = kiHan;
        this.uuDai = uuDai;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String covertoString() {
        return getMaSoSo() +
                "," + getMaKhachHang() +
                "," + getNgayMoSo() +
                "," + getThoiGianGui() +
                "," + getSoTien() +
                "," + getLaiXuat() +
                "," + kiHan +
                "," + uuDai;
    }

    @Override
    public String toString() {
        return "Số tiết kiệm dài hạn- " + super.toString() +
                ", kì hạn: " + kiHan +
                ", ưu đãi: " + uuDai;
    }
}
