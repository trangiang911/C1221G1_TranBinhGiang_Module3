package model.customer;

import java.util.Date;

public class Customer {
    private Integer maKhachHang;
    private Integer maLoaiKhach;
    private String hoTen;
    private String ngaySinh;
    private Integer gioiTinh;
    private String soCMND;
    private String soDienThoai;
    private String email;
    private String diaChi;

    public Customer(Integer maKhachHang, Integer maLoaiKhach, String hoTen, String ngaySinh, Integer gioiTinh, String soCMND, String soDienThoai, String email, String diaChi) {
        super();
        this.maKhachHang = maKhachHang;
        this.maLoaiKhach = maLoaiKhach;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Customer(Integer maLoaiKhach, String hoTen, String ngaySinh, Integer gioiTinh, String soCMND, String soDienThoai, String email, String diaChi) {
        super();
        this.maLoaiKhach = maLoaiKhach;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Customer() {
        super();
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Integer getMaLoaiKhach() {
        return maLoaiKhach;
    }

    public void setMaLoaiKhach(Integer maLoaiKhach) {
        this.maLoaiKhach = maLoaiKhach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
