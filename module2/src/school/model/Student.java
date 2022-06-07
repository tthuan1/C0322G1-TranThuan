package school.model;

import java.util.Objects;

public class Student extends Person {
    private Integer studentCode;
    private Double mediumScore;

    public Student() {
    }

    public Student(Integer id, String name, String gender, String dateOfBirth, String address, Integer studentCode, Double mediumScore) {
        super(id, name, gender, dateOfBirth, address);
        this.studentCode = studentCode;
        this.mediumScore = mediumScore;
    }

    public Integer getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Integer studentCode) {
        this.studentCode = studentCode;
    }

    public Double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(Double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String coverToString() {
        return getId() + "," + getName() + "," + getGender() + "," + getDateOfBirth() + "," + getAddress() + "," + getStudentCode() + "," + getMediumScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentCode.equals(student.studentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode);
    }

    @Override
    public String toString() {
        return "Student- " + super.toString() +
                ", studentCode: " + studentCode +
                ", mediumScore: " + mediumScore;
    }
}
