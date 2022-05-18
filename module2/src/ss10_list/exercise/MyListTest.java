package ss10_list.exercise;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "hoan");
        Student b = new Student(2, "huy");
        Student c = new Student(3, "tuan");
        Student d = new Student(4, "tu");
        Student e = new Student(5, "minh");
        Student f = new Student(6, "vuong");

        MyList<Student> studentMyList = new MyList<>();

        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);

        for (int i = 0; i < studentMyList.size(); i++) {
            Student student = (Student) studentMyList.elements[i];
            System.out.print(student.getId() + "\t");
            System.out.println(student.getName());
        }
        System.out.println("size: " + studentMyList.size());
        System.out.println(studentMyList.get(3).getName());
        System.out.println(studentMyList.indexOf(f));
        System.out.println(studentMyList.contains(d));

        MyList<Student> newMyList = new MyList<>();
        newMyList = studentMyList.clone();
        for (int i = 0; i < newMyList.size(); i++) {
            System.out.println(newMyList.get(i).getName());
        }
        newMyList.remove(3);
        for (int i = 0; i < newMyList.size(); i++) {
            System.out.println(newMyList.get(i).getId());
            System.out.println(newMyList.get(i).getName());
        }
    }
}
