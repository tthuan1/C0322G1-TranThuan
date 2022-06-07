package school.services.impl;

import school.common.CheckException;
import school.common.InputInformation;
import school.common.ReadAndWriteFile;
import school.common.Regex;
import school.model.Student;
import school.services.Service;
import school.uitl.StudentComparatorDate;
import school.uitl.StudentComparatorName;

import java.util.*;

public class StudentServiceImpl implements Service {
    static List<Student> studentList = new LinkedList<>();

    @Override
    public void add() {
        studentList.clear();
        ReadAndWriteFile.readFilerStudent(studentList);
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

        System.out.println("Nhập mã sinh viên: ");
        int maSinhVien;
        while (true) {
            boolean check = true;
            maSinhVien = Integer.parseInt(Regex.regexMaStudent());
            for (Student student : studentList) {
                if (maSinhVien == student.getStudentCode()) {
                    System.out.println("mã sinh viên trùng yêu cầu nhập lại");
                    check = false;
                    break;
                }
            }
            if (check) {
                break;
            }
        }

        System.out.println("Nhập điểm trung bình: ");
        double diemTB = Double.parseDouble(Regex.regexDiemTB());

        Student student = new Student(id, name, gender, date, diaChi, maSinhVien, diemTB);
        studentList.add(student);
        ReadAndWriteFile.writeFileStudent(studentList);

    }

    @Override
    public void display() {
        studentList.clear();
        ReadAndWriteFile.readFilerStudent(studentList);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void delete() {
        studentList.clear();
        ReadAndWriteFile.readFilerStudent(studentList);
        System.out.print("Nhập id cần xoá: ");
        int id = CheckException.checkparseInt();
        boolean flag = true;
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                System.out.println("Bạn có muốn xoá không" +
                        "\n1. Có" +
                        "\n2. Không" +
                        "\nNhập: ");
                int choose = CheckException.checkparseInt();
                switch (choose) {
                    case 1:
                        studentList.remove(i);
                        ReadAndWriteFile.writeFileStudent(studentList);
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
        studentList.clear();
        ReadAndWriteFile.readFilerStudent(studentList);
        Collections.sort(studentList, new StudentComparatorName());
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void sortDate() {
        studentList.clear();
        ReadAndWriteFile.readFilerStudent(studentList);
        Collections.sort(studentList, new StudentComparatorDate());
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void edit() {
        studentList.clear();
        ReadAndWriteFile.readFilerStudent(studentList);

        System.out.print("Nhập id cần sửa: ");
        int id = CheckException.checkparseInt();
        boolean flag = true;
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                System.out.println("Nhập tên: ");
                String name = CheckException.checkString();

                System.out.println("Nhập giới tính: ");
                String gender = InputInformation.gender();

                System.out.println("Nhập ngày sinh: ");
                String date = CheckException.checkString();
                Regex.regexAge(date);

                System.out.println("Nhập địa chỉ: ");
                String diaChi = CheckException.checkString();

                System.out.println("Nhập mã sinh viên: ");
                int maSinhVien;
                while (true) {
                    boolean check = true;
                    maSinhVien = Integer.parseInt(Regex.regexMaStudent());
                    for (Student student : studentList) {
                        if (maSinhVien == student.getStudentCode()) {
                            System.out.println("mã sinh viên trùng yêu cầu nhập lại");
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        break;
                    }
                }

                System.out.println("Nhập điểm trung bình: ");
                double diemTB = Double.parseDouble(Regex.regexDiemTB());

                Student student = new Student(studentList.get(i).getId(), name, gender, date, diaChi, maSinhVien, diemTB);
                studentList.set(i, student);
                flag = false;
                System.out.println("đã sửa thành công");
                break;
            }
        }
        if (flag) {
            System.out.println("Không thể xoá");
        }
        ReadAndWriteFile.writeFileStudent(studentList);
    }
}
