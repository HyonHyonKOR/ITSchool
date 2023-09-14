create table sep14_apple(
   a_location varchar2(10 char) primary key,
   a_color varchar2(10 char) not null,
   a_flavor varchar2(10 char) not null,
   a_price number(5) not null,
   a_introduce varchar2(100 char) not null
);

insert into sep14_apple values('충주','빨강','단맛',4000,'충주사과!!!!!!');
insert into sep14_apple values('서울','초록','신맛',4500,'서울사과!!!!!!');

select * from sep14_apple;