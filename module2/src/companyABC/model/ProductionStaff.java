package companyABC.model;

public class ProductionStaff extends Person {
    //    Số sản phẩm, Giá mỗi sản phẩm
    private Integer product;
    private double price;

    public ProductionStaff() {
    }

    public ProductionStaff(Integer id, String employeeCode, String name, String dateOfBirth, String address, Integer product, Double price) {
        super(id, employeeCode, name, dateOfBirth, address);
        this.product = product;
        this.price = price;
    }

    @Override
    public String coverToString() {
        return super.getId() + "," + super.getEmployeeCode() + "," + super.getName() + "," + super.getDateOfBirth() + "," + super.getAddress() + "," + product + "," + price;
    }

    @Override
    public String toString() {
        return "ProductionStaff: " +
                super.toString() +
                "product=" + product +
                ", price=" + price;
    }
}
