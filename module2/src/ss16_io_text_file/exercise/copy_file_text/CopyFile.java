package ss16_io_text_file.exercise.copy_file_text;

import furama_resort.model.person.Employee;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        copyFile();
    }
    public static void copyFile() {
        List<String> list=new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/ss16_io_text_file/exercise/copy_file_text/test.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split("");
                list.add(String.valueOf(temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("src/ss16_io_text_file/exercise/copy_file_text/newTest.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }


}
