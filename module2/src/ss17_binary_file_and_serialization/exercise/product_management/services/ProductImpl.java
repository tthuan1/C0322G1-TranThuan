package ss17_binary_file_and_serialization.exercise.product_management.services;

import ss17_binary_file_and_serialization.exercise.product_management.common.WriteAndRead;
import ss17_binary_file_and_serialization.exercise.product_management.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductImpl implements IProduct {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();

    static {
        products = WriteAndRead.readFile("src/ss17_binary_file_and_serialization/exercise/product_management/data/data.dat");
    }

    @Override
    public void add() {
        System.out.print("Nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập hãn sãn xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập giá: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Mô tả khác: ");
        String otherDescription = scanner.nextLine();
        products.add(new Product(productCode, productName, manufacturer, price, otherDescription));
        WriteAndRead.writeFile("src/ss17_binary_file_and_serialization/exercise/product_management/data/data.dat", products);
    }

    @Override
    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void search() {
        System.out.print("Nhập mã sản phẩm cần tìm kiếm: ");
        String searchName = scanner.nextLine();
        for (Product product : products) {
            if (searchName.equals(product.getProductCode())) {
                System.out.println(product);
            }
        }
    }
}
