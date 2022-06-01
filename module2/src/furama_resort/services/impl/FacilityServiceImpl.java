package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
import furama_resort.common.Regex;
import furama_resort.model.facility.Facility;
import furama_resort.model.facility.House;
import furama_resort.model.facility.Room;
import furama_resort.model.facility.Villa;
import furama_resort.services.FacilityService;


import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    static Scanner scanner=new Scanner(System.in);

    static List<Villa> villaList = new ArrayList<>();
    static List<House> houseList = new ArrayList<>();
    static List<Room> roomList = new ArrayList<>();
//    static List<Facility> facility =new ArrayList<>();


    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    static {
        ReadAndWriteFile.readFilerVilla(villaList);
        ReadAndWriteFile.readFilerHouse(houseList);
        ReadAndWriteFile.readFilerRoom(roomList);
        for (Villa villa:villaList) {
            facilityMap.put(villa,1);
        }
        for (House house:houseList) {
            facilityMap.put(house,1);
        }
        for (Room room:roomList) {
            facilityMap.put(room,1);
        }
    }


    @Override
    public void display() {
        for (Map.Entry<Facility,Integer> element:facilityMap.entrySet()) {
            System.out.println(element.getKey());
        }
    }

    @Override
    public void addVilla() {
        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = scanner.nextLine();
//        Regex.regexServiceCodeVilla(serviceCode);

        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
//        Regex.regexName(serviceName);

        System.out.print("Nhập diện tích sử dụng: ");
        String checkUsableArea = scanner.nextLine();
//        Regex.regexArea(checkUsableArea);
        double usableArea=Double.parseDouble(checkUsableArea);


        System.out.print("Nhập chi phí thuê: ");
        String checkRentalCosts=scanner.nextLine();
//        Regex.regexRentalCosts(checkRentalCosts);
        int rentalCosts = Integer.parseInt(checkRentalCosts);

        System.out.print("Nhập số lượng người: ");
        String checkNumberPeople=scanner.nextLine();
//        Regex.regexNumberPeople(checkNumberPeople);
        int numberPeople = Integer.parseInt(checkNumberPeople);

        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
//        Regex.regexName(rentalType);

        System.out.print("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
//        Regex.regexName(roomStandard);

        System.out.print("Nhập số tầng: ");
        String checkNumberOfFloors=scanner.nextLine();
//        Regex.regexNumberOfFloors(checkNumberOfFloors);
        int numberOfFloors = Integer.parseInt(checkNumberOfFloors);

        System.out.print("Nhập diện tích hồ bơi: ");
        String checkPoolArea=scanner.nextLine();
//        Regex.regexArea(checkPoolArea);
        double poolArea = Double.parseDouble(checkPoolArea);

        Villa villa = new Villa(serviceCode, serviceName, usableArea, rentalCosts, numberPeople, rentalType, roomStandard, numberOfFloors, poolArea);
        facilityMap.put(villa,0);
        villaList.add(villa);
        ReadAndWriteFile.writeFileVilla(villaList);
    }

    @Override
    public void addHouse() {
        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = scanner.nextLine();
//        Regex.regexServiceCodeHouse(serviceCode);

        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
//        Regex.regexName(serviceName);

        System.out.print("Nhập diện tích sử dụng: ");
        String checkUsableArea=scanner.nextLine();
//        Regex.regexArea(checkUsableArea);
        double usableArea = Double.parseDouble(checkUsableArea);

        System.out.print("Nhập chi phí thuê: ");
        String checkrentalCosts=scanner.nextLine();
//        Regex.regexRentalCosts(checkrentalCosts);
        int rentalCosts = Integer.parseInt(checkrentalCosts);


        System.out.print("Nhập số lượng người: ");
        String checkNumberPeople=scanner.nextLine();
//        Regex.regexNumberPeople(checkNumberPeople);
        int numberPeople = Integer.parseInt(checkNumberPeople);


        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
//        Regex.regexName(rentalType);


        System.out.print("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
//        Regex.regexName(roomStandard);


        System.out.print("Nhập số tầng: ");
        String checkNumberOfFloors=scanner.nextLine();
//        Regex.regexNumberOfFloors(checkNumberOfFloors);
        int numberOfFloors = Integer.parseInt(checkNumberOfFloors);


        House house = new House(serviceCode, serviceName, usableArea, rentalCosts, numberPeople, rentalType, roomStandard,numberOfFloors);
        facilityMap.put(house,1);
        houseList.add(house);
        ReadAndWriteFile.writeFileHouse(houseList);
    }

    @Override
    public void addRoom() {
        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = scanner.nextLine();
//        Regex.regexServiceCodeRoom(serviceCode);

        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
//        Regex.regexName(serviceName);

        System.out.print("Nhập diện tích sử dụng: ");
        String checkUsableArea=scanner.nextLine();
//        Regex.regexArea(checkUsableArea);
        double usableArea = Double.parseDouble(checkUsableArea);

        System.out.print("Nhập chi phí thuê: ");
        String checkRentalCosts=scanner.nextLine();
//        Regex.regexRentalCosts(checkRentalCosts);
        int rentalCosts = Integer.parseInt(checkRentalCosts);

        System.out.print("Nhập số lượng người: ");
        String checkNumberPeople=scanner.nextLine();
//        Regex.regexNumberPeople(checkNumberPeople);
        int numberPeople = Integer.parseInt(checkNumberPeople);

        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
//        Regex.regexName(rentalType);

        System.out.print("Nhập dịch dụ miễn phí: ");
        String freeService = scanner.nextLine();

        Room room = new Room(serviceCode, serviceName, usableArea, rentalCosts, numberPeople, rentalType, freeService);
        facilityMap.put(room,0);
        roomList.add(room);
        ReadAndWriteFile.writeFileRoom(roomList);
    }

    @Override
    public void displayListFacilityMaintenance() {
        for (Facility facility: facilityMap.keySet())
            if (facilityMap.get(facility) > 4) {
                System.out.println(facility.toString());
            }
    }

}
