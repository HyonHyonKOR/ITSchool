create table sns_member(
  m_id varchar2(20 char) primary key,
  m_password varchar2(20 char) not null,
  m_name varchar2(20 char) not null,
  m_phonenum varchar2(15) not null,
  m_birthday date not null,
  m_photo varchar2(200 char) not null
);
