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

    @Override
    public void disPlay() {
        for (Person persons : person) {
            if (persons != null){
                System.out.println(persons);
            }
//            if (persons instanceof ManagementStaff) {
//                System.out.println(persons);
//            }
//            if (persons instanceof DailyWorker) {
//                System.out.println(persons);
//            }
//            if (persons instanceof ProductionStaff) {
//                System.out.println(persons);
//            }
        }
    }
}
