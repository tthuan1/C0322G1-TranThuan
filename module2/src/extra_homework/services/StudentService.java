package extra_homework.services;

import extra_homework.model.Person;
import extra_homework.model.Student;

import java.util.Scanner;

import static extra_homework.controllers.DisplayMainMenu.count;
import static extra_homework.controllers.DisplayMainMenu.persons;

public class StudentService implements IServices {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập name: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập Point: ");
        int point = Integer.parseInt(scanner.nextLine());
        persons[count] = new Student(id, name, age, gender, point);
        count++;
    }

    @Override
    public void delete() {
        System.out.print("Nhập id cần xoá: ");
        String input = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] instanceof Student && input.equals(persons[i].getId())) { // kiếm phần tử muốn xoá
                flag = false;
                for (int j = i + 1; j < (persons.length - i); j++) {// ghi đè lại mảng tại vị trí muốn xoá thành vị trí sau đó
                    persons[i] = persons[j];
                }
                count--;
                System.out.println("Đã xoá sinh viên có id " + input);
                break;
            }
        }
        if (flag) {
            System.out.println("Không tìm thấy phần tử cần xoá");
        }
    }

    @Override
    public void search() {
        System.out.print("Nhập id cần tìm kiếm Student: ");
        String input = scanner.nextLine();
        boolean flag = true;
        for (Person person : persons) {
            if (person instanceof Student && input.equals(person.getId())) {
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
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }
}
