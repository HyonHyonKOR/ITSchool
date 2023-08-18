--arithmetic
SELECT 10+10+10 FROM dual;
SELECT 10-10 FROM dual;
SELECT 10*5 AS MULTIFLY FROM dual;
SELECT 10/5 AS DEVIDE FROM dual;
SELECT SYSDATE FROM DUAL;

--make a table
CREATE TABLE PERSON(
    p_name varchar2(10 char),
    p_age number(3),
    p_gender varchar2(2 char)
);

INSERT INTO person VALUES('홍길동',10,'남');
INSERT INTO person VALUES('김길동',30,'여');
INSERT INTO person VALUES('최길동',10,'남');

drop table person purge;

--number vs float
create table testNum(
   t_num number(5),  --12345 
   t_flo float(5)    --12000
 );
 
 insert into testNum values(12345,12345);
 select * from testNum;

drop table testNum purge;

--primary key, foreign key

CREATE TABLE EXAMPLE6(
    ex6_id VARCHAR2(10 CHAR) PRIMARY KEY
);

insert into example6 values('10');
insert into example6 values('20');
insert into example6 values('30');

CREATE TABLE EXAMPLE7(
    ex7_id VARCHAR2(10 CHAR),
    CONSTRAINT fk_ex7 FOREIGN KEY(ex7_id)
        REFERENCES EXAMPLE6(ex6_id)
        ON DELETE CASCADE
);

insert into example7 values('10');
insert into example7 values('20');
insert into example7 values('30');
insert into example7 VALUES('40'); --실패: 참조한 ex6에는 현재 '10','20','30'만 있어서

select * from example6;
select * from example7;

delete FROM example6 WHERE ex6_id = '10';
select * from example6;
select * from example7;

drop table example6 CASCADE CONSTRAINTS PURGE;
drop table example7 CASCADE CONSTRAINTS PURGE;

CREATE TABLE school(
    department_code NUMBER(4) PRIMARY KEY,
    department_name VARCHAR2(10 CHAR) NOT NULL
);

CREATE TABLE student(
    student_number NUMBER(3) primary NOT NULL, 
    student_name VARCHAR2(30 CHAR) NOT NULL,
    department_code NUMBER(4) NOT NULL,
    CONSTRAINT fk_department_code FOREIGN KEY(department_code)
    REFERENCES school(department_code) 
    ON DELETE CASCADE
);

INSERT INTO school VALUES(1001,'컴퓨터공학과');
INSERT INTO school VALUES(1002,'체육학과');

INSERT INTO student VALUES(101,'김수철',1002);
INSERT INTO student VALUES(102,'니콜라스',1001);
INSERT INTO student VALUES(103,'정찬성',1002);
INSERT INTO student VALUES(104,'남궁성',1001);

select * from school;
select * from student;

DELETE FROM SCHOOL WHERE department_code=1001;

select * from school;
select * from student;

drop table school; --테이블 삭제가 안됨(참조 중인 테이블이 있어서)

drop table school CASCADE CONSTRAINTS PURGE; --참조를 무시
drop table student CASCADE CONSTRAINTS PURGE;

--check
create table example8(
   coll number(10),
   constraint ex8_check check(coll between 1 and 9)
);

insert into example8 values(10); //error

--default
create table example9(
coll number default 999
);

insert into example9 values(default);
insert into example9 values(NULL);
insert into example9 values(0);
insert into example9 values(11);

--practice
create table coffeemenu(
    c_name VARCHAR2(17 char) primary key,
    c_price number(7) not null,
    c_calories number(3) not null,
    c_startsell date not null
);


insert into coffeemenu values('감자맛커피',7500,250,sysdate);
desc coffeemenu;


alter table coffeemenu rename column c_name to c_name2;
desc coffeemenu;

alter table coffeemenu add c_name1 varchar2(20 char);
desc coffeemenu;

UPDATE coffeemenu SET c_name1 = c_name2;
select * from coffeemenu;
ALTER TABLE coffeemenu DROP COLUMN c_name2;
desc coffeemenu;

alter table coffeemenu modify c_name1 not NULL;
desc coffeemenu;

drop table coffeemenu;

flashback table coffeemenu to before drop;
select * from coffeemenu;

purge recyclebin;

drop table coffeemenu purge;

