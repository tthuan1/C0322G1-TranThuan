package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.facility.Villa;
import furama_resort.services.FacilityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VillaServiceImpl implements FacilityService {
    static Scanner scanner = new Scanner(System.in);
    static List<Villa> villaList = new ArrayList<>();
    static {
        ReadAndWriteFile.readFilerVilla(villaList);
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
        System.out.print("Nhập diện tích hồ bơi: ");
        double poolArea = Double.parseDouble(scanner.nextLine());
        Villa villa = new Villa(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType, roomStandard, numberOfFloors, poolArea);
        villaList.add(villa);
        ReadAndWriteFile.writeFileVilla(villaList,"src/furama_resort/data/facility/villa.csv");
    }

    @Override
    public void display() {
        for (Villa villa : villaList) {
            System.out.println(villa);
        }
    }
}
