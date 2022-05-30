package ss19_string_regex.exercise;

import java.util.Scanner;

public class ValidateClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String className;
        System.out.print("Ví dụ tên lớp hợp lệ: C0318G" +
                "\nVí dụ tên lớp không hợp lệ: M0318G, P0323A" +
                "\nNhập tên lớp: ");
        className = scanner.nextLine();
        String regex = "^[A,C,P][0-9]{4}[G-M]$";
        while (!className.matches(regex)) {
            System.out.println("Nhập không đúng định dạng tên class!!" +
                    "\nYêu cầu nhập lại lại đây: ");
            className = scanner.nextLine();
        }
        System.out.print("Đã nhập thành công tên lớp " + className);
    }
}
