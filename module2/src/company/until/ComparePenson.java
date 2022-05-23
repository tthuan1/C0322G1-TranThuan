package company.until;

import company.model.Person;

import java.util.Comparator;

public class ComparePenson implements Comparator<Person> {
    //Muốn sử dụng comparator thì cần implements Comparator Override lại phương thức compare sau đó ta thao tác như sau
    //Collections.sort(danh sách,new class đã triển khai Comparator ());
    //hoặc
    //list.sort(((o1, o2) -> o1.thuộc tính muốn sắp xếp().compareTo(o2.thuộc tính muốn sắp xếp)));
    //lưu lý không cần tạo class đã implements Comparator nhưng chỉ sài ngay không có thể tái sử dụng
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.payroll().equals(o2.payroll())) {
            return o1.getName().compareTo(o2.getName());
        }
        return (int) (o1.payroll() - o2.payroll());
    }
}
