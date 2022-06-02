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


    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();



    @Override
    public void display() {
        facilityMap.clear();
        ReadAndWriteFile.readFileFacility(facilityMap);

        for (Map.Entry<Facility,Integer> element:facilityMap.entrySet()) {
            System.out.println(element.getKey()+", số lần sử dụng: "+element.getValue());
        }
    }

    @Override
    public void addVilla() {
        facilityMap.clear();
        ReadAndWriteFile.readFileFacility(facilityMap);

        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode =  Regex.regexServiceCodeVilla();

        System.out.print("Nhập tên dịch vụ: ");
        String serviceName =  Regex.regexName();
//        Regex.regexName();

        System.out.print("Nhập diện tích sử dụng: ");
        String checkUsableArea = scanner.nextLine();
//        Regex.regexArea();
        double usableArea=Double.parseDouble(checkUsableArea);


        System.out.print("Nhập chi phí thuê: ");
        String checkRentalCosts=scanner.nextLine();
//        Regex.regexRentalCosts();
        int rentalCosts = Integer.parseInt(checkRentalCosts);

        System.out.print("Nhập số lượng người: ");
        String checkNumberPeople=scanner.nextLine();
//        Regex.regexNumberPeople();
        int numberPeople = Integer.parseInt(checkNumberPeople);

        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
//        Regex.regexName();

        System.out.print("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
//        Regex.regexName();

        System.out.print("Nhập số tầng: ");
        String checkNumberOfFloors=scanner.nextLine();
//        Regex.regexNumberOfFloors();
        int numberOfFloors = Integer.parseInt(checkNumberOfFloors);

        System.out.print("Nhập diện tích hồ bơi: ");
        String checkPoolArea=scanner.nextLine();
//        Regex.regexArea();
        double poolArea = Double.parseDouble(checkPoolArea);

        Villa villa = new Villa(serviceCode, serviceName, usableArea, rentalCosts, numberPeople, rentalType, roomStandard, numberOfFloors, poolArea);
        facilityMap.put(villa,0);
        ReadAndWriteFile.writeFileFacility(facilityMap);
    }

    @Override
    public void addHouse() {
        facilityMap.clear();
        ReadAndWriteFile.readFileFacility(facilityMap);
        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = Regex.regexServiceCodeHouse();


        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
//        Regex.regexName();

        System.out.print("Nhập diện tích sử dụng: ");
        String checkUsableArea=scanner.nextLine();
//        Regex.regexArea();
        double usableArea = Double.parseDouble(checkUsableArea);

        System.out.print("Nhập chi phí thuê: ");
        String checkrentalCosts=scanner.nextLine();
//        Regex.regexRentalCosts();
        int rentalCosts = Integer.parseInt(checkrentalCosts);


        System.out.print("Nhập số lượng người: ");
        String checkNumberPeople=scanner.nextLine();
//        Regex.regexNumberPeople();
        int numberPeople = Integer.parseInt(checkNumberPeople);


        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
//        Regex.regexName();


        System.out.print("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
//        Regex.regexName();


        System.out.print("Nhập số tầng: ");
        String checkNumberOfFloors=scanner.nextLine();
//        Regex.regexNumberOfFloors();
        int numberOfFloors = Integer.parseInt(checkNumberOfFloors);


        House house = new House(serviceCode, serviceName, usableArea, rentalCosts, numberPeople, rentalType, roomStandard,numberOfFloors);
        facilityMap.put(house,0);
        ReadAndWriteFile.writeFileFacility(facilityMap);
    }

    @Override
    public void addRoom() {
        facilityMap.clear();
        ReadAndWriteFile.readFileFacility(facilityMap);

        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = scanner.nextLine();
//        Regex.regexServiceCodeRoom();

        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
//        Regex.regexName();

        System.out.print("Nhập diện tích sử dụng: ");
        String checkUsableArea=scanner.nextLine();
//        Regex.regexArea();
        double usableArea = Double.parseDouble(checkUsableArea);

        System.out.print("Nhập chi phí thuê: ");
        String checkRentalCosts=scanner.nextLine();
//        Regex.regexRentalCosts();
        int rentalCosts = Integer.parseInt(checkRentalCosts);

        System.out.print("Nhập số lượng người: ");
        String checkNumberPeople=scanner.nextLine();
//        Regex.regexNumberPeople();
        int numberPeople = Integer.parseInt(checkNumberPeople);

        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
//        Regex.regexName();

        System.out.print("Nhập dịch dụ miễn phí: ");
        String freeService = scanner.nextLine();

        Room room = new Room(serviceCode, serviceName, usableArea, rentalCosts, numberPeople, rentalType, freeService);
        facilityMap.put(room,0);

        ReadAndWriteFile.writeFileFacility(facilityMap);
    }

    @Override
    public void displayListFacilityMaintenance() {
        facilityMap.clear();
        ReadAndWriteFile.readFileFacility(facilityMap);

        for (Map.Entry<Facility,Integer> element: facilityMap.entrySet())
            if (element.getValue() > 4) {
                System.out.println(element.getKey()+", số lần sử dụng: "+element.getValue());
            }
    }

}
