--*** 서브쿼리(SUBQUERY)
-- SELECT문 안에 다시 SELECT문을 사용하는 기술
-- 하나의 SQL문 안에 다른 SQL문이 중첩된 질의를 말함 
-- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공할 때 사용함
-- 나중에 배울 JOIN

--주질의 (MAIN QUERY, 외부질의)와 부속질의(SUB QUERY, 내부 질의)로 구성됨

select s_name, s_price 
    from snack 
        where s_price < (
                           select avg(s_price) 
                           from snack
                        );
                                                   
-- 평균가보다 가격이 낮은 과자의 이름과 가격 정보를 조회한 문장
-- 한가지 팁이라면 메인쿼리와 서브쿼리를 나눠서 구분
-- 메인쿼리의 WHERE절에서 서브쿼리의 결과와 비교할 때는 반드시!! 비교연산자를 사용!!

-- 최고가 얼마인지
select s_price from snack 
       where s_price =(
                         select max(s_price)
                         from snack
                      );
-- 제일 비싼 과자의 이름, 제조사 , 가격
select s_name, s_maker, s_price from snack 
       where s_price =(
                         select max(s_price)
                         from snack
                      );

-- 제일 싼 과자는 어디에서 만드는지?
select s_maker from snack 
       where s_price =(
                         select min(s_price)
                         from snack
                      );
-- 평균가보다 비싼 과자는 몇 종류?
select count(*) from snack 
       where s_price >(
                         select avg(s_price)
                         from snack
                      );

-- 유통기한이 가장 오래 남은 과자의 전체 정보
select * from snack where s_exp = (
                                  select max(s_exp)
                                    from snack
                                  );

-------------------------------------
-- 과자회사 테이블을 만들건데 => 회사 이름, 주소(도시), 직원 수 값에 대한 속성
-- 과자 테이블에 맞춰서 데이터 넣어주세요!
CREATE TABLE maker(
    m_name varchar2 (10 char) primary key,
    m_address varchar2 (10 char) not null,
    m_employee number(3) not null
);


insert into maker values ('오리온','서울',100);
insert into maker values ('해태','광주',50);
insert into maker values ('롯데','부산',30);
insert into maker values ('TOHATO','경기',5); 

-- 직원 수가 제일 적은 회사에서 만드는 과자이름, 가격 조회
SELECT s_name 과자이름, s_price 가격 FROM snack 
       WHERE s_maker = (      
                  SELECT m_name FROM maker 
                     WHERE m_employee=
                     (SELECT MIN(m_employee) FROM maker)        
                       );
                      
-- 제일 비싼 과자를 만드는 회사는 어디에?
-- ORA-01427: single-row subquery returns more than one row
-- m_name = , =의 존재때문에 단일한 값만 가져올 수 있음
-- 이 경우에는 =가 아닌 IN으로 처리한다 

SELECT m_address 주소 FROM maker 
       WHERE m_name IN (      
                 SELECT s_maker FROM snack 
                     WHERE s_price IN
                     (SELECT MAX(s_price) FROM snack)       
                       );

-- 서울에 있는 회사에서 만드는 과자의 평균가?
SELECT AVG(s_price) 평균가 FROM snack
     WHERE s_maker IN (
          SELECT m_name FROM maker 
         WHERE m_address = '서울'
       );

-- 평균가 이상의 과자를 만드는 회사 이름, 위치 조회
SELECT m_name "회사 이름", m_address "위치" FROM maker
     WHERE m_name IN (
          SELECT s_maker FROM snack 
         WHERE s_price > 
         (SELECT AVG(s_price) FROM snack)
       );