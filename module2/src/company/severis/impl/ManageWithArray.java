package company.severis.impl;

import company.model.DailyWorker;
import company.model.ManagementStaff;
import company.model.Person;
import company.model.ProductionStaff;
import company.severis.ISeveris;

import java.util.Collections;

public class ManageWithArray implements ISeveris {
    static Person[] person = new Person[1000];

    static {
        person[0] = new ManagementStaff("Thuận", "18/09/1999", "da nang", 500000, 1.5);
        person[1] = new DailyWorker("Hoàn", "03/06/1995", "da nang", 600);
        person[2] = new ManagementStaff("Quang", "2", "3", 10000000, 3.5);
        person[3] = new ProductionStaff("Chiến", "2", "3", 1100);
    }

// khó khăn gì khi hiển thị thông tin phải check null , nếu không check thì sảy ra kết quả không mong muốn là
// hiển thị hết tất cả những gì có trong mảng kể cả giá trị null
//instanceof có chức năng so sánh kiểu dữ liệu có bằng nhau hay không và trả về giá trị boolean
//nếu có 1001 nhân viên trong công ty thì xảy ra ngoại lệ ArrayIndexOutOfBoundsException

    @Override
    public void disPlay() {
        for (Person persons : person) {
            if (persons != null){
                System.out.println(persons);
            }
        }
    }
}
