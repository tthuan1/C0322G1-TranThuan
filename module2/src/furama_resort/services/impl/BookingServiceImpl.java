package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.Booking;
import furama_resort.model.facility.Facility;
import furama_resort.model.facility.Villa;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;
import furama_resort.services.BookingService;
import furama_resort.uitl.BookingComparator;
import javafx.scene.transform.Scale;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingList = new TreeSet<>(new BookingComparator());
    static List<Customer> listCustomer = new LinkedList<>();
    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();


    static {
        ReadAndWriteFile.readFilerCustomer(listCustomer);
        facilityMap.put(new Villa("SVVL-0001", "vip1", 1.0, 1, 5, "thuê theo năm", "12", 1, 1.0), 5);
        facilityMap.put(new Villa("SVVL-0002", "vip2", 1.0, 1, 5, "thuê theo ngày", "12", 1, 1.0), 6);
        facilityMap.put(new Villa("SVVL-0003", "vip3", 1.0, 1, 5, "thuê theo tháng", "12", 1, 1.0), 3);
        facilityMap.put(new Villa("SVVL-0004", "vip4", 1.0, 1, 5, "thuê theo giờ", "12", 1, 1.0), 6);
        facilityMap.put(new Villa("SVVL-0005", "vip5", 1.0, 1, 5, "thuê theo năm", "12", 1, 1.0), 3);

    }

    @Override
    public void addBooking() {
        int bookingCode = 0;
        if (!bookingList.isEmpty()) {
            bookingCode = bookingList.size();
        }
        Customer customer=chooseCustomer();
        Facility facility=chooseFacility();
        System.out.printf("Nhập ngày bắt đầu: ");
        String startDay = scanner.nextLine();
        System.out.printf("Nhập ngày kết thúc: ");
        String endDate = scanner.nextLine();
        Booking booking=new Booking(bookingCode,startDay,endDate, customer.getCustomerCode(), facility.getServiceCode());
        bookingList.add(booking);
        ReadAndWriteFile.writeFileBooking(bookingList);


//        Booking booking = new Booking(bookingCode, startDay, endDate, customer.getCustomerCode(), customer.getName(),getNamefacility);
        //codeBooking, String startDay, String endDate, String customerCode,
        // String serviceName, String typeOfService) {
//        bookingList.add(booking);


//        System.out.printf("Nhập mã booking: ");
//        String bookingCode = scanner.nextLine();
//        System.out.printf("Nhập ngày bắt đầu: ");
//        String startDay = scanner.nextLine();
//        System.out.printf("Nhập ngày kết thúc: ");
//        String endDate = scanner.nextLine();
//        System.out.printf("Nhập mã khách hàng: ");
//        String customerCode = scanner.nextLine();
//        System.out.printf("Nhập tên dịch vụ: ");
//        String serviceName = scanner.nextLine();
//        System.out.printf("Nhập loại dịch vụ: ");
//        String typeOfService = scanner.nextLine();
//        Booking booking = new Booking(bookingCode, startDay, endDate, customerCode, serviceName, typeOfService);
//        bookingList.add(booking);
    }

    public static Customer chooseCustomer() {
        System.out.println("-------------Danh sách khách hàng-------------");
        for (Customer customer : listCustomer) {
            System.out.println(customer);
        }
        System.out.print("Nhập id khách hàng: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        while (flag) {
            for (Customer customer : listCustomer) {
                if (id == customer.getCustomerCode()) {
                    flag = false;
                    return customer;
                }
            }
            if (flag) {
                System.out.println("Nhập sai, vui lòng nhập lại");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("-------------Danh sách dịch vụ-------------");
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()){
            System.out.println(entry.getKey());
        }

        System.out.print("Nhập id dịch vụ: ");
        String  id =scanner.nextLine();
        boolean flag = true;
        while (flag) {
            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                if (id.equals(entry.getKey().getServiceCode())) {
                    flag = false;
                    return entry.getKey();
                }
            }
            if (flag) {
                System.out.println("Nhập sai, vui lòng nhập lại");
                id = scanner.nextLine();
            }
        }
        return null;
    }

    @Override
    public void displayBooking() {
        ReadAndWriteFile.readFilerBooking(bookingList);
        for (Booking booking : bookingList) {
//            System.out.printf(booking);
            System.out.println(booking);

        }
    }

    @Override
    public void createConstracts() {

    }

    @Override
    public void displayContracts() {

    }

    @Override
    public void editContracts() {

    }
}
