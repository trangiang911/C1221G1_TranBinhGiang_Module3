package model;

import java.util.Objects;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String summary;
    private String producer;

    public Product(Integer id, String name, Double price, String summary, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.summary = summary;
        this.producer = producer;
    }

    public Product() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }


}
