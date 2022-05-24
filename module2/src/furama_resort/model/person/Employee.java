package furama_resort.model.person;

public class Employee extends Person {
    private String employeeCode;
    private String level;
    private String position;
    private Integer salary;

    public Employee() {
    }

    public Employee(String employeeCode, String name, String date, String gender, String identityCard, String numberPhone, String email, String level, String position, Integer salary) {
        super(name, date, gender, identityCard, numberPhone, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String coverToString() {
        return employeeCode + "," + getName() + "," + getDate() + "," + getGender() + "," + getIdentityCard() + "," + getPhoneNumber() + ","
                + getEmail() + "," + level + "," + position + "," + salary;
    }

    @Override
    public String toString() {
        return "Employee-" +
                " employeeCode: " + employeeCode +
                super.toString() +
                ", level: " + level +
                ", position: " + position +
                ", salary: " + salary;
    }
}
