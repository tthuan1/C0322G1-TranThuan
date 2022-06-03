package furama_resort.common;

import furama_resort.model.Booking;
import furama_resort.model.Contract;
import furama_resort.model.facility.Facility;
import furama_resort.model.facility.House;
import furama_resort.model.facility.Room;
import furama_resort.model.facility.Villa;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteFile {
    private static void writeFile(List<String> list, String path) {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void writeFileFacility(Map<Facility, Integer> lists) {
        List<String> listHouse = new ArrayList<>();
        List<String> listVilla = new ArrayList<>();
        List<String> listRoom = new ArrayList<>();
        for (Map.Entry<Facility, Integer> entry : lists.entrySet()) {
            if (entry.getKey() instanceof House) {
                listHouse.add(((House) entry.getKey()).coverToString() + "," + entry.getValue());
            } else if (entry.getKey() instanceof Room) {
                listRoom.add(((Room) entry.getKey()).coverToString() + "," + entry.getValue());
            } else {
                listVilla.add(((Villa) entry.getKey()).coverToString() + "," + entry.getValue());
            }
        }
        writeFile(listHouse, "src/furama_resort/data/facility/house.csv");
        writeFile(listVilla, "src/furama_resort/data/facility/villa.csv");
        writeFile(listRoom, "src/furama_resort/data/facility/Room.csv");
    }

    public static void writeFileCustomer(List<Customer> lists) {
        List<String> list = new ArrayList<>();
        for (Customer e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/furama_resort/data/person/customer.csv");
    }

    public static void writeFileEmployee(List<Employee> lists) {
        List<String> list = new ArrayList<>();
        for (Employee e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/furama_resort/data/person/employee.csv");
    }

    public static void writeFileBooking(Set<Booking> lists) {
        List<String> list = new ArrayList<>();
        for (Booking e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/furama_resort/data/booking.csv");
    }
    public static void writeFileContract(List<Contract> lists) {
        List<String> list = new ArrayList<>();
        for (Contract e : lists) {
            list.add(e.coverToString());
        }
        writeFile(list, "src/furama_resort/data/contract.csv");
    }


    public static void readFilerEmployee(List<Employee> list) {
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/person/employee.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Employee employee = new Employee(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], Integer.parseInt(temp[9]));
                list.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFilerCustomer(List<Customer> list) {
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/person/customer.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Customer customer = new Customer(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                list.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void readFilerHouse(List<House> list) {
//        try {
//            FileReader fileReader = new FileReader("src/furama_resort/data/facility/house.csv");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                House house = new House(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6], Integer.parseInt(temp[7]));
//                list.add(house);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void readFilerRoom(List<Room> list) {
//        try {
//            FileReader fileReader = new FileReader("src/furama_resort/data/facility/room.csv");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                Room room = new Room(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6]);
//                list.add(room);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void readFilerVilla(List<Villa> list) {
//        try {
//            FileReader fileReader = new FileReader("src/furama_resort/data/facility/villa.csv");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                Villa villa = new Villa(temp[0], temp[1], Double.parseDouble(temp[2]),
//                        Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5],
//                        temp[6], Integer.parseInt(temp[7]), Double.parseDouble(temp[8]));
//                list.add(villa);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void readFilerContract(List<Contract> list) {
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/contract.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Contract contract = new Contract(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]));
                list.add(contract);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFilerBooking(Set<Booking> list) {
        List<Customer> customerList = new ArrayList<>();
        readFilerCustomer(customerList);
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/booking.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Booking booking = new Booking(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]), temp[4]);
                list.add(booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileFacility(Map<Facility, Integer> list) {
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/facility/villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Villa villa = new Villa(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6], Integer.parseInt(temp[7]), Double.parseDouble(temp[8]));
                list.put(villa, Integer.parseInt(temp[9]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/facility/room.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                Room room = new Room(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6]);
                list.put(room, Integer.parseInt(temp[7]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader("src/furama_resort/data/facility/house.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                House house = new House(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6], Integer.parseInt(temp[7]));
                list.put(house, Integer.parseInt(temp[8]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
