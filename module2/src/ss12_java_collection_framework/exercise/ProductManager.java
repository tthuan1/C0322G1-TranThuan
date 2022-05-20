package ss12_java_collection_framework.exercise;

import ss12_java_collection_framework.exercise.service.IProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager implements IProduct {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> product = new ArrayList<>();
//    static LinkedList<Product> product = new LinkedList<>();

    static {
        product.add(new Product(1, "điện thoại", 5000000));
        product.add(new Product(2, "tivi", 100000));
        product.add(new Product(4, "tủ lạnh", 3000000));
    }

    @Override
    public void add() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá tiền: ");
        int price = Integer.parseInt(scanner.nextLine());
        product.add(new Product(id, name, price));
    }

    @Override
    public void display() {
        for (Product value : product) {
            System.out.println(value);
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < product.size(); i++) {
            if (id == product.get(i).getId()) {
                product.remove(i);
                i--;
            }
        }
    }

    @Override
    public void search(String name) {
        for (Product value : product) {
            if (value.getName().contains(name)) {
                System.out.print(value);
            }
        }
    }

    @Override
    public void update(int idCheck) {
        int count = 0;
        for (Product value : product) {
            if (idCheck == value.getId()) {
                System.out.print("Nhập id thay thế: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập tên sản phẩm thay thế: ");
                String name = scanner.nextLine();
                System.out.print("Nhập giá tiền thay thế: ");
                int price = Integer.parseInt(scanner.nextLine());
                value.setId(id);
                value.setName(name);
                value.setPrice(price);
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Update thành công");
        } else {
            System.out.println("không có id này");
        }
    }

    @Override
    public void sortUpAscending() {
        Collections.sort(product);
        System.out.println("So sánh giá tăng dần:");
        display();
    }

    @Override
    public void sortDescending() {
        Collections.sort(product, (o1, o2) -> o2.getPrice() - o1.getPrice());
        System.out.println("So sánh giá giảm dần:");
        display();
    }
}
