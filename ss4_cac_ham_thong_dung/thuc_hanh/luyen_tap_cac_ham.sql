use quanlysinhvien1;
select `subject`.* from `subject`
where credit = (select max(credit) from `subject`);
select `subject`.*, max(mark.mark) as diem_lon_nhat from `subject`
join mark on `subject`.subid=mark.subid where mark=(select max(mark.mark) from mark);
select student.*, avg(mark) as diem_trung_binh from student
join mark on student.studentid=mark.studentid
group by student.studentid
order by diem_trung_binh desc;