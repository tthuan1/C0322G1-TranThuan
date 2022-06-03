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

        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea=Regex.regexArea();

        System.out.print("Nhập chi phí thuê: ");
        int rentalCosts = Regex.regexRentalCosts();

        System.out.print("Nhập số lượng người: ");
        int numberPeople = Regex.regexNumberPeople();

        System.out.print("Nhập kiểu thuê: ");
        String rentalType = Regex.regexName();

        System.out.print("Nhập tiêu chuẩn phòng: ");
        String roomStandard =Regex.regexName();

        System.out.print("Nhập số tầng: ");
        int numberOfFloors = Regex.regexNumberOfFloors();

        System.out.print("Nhập diện tích hồ bơi: ");
        double poolArea = Regex.regexArea();

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
        String serviceName = Regex.regexName();

        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Regex.regexArea();

        System.out.print("Nhập chi phí thuê: ");
        int rentalCosts = Regex.regexRentalCosts();

        System.out.print("Nhập số lượng người: ");
        int numberPeople = Regex.regexNumberPeople();

        System.out.print("Nhập kiểu thuê: ");
        String rentalType = Regex.regexName();

        System.out.print("Nhập tiêu chuẩn phòng: ");
        String roomStandard =  Regex.regexName();

        System.out.print("Nhập số tầng: ");
        int numberOfFloors = Regex.regexNumberOfFloors();

        House house = new House(serviceCode, serviceName, usableArea, rentalCosts, numberPeople, rentalType, roomStandard,numberOfFloors);
        facilityMap.put(house,0);
        ReadAndWriteFile.writeFileFacility(facilityMap);
    }

    @Override
    public void addRoom() {
        facilityMap.clear();
        ReadAndWriteFile.readFileFacility(facilityMap);

        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = Regex.regexServiceCodeRoom();

        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = Regex.regexName();

        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Regex.regexArea();

        System.out.print("Nhập chi phí thuê: ");
        int rentalCosts = Regex.regexRentalCosts();

        System.out.print("Nhập số lượng người: ");
        int numberPeople = Regex.regexNumberPeople();

        System.out.print("Nhập kiểu thuê: ");
        String rentalType = Regex.regexName();

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
