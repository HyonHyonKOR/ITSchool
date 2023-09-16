create table sep14_apple(
   a_location varchar2(10 char) primary key,
   a_color varchar2(10 char) not null,
   a_flavor varchar2(10 char) not null,
   a_price number(5) not null,
   a_introduce varchar2(100 char) not null
);

insert into sep14_apple values('충주','빨강','단맛',4000,'충주사과!!!!!!');
insert into sep14_apple values('서울','초록','신맛',4500,'서울사과!!!!!!');
select * from sep14_apple ;

select * 
from
(
select ROWNUM rn,a_location,a_color,a_flavor,a_price,a_introduce
from(
  select * from SEP14_APPLE order by a_price
	)
)
where rn between 5 and 8;

