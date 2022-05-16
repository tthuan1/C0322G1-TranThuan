package extra_homework.controllers;

import extra_homework.model.Person;
import extra_homework.model.Student;
import extra_homework.model.Teacher;
import extra_homework.services.StudentService;
import extra_homework.services.TeacherService;

import java.util.Scanner;

public class DisplayMainMenu {
    public static Person[] persons = new Person[1000];
    public static int count = 4;
    static Scanner scanner = new Scanner(System.in);

    static {
        persons[0] = new Student("SV1", "Thuận", 18, "Nam", 45);
        persons[1] = new Student("SV2", "Hoàn", 20, "Nam", 75);
        persons[2] = new Teacher("GV1", "Quang", 21, "Nam", 8000000);
        persons[3] = new Teacher("GV2", "Chiến", 21, "Nam", 10000000);
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.print("-------Menu---------\n" +
                    "\t1. Add Student\n" +
                    "\t2. Xóa Student\n" +
                    "\t3. Search Student\n" +
                    "\t4. Hiển thị danh sách Student\n" +
                    "\t5. Thêm mới Teacher\n" +
                    "\t6. Xóa Teacher\n" +
                    "\t7. Tìm kiếm Teacher\n" +
                    "\t8. Hiển thị danh sách Teacher\n" +
                    "\t9. Hiển thị tất cả\n" +
                    "\t10. Exit\n" +
                    "\t Choose: ");
            int choose = Integer.parseInt(scanner.nextLine());
            StudentService studen = new StudentService();
            TeacherService teacher = new TeacherService();
            switch (choose) {
                case 1:
                    studen.add();
                    break;
                case 2:
                    studen.delete();
                    break;
                case 3:
                    studen.search();
                    break;
                case 4:
                    studen.display();
                    break;
                case 5:
                    teacher.add();
                    break;
                case 6:
                    teacher.delete();
                    break;
                case 7:
                    teacher.search();
                    break;
                case 8:
                    teacher.display();
                    break;
                case 9:
                    studen.display();
                    teacher.display();
                    break;
                case 10:
                    flag = true;
                    System.out.println("Đã thoát");
                    break;
                default:
                    System.out.println("Nhập sai!");
                    break;
            }
        } while (!flag);
    }
}
