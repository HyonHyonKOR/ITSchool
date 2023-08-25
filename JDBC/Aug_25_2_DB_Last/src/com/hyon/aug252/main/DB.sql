-- 어떤 특정한 식당에 대한 테이블
-- 식당 지점(체인점 지역), 식당 주인, 좌석 수
CREATE TABLE FRANCHISEHYON(
  f_location VARCHAR2(15 CHAR) PRIMARY KEY,
  f_ceo_name VARCHAR2(15 CHAR) NOT NULL,
  f_seat NUMBER(3) NOT NULL
  );

-- 예약 테이블
-- 예약자 이름, 예약 시간, 예약자 전화번호, 예약 지점 

CREATE TABLE RESERVATION(
  r_no NUMBER(3) primary key,
  r_name VARCHAR2(15 CHAR) not null,
  r_day DATE not null,
  r_phone NUMBER(3) not null,
  r_f_location VARCHAR2(10 CHAR) not null,
  constraint fk_r_f_location foreign key (r_f_location)
  REFERENCES FRANCHISEHYON(f_location) 
  ON DELETE CASCADE
);

CREATE SEQUENCE RESERVATION_SEQ;


