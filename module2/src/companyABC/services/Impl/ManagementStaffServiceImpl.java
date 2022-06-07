package companyABC.services.Impl;

import companyABC.common.CheckException;
import companyABC.common.ReadAndWriteFile;
import companyABC.common.Regex;
import companyABC.model.ManagementStaff;
import companyABC.model.Person;
import companyABC.services.Service;

import java.util.ArrayList;
import java.util.List;

public class ManagementStaffServiceImpl implements Service {
    public List<ManagementStaff> managementStaffs = new ArrayList<>();

    @Override
    public void display() {
        managementStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(managementStaffs);
        for (ManagementStaff managementStaff :  managementStaffs) {
            System.out.println(managementStaff);
        }
    }

    @Override
    public void add() {
        managementStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(managementStaffs);
        int id = 1;
        if (!managementStaffs.isEmpty()) {
            id = managementStaffs.size() + 1;
        }
        System.out.println("Nhập mã nhân viên: ");
        String employeeCode = CheckException.checkString();

        System.out.println("Nhập Tên: ");
        String name = CheckException.checkString();
        System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String dateOfBirth = CheckException.checkString();
        Regex.regexAge(dateOfBirth);
        System.out.println("Nhập địa chỉ: ");
        String address = CheckException.checkString();
        System.out.println("Nhập lương cơ bản: ");
        double salary = CheckException.checkparseDouble();
        System.out.println("Nhập hệ số lương: ");
        double coefficientsSalary = CheckException.checkparseDouble();
        ManagementStaff managementStaff = new ManagementStaff(id, employeeCode, name, dateOfBirth, address, salary, coefficientsSalary);
        managementStaffs.add(managementStaff);
        ReadAndWriteFile.writeFileEmployee(managementStaffs);
        System.out.println("thêm mới thành công!");
    }

    @Override
    public void delete() {
        managementStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(managementStaffs);
        System.out.print("Nhập id bạn muốn xoá: ");
        String s=CheckException.checkString();
        boolean flag=true;
        for (int i = 0; i < managementStaffs.size(); i++) {
            if (s.equals(managementStaffs.get(i).getEmployeeCode())){
                managementStaffs.remove(i);
                System.out.println("Đã xoá thành công!!");
                flag=false;
                break;
            }
        }
        if (flag){
            System.out.println("mã không tồn tại !!");
        }
        ReadAndWriteFile.writeFileEmployee(managementStaffs);

    }

    @Override
    public void search() {
        managementStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(managementStaffs);
        System.out.print("Nhập mã nhân viên tìm kiếm: ");
        String s=CheckException.checkString();
        boolean flag=true;
        for (ManagementStaff managementStaff : managementStaffs) {
            if (s.equals(managementStaff.getEmployeeCode())) {
                System.out.println(managementStaff);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("mã không tồn tại !!");
        }
    }
}
