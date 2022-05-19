package furama_resort.common;

import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;
import furama_resort.model.person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    private static void writeFile(List<String> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
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

    //    public static void writeFileCustomer(List<Customer> lists, String path) {
//        List<String> list = new ArrayList<>();
//        for (Customer e : lists) {
//            list.add(e.coverToString());
//        }
//        writeFile(list, path);
//    }
//
//    public static void writeFileEmployee(List<Employee> lists, String path) {
//        List<String> list = new ArrayList<>();
//        for (Employee e : lists) {
//            list.add(e.coverToString());
//        }
//        writeFile(list, path);
//    }
    public static <E> void writeFileTest(List<E> lists, String path) {
        List<String> list = new ArrayList<>();
        for (E e : lists) {
            list.add(e.toString());
        }
        writeFile(list, path);
    }

    public static void readFiler(List list, String option) {
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/data.scv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                if (/*temp[0].equals("customer") &&*/ option.equals("customer")) {
                    Customer customer = new Customer(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                    list.add(customer);
                }
                if (temp[0].equals("employee") && option.equals("employee")) {
                    Employee employee = new Employee(temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], Integer.parseInt(temp[10]));
                    list.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------
    public static void write(String path, List<String> stringList) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String item : stringList) {
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> read(String path) {
        List<String[]> list = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arr = line.split(",");
                list.add(arr);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
