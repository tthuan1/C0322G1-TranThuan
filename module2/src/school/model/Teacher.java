package school.model;

public class Teacher extends Person {
    private String teachingClass;
    private Double hourlySalary;
    private Double teachinHours;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String gender, String dateOfBirth, String address, String teachingClass, Double hourlySalary, Double teachinHours) {
        super(id, name, gender, dateOfBirth, address);
        this.teachingClass = teachingClass;
        this.hourlySalary = hourlySalary;
        this.teachinHours = teachinHours;
    }

    public String getTeachingClass() {
        return teachingClass;
    }

    public void setTeachingClass(String teachingClass) {
        this.teachingClass = teachingClass;
    }

    public Double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public Double getTeachinHours() {
        return teachinHours;
    }

    public void setTeachinHours(Double teachinHours) {
        this.teachinHours = teachinHours;
    }

    @Override
    public String coverToString() {
        return getId() + "," + getName() + "," + getGender() + "," + getDateOfBirth() + "," + getAddress() + "," + getTeachingClass() + "," + getHourlySalary() + "," + getTeachinHours();
    }

    @Override
    public String toString() {
        return "Teacher- " + super.toString() +
                ", lớp dạy: " + teachingClass + '\'' +
                ", Lương một giờ dạy: " + hourlySalary +
                ", Số giờ dạy trong tháng: " + teachinHours;
    }
}
