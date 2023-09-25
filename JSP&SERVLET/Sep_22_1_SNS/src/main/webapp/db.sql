create table sns_member(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(12 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(11 char) not null,
	m_birthday date not null,
	m_photo varchar2(200 char) not null
);

select * from sns_member;


-- select * from sns_member where m_id='1' or '1'='1';
----------------------------------------------------------------------------------
create table sns_board(
	b_no number(4) primary key,
	b_writer varchar2(10 char) not null,
	b_when date not null,
	b_text varchar2(200 char) not null,
	constraint fk_sns_board foreign key(b_writer)
		references sns_member(m_id)
		on delete cascade
);

create sequence sns_board_seq;

select * from SNS_BOARD;  