package model.employee;

public class Education {
    Integer maTringDo;
    String tenTrinhDo;

    public Education(Integer maTringDo, String tenTrinhDo) {
        this.maTringDo = maTringDo;
        this.tenTrinhDo = tenTrinhDo;
    }

    public Education(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    public Education() {
    }

    public Integer getMaTringDo() {
        return maTringDo;
    }

    public void setMaTringDo(Integer maTringDo) {
        this.maTringDo = maTringDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }
}
