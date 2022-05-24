package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.facility.House;
import furama_resort.services.FacilityService;
import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseServiceImpl implements FacilityService {
    static Scanner scanner = new Scanner(System.in);
    static List<House> houseList = new ArrayList<>();
    static {
        ReadAndWriteFile.readFilerHouse(houseList);
    }

    @Override
    public void add() {
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
        House house = new House(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType, roomStandard, numberOfFloors);
        houseList.add(house);
        ReadAndWriteFile.writeFileHouse(houseList,"src/furama_resort/data/facility/house.csv");
    }

    @Override
    public void display() {
        for (House house : houseList) {
            System.out.println(house);
        }
    }
}
