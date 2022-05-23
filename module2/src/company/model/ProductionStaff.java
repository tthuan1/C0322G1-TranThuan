package company.model;

import company.severis.ITimekeeping;

public class ProductionStaff extends Person implements ITimekeeping {
    private Integer productNumber;

    public ProductionStaff() {
    }

    public ProductionStaff(String name, String dateOfBirth, String address, Integer productNumber) {
        super(name, dateOfBirth, address);
        this.productNumber = productNumber;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return "Nhân viên sản xuất- " + super.toString() +
                ", số sản phẩm: " + productNumber;
    }

    @Override
    public Double payroll() {
        return productNumber * 50.000;
    }

    @Override
    public void timekeeping() {
        System.out.println("Chấm công bằng mắt");
    }

}
