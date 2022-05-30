package ss19_string_regex.exercise;

import java.util.Scanner;

public class ValidatePhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumbel;
        System.out.print("Ví dụ số điện thoại hợp lệ: (84)-(0978489648)" +
                "\nVí dụ tên lớp không hợp lệ: (a8)-(22222222)" +
                "\nNhập số điện thoại: ");
        phoneNumbel = scanner.nextLine();
        String regex = "^\\([0-9]{2}\\)-\\((0)[0-9]{9}\\)$";
        String regex1 = "^(0)[0-9]{9}$";
        while ((!phoneNumbel.matches(regex)) && (!phoneNumbel.matches(regex1))) {
            System.out.println("Nhập không đúng định dạng số điện thoại" +
                    "\nYêu cầu nhập lại lại đây: ");
            phoneNumbel = scanner.nextLine();
        }
        System.out.print("Đã nhập thành công số điện thoại " + phoneNumbel);
    }
}
