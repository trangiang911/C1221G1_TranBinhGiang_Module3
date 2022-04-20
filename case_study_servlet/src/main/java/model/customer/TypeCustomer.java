package model.customer;

public class TypeCustomer {
    private Integer maLoaiKhachHang;
    private String loaiKhachHang;

    public TypeCustomer(Integer maLoaiKhachHang, String loaiKhachHang) {
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.loaiKhachHang = loaiKhachHang;
    }

    public TypeCustomer(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public TypeCustomer() {
    }

    public Integer getMaLoaiKhachHang() {
        return maLoaiKhachHang;
    }

    public void setMaLoaiKhachHang(Integer maLoaiKhachHang) {
        this.maLoaiKhachHang = maLoaiKhachHang;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
}
