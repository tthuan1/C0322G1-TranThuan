package furama_resort.services.impl;

import furama_resort.common.CheckException;
import furama_resort.common.ReadAndWriteFile;
import furama_resort.common.Regex;
import furama_resort.model.Booking;
import furama_resort.model.facility.Facility;
import furama_resort.model.person.Customer;
import furama_resort.services.BookingService;
import furama_resort.uitl.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingList = new TreeSet<>(new BookingComparator());
    static List<Customer> listCustomer = new LinkedList<>();
    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    @Override
    public void add() {
        bookingList.clear();
        ReadAndWriteFile.readFilerBooking(bookingList);
        int bookingCode = 1;
        if (!bookingList.isEmpty()) {
            bookingCode = bookingList.size() + 1;
        }

        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();

        System.out.print("Nhập ngày bắt đầu: ");
        String startDay = CheckException.checkString();
        Regex.regexAge(startDay);

        System.out.print("Nhập ngày kết thúc: ");
        String endDate = CheckException.checkString();
        Regex.regexAge(endDate);

        facilityMap.put(facility, facilityMap.get(facility) + 1);

        Booking booking = new Booking(bookingCode, startDay, endDate, Objects.requireNonNull(customer).getCustomerCode(), Objects.requireNonNull(facility).getServiceCode());
        bookingList.add(booking);
        ReadAndWriteFile.writeFileFacility(facilityMap);
        ReadAndWriteFile.writeFileBooking(bookingList);
    }

    public static Customer chooseCustomer() {
        listCustomer.clear();
        ReadAndWriteFile.readFilerCustomer(listCustomer);
        System.out.println("-------------Danh sách khách hàng-------------");
        for (Customer customer : listCustomer) {
            System.out.println(customer);
        }
        System.out.print("Nhập id khách hàng: ");
        int id = CheckException.checkparseInt();
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
        bookingList.clear();
        ReadAndWriteFile.readFilerBooking(bookingList);
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }
}
