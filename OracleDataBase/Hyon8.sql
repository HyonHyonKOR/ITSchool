-----------------------------------------------------------------------------------------
-- 요식업 프랜차이즈
-- 홍콩반점 서초점은 홍길동이 운영하고 100석
-- 홍콩반점 종로점은 김길동이 운영하고 80석
-- 한신포차 강남점은 홍길동이 운영하고 150석
-- 구로포차 구로점은 최길동이 운영하고 130석
-----------------------------------------------------------------------------------------
-- 홍길동, 1990-03-01일생, 남자
-- 김길동, 1992-02-01일생, 여자
-- 홍길동, 1991-12-12일생, 여자
-- 최길동, 1989-07-14일생, 남자
-----------------------------------------------------------------------------------------

CREATE TABLE FRANCHISE(
    f_no   NUMBER(4) PRIMARY KEY,
    f_name VARCHAR2(15 CHAR) NOT NULL,
    f_location VARCHAR2(10 CHAR) NOT NULL,
    f_ceo NUMBER(3) NOT NULL,   --사장님 번호, 이름값으로 하게되면 '홍길동' 겹침
    f_seat NUMBER(3) NOT NULL
);

CREATE SEQUENCE FRANCHISE_SEQ;

INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'홍콩반점','서초',1,100);
INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'홍콩반점','종로',2,80);
INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'한신포차','강남',3,150);
INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'구로포차','구로',4,130);

SELECT * FROM FRANCHISE;

CREATE TABLE CEO(
    c_no NUMBER(3) PRIMARY KEY,
    c_name VARCHAR2(15 CHAR) NOT NULL,
    c_birthday DATE NOT NULL,
    c_gender CHAR(2 CHAR) NOT NULL
    CONSTRAINT OwnerInfo_c_gender CHECK(c_gender IN('남자','여자'))
);

CREATE SEQUENCE CEO_SEQ;


INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'홍길동',
TO_DATE('1990-03-01','YYYY-MM-DD'),'남자');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'김길동',
TO_DATE('1992-02-01','YYYY-MM-DD'),'여자');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'홍길동',
TO_DATE('1991-12-12','YYYY-MM-DD'),'여자');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'최길동',
TO_DATE('1989-07-14','YYYY-MM-DD'),'남자');

SELECT * FROM CEO;

SELECT * FROM CEO WHERE c_no = 
  (SELECT f_ceo FROM FRANCHISE WHERE f_seat=
  (SELECT MAX(f_seat) FROM FRANCHISE)
  );
      
 --짜장면,5000원,홍콩반점 서초점(100명)
 --불닭발,12000원,한신포차 강남점(150명)
   
 CREATE TABLE MENU(     
     m_no NUMBER(3) PRIMARY KEY, --메뉴 번호
     m_name VARCHAR(20 CHAR) NOT NULL,
     m_price NUMBER(5) NOT NULL,
     m_f_no NUMBER(3) NOT NULL  --메뉴 파는 식당 번호
 );
 
CREATE SEQUENCE MENU_SEQ;   
    
INSERT INTO MENU 
VALUES(MENU_SEQ.NEXTVAL,'짜장면',5000,
(SELECT f_no FROM FRANCHISE WHERE f_name='홍콩반점' AND
f_location='서초'));

INSERT INTO MENU 
VALUES(MENU_SEQ.NEXTVAL,'불닭발',12000,
(SELECT f_no FROM FRANCHISE WHERE f_name='한신포차' AND
f_location='강남'));

-- 1 홍콩반점 서초 100, 2 홍콩반점 종로 80, 
-- 3 한신포차 강남 150, 4 구로포차 구로 130

INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'짬뽕',6000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'볶음밥',7000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'군만두',6000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'쟁반짜장',10000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'찹쌀탕수육',12000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'짜장면',5000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'짬뽕',6000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'짬뽕밥',7000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'고추짜장',6000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'칭따오맥주',4500,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'사이다',2000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'계란찜',5000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'닭똥집',15000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'닭발',10000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'조개탕',12000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'오뎅탕',13000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'계란말이',8000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'치즈계란말이',11000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'계란찜',4000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'홍합탕',11000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'감자전',10000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'골뱅이무침',8000,4);

--프랜차이즈 메뉴 전체의 이름, 가격 조회
--  => 정보를 가격 오름차순 => 메뉴명 가나다 역순
SELECT m_name 메뉴명 ,m_price 가격 FROM menu ORDER BY m_price, m_name DESC;

-- 전체 사장님들 이름, 생일 조회
SELECT c_name "사장 이름", c_birthday "사장 생일" FROM CEO;

-- 프랜차이즈 식당 몇 개?
SELECT COUNT(f_no) "프랜차이즈 식당 개수" FROM FRANCHISE;

-- 메뉴 전체의 평균가
SELECT ROUND(AVG(m_price),1)||'원' "전체 메뉴의 평균가" FROM MENU;

-- 제일 비싼 메뉴 이름, 가격
SELECT m_name 메뉴명 ,m_price 가격 FROM MENU WHERE m_price =
(SELECT MAX(m_price) FROM MENU);

-- 최연장자 사장님 이름, 생일
SELECT c_name "사장 이름", c_birthday "사장 생일" FROM CEO WHERE c_birthday =
(SELECT MIN(c_birthday) FROM CEO);

-- 좌석 수 제일 적은 식당 이름, 지점명, 좌석 수 
SELECT f_name "식당 이름", f_location 지점명, f_seat 좌석수 
FROM FRANCHISE WHERE f_seat =
(SELECT MIN(f_seat) FROM FRANCHISE);

-- 홍콩반점 서초점 운영하는 사람의 이름, 생일
SELECT c_name "서초점 운영자", c_birthday "운영자 생일" FROM CEO WHERE c_no=
(SELECT f_ceo FROM FRANCHISE WHERE f_name='홍콩반점' AND f_location='서초');

--'짜장'이 들어간 음식은 어디가면 먹을 수 있나?
SELECT f_location "짜장 파는 곳 "FROM FRANCHISE WHERE f_no IN 
(SELECT m_f_no FROM MENU WHERE m_name IN 
(SELECT m_name FROM MENU WHERE m_name LIKE '%짜장%'));

-- 좌석 수 제일 많은 식당을 운영하는 사람의 모든 정보
SELECT * FROM CEO WHERE c_no =
(SELECT f_no FROM FRANCHISE WHERE f_seat =
(SELECT MAX(f_seat) FROM FRANCHISE));

--최연소 사장님네 가게 메뉴 이름, 가격 조회
SELECT m_name 메뉴명, m_price 가격 FROM MENU WHERE m_f_no =
(SELECT f_no FROM FRANCHISE WHERE f_ceo =
(SELECT c_no FROM CEO WHERE c_birthday =
(SELECT MAX(c_birthday) FROM CEO))) ORDER BY(m_name);


--DROP table DRINK cascade constraint PURGE;
--DROP SEQUENCE DRINK_SEQ;