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
        list.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        for (Person person: list) {
            System.out.println(person);
        }
    }
    //Không nên dùng vòng lặp truyền thống (for i = 0 -> size() – 1 => get(i)) để duyệt qua từng phần tử
    // có trong LinkedList tại vì LinkedList là danh sách theo các node, chỉ có node trước đó biết vị trí node sau
    //vì thế, khi duyệt thì độ phúc tạp lên O^n
    //xóa và thêm nhân viên thì nên sử dụng LinkedList bởi vì khi xoá  thì 2 node 2 bên của node đó sẽ không
    //liên kết với node xoá mà chúng sẽ liên kết với nhau

    //Ưu và nhược điểm của ArrayList và LinkedList.
    //ArrayList nên để hiển thị
    //LinkedList nên sử dụng khi thêm xoá dữ liệu



}
