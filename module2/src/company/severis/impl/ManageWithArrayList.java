package company.severis.impl;

import company.model.DailyWorker;
import company.model.ManagementStaff;
import company.model.Person;
import company.model.ProductionStaff;
import company.severis.ISeveris;

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
        for (int i = 0; i < list.size() ; i++) {
            personMap.put(i, list.get(i));
        }
    }

    @Override
    public void disPlay() {
//        list.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
//        Collections.sort(list,new ComparePenson());
//        for (Person person: list) {
//            System.out.println(person);
//        }
        for (Integer person:personMap.keySet()) {
            System.out.println(personMap.get(person)+", id: "+person);
        }
    }
}
