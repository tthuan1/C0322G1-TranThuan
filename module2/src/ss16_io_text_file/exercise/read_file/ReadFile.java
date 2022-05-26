package ss16_io_text_file.exercise.read_file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/ss16_io_text_file/exercise/read_file/country.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                    list.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fie không tồn tại");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String s:list
             ) {
            System.out.println(s);
        }
    }

}
