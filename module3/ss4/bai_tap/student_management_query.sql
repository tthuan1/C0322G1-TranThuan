use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select s.*, max(credit)
from `subject` s 
group by (sub_id)
order by credit Desc
;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from subject
where credit=(
	select max(credit) from subject
);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.*, avg(mark) as DTB
from student
join mark on student.student_id=mark.student_id
group by (student_id)
;
       