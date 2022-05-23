package company.severis.impl;

import company.model.DailyWorker;
import company.model.ManagementStaff;
import company.model.Person;
import company.model.ProductionStaff;
import company.severis.ISeveris;

import java.util.Map;
import java.util.TreeMap;

public class ManageWithMap implements ISeveris {
    static Map<Integer, Person> personMap=new TreeMap<>();
    static {
        personMap.put(1,new DailyWorker("Hoàn","1/1/1995","da nang",30) );
        personMap.put(3,new ManagementStaff("Thuận","18/19/1999","da nang",300000,2.2) );
        personMap.put(4,new ProductionStaff("Quang","2/1/1995","da nang",1000) );
        personMap.put(2,new ManagementStaff("H","18/19/1999","da nang",300000,2.2));
    }

    @Override
    public void disPlay() {
        for (Integer person:personMap.keySet()) {
            System.out.println(personMap.get(person)+", id: "+person);
        }
        System.out.println(personMap.containsKey(6));
        System.out.println(personMap.containsKey(2));
    }
    //để kiểm tra mã nhân viên đã tồn tại hay chưa sử dụng containsKey như trên, kết quả sẽ trả về true khi đã tồn tại
    // false thi key chưa tồn tại
}
