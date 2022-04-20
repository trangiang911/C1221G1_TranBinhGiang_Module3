package model.service_model;

public class Service {
    Integer maDichVu;
    String tenDichVu;
    Integer dienTich;
    Double chiPhiThue;
    Integer soNguoiToiDa;
    Integer KieuThue;
    Integer maLoaiDichVu;
    String matieuChuanPhong;
    String moTa;
    Double dienTichHoBoi;
    Integer soTang;

    public Service(Integer maDichVu, String tenDichVu, Integer dienTich, Double chiPhiThue, Integer soNguoiToiDa, Integer kieuThue, Integer maLoaiDichVu, String matieuChuanPhong, String moTa, Double dienTichHoBoi, Integer soTang) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.KieuThue = kieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.matieuChuanPhong = matieuChuanPhong;
        this.moTa = moTa;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Service(String tenDichVu, Integer dienTich, Double chiPhiThue, Integer soNguoiToiDa, Integer kieuThue, Integer maLoaiDichVu, String matieuChuanPhong, String moTa, Double dienTichHoBoi, Integer soTang) {
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.KieuThue = kieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.matieuChuanPhong = matieuChuanPhong;
        this.moTa = moTa;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Service() {
    }

    public Integer getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(Integer maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Integer getDienTich() {
        return dienTich;
    }

    public void setDienTich(Integer dienTich) {
        this.dienTich = dienTich;
    }

    public Double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(Double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public Integer getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(Integer soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public Integer getKieuThue() {
        return KieuThue;
    }

    public void setKieuThue(Integer kieuThue) {
        KieuThue = kieuThue;
    }

    public Integer getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(Integer maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getMatieuChuanPhong() {
        return matieuChuanPhong;
    }

    public void setMatieuChuanPhong(String matieuChuanPhong) {
        this.matieuChuanPhong = matieuChuanPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(Double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public Integer getSoTang() {
        return soTang;
    }

    public void setSoTang(Integer soTang) {
        this.soTang = soTang;
    }
}