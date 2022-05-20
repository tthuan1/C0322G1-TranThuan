package ss12_java_collection_framework.exercise;

import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        boolean flag = true;
        do {
            System.out.print("\n1. Thêm sản phẩm \n" +
                    "2. Sửa thông tin sản phẩm theo id\n" +
                    "3. Xoá sản phẩm theo id\n" +
                    "4. Hiển thị danh sách sản phẩm\n" +
                    "5. Tìm kiếm sản phẩm theo tên\n" +
                    "6. Sắp xếp sản phẩm tăng dần theo giá\n" +
                    "7. Sắp xếp sản phẩm giảm dần theo giá\n" +
                    "8. Thoát\n" +
                    "Nhập đi: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    updateView();
                    break;
                case 3:
                    deleteView();
                    break;
                case 4:
                    productManager.display();
                    break;
                case 5:
                    searchView();
                    break;
                case 6:
                    System.out.println("sắp sếp");
                    productManager.sortUpAscending();
                    break;
                case 7:
                    productManager.sortDescending();
                    break;
                case 8:
                    flag = false;
                    System.out.println("Chương trình đã thoát");
                    break;
                default:
            }
        } while (flag);
    }

    public static void deleteView() {
        System.out.print("\nNhập id muốn xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        productManager.delete(id);
        System.out.print("Xoá thành công!!\n");
    }

    public static void searchView() {
        System.out.print("\nNhập nên sản phẩm tìm kiếm: ");
        String name = scanner.nextLine();
        productManager.search(name);
    }

    public static void updateView() {
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        productManager.update(id);
    }

}
