create table snack(
s_no number(4) primary key,
s_name varchar2 (10 char) not null, 
s_maker varchar2 (10 char) not null, 
s_price number(4) not null
);

INSERT INTO snack(s_name,s_price,s_no,s_maker) VALUES('새콤달콤',500,1,'롯데');
INSERT INTO snack VALUES (2,'감자깡','농심',1000); 
INSERT INTO snack(s_no, s_maker,s_name,s_price) VALUES(3,'오뚜기','뿌셔뿌셔',800);
INSERT INTO snack VALUES(4,'고구마깡','농심',1000);

DROP TABLE snack CASCADE CONSTRAINTS PURGE;

CREATE SEQUENCE snack_seq;

INSERT INTO snack VALUES(snack_seq.NEXTVAL,'새콤달콤','롯데',500);
INSERT INTO snack VALUES (snack_seq.NEXTVAL,'감자깡','농심',1000); 
INSERT INTO snack VALUES (snack_seq.NEXTVAL,'오뚜기','뿌셔뿌셔',800); 
INSERT INTO snack VALUES(snack_seq.NEXTVAL,'고구마깡','농심',1000);

SELECT * from snack;
DROP TABLE snack CASCADE CONSTRAINTS PURGE;
DROP SEQUENCE snack_seq;

create table snack(
s_no number(4) primary key,
s_name varchar2 (10 char) not null, 
s_maker varchar2 (10 char) not null, 
s_price number(4) not null,
s_exp date not null
);

CREATE SEQUENCE snack_seq;

SELECT SYSDATE FROM DUAL;

--특정 시간/ 날짜
-- 내장함수 - to_date('값','패턴')
-- 패턴(대문자) - YYYY(연도 4자리), MM(월),DD(일),AM/PM(오전/오후),
--                    HH,HH24(추천),MI(분),SS(초)

 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'새콤달콤','롯데',500,TO_DATE('2023-08-22 12','YYYY-MM-DD HH24'));
  INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'오예스','해태',3000,TO_DATE('2023-08-25 15','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'허니버터칩','해태',3000,TO_DATE('2023-08-20 07','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'초코비','TOHATO',1200,TO_DATE('2023-08-21 09','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'무뚝뚝감자칩','오리온',2000,TO_DATE('2023-08-22 09','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'눈을감자','오리온',1500,TO_DATE('2023-08-11 11','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'도리토스','롯데',1600,TO_DATE('2023-08-24 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'꼬칼콘 찰옥수수맛','롯데',1000,TO_DATE('2023-08-21 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'꼬칼콘 군옥수수맛','롯데',1000,TO_DATE('2023-08-23 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'꼬칼콘 달콤한맛','롯데',1000,TO_DATE('2023-08-25 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'꼬칼콘 매콤달콤한맛','롯데',1000,TO_DATE('2023-08-15 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'꼬칼콘 고소한맛','롯데',1000,TO_DATE('2023-08-20 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'홈런볼','해태',1100,TO_DATE('2023-08-25 08','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'고래밥','해태',1000,TO_DATE('2023-08-22 11','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'빅파이','해태',2800,TO_DATE('2023-08-19 09','YYYY-MM-DD HH24'));
  INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'초코송이','오리온',1000,TO_DATE('2023-08-25 15','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'초코파이','오리온',3000,TO_DATE('2023-08-22 10','YYYY-MM-DD HH24'));
  INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'포카칩 오리지날','오리온',1200,TO_DATE('2023-08-24 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'포카칩 어니언맛','오리온',1200,TO_DATE('2023-08-23 08','YYYY-MM-DD HH24'));
 
 --이제 데이터들을 조회해봅시다!
 --R(Read) ********
 /*select [distinct] [컬럼명],[컬럼명 as 별칭 || 컬럼명 별칭], [연산자 사용],[통계함수],
 from [테이블명]
 where [조건식]
 group by [그룹대상]
 having [함수 포함 조건]
 order by [정렬대상 ASC/DESC (오름차순 / 내림차순)] --기본값은 오름차순
 --의 형태 
 */
 
 --과자테이블 전체 조회
 --'*' : 테이블 내의 모든 컬럼을 가져온다
 SELECT * FROM snack;
 
 SELECT s_maker FROM snack;
 --distinct : 중복 제거
 SELECT DISTINCT s_maker FROM snack;
 
 --별칭 같은 경우에는 select문 안에서 숫자 계산이 가능한데 (+,-,*,/)
 SELECT s_price / 100 FROM snack;
 --컬럼명 자체가 s_price/100으로 나옴
 --실제 프로그래밍 언어와 연동하다보면 컬럼명을 이용해서 값을 불러오는 경우가 있는데,
 --별칭을 써서 헷갈림을 방지하는 용도로 사용 
 SELECT s_price / 100 as s_price,s_price / 100 s_price2 from snack;
 
 --연산자 사용(산술연산자)
 --Dual 테이블의 정의
 --1. 오라클 자체에서 제공하는 더미테이블
 --2. 간단하게 함수를 이용해서 계산 결과값을 확인할 때 사용하는 테이블
 SELECT 1+'3' FROM DUAL; 
 --어떤 결과값이 나올까??? => 4가 나옴
 --대부분 다른 언어들 같은 경우에는 문자 우선으로 13이라는 결과가 나오는데
 --오라클 에서는 반대로 숫자가 우선시됨!!
 --오라클내에서는 연산자가 숫자만 연산해줌 
 
 SELECT 1+'a' FROM DUAL; --에러! invalid number
 
 --문자를 더해주기 위한 연산자가 따로 있는데
 -- '||' (shift + \)
 SELECT '3' || 10 from dual;
 
 -- WHERE절(조건식)
-- 전체 데이터 중 지정한 조건에 맞는 데이터를 찾아주는 문장
-- 조건식에 사용할 연산자 => 비교 연산자 
-- =,!=,^=,<>,>,<,>=,<=
-- 2,3,4번째는 '같지 않다' 로 쓰이는 연산자인데 왜 3개나 될까...?
-- ^= 오라클의 차별화 연산자 그냥 다 같음 

SELECT * FROM snack WHERE S_PRICE = 3000;
--모든 과자의 이름, 가격 조회
--모든 과자 이름(가격)으로 조회 
--2000원 이하의 과자 중 최소가격 
--모든 과자의 평균가
--과자 이름과 가격의 30% 할인 금액 
-- 3500원인 과자의 갯수 
-- 4000원 이하인 과자 이름, 회사 이름 

SELECT s_name 이름 FROM snack;
SELECT s_price || '원' 가격 FROM snack;
SELECT s_name||'(' || s_price|| '원)' "이름(가격)" FROM snack;
SELECT MIN(s_price) FROM snack WHERE s_price <=2000;
SELECT ROUND(AVG(s_price),1) ||'원' 평균가격 FROM snack;
SELECT s_name "과자 이름", s_price*0.7 || '원' "30% 할인 금액" FROM Snack;
SELECT COUNT(*) FROM snack WHERE s_price <=3500;
SELECT s_name "과자 이름" , s_maker "회사 이름" FROM Snack WHERE s_price <=4000;