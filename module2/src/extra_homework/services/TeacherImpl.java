package extra_homework.services;

import extra_homework.model.Person;
import extra_homework.model.Student;
import extra_homework.model.Teacher;

import java.util.Scanner;

import static extra_homework.controllers.DisplayMainMenu.count;
import static extra_homework.controllers.DisplayMainMenu.persons;

public class TeacherImpl implements Iservices {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        Person student = new Student();
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập name: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập Point: ");
        int salary = Integer.parseInt(scanner.nextLine());
        persons[count] = new Teacher(id, name, age, gender, salary);
        count++;
    }

    @Override
    public void delete() {
        System.out.print("Nhập id cần xoá: ");
        String input = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] instanceof Teacher && input.equals(persons[i].getId())) {
                flag = false;
                for (int j = i+1; j < (persons.length-i); j++) {
                    persons[i]=persons[j];
                }
                count--;
                System.out.println("Đã xoá giáo viên có id "+input);
                break;
            }
        }
        if (flag) {
            System.out.println("Không tìm thấy phần tử cần xoá");
        }
    }

    @Override
    public void search() {
        System.out.print("Nhập id cần tìm kiếm Teacher: ");
        String input = scanner.nextLine();
        boolean flag = true;
        for (Person person : persons) {
            if (person instanceof Teacher && input.equals(person.getId())) {
                System.out.println(person);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Không tìm thấy !!!");
        }
    }

    @Override
    public void display() {
        for (Person person : persons) {
            if (person instanceof Teacher) {
                System.out.println(person);
            }
        }
    }
}
