package school.common;

import java.util.Scanner;

public class CheckException {
    static Scanner scanner = new Scanner(System.in);

    public static int checkparseInt() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }

    public static Double checkparseDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }

    public static String checkString() {
        String value = scanner.nextLine();
        while (true) {
            try {
                int check = 1 / value.length();
                break;
            } catch (Exception e) {
                System.out.print("Nhập rổng yêu cầu nhập lại: ");
                value = scanner.nextLine();
            }
        }
        return value;
    }

}
