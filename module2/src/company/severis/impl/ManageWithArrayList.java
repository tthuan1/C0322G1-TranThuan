package company.severis.impl;

import company.model.DailyWorker;
import company.model.ManagementStaff;
import company.model.Person;
import company.model.ProductionStaff;
import company.severis.ISeveris;
import company.until.ComparePenson;

import java.util.*;

public class ManageWithArrayList implements ISeveris {
    static List<Person> list=new ArrayList<>();

    static Map<Integer,Person> personMap=new TreeMap<>();
    static {
        list.add(new DailyWorker("Hoàn","1/1/1995","da nang",30));
        list.add(new ManagementStaff("Thuận","18/19/1999","da nang",300000,2.2));
        list.add(new ProductionStaff("Quang","2/1/1995","da nang",1000));
        list.add(new ManagementStaff("A","18/19/1999","da nang",300000,2.2));
        list.add(new ManagementStaff("F","18/19/1999","da nang",300000,2.2));
        list.add(new ManagementStaff("B","18/19/1999","da nang",300000,2.2));
        list.add(new ManagementStaff("G","18/19/1999","da nang",300000,2.2));
        list.add(new ManagementStaff("C","18/19/1999","da nang",2000,2.2));
        list.add(new ManagementStaff("H","18/19/1999","da nang",300000,2.2));
        list.add(new ManagementStaff("D","18/19/1999","da nang",4000,2.2));
        list.add(new ManagementStaff("I","18/19/1999","da nang",300000,2.2));
        list.add(new ManagementStaff("E","18/19/1999","da nang",5000,2.2));
    }
    //ArrayList không cần khởi tạo 1000 phần tử trước vì ArrayList có cơ chế mảng động cho phép tạo ra mảng mới
    // gấp 150% mảng củ và sao chép lại các phần từ có trước đó, nên khi có 1001 nhân viên thì không có vấn đề

    @Override
    public void disPlay() {
        Collections.sort(list,new ComparePenson());
        for (Person person: list) {
            System.out.println(person);
        }
    }
}
