package companyABC.controllers;

import companyABC.common.CheckException;
import companyABC.services.Impl.ManagementStaffServiceImpl;
import companyABC.services.Impl.ProductionStaffServiceImpl;
import companyABC.services.Service;


public class DisplayMainMenu {
    static Service managementStaff = new ManagementStaffServiceImpl();
    static Service productionStaff = new ProductionStaffServiceImpl();


    public static void menu() {
        do {
            System.out.println("-----------Menu------------");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.println("Enter your choose");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    viewPerson();
                    break;
                case 2:
                    addNewStaff();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("xin hãy nhập lại");
            }
        } while (true);
    }

    public static void addNewStaff() {
        do {
            System.out.println("--------Thêm mới nhân viên----------");
            System.out.println("1. Thêm mới nhân viên quản lý");
            System.out.println("2. Thêm mới nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    System.out.println("Thêm mới nhân viên quản lý");
                    managementStaff.add();
                    break;
                case 2:
                    System.out.println("Thêm mới nhân viên sản xuất");
                    productionStaff.add();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void deletePerson() {
        do {
            System.out.println("--------Xóa nhân viên----------");
            System.out.println("1. xóa nhân viên quản lý");
            System.out.println("2. xóa nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    System.out.println("xóa nhân viên quản lý");
                    managementStaff.delete();
                    break;
                case 2:
                    System.out.println("xóa nhân viên sản xuất");
                    productionStaff.delete();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(" xin hãy nhập lại");
            }
        } while (true);
    }

    public static void viewPerson() {
        do {
            System.out.println("--------Xem danh sách nhân viên----------");
            System.out.println("1. xem danh sách nhân viên quản lý");
            System.out.println("2. xem danh sách nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    System.out.println("danh sách nhân viên quản lý");
                    managementStaff.display();
                    break;
                case 2:
                    System.out.println("danh sách nhân viên sản xuất");
                    productionStaff.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void searchPerson() {
        do {
            System.out.println("--------Tìm kiếm nhân viên----------");
            System.out.println("1. tìm kiếm nhân viên quản lý");
            System.out.println("2. tìm kiếm nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    System.out.println("tìm kiếm nhân viên quản lý");
                    managementStaff.search();
                    break;
                case 2:
                    System.out.println("tìm kiếm nhân viên sản xuất");
                    productionStaff.search();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(" xin hãy nhập lại");
            }
        } while (true);
    }

}
