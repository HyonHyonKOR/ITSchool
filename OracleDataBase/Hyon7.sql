--1. 음료테이블과 카페테이블 만들기
-- 음료테이블 : 음료이름/가격/판매하는 카페의 이름
-- 카페테이플 : 카페이름 / 지역 /좌석 수 
-- 각 테이블에서 음료이름과 카페이름은 고유한 값을 갖는다
-- 두 테이블의 관계를 고려

CREATE TABLE cafe(
    c_name varchar2(15 char) primary key,
    c_address varchar2(5 char) not null,
    c_space number(3) not null
);

CREATE TABLE drink(
    d_name varchar2(15 char) primary key,
    d_price number(5) not null,
    d_c_name varchar2(15 char) not null,
    constraint fk_d_c_name foreign key (d_c_name)
    references cafe(c_name)
    on delete cascade
);

--2. 조건에 맞는 테이블을 만들고 값을 넣어주세요
--A카페는 서울에 위치하고 좌석이 100석이며, (아메리카노,2000원) (라떼,3000원)
--(녹차,2500원)을 판매합니다
INSERT INTO cafe VALUES ('A카페','서울',100);
INSERT INTO drink VALUES ('아메리카노',2000,'A카페');
INSERT INTO drink VALUES ('라떼',3000,'A카페');
INSERT INTO drink VALUES ('녹차',2500,'A카페');

--B카페는 부천에 위치하고 좌석이 80석이며 (홍차,2500원),(스무디,3000원)
--(에스프레소,4000원을 판매합니다.

INSERT INTO cafe VALUES ('B카페','부천',80);
INSERT INTO drink VALUES ('홍차',2500,'B카페');
INSERT INTO drink VALUES ('스무디',3000,'B카페');
INSERT INTO drink VALUES ('에스프레소',4000,'B카페');


--3. 요청하는 쿼리문을 작성해주세요
--평균가보다 비싼 음료는 몇 종류?
SELECT COUNT(*) FROM DRINK WHERE D_PRICE>
(SELECT AVG(D_PRICE) FROM DRINK);

--제일 싼 음료를 파는 카페의 이름?
SELECT c_name FROM CAFE WHERE c_name=
(SELECT d_c_name FROM DRINK WHERE d_price=   
(SELECT MIN(D_PRICE) FROM DRINK)
);

--서울에 있는 카페에서 만드는 음료 평균가?
SELECT AVG(D_PRICE) FROM DRINK WHERE d_c_name=
(SELECT c_name FROM CAFE WHERE c_address ='서울');

--좌석이 90석 이상인 카페에서 파는 음료의 이름?
SELECT d_name FROM DRINK WHERE d_c_name IN
(SELECT c_name FROM CAFE WHERE c_space >= 90);

--평균가 이하인 음료의 이름?
SELECT d_name FROM DRINK WHERE d_price <=
 (SELECT AVG(d_price) FROM DRINK);

--가장 비싼 음료를 파는 카페는 어디에 있는지?
SELECT c_address FROM CAFE WHERE c_name = 
(SELECT d_c_name FROM DRINK WHERE d_price =
  (SELECT MAX(d_price) FROM DRINK)
);