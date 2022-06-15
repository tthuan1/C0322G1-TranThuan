use QuanLySinhVien;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from Student
where Student.StudentName like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from Class
where  month(Class.StartDate) = 12  ;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from  Subject
where  Subject.Credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
UPDATE Student
SET  StudentName = "Hung"
where ClassId = 2 ;
select * from Student;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần
select  `Student`.StudentName, `Subject`.SubName, `Mark`.Mark from Student,`Subject`,Mark
order by `Mark`.Mark desc, StudentName
;
