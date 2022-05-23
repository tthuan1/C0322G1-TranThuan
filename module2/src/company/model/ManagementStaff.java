package company.model;

import company.severis.ITimekeeping;

public class ManagementStaff extends Person implements ITimekeeping {
    private Integer basicSalary;
    private Double coefficientsSalary;

    public ManagementStaff() {
    }

    public ManagementStaff(String name, String dateOfBirth, String address, Integer basicSalary, Double coefficientsSalary) {
        super(name, dateOfBirth, address);
        this.basicSalary = basicSalary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(Double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public String toString() {
        return "Nhân viên quản lý-  " + super.toString() +
                ", số lương cơ bản: " + basicSalary +
                ", hệ số lương: " + coefficientsSalary;

    }
    @Override
    public Double payroll() {
        return basicSalary * coefficientsSalary;
    }

    @Override
    public void timekeeping() {
        System.out.println("Chấm công bằng máy");
    }

}
