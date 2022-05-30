package furama_resort.services.impl;

import furama_resort.common.ReadAndWriteFile;
import furama_resort.model.person.Employee;
import furama_resort.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> listEmployee = new ArrayList<>();

    static {
        ReadAndWriteFile.readFilerEmployee(listEmployee);
    }

    @Override
    public void add() {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String date = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập chứng minh nhân dân: ");
        String cmnd = scanner.nextLine();
        System.out.print("Nhập SĐT: ");
        String sdt = scanner.nextLine();
        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        int maNhanVien = Integer.parseInt(scanner.nextLine());
        String level = null;
        while (level == null) {
            System.out.print("--------Nhập trình độ nhân viên---------\n" +
                    "\t1. Trung cấp \n" +
                    "\t2. Cao đẳng \n" +
                    "\t3. Đại học \n" +
                    "\t4. Sau đại học \n" +
                    "\tEnter: ");
            String  choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    level = "Trung cấp";
                    break;
                case "2":
                    level = "Cao đẳng";
                    break;
                case "3":
                    level = "Đại học";
                    break;
                case "4":
                    level = "Sau đại học";
                    break;
                default:
                    System.err.println("Chọn không đúng vui lòng nhập lại!!");
            }
        }
        String position = null;
        while (position == null) {
            System.out.print("--------Nhập vị trí nhân viên---------\n" +
                    "\t1. Lễ tân \n" +
                    "\t2. Phục vụ \n" +
                    "\t3. Chuyên viên \n" +
                    "\t4. Giám sát \n" +
                    "\t5. Quản lý \n" +
                    "\t6. Giám đốc \n" +
                    "\tEnter: ");
            String  choose =scanner.nextLine();
            switch (choose) {
                case "1":
                    position = "Lễ tân";
                    break;
                case "2":
                    position = "Phục vụ";
                    break;
                case "3":
                    position = "Chuyên viên";
                    break;
                case "4":
                    position = "Giám sát";
                    break;
                case "5":
                    position = "Quản lý";
                    break;
                case "6":
                    position = "Giám đốc";
                    break;
                default:
                    System.err.println("Chọn không đúng vui lòng nhập lại!!");
            }
        }
        System.out.print("Nhập số lương: ");
        int luong = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(maNhanVien, name, date, gioiTinh, cmnd, sdt, email, level, position, luong);
        listEmployee.add(employee);
        ReadAndWriteFile.writeFileEmployee(listEmployee);
    }

    @Override
    public void display() {
        for (Employee employee : listEmployee) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        System.out.print("Nhập mã nhân viên cần sửa: ");
        int update = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < listEmployee.size(); i++) {
            if (update==(listEmployee.get(i).getEmployeeCode())) {
                count++;
                System.out.print("Nhập tên nhân viên: ");
                String name = scanner.nextLine();
                System.out.print("Nhập ngày sinh: ");
                String date = scanner.nextLine();
                System.out.print("Nhập giới tính: ");
                String gioiTinh = scanner.nextLine();
                System.out.print("Nhập chứng minh nhân dân: ");
                String cmnd = scanner.nextLine();
                System.out.print("Nhập SĐT: ");
                String sdt = scanner.nextLine();
                System.out.print("Nhập Email: ");
                String email = scanner.nextLine();
                System.out.print("Nhập mã nhân viên: ");
                int maNhanVien = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập trình độ nhân viên: ");
                String trinhDo = scanner.nextLine();
                System.out.print("Nhập vị trí nhân viên: ");
                String viTri = scanner.nextLine();
                System.out.print("Nhập số lương: ");
                int luong = Integer.parseInt(scanner.nextLine());
                Employee employee = new Employee(maNhanVien, name, date, gioiTinh, cmnd, sdt, email, trinhDo, viTri, luong);
                listEmployee.set(i, employee);
                ReadAndWriteFile.writeFileEmployee(listEmployee);
            }
        }
        if (count == 0) {
            System.out.println("Không tiềm thấy số mã nhân viên " + update + " này !!\n");
        }
    }
}
