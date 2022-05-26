package ss16_io_text_file.exercise.copy_file_text;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        copyFile();
    }

    public static void copyFile() {
        File fileR = new File("src/ss16_io_text_file/exercise/copy_file_text/test.txt");
        File fileW = new File("src/ss16_io_text_file/exercise/copy_file_text/newTest.txt");
        try (FileReader fileReader = new FileReader(fileR);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(fileW, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line = bufferedReader.readLine();

            if (fileR.exists()) {
                System.out.println("tập tin đích đã tồn tại! bạn có muốn thay đổi ?" + "\ny\tn");
                String input = scanner.nextLine();
                if (input.equals("y")) {
                    PrintWriter writer = new PrintWriter("src/ss16_io_text_file/exercise/copy_file_text/newTest.txt");
                    writer.print("");
                    writer.close();
                    if (line != null) {
                        bufferedWriter.write(line);
                    }
                    while ((line = bufferedReader.readLine()) != null) {
                        bufferedWriter.newLine();
                        bufferedWriter.write(line);
                    }
                } else if (input.equals("n")) {
                    System.out.println("Không copy file !!");
                } else {
                    System.out.println("Chọn không đúng!!");
                }
            } else {
                if (line != null) {
                    bufferedWriter.write(line);
                }
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.newLine();
                    bufferedWriter.write(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Đường dẫn sai !!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
