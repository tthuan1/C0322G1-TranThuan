package companyABC.model;

public class ManagementStaff extends Person {
    private Double basicSalary;
    private Double coefficientsSalary;

    public ManagementStaff() {
    }

    public ManagementStaff(Integer id, String employeeCode, String name, String dateOfBirth, String address, Double basicSalary, Double coefficientsSalary) {
        super(id, employeeCode, name, dateOfBirth, address);
        this.basicSalary = basicSalary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(Double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public String coverToString() {
        return super.getId()+"," + super.getEmployeeCode()+"," + super.getName() + "," + super.getDateOfBirth() + "," + super.getAddress() + "," + basicSalary + "," + coefficientsSalary;
    }

    @Override
    public String toString() {
        return "ManagementStaff{" + super.toString() +
                "basicSalary=" + basicSalary +
                ", coefficientsSalary=" + coefficientsSalary +
                '}';
    }
}
