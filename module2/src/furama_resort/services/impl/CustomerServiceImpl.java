package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Person;
import furama_resort.services.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> listCustomer = new LinkedList<>();

    static {
        ReadAndWriteFile.readFiler(listCustomer,"customer");
    }

    @Override
    public void add() {
        listCustomer.removeAll(listCustomer);
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh khách hàng: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Nhập giới tính khách hàng: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập chứng minh nhân dân khách hàng: ");
        String identityCard = scanner.nextLine();
        System.out.print("Nhập SĐT khách hàng: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập email khách hàng");
        String email = scanner.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        String customerCode = scanner.nextLine();
        System.out.print("Nhập loại khách hàng: ");
        String customerType = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(customerCode, name, dateOfBirth, gender, identityCard, phoneNumber, email, customerType, address);
        listCustomer.add(customer);
        ReadAndWriteFile.writeFileTest(listCustomer, "src/furama_resort/data/data.scv");
    }

    @Override
    public void display() {
        listCustomer.removeAll(listCustomer);
        ReadAndWriteFile.readFiler(listCustomer,"customer");
        for (Customer customer : listCustomer) {
            System.out.println(customer.coverToString());
        }
//        int count = 0;

//        for (Person person : listCustomer) {
//            if (person instanceof Customer) {
//                System.out.println(((Customer)person).coverToString());
//
//            }
//        }
//        }
    }

    @Override
    public void edit() {
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String code = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < listCustomer.size(); i++) {
            if (code.equals(listCustomer.get(i).getCustomerCode())) {
                System.out.print("Nhập lại tên khách hàng: ");
                String name = scanner.nextLine();
                System.out.print("Nhập lại ngày sinh khách hàng: ");
                String dateOfBirth = scanner.nextLine();
                System.out.print("Nhập lại giới tính khách hàng: ");
                String gender = scanner.nextLine();
                System.out.print("Nhập lại chứng minh nhân dân khách hàng: ");
                String identityCard = scanner.nextLine();
                System.out.print("Nhập lại SĐT khách hàng: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Nhập lại email khách hàng");
                String email = scanner.nextLine();
                System.out.print("Nhập lại mã khách hàng: ");
                String customerCode = scanner.nextLine();
                System.out.print("Nhập lại loại khách hàng: ");
                String customerType = scanner.nextLine();
                System.out.print("Nhập lại địa chỉ: ");
                String address = scanner.nextLine();
                Customer customer = new Customer(customerCode, name, dateOfBirth, gender, identityCard, phoneNumber, email, customerType, address);
                listCustomer.set(i, customer);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tiềm thấy số mã khách hàng " + code + " này !!\n");
        }
    }
}
