package furama_resort.services.impl;

import furama_resort.common.CheckException;
import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.Booking;
import furama_resort.model.Contract;
import furama_resort.services.ContactService;
import furama_resort.uitl.BookingComparator;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static List<Contract> contractList = new ArrayList<>();

    @Override
    public void add() {
        contractList.clear();
        bookingSet.clear();
        ReadAndWriteFile.readFilerContract(contractList);
        ReadAndWriteFile.readFilerBooking(bookingSet);

        Queue<Booking> bookingQueue = new LinkedList<>();
        bookingQueue.addAll(bookingSet);

        Booking booking = bookingQueue.poll();

        int contractsCode = 1;
        if (!contractList.isEmpty()) {
            contractsCode = contractList.size() + 1;
        }

        System.out.print("Nhập số tiền đặc cọc trước: ");
        int deposits = CheckException.checkparseInt();

        System.out.println("Nhập tổng tiền: ");
        int totalMoney = CheckException.checkparseInt();

        Contract contract = new Contract(contractsCode, Objects.requireNonNull(booking).getBookingCode(), deposits, totalMoney, booking.getCustomerCode());
        contractList.add(contract);
        ReadAndWriteFile.writeFileBooking(bookingSet);
        ReadAndWriteFile.writeFileContract(contractList);
        System.out.println("Tạo bản hợp đồng thành công !!!");
    }

    @Override
    public void edit() {
        ReadAndWriteFile.readFilerContract(contractList);
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
        System.out.print("Nhập mã hợp đồng cần sửa: ");
        int contractsCode = CheckException.checkparseInt();
        boolean flag = true;
        for (int i = 0; i < contractList.size(); i++) {
            if (contractsCode == contractList.get(i).getContractsCode()) {
                System.out.print("Nhập số tiền đặc cọc trước: ");
                int deposits = CheckException.checkparseInt();

                System.out.println("Nhập tổng tiền: ");
                int totalMoney = CheckException.checkparseInt();

                Contract contract = new Contract(contractsCode, contractList.get(i).getBookingCode(), deposits, totalMoney, contractList.get(i).getCustomerCode());
                contractList.set(i, contract);

                ReadAndWriteFile.writeFileContract(contractList);
                System.out.println("Tạo bản hợp đồng thành công !!!");
                flag = false;
                System.out.println("Sửa thành công !!");
                break;
            }
        }
        if (flag) {
            System.out.println("Không tìm thấy mã hợp đồng !!");
        }
    }

    @Override
    public void display() {
        contractList.clear();
        ReadAndWriteFile.readFilerContract(contractList);

        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }
}
