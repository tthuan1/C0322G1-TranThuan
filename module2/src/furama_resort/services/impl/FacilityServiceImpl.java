package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
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
    static List<Facility> facility =new ArrayList<>();


    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    static {
        facilityMap.put(new Villa("SVVL-0001","1",1.0,1,5,"1","12",1, 1.0),5);
        facilityMap.put(new Villa("SVVL-0002","1",1.0,1,5,"1","12",1, 1.0),6);
        facilityMap.put(new Villa("SVVL-0003","1",1.0,1,5,"1","12",1, 1.0),3);
        facilityMap.put(new Villa("SVVL-0004","1",1.0,1,5,"1","12",1, 1.0),6);
        facilityMap.put(new Villa("SVVL-0005","1",1.0,1,5,"1","12",1, 1.0),3);
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
        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chi phí thuê: ");
        int rentalCosts = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số lượng người: ");
        int maximumPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.print("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        System.out.print("Nhập số tầng: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập diện tích hồ bơi: ");
        double poolArea = Double.parseDouble(scanner.nextLine());
        Villa villa = new Villa(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType, roomStandard, numberOfFloors, poolArea);
        facilityMap.put(villa,0);
        villaList.add(villa);
        ReadAndWriteFile.writeFileVilla(villaList);
    }

    @Override
    public void addHouse() {
        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = scanner.nextLine();
        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chi phí thuê: ");
        int rentalCosts = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số lượng người: ");
        int maximumPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.print("Nhập dịch vụ miễn phí: ");
        String freeService = scanner.nextLine();
        Room room = new Room(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType, freeService);
        facilityMap.put(room,0);
        roomList.add(room);
        ReadAndWriteFile.writeFileRoom(roomList);
    }

    @Override
    public void addRoom() {
        System.out.print("Nhập mã dịch vụ: ");
        String serviceCode = scanner.nextLine();
        System.out.print("Nhập tên dịch vụ: ");
        String serviceName = scanner.nextLine();
        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chi phí thuê: ");
        int rentalCosts = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số lượng người: ");
        int maximumPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.print("Nhập dịch dụ miễn phí: ");
        String freeService = scanner.nextLine();
        Room room = new Room(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType, freeService);
        facilityMap.put(room,0);
        roomList.add(room);
        ReadAndWriteFile.writeFileHouse(houseList);
    }

    @Override
    public void displayListFacilityMaintenance() {
        for (Facility facility: facilityMap.keySet())
            if (facilityMap.get(facility) > 4) {
                System.out.println(facility.toString());
            }
    }

}
