package ss17_binary_file_and_serialization.exercise.cotroller;


import ss17_binary_file_and_serialization.exercise.services.ProductImpl;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        boolean flag = true;
        ProductImpl product=new ProductImpl();
        do {
            System.out.print("\n----Menu----" +
                    "\n1. Thêm" +
                    "\n2. Hiển thị" +
                    "\n3. Tìm kiếm" +
                    "\n4.\tExit" +
                    "\nNhập: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    product.add();
                    break;
                case 2:
                    product.display();
                    break;
                case 3:
                    product.search();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    break;
            }
        } while (flag);
    }
}
