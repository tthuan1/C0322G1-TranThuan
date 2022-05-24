package furama_resort.controllers;

import furama_resort.services.CustomerService;
import furama_resort.services.EmployeeService;
import furama_resort.services.FacilityService;
import furama_resort.services.impl.*;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner=new Scanner(System.in);

    public static void displayMainMenu() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Employee Management\n" +
                    "\t2. Customer Management\n" +
                    "\t3. Facility Management\n" +
                    "\t4. Booking Management\n" +
                    "\t5. Promotion Management\n" +
                    "\t6. Exit\n" +
                    "\tEnter: ");
            int choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    customerManagement();
                    break;
                case 3:
                    facilityManagement();
                    break;
                case 4:
                    bookingManagerment();
                    break;
                case 5:
                    promotionManagement();
                    break;
                case 6:
                    System.out.println("program exited !!");
                    System.exit(6);
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        }while (true);
    }

    public static void employeeManagement() {
        EmployeeService employeeService=new EmployeeServiceImpl();
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Display list employees\n" +
                    "\t2. Add new employee\n" +
                    "\t3. Edit employee\n" +
                    "\t4. Return main menu\n" +
                    "\tEnter: ");
            int choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        }while (true);
    }

    public static void customerManagement() {
        CustomerService customerService=new CustomerServiceImpl();
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Display list customers\n" +
                    "\t2. Add new customer\n" +
                    "\t3. Edit customer\n" +
                    "\t4. Return main menu\n" +
                    "\tEnter: ");
            int choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        }while (true);

    }

    public static void facilityManagement() {
        FacilityService facilityService=new FacilityServiceImpl();
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Display list facility\n" +
                    "\t2. Add new facility\n" +
                    "\t3. Display list facility maintenance\n" +
                    "\t4. Return main menu\n" +
                    "\tEnter: ");
            int choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    facilityAdd();
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        }while (true);
    }

    public static void bookingManagerment() {
        System.out.print("\t-----------------------------------------\n" +
                "\t1. Add new booking\n" +
                "\t2. Display list booking\n" +
                "\t3. Create new constracts\n" +
                "\t4. Display list contracts\n" +
                "\t5. Edit contracts\n" +
                "\t6. Return main menu\n" +
                "\tEnter: ");
    }

    public static void promotionManagement() {
        System.out.print("\t-----------------------------------------\n" +
                "\t1. Display list customers use service\n" +
                "\t2. Display list customers get voucher\n" +
                "\t3. Return main menu\n" +
                "\tEnter: ");
    }
    public  static void facilityAdd(){
        FacilityService villaService=new VillaServiceImpl();
        FacilityService houseService=new HouseServiceImpl();
        FacilityService roomService=new RoomServiceImpl();
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Add New Villa\n" +
                    "\t2. Add New House\n" +
                    "\t3. Add New Room\n" +
                    "\t4. Back to menu\n" +
                    "\tEnter: ");
            int choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    villaService.add();
                    break;
                case 2:
                    houseService.add();
                    break;
                case 3:
                    roomService.add();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        }while (true);
    }
}
