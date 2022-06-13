package services.impl;


import common.CheckException;
import common.InputInformation;
import common.ReadAndWriteFile;
import common.Regex;
import model.SoTietKiemVoThoiHan;
import services.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoTietKiemVoThoiHanServiceImpl implements Service {
    static Scanner scanner = new Scanner(System.in);
    static List<SoTietKiemVoThoiHan> soTietKiemVoThoiHanList = new ArrayList<>();

    @Override
    public void add() {
        soTietKiemVoThoiHanList.clear();
        ReadAndWriteFile.readFilerVoThoiHan(soTietKiemVoThoiHanList);

        System.out.print("Nhập mã số sổ: ");
        String maSoSo = Regex.regexMaSoSo();

        System.out.print("Nhập mã khách hàng: ");
        int maKhachHang = CheckException.checkParseInt();

        System.out.print("Nhập ngày mở sổ: ");
        String ngayMoSo = Regex.regexAge1();

        System.out.print("Nhập thời gian gửi: ");
        String thoiGianGui = Regex.regexAge1();

        System.out.print("Nhập số tiền: ");
        String soTien = CheckException.checkString();

        System.out.print("Nhập lãi xuất: ");
        String laiXuat = CheckException.checkString();
        SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan(maSoSo, maKhachHang, ngayMoSo, thoiGianGui, soTien, laiXuat);
        soTietKiemVoThoiHanList.add(soTietKiemVoThoiHan);
        ReadAndWriteFile.writeFileVoThoiHan(soTietKiemVoThoiHanList);
    }

    @Override
    public void display() {
        soTietKiemVoThoiHanList.clear();
        ReadAndWriteFile.readFilerVoThoiHan(soTietKiemVoThoiHanList);
        for (SoTietKiemVoThoiHan soTietKiemVoThoiHan : soTietKiemVoThoiHanList) {
            System.out.println(soTietKiemVoThoiHan);
        }
    }


    @Override
    public void delete() {
        soTietKiemVoThoiHanList.clear();
        ReadAndWriteFile.readFilerVoThoiHan(soTietKiemVoThoiHanList);
        System.out.println("Nhập mã sổ sổ muốn xoá: ");

        String  maSoSo = CheckException.checkString();

        int count = 0;
        for (int i = 0; i < soTietKiemVoThoiHanList.size(); i++) {
            if (maSoSo.equals(soTietKiemVoThoiHanList.get(i).getMaSoSo()) ) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = CheckException.checkParseInt();

                switch (inputChoose) {
                    case 1:
                        soTietKiemVoThoiHanList.remove(i);
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
        ReadAndWriteFile.writeFileVoThoiHan(soTietKiemVoThoiHanList);

    }

}
