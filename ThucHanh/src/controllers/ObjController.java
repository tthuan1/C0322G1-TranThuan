package controllers;

import common.CheckException;
import services.Service;
import services.impl.SoTietKiemCoThoiHanServiceImpl;
import services.impl.SoTietKiemDaiHanServiceImpl;
import services.impl.SoTietKiemVoThoiHanServiceImpl;

public class ObjController {
    static Service coThoiHan = new SoTietKiemCoThoiHanServiceImpl();
    static Service voThoiHan = new SoTietKiemVoThoiHanServiceImpl();
    static Service daiHan = new SoTietKiemDaiHanServiceImpl();

    public static void displayMainMenu() {
        do {
            System.out.print("\t---CHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM---------\n" +
                    "\t Chọn chức năng theo số\n" +
                    "\t1. Thêm mới sổ tiết kiệm\n" +
                    "\t2. Xoá sổ tiết kiệm\n" +
                    "\t3. Xem danh sách sổ tiết kiệm\n" +
                    "\t4. Thoát\n" +
                    "\tEnter: ");
            int choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    themMoiSoTietKiem();
                    break;
                case 2:
                    xoaSoTitKiem();
                    break;
                case 3:
                    coThoiHan.display();
                    voThoiHan.display();
                    daiHan.display();
                    break;
                case 4:
                    System.out.println("program exited !!");
                    System.exit(4);
                default:
                    System.out.println("Nhập không có số đển chọn !!");
                    break;
            }
        } while (true);
    }

    public static void themMoiSoTietKiem() {

        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Thêm mới sổ tiết kiệm dài hạn\n" +
                    "\t2. Thêm mới sổ tiết kiệm ngắn hạn\n" +
                    "\t3. Return main menu\n" +
                    "\tEnter: ");
            int choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    daiHan.add();
                    break;
                case 2:
                    themMoiNganHan();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập sai yêu cầu nhập lại !!");
                    break;
            }
        } while (true);
    }

    public static void themMoiNganHan() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Vô thời hạn\n" +
                    "\t2. Có thời hạn\n" +
                    "\t3. Return main menu\n" +
                    "\tEnter: ");
            int choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    voThoiHan.add();
                    break;
                case 2:
                    coThoiHan.add();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập sai yêu cầu nhập lại !!");
                    break;
            }
        } while (true);
    }


    public static void xoaSoTitKiem() {
        do {
            System.out.print("\t-----------------------------------------\n" +
                    "\t1. Xoá sổ tiết kiệm vô thời hạn\n" +
                    "\t2. Xoá sổ tiết kiệm dài hạn\n" +
                    "\t3. Xoá sổ tiết kiệm có thời hạn\n" +
                    "\t4. Return main menu\n" +
                    "\tEnter: ");
            int choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    voThoiHan.delete();
                    break;
                case 2:
                    daiHan.delete();
                    break;
                case 3:
                    coThoiHan.delete();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập sai yêu cầu nhập lại !!");
                    break;
            }
        } while (true);
    }
}
