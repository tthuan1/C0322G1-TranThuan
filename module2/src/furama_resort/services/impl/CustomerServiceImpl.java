package furama_resort.services.impl;

import furama_resort.common.CheckException;
import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.person.Customer;
import furama_resort.services.CustomerService;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> listCustomer = new LinkedList<>();

    @Override
    public void add() {
        listCustomer.clear();
        ReadAndWriteFile.readFilerCustomer(listCustomer);
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

        System.out.print("Nhập email khách hàng: ");
        String email = scanner.nextLine();

        System.out.print("Nhập mã khách hàng: ");
        Integer customerCode = Integer.parseInt(scanner.nextLine());

        String customerType = null;
        while (customerType == null) {
            System.out.print("--------Nhập loại khách hàng---------\n" +
                    "\t1. Diamond \n" +
                    "\t2. Platinium \n" +
                    "\t3. Gold \n" +
                    "\t4. Silver \n" +
                    "\t5. Member \n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    customerType = "Diamond";
                    break;
                case 2:
                    customerType = "Platinium";
                    break;
                case 3:
                    customerType = "Gold";
                    break;
                case 4:
                    customerType = "Silver";
                    break;
                case 5:
                    customerType = "Member";
                    break;
                default:
                    System.out.println("Nhập lại!!");
            }
        }
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(customerCode, name, dateOfBirth, gender,
                identityCard, phoneNumber, email, customerType, address);
        listCustomer.add(customer);
        ReadAndWriteFile.writeFileCustomer(listCustomer);
    }

    @Override
    public void display() {
        listCustomer.clear();
        ReadAndWriteFile.readFilerCustomer(listCustomer);
        for (Customer customer : listCustomer) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        listCustomer.clear();
        ReadAndWriteFile.readFilerCustomer(listCustomer);
        System.out.print("Nhập mã khách hàng cần sửa: ");
        int code = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < listCustomer.size(); i++) {
            if (code == listCustomer.get(i).getCustomerCode()) {
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
                System.out.print("Nhập lại email khách hàng: ");
                String email = scanner.nextLine();
                System.out.print("Nhập lại mã khách hàng: ");
                int customerCode = Integer.parseInt(scanner.nextLine());
                String customerType = null;
                while (customerType == null) {
                    System.out.print("--------Nhập loại khách hàng---------\n" +
                            "\t1. Diamond \n" +
                            "\t2. Platinium \n" +
                            "\t3. Gold \n" +
                            "\t4. Silver \n" +
                            "\t5. Member \n" +
                            "\tEnter: ");
                    int choose = CheckException.checkparseInt();
                    switch (choose) {
                        case 1:
                            customerType = "Diamond";
                            break;
                        case 2:
                            customerType = "Platinium";
                            break;
                        case 3:
                            customerType = "Gold";
                            break;
                        case 4:
                            customerType = "Silver";
                            break;
                        case 5:
                            customerType = "Member";
                            break;
                        default:
                            System.out.println("Nhập lại!!");
                    }
                }
                System.out.print("Nhập lại địa chỉ: ");
                String address = scanner.nextLine();
                Customer customer = new Customer(customerCode, name, dateOfBirth, gender,
                        identityCard, phoneNumber, email, customerType, address);
                listCustomer.set(i, customer);
                count++;
                ReadAndWriteFile.writeFileCustomer(listCustomer);
                break;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy số mã khách hàng " + code + " này !!\n");
        }
    }
}
