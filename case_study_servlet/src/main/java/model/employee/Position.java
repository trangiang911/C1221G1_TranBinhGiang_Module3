package model.employee;

public class Position {
    Integer maViTri;
    String tenViTri;

    public Position(Integer maViTri, String tenViTri) {
        this.maViTri = maViTri;
        this.tenViTri = tenViTri;
    }

    public Position(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public Position() {
    }

    public Integer getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(Integer maViTri) {
        this.maViTri = maViTri;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }
}
