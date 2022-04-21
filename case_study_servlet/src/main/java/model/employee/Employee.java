package model.employee;

public class Employee {
    Integer maNhanVien;
    String hoTen;
    String ngaySinh;
    String cmnd;
    String luong;
    String sdt;
    String email;
    String diaChi;
    Integer maViTri;
    Integer maTrinhDo;
    Integer maBoPhan;

    public Employee(Integer maNhanVien, String hoTen, String ngaySinh, String cmnd, String luong, String sdt, String email, String diaChi, Integer maViTri, Integer maTrinhDo, Integer maBoPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.maViTri = maViTri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public Employee(String hoTen, String ngaySinh, String cmnd, String luong, String sdt, String email, String diaChi, Integer maViTri, Integer maTrinhDo, Integer maBoPhan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.maViTri = maViTri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public Employee() {
    }

    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
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

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public Integer getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(Integer maViTri) {
        this.maViTri = maViTri;
    }

    public Integer getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(Integer maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public Integer getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(Integer maBoPhan) {
        this.maBoPhan = maBoPhan;
    }
}
