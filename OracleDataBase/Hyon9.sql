--1. 전체 식당 이름, 지점명, 사장님 이름, 사장님 생일 조회
SELECT f_name, f_location,c_name,c_birthday 
FROM franchise,ceo 
WHERE franchise.f_ceo=ceo.c_no;

--2. 전체 메뉴명, 가격, 식당이름, 지점명
SELECT m_name, m_price, f_name, f_location 
FROM franchise,menu
WHERE franchise.f_ceo= menu.m_f_no;

--3. 좌석 수가 50석 이상인 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
SELECT m_name, m_price, f_name, f_location 
FROM franchise,menu
WHERE franchise.f_ceo = menu.m_f_no 
AND franchise.f_seat>=50;

--4. 좌석 수가 가장 많은 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
SELECT m_name, m_price, f_name, f_location 
FROM franchise,menu
WHERE franchise.f_ceo = menu.m_f_no 
AND franchise.f_seat =
(SELECT MAX(franchise.f_seat) FROM franchise);

--5. 전체 메뉴명, 가격, 식당이름, 지점명, 사장님 이름, 생일
SELECT m_name,m_price, f_name, f_location, c_name, c_birthday
FROM menu,franchise,ceo
WHERE franchise.f_ceo = menu.m_f_no 
AND menu.m_f_no = ceo.c_no; 

--6. 최연장자 사장님네 가게의 전체 메뉴명, 가격, 식당이름, 지점명, 사장님이름 ,생일
SELECT m_name,m_price, f_name, f_location, c_name, c_birthday
FROM menu,franchise,ceo
WHERE franchise.f_ceo = menu.m_f_no 
AND menu.m_f_no = ceo.c_no
AND ceo.c_birthday = 
(SELECT MAX(c_birthday) FROM ceo);

--6-1. 6번을 메뉴명 가나다순, 식당이름 가나다순으로 정렬
SELECT m_name,m_price, f_name, f_location, c_name, c_birthday
FROM menu,franchise,ceo
WHERE franchise.f_ceo = menu.m_f_no 
AND menu.m_f_no = ceo.c_no
AND ceo.c_birthday = 
(SELECT MAX(c_birthday) FROM ceo)
ORDER BY m_name,f_name;

/*
데이터의 갯수를 나눠서 페이지로 나누고 싶음 (페이징 처리)
어떻게 할까?
메뉴 테이블에 M_NO가 있음(PRIMARY KEY)
SEQUENCE로 처리했음
INSERT하는데 실패해도 올라감
데이터 삭제했다면 ? => 번호값 비어있을거고...
M_NO가 정확히 1,2,3,4가 아닌 경우 어떤 방법이 있을까?
----------------------------------------------------
<ROWNUM(가상필드) 고급>
SELECT 할때마다 자동으로 부여됨
*랑은 같이 사용 못함
ORDER BY보다 먼저 부여 
무조건 1번부터 조회해야!!

*/

-- 메뉴명 가나다순으로 정렬해서 MENU 테이블의 전체 정보
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO FROM MENU ORDER BY m_name;


--메뉴명 가나다순으로 정렬해서 MENU 테이블 전체 정보
SELECT ROWNUM, M_NO,M_NAME, M_PRICE
  FROM(                         --SUB QUERY를 FROM 안에 넣는 경우
  SELECT M_NO, M_NAME, M_PRICE  --INLINE VIEW라고 함(인라인 뷰)
  FROM MENU ORDER BY m_name     --하나의 쿼리문 내에서 테이블처럼 사용
                                --쿼리문 종료후에 사라짐!
  );
 
--메뉴명 가나다순으로 정렬해서 ROWNUM 2~4까지 MENU 테이블 전체 정보

SELECT * --ROWNUM,RN,M_NO,M_NAME,M_PRICE
FROM
(
SELECT ROWNUM RN, m_no,m_name,m_price,m_f_no
 FROM(
 SELECT m_no,m_name,m_price,m_f_no 
 FROM MENU ORDER BY m_name
 ) 
 ) 
 WHERE RN BETWEEN 2 AND 4;
 
 --~길동 이름을 가진 사장님네
 -- 메뉴명, 가격, 식당명, 지점명, 사장님이름
 -- 가격 내림차순 => 메뉴명 가나다순
 -- => 3 ~ 8 번만 조회
 
 SELECT ROWNUM,RN,m_name,m_price,f_name,f_location,c_name
 FROM
 (
    SELECT ROWNUM RN,m_name,m_price,f_name,f_location,c_name
    FROM(
         SELECT m_name,m_price,f_name,f_location,c_name
         FROM menu,franchise,ceo
         WHERE m_f_no= f_ceo 
         AND f_ceo = c_no
         AND c_name IN
         (SELECT c_name FROM ceo WHERE c_name LIKE '%길동')
         ORDER BY m_price DESC, m_name
        )
 ) 
 WHERE RN BETWEEN 3 AND 8;
 
 
 -- 김씨 성을 가진 사장님네
 -- 메뉴명, 가격, 사장님이름, 성별
 -- 가격 오름차순 
 -- => 2 ~ 3 번만 조회
 
 SELECT ROWNUM ,RN, m_name,m_price,c_name,c_gender
    FROM
    ( 
    SELECT ROWNUM RN, m_name,m_price,c_name,c_gender
      FROM( 
         SELECT m_name,m_price,c_name,c_gender
         FROM menu,ceo
         WHERE m_f_no = c_no
         AND c_name LIKE '김%'
         ORDER BY m_price
          )
     )
     WHERE RN BETWEEN 2 AND 3;
     
  SELECT * FROM franchise;