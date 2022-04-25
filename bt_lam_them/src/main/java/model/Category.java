package model;

public class Category {
    private Integer id_cate;
    private String name;

    public Category(Integer id_cate, String name) {
        this.id_cate = id_cate;
        this.name = name;
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Integer getId_cate() {
        return id_cate;
    }

    public void setId_cate(Integer id_cate) {
        this.id_cate = id_cate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
