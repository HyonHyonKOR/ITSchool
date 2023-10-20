create table oct20_coffee(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_price number(5) not null,
	c_bean varchar2(10 char) not null
);

select * from OCT20_COFFEE;

create sequence oct20_coffe_seq; 