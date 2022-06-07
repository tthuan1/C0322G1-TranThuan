package companyABC.services.Impl;

import companyABC.common.CheckException;
import companyABC.common.ReadAndWriteFile;
import companyABC.common.Regex;
import companyABC.model.ProductionStaff;
import companyABC.services.Service;

import java.util.ArrayList;
import java.util.List;

public class ProductionStaffServiceImpl implements Service {
    public List<ProductionStaff> productionStaffs = new ArrayList<>();

    @Override
    public void display() {
        productionStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(productionStaffs);
        for (ProductionStaff productionStaff : productionStaffs) {
            System.out.println(productionStaff);
        }
    }

    @Override
    public void add() {
        productionStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(productionStaffs);
        int id = 1;
        if (!productionStaffs.isEmpty()) {
            id = productionStaffs.size() + 1;
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
        System.out.println("Nhập số sản phẩm: ");
        int product = CheckException.checkparseInt();
        System.out.println("Nhập giá mỗi sản phẩm: ");
        double price = CheckException.checkparseDouble();
        ProductionStaff productionStaff = new ProductionStaff(id, employeeCode, name, dateOfBirth, address, product, price);
        productionStaffs.add(productionStaff);
        ReadAndWriteFile.writeFileEmployee(productionStaffs);
        System.out.println("thêm mới thành công!");
    }

    @Override
    public void delete() {
        productionStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(productionStaffs);
        System.out.print("Nhập id bạn muốn xoá: ");
        String s=CheckException.checkString();
        boolean flag=true;
        for (int i = 0; i < productionStaffs.size(); i++) {
            if (s.equals(productionStaffs.get(i).getEmployeeCode())){
                productionStaffs.remove(i);
                System.out.println("Đã xoá thành công!!");
                flag=false;
                break;
            }
        }
        if (flag){
            System.out.println("mã không tồn tại !!");
        }
        ReadAndWriteFile.writeFileEmployee(productionStaffs);

    }

    @Override
    public void search() {
        productionStaffs.clear();
        ReadAndWriteFile.readFilerEmployee(productionStaffs);
        System.out.print("Nhập mã nhân viên tìm kiếm: ");
        String s=CheckException.checkString();
        boolean flag=true;
        for (ProductionStaff productionStaff : productionStaffs) {
            if (s.equals(productionStaff.getEmployeeCode())) {
                System.out.println(productionStaff);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("mã không tồn tại !!");
        }
    }
}
