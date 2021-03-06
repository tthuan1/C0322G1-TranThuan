package companyABC.common;

import companyABC.model.ManagementStaff;
import companyABC.model.Person;
import companyABC.model.ProductionStaff;
import furama_resort.model.Booking;
import furama_resort.model.Contract;
import furama_resort.model.facility.Facility;
import furama_resort.model.facility.House;
import furama_resort.model.facility.Room;
import furama_resort.model.facility.Villa;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;

import java.io.*;
import java.time.Period;
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

    public static void writeFileManagementStaff(List<ManagementStaff> lists) {
        List<String> list = new ArrayList<>();
        for (ManagementStaff e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/companyABC/data/employee.csv");
    }
    public static <E>void writeFileEmployee(List<E> lists) {
        List<String> list = new ArrayList<>();
        if (lists instanceof ManagementStaff){
            for (E e : lists) {
                if (e instanceof ManagementStaff){
                    list.add(((ManagementStaff) e).coverToString());
                }
            }
        }
        writeFile(list, "src/companyABC/data/employee.csv");
    }

    public static void writeFileProductionStaff(List<ProductionStaff> lists) {
        List<String> list = new ArrayList<>();
        for (ProductionStaff e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/companyABC/data/employee.csv");
    }


//
//    public static void readFilerProductionStaff(List<ProductionStaff> list) {
//        try (FileReader fileReader = new FileReader("src/companyABC/data/employee.csv");
//             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                if (temp.length==8){
//                    ProductionStaff productionStaff = new ProductionStaff(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), Double.parseDouble(temp[6]));
//                    list.add(productionStaff);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void readFilerManagementStaff(List<ManagementStaff> list) {
//        try (FileReader fileReader = new FileReader("src/companyABC/data/employee.csv");
//             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                if (temp.length==7){
//                    ManagementStaff managementStaff = new ManagementStaff(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Double.parseDouble(temp[5]), Double.parseDouble(temp[6]));
//                    list.add(managementStaff);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static<E> void readFilerEmployee(List<E> list) {
        try (FileReader fileReader = new FileReader("src/companyABC/data/employee.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                    if (temp.length==7){
                        ManagementStaff managementStaff = new ManagementStaff(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Double.parseDouble(temp[5]), Double.parseDouble(temp[6]));
                        list.add((E) managementStaff);
                    }
                    if (temp.length==8){
                        ProductionStaff productionStaff = new ProductionStaff(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), Double.parseDouble(temp[6]));
                        list.add((E)productionStaff);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
