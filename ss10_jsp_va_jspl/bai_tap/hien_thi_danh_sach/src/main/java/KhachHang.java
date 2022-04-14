import java.util.Date;

public class KhachHang {
    public String name;
    public String date;
    public String diaChi;
    public String avt;

    public KhachHang(String name, String date, String diaChi, String avt) {
        this.name = name;
        this.date = date;
        this.diaChi = diaChi;
        this.avt = avt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    @Override
    public String toString() {
        return "khachHang{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", avt='" + avt + '\'' +
                '}';
    }
}
