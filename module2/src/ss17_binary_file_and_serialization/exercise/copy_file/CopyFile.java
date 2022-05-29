package ss17_binary_file_and_serialization.exercise.copy_file;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập: ");
        String data = scanner.nextLine();
        writeFile("src/ss17_binary_file_and_serialization/exercise/copy_file/test.csv", data);
        copyFile();
    }

    public static void writeFile(String path, String  data) {
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("src/ss17_binary_file_and_serialization/exercise/copy_file/test.csv");
            outputStream = new FileOutputStream("src/ss17_binary_file_and_serialization/exercise/copy_file/newTest.csv");
            byte[] temp = new byte[1024];
            int length;
            while ((length = inputStream.read(temp)) > 0) {
                outputStream.write(temp, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
