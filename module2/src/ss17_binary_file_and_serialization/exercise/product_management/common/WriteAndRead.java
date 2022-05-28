package ss17_binary_file_and_serialization.exercise.product_management.common;


import ss17_binary_file_and_serialization.exercise.product_management.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndRead {
    public static List<Product> readFile(String fileDataProduct) {
        List<Product> productList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(fileDataProduct);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            System.out.println("File is empty");
        }
        return productList;
    }

    public static void writeFile(String fileDataProduct, List<Product> productList) {
        try {
            FileOutputStream fos = new FileOutputStream(fileDataProduct);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            fos.close();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
