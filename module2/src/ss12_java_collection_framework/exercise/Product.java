package ss12_java_collection_framework.exercise;

public class Product implements Comparable<Product> {
    private Integer id;
    private String name;
    private Integer price;

    public Product() {
    }

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sản phẩm: " +
                "id:" + id +
                ", name: " + name +
                ", price: " + price;
    }

    @Override
    public int compareTo(Product o) {
        return this.price - o.getPrice();
    }

}