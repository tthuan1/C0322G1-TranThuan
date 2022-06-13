package model;

public class KhachHang {
    private Integer maKhachHang;
    private String tenKhachHang;
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(Integer maKhachHang, String tenKhachHang, String ngaySinh, String gioiTinh, String soDienThoai, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }
    public String coverToString(){
        return "," + maKhachHang +
                "," + tenKhachHang +
                "," + ngaySinh +
                "," + gioiTinh +
                "," + soDienThoai +
                "," + diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang-" +
                " maKhachHang: " + maKhachHang +
                ", tenKhachHang='" + tenKhachHang +
                ", ngaySinh='" + ngaySinh +
                ", gioiTinh='" + gioiTinh +
                ", soDienThoai='" + soDienThoai +
                ", diaChi='" + diaChi;
    }
}
