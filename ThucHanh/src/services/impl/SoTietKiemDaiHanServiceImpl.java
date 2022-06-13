package services.impl;

import common.CheckException;
import common.InputInformation;
import common.ReadAndWriteFile;
import common.Regex;
import model.SoTietKiemDaiHan;
import services.Service;

import java.util.*;

public class SoTietKiemDaiHanServiceImpl implements Service {
    static Scanner scanner = new Scanner(System.in);
    static List<SoTietKiemDaiHan> soTietKiemDaiHanList = new ArrayList<>();

    @Override
    public void add() {
        soTietKiemDaiHanList.clear();
        ReadAndWriteFile.readFilerDaiHan(soTietKiemDaiHanList);

        System.out.print("Nhập mã số sổ: ");
        String maSoSo = Regex.regexMaSoSo();

        System.out.print("Nhập mã khách hàng: ");
        int maKhachHang = CheckException.checkParseInt();

        System.out.print("Nhập ngày mở sổ: ");
        String ngayMoSo = Regex.regexAge1();

        System.out.print("Nhập thời gian gửi: ");
        String thoiGianGui = Regex.regexAge1();

        System.out.print("Nhập số tiền: ");
        String soTien = String.valueOf(CheckException.checkString());

        System.out.print("Nhập lãi xuất: ");
        String laiXuat = CheckException.checkString();

        System.out.print("Nhập kì hạn: ");
        String kiHan = InputInformation.kiHanDaiHan();

        System.out.print("Nhập ưu đãi: ");
        String uuDai = CheckException.checkString();

        SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTien, laiXuat, kiHan, uuDai);
        soTietKiemDaiHanList.add(soTietKiemDaiHan);
        ReadAndWriteFile.writeFileDaiHan(soTietKiemDaiHanList);
    }

    @Override
    public void display() {
        soTietKiemDaiHanList.clear();
        ReadAndWriteFile.readFilerDaiHan(soTietKiemDaiHanList);
        for (SoTietKiemDaiHan soTietKiemDaiHan:soTietKiemDaiHanList) {
            System.out.println(soTietKiemDaiHan);
        }
    }


    @Override
    public void delete() {
        soTietKiemDaiHanList.clear();
        ReadAndWriteFile.readFilerDaiHan(soTietKiemDaiHanList);
        System.out.println("Nhập mã sổ sổ muốn xoá: ");

        String  maSoSo = CheckException.checkString();

        int count = 0;
        for (int i = 0; i < soTietKiemDaiHanList.size(); i++) {
            if (maSoSo.equals(soTietKiemDaiHanList.get(i).getMaSoSo()) ) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = CheckException.checkParseInt();

                switch (inputChoose) {
                    case 1:
                        soTietKiemDaiHanList.remove(i);
                        System.out.println("đã xóa thành công");
                        count++;
                        break;
                    case 2:
                        count++;
                        break;
                }
            }
        }
        if (count==0){
            System.out.println("Không tìm thấy !!");
        }
ReadAndWriteFile.writeFileDaiHan(soTietKiemDaiHanList);
    }

    public void sortName() {
//        studentList.clear();
//        ReadAndWriteFile.readFilerStudent(studentList);
//        Collections.sort(studentList, new StudentComparatorName());
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
    }
}
