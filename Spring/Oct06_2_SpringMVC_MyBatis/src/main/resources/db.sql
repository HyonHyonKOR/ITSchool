create table oct06_student(
   s_no number(3) primary key,
   s_name varchar(10 char) not null,
   s_nickname varchar(10 char) not null
);

create sequence oct06_student_seq;

select * from oct06_student;