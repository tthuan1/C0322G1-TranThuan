package school.controllers;

import furama_resort.common.CheckException;
import school.services.Service;
import school.services.impl.StudentServiceImpl;
import school.services.impl.TeacherServiceImpl;

public class SchoolController {
    static Service student = new StudentServiceImpl();
    static Service teacher = new TeacherServiceImpl();

    public static void displayMainMenu() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "1. Hiển thị danh sách\n" +
                    "2. Thêm mới\n" +
                    "3. Xóa \n" +
                    "4. hiển thị sắp xếp\n" +
                    "5. Chỉnh sửa.\n" +
                    "6. Thoát \n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    display();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    displaySort();
                    break;
                case 5:
                    edit();
                    break;
                case 6:
                    System.out.println("program exited !!");
                    System.exit(6);
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        } while (true);
    }

    public static void display() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Display list student\n" +
                    "\t2. Display list teacher\n" +
                    "\t3. Return main menu\n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    student.display();
                    break;
                case 2:
                    teacher.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        } while (true);
    }

    public static void add() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Add new student\n" +
                    "\t2. Add new teacher\n" +
                    "\t3. Return main menu\n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    student.add();
                    break;
                case 2:
                    teacher.add();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        } while (true);
    }

    public static void delete() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Delete student\n" +
                    "\t2. Delete teacher\n" +
                    "\t3. Return main menu\n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    student.delete();
                    break;
                case 2:
                    teacher.delete();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        } while (true);
    }

    public static void displaySort() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Tên student tăng dần\n" +
                    "\t2. Tên teacher tăng dần\n" +
                    "\t3. Ngày sinh student tăng dần\n" +
                    "\t4. Ngày sinh teacher tăng dần\n" +
                    "\t5. Return main menu\n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    student.sortName();
                    break;
                case 2:
                    break;
                case 3:
                    student.sortDate();
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        } while (true);
    }

    public static void edit() {
        System.out.print("\t-----------------------------------------\n" +
                "\t1. edit student\n" +
                "\t2. edit teacher\n" +
                "\t3. Return main menu\n" +
                "\tEnter: ");
        int choose = CheckException.checkparseInt();
        switch (choose) {
            case 1:
                student.edit();
                break;
            case 2:
                teacher.edit();
                break;
            case 3:
                return;
            default:
                System.out.println("Nhập không có số đển chọn !!");
                break;
        }
    }

}
