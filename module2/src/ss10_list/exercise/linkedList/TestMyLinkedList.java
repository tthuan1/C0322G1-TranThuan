package ss10_list.exercise.linkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        class Student {
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

        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "Thuận");
        Student student2 = new Student(1, "Hoàng");
        Student student3 = new Student(1, "Chiến");
        Student student4 = new Student(1, "Quang");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addFirst(student3);
        myLinkedList.addFirst(student4);

        myLinkedList.remove(1);

        System.out.println(myLinkedList.indexOf(student2));
        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
    }
}
