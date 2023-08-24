CREATE TABLE TB1(NAME VARCHAR2(20), AGE NUMBER(3));
CREATE TABLE TB2(NAME VARCHAR2(20), AGE NUMBER(3));
  
--INSERT INTO TB1 VALUES('김비버',30);
--INSERT INTO TB1 VALUES('박비버',35);
--INSERT INTO TB1 VALUES('최비버',40);
--INSERT INTO TB1 VALUES('오비버',40);
--
--INSERT INTO TB2 VALUES('김비버',30);
--INSERT INTO TB2 VALUES('이비버',50);
--INSERT INTO TB2 VALUES('정비버',55);

--CROSS JOIN : 별도의 조건 없이 두 테이블 간의 가능한 모든 결과를 조회(모든 경우의 수)
--사실상 안쓰는 조인
SELECT * FROM TB1, TB2;
SELECT * FROM TB1 CROSS JOIN TB2;

--INNER JOIN: 조건에 해당하는 값만 나옴
SELECT * FROM TB1 INNER JOIN TB2 ON tb1.name = tb2.name;
SELECT * FROM TB1 A, TB2 B WHERE a.name = b.name; --EQUI 조인(동등조인) 
SELECT * FROM TB1 JOIN TB2 USING (NAME); --JOIN~USING(조인대상컬럼명)
SELECT * FROM TB1 NATURAL JOIN TB2; --자연조인,조건절 없이 양쪽에 같은 가진 컬럼만 조회

--OUTER JOIN: 기준 테이블의 데이터가 모두 조회(누락 없이) 되고
--대상 테이블에 데이터가 있을 경우 해당 컬럼의 값을 가져오기 위해서 사용
-- (+)를 이용한 OUTER JOIN: NULL이 출력되는 테이블의 컬럼에 (+) 기호 추가

-- LEFT OUTER JOIN: 왼쪽 테이블에 값이 있을때 오른쪽 테이블이 조건에 맞지 않아도 나옴
--      (조건에 맞지 않으면 NULL로 메꿈)
SELECT * FROM TB1 LEFT OUTER JOIN TB2 ON tb1.name = tb2.name;
SELECT * FROM TB1, TB2 WHERE tb1.name = tb2.name(+);

-- RIGHT OUTER JOIN: 오른U 테이블에 값이 있을때 왼쪽 테이블이 조건에 맞지 않아도 나옴
--      (조건에 맞지 않으면 NULL로 메꿈)
SELECT * FROM TB1 RIGHT OUTER JOIN TB2 ON tb1.name=tb2.name;
SELECT * FROM TB1, TB2 WHERE tb1.name(+) = tb2.name;

-- FULL OUTER JOIN : 한쪽 테이블에 값이 있을 때 다른쪽 테이블이 조건에 맞지 않아도 나옴
SELECT * FROM TB1 FULL OUTER JOIN TB2 ON tb1.name=tb2.name;

--SELF JOIN ** 헷갈림
--하나의 테이블 내에 있는 컬럼끼리 연결하는 조인이 필요한 경우

--한 웹사이트에 회원이 5명이 있고 관리자가 2명이 있음
--회원의 이름은 각각 회원1~5 / 관리자의 이름 관리자 1,2
--회원의 아이디는 각각 MEMBER1~5 / 관리자의 아이디는 각각 MANAGER1,2
--회원 1~3번은 관리가 1인 관리 / 나머지회원은 관리자 2가 관리

CREATE TABLE web(
   me_id varchar2(8 char) primary key,
   me_name varchar2(15 char) not null,
   ma_id char(8 char) 
);

INSERT INTO web values('member1','회원1','manager1');
INSERT INTO web values('member2','회원2','manager1');
INSERT INTO web values('member3','회원3','manager1');
INSERT INTO web values('member4','회원4','manager2');
INSERT INTO web values('member5','회원5','manager2');
INSERT INTO web values('manager1','관리자1',null);
INSERT INTO web values('manager2','관리자2',null);

--이 테이블 내에서 각 관리자가 어떤 회원을 관리하는지 알고 싶음
select * 
from web A inner join web B 
on a.me_id=b.me_id;

select A.me_id,B.me_name,B.me_id
from web A inner join web B 
on a.me_id = b.ma_id;


