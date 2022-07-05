package model;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String describe;
    private String producer;
    private String delete;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String describe, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.producer = producer;
    }

    public Product(String name, Double price, String describe, String producer) {
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.producer = producer;
    }

    public Product(Integer id, String name, Double price, String describe, String producer, String delete) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.producer = producer;
        this.delete = delete;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
}
