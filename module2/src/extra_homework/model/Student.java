package extra_homework.model;

public class Student extends Person {
    private int point;

    public Student() {
    }

    public Student(String id, String name, int age, String gender, int point) {
        super(id, name, age, gender);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student-" +super.toString()+
                "point: " + point;
    }
}
