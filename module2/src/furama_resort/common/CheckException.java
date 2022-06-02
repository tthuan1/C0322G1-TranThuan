package furama_resort.common;

import java.util.Scanner;

public class CheckException {
    public static int checkparseInt() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt((new Scanner(System.in)).nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }

    public static double checkparseDouble() {
        Double value;
        while (true) {
            try {
                value = Double.parseDouble((new Scanner(System.in)).nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }

    public static String checkString() {
        String value;
        while (true) {
            try {
                value = (new Scanner(System.in)).nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập lại: ");
            }
        }
        return value;
    }

}
