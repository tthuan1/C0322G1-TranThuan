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

    }

    @Override
    public void add() {
        bookingList.clear();
        ReadAndWriteFile.readFilerBooking(bookingList);
        int bookingCode = 1;
        if (!bookingList.isEmpty()) {
            bookingCode = bookingList.size()+1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.printf("Nhập ngày bắt đầu: ");
        String startDay = scanner.nextLine();
        System.out.printf("Nhập ngày kết thúc: ");
        String endDate = scanner.nextLine();
        facilityMap.put(facility, facilityMap.get(facility)+1);
        Booking booking = new Booking(bookingCode, startDay, endDate, customer.getCustomerCode(), facility.getServiceCode());
        bookingList.add(booking);
        ReadAndWriteFile.writeFileFacility(facilityMap);
        ReadAndWriteFile.writeFileBooking(bookingList);
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
        facilityMap.clear();
        ReadAndWriteFile.readFileFacility(facilityMap);
        System.out.println("-------------Danh sách dịch vụ-------------");
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.print("Nhập id dịch vụ: ");
        String id = scanner.nextLine();
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
    public void display() {
        ReadAndWriteFile.readFilerBooking(bookingList);
        for (Booking booking : bookingList) {
//            System.out.printf(booking);
            System.out.println(booking);
        }
    }
}
