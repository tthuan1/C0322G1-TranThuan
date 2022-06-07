package school.services.impl;

import school.common.CheckException;
import school.common.InputInformation;
import school.common.ReadAndWriteFile;
import school.common.Regex;
import school.model.Teacher;
import school.services.Service;
import school.uitl.TeacherComparatorDate;
import school.uitl.TeacherComparatorName;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TeacherServiceImpl implements Service {
    static List<Teacher> teacherList = new LinkedList<>();

    @Override
    public void add() {
        teacherList.clear();
        ReadAndWriteFile.readFilerTeacher(teacherList);

        System.out.println("Nhập id: ");
        int id = CheckException.checkparseInt();

        System.out.println("Nhập tên: ");
        String name = CheckException.checkString();

        System.out.println("Nhập giới tính: ");
        String gender = InputInformation.gender();

        System.out.println("Nhập ngày sinh: ");
        String date = CheckException.checkString();
        Regex.regexAge(date);

        System.out.println("Nhập địa chỉ: ");
        String diaChi = CheckException.checkString();

        System.out.println("Nhập lớp dạy: ");
        String lop = CheckException.checkString();

        System.out.println("Nhập lương một giờ dạy: ");
        double luong =Double.parseDouble( Regex.regexSoDuong());

        System.out.println("Nhập số giờ dạy trong tháng: ");
        double soGio = Double.parseDouble( Regex.regexSoDuong());

        Teacher teacher = new Teacher(id, name, gender, date, diaChi, lop, luong, soGio);
        teacherList.add(teacher);
        ReadAndWriteFile.writeFileTeacher(teacherList);

    }

    @Override
    public void display() {
        teacherList.clear();
        ReadAndWriteFile.readFilerTeacher(teacherList);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void delete() {
        teacherList.clear();
        ReadAndWriteFile.readFilerTeacher(teacherList);
        System.out.print("Nhập id cần xoá: ");
        int id = CheckException.checkparseInt();
        boolean flag = true;
        for (int i = 0; i < teacherList.size(); i++) {
            if (id == teacherList.get(i).getId()) {
                System.out.println("Bạn có muốn xoá không" +
                        "\n1. Có" +
                        "\n2. Không" +
                        "\nNhập: ");
                int choose = CheckException.checkparseInt();
                switch (choose) {
                    case 1:
                        teacherList.remove(i);
                        ReadAndWriteFile.writeFileTeacher(teacherList);
                        flag = false;
                        System.out.println("xoá thành công");
                        break;
                    case 2:
                        System.out.println("Dừng xoá !!");
                        break;
                    default:
                        System.out.println("nhập sai và dừng xoá !!");
                        break;
                }
            }
        }
        if (flag) {
            System.out.println("Không thể xoá");
        }
    }

    @Override
    public void sortName() {
        teacherList.clear();
        ReadAndWriteFile.readFilerTeacher(teacherList);
        Collections.sort(teacherList, new TeacherComparatorName());
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void sortDate() {
        teacherList.clear();
        ReadAndWriteFile.readFilerTeacher(teacherList);
        Collections.sort(teacherList, new TeacherComparatorDate());
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }


    @Override
    public void edit() {
        teacherList.clear();
        ReadAndWriteFile.readFilerTeacher(teacherList);

        System.out.print("Nhập id cần sửa: ");
        int id = CheckException.checkparseInt();
        boolean flag = true;
        for (int i = 0; i < teacherList.size(); i++) {
            if (id == teacherList.get(i).getId()) {
                System.out.println("Nhập tên: ");
                String name = CheckException.checkString();

                System.out.println("Nhập giới tính: ");
                String gender = InputInformation.gender();

                System.out.println("Nhập ngày sinh: ");
                String date = CheckException.checkString();
                Regex.regexAge(date);

                System.out.println("Nhập địa chỉ: ");
                String diaChi = CheckException.checkString();

                System.out.println("Nhập lớp dạy: ");
                String lop = CheckException.checkString();

                System.out.println("Nhập lương một giờ dạy: ");
                double luong = Double.parseDouble( Regex.regexSoDuong());

                System.out.println("Nhập số giờ dạy trong tháng: ");
                double soGio = Double.parseDouble( Regex.regexSoDuong());

                Teacher teacher = new Teacher(id, name, gender, date, diaChi, lop, luong, soGio);
                teacherList.set(i, teacher);
                flag = false;
                System.out.println("đã sửa thành công");
                ReadAndWriteFile.writeFileTeacher(teacherList);
                break;
            }
        }
        if (flag) {
            System.out.println("Không thể xoá");
        }
    }
}
