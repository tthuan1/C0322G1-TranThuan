package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.facility.Room;
import furama_resort.services.FacilityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomServiceImpl implements FacilityService {
    static Scanner scanner = new Scanner(System.in);
    static List<Room> roomList = new ArrayList<>();

    static {
        ReadAndWriteFile.readFilerRoom(roomList);
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
        System.out.print("Nhập dịch vụ miễn phí: ");
        String freeService = scanner.nextLine();
        Room room = new Room(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType, freeService);
        roomList.add(room);
        ReadAndWriteFile.writeFileRoom(roomList,"src/furama_resort/data/facility/room.csv");
    }

    @Override
    public void display() {
        for (Room room : roomList) {
            System.out.println(room);
        }
    }
}
