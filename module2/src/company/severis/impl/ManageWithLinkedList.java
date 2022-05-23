package company.severis.impl;

import company.model.DailyWorker;
import company.model.ManagementStaff;
import company.model.Person;
import company.model.ProductionStaff;
import company.severis.ISeveris;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ManageWithLinkedList implements ISeveris {
    static List<Person> list=new LinkedList<>();
    static {
        list.add(new DailyWorker("Hoàn","1/1/1995","da nang",30));
        list.add(new ManagementStaff("Thuận","18/19/1999","da nang",300000,2.2));
        list.add(new ProductionStaff("Quang","2/1/1995","da nang",1000));
    }

    @Override
    public void disPlay() {
        for (Person person: list) {
            System.out.println(person);
        }
    }

}
