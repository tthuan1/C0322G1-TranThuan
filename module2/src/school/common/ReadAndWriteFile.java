package school.common;

import furama_resort.model.Booking;
import furama_resort.model.Contract;
import furama_resort.model.facility.Facility;
import furama_resort.model.facility.House;
import furama_resort.model.facility.Room;
import furama_resort.model.facility.Villa;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;
import school.model.Student;
import school.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteFile {
    private static void writeFile(List<String> list, String path) {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void writeFileStudent(List<Student> lists) {
        List<String> list = new ArrayList<>();
        for (Student e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/school/data/student.csv");
    }

    public static void writeFileTeacher(List<Teacher> lists) {
        List<String> list = new ArrayList<>();
        for (Teacher e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/school/data/teacher.csv");
    }


    public static void readFilerTeacher(List<Teacher> list) {
        try (FileReader fileReader = new FileReader("src/school/data/teacher.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Teacher teacher = new Teacher(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], Double.parseDouble(temp[6]), Double.parseDouble(temp[7]));
                list.add(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFilerStudent(List<Student> list) {
        try (FileReader fileReader = new FileReader("src/school/data/student.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Student student = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), Double.parseDouble(temp[6]));
                list.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
