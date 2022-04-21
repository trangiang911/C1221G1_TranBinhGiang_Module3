package model.employee;

public class Division {
    Integer maBoPhan;
    String tenBoPhan;

    public Division(Integer maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }

    public Division(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public Division() {
    }

    public Integer getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(Integer maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
}
