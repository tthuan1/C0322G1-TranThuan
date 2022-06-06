package companyABC.model;

public abstract class Person {
    private Integer id;
    private String employeeCode;
    private String name;
    private String dateOfBirth;
    private String address;

    public Person() {
    }

    public Person(Integer id, String employeeCode, String name, String dateOfBirth, String address) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    abstract String coverToString();

    @Override
    public String toString() {
        return "id: " + id +
                ", mã nhân viên: " + employeeCode +
                ", tên: " + name +
                ", ngày sinh: " + dateOfBirth +
                ", địa chỉ: " + address;
    }
}
