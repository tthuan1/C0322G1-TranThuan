package ss17_binary_file_and_serialization.exercise.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productCode;
    private String productName;
    private String manufacturer;
    private int price;
    private String otherDescription;

    public Product() {
    }

    public Product(String productCode, String productName, String manufacturer, int price, String otherDescription) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.otherDescription = otherDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override
    public String toString() {
        return "Product- " +
                "Mã sản phẩm: " + productCode +
                ", tên sản phẩm: " + productName +
                ", hãn sản xuất: " + manufacturer +
                ", giá: " + price +
                ", mô tả khác: " + otherDescription ;
    }
}
