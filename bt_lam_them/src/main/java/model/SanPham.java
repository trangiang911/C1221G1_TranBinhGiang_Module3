package model;

public class SanPham {
    private Integer id;
    private String name;
    private String price;
    private String quantity;
    private String color;
    private Integer id_cate;

    public SanPham(Integer id, String name, String price, String quantity, String color, Integer id_cate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.id_cate = id_cate;
    }

    public SanPham(String name, String price, String quantity, String color, Integer id_cate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.id_cate = id_cate;
    }

    public SanPham() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId_cate() {
        return id_cate;
    }

    public void setId_cate(Integer id_cate) {
        this.id_cate = id_cate;
    }
}
