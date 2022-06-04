package furama_resort.services.impl;

import furama_resort.common.CheckException;
import furama_resort.common.InputInformation;
import furama_resort.common.ReadAndWriteFile;
import furama_resort.common.Regex;
import furama_resort.model.person.Employee;
import furama_resort.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> listEmployee = new ArrayList<>();

    @Override
    public void add() {
        listEmployee.clear();
        ReadAndWriteFile.readFilerEmployee(listEmployee);

        System.out.print("Nhập tên nhân viên: ");
        String name = CheckException.checkString();

        System.out.print("Nhập ngày sinh: ");
        String date = scanner.nextLine();
        Regex.regexAge(date);

        String gender = InputInformation.gender();

        System.out.print("Nhập chứng minh nhân dân: ");
        String cmnd = scanner.nextLine();

        System.out.print("Nhập SĐT: ");
        String sdt = CheckException.checkString();

        System.out.print("Nhập Email: ");
        String email = CheckException.checkString();

        System.out.print("Nhập max nhân viên: ");
        int employeeCode = CheckException.checkparseInt();

        String level = InputInformation.level();

        String position = InputInformation.position();

        System.out.print("Nhập số lương: ");
        int salary = CheckException.checkparseInt();

        Employee employee = new Employee(employeeCode, name, date, gender, cmnd, sdt, email, level, position, salary);
        listEmployee.add(employee);
        ReadAndWriteFile.writeFileEmployee(listEmployee);
    }

    @Override
    public void display() {
        listEmployee.clear();
        ReadAndWriteFile.readFilerEmployee(listEmployee);
        for (Employee employee : listEmployee) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        listEmployee.clear();
        ReadAndWriteFile.readFilerEmployee(listEmployee);
        System.out.print("Nhập mã nhân viên cần sửa: ");
        int update = CheckException.checkparseInt();
        int count = 0;
        for (int i = 0; i < listEmployee.size(); i++) {
            if (update == (listEmployee.get(i).getEmployeeCode())) {
                count++;
                System.out.print("Nhập tên nhân viên: ");
                String name = CheckException.checkString();

                System.out.print("Nhập ngày sinh: ");
                String date = CheckException.checkString();
                Regex.regexAge(date);

                String gender = InputInformation.gender();

                System.out.print("Nhập chứng minh nhân dân: ");
                String cmnd = CheckException.checkString();

                System.out.print("Nhập SĐT: ");
                String sdt = CheckException.checkString();

                System.out.print("Nhập Email: ");
                String email = CheckException.checkString();

                int employeeCode = listEmployee.get(i).getEmployeeCode();

                String level = InputInformation.level();

                String position = InputInformation.position();

                System.out.print("Nhập số lương: ");
                int luong = CheckException.checkparseInt();

                Employee employee = new Employee(employeeCode, name, date, gender, cmnd, sdt, email, level, position, luong);
                listEmployee.set(i, employee);
                ReadAndWriteFile.writeFileEmployee(listEmployee);
            }
        }
        if (count == 0) {
            System.out.println("Không tiềm thấy số mã nhân viên " + update + " này !!\n");
        }
    }
}
