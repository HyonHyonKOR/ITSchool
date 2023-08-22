--관계 연산자
--NOT, AND, OR, BETWEEN, IN
--먼저 AND와 BETWEEN
--가격이 1000원 이상 3000원 이하인 과자의 전체내용을 조회
--AND를 써서 하는 방법
SELECT * FROM snack WHERE S_PRICE >=1000 AND S_PRICE <= 3000;
--BETWEEN를 써서 하는 방법
SELECT * FROM snack WHERE S_PRICE BETWEEN 1000 AND 3000;
--BETWEEN은 이상/이하로 조건을 정하기 때문에
--1000원 초과, 3000원 미만에서는 BETWEEN 사용 못함..
--OR를 써서 하는 방법
--가격이 1000원, 2000원, 3000원인 과자의 전체내용을 조회
SELECT * FROM snack WHERE S_PRICE =1000 OR S_PRICE = 2000 OR S_PRICE = 3000;
--비효율적이고 복잡한 방법에서 벗어나 어떻게 편하게 쓸 수 있는 방법이 없을까...?
--연속되지 않은 값들을 받아오고 싶을 때는 IN을 사용 
SELECT * FROM snack WHERE S_PRICE IN(1000,2000,3000);
--NOT IN을 써서 하는 방법 
SELECT * FROM snack WHERE S_PRICE NOT IN(1000,2000,3000);
---------------------------------------------------------------
--패턴 연산자
--문자열을 포함하는 검색 : LIKE '패턴'의 형태
-- 이 때 패턴에는 '%'를 넣는데 뭐가 들어갈지 모른다는 뜻!
--  LIKE '%ㅋ' : ㅋ로 끝나는거 
--  LIKE 'ㅋ%' : ㅋ로 시작하는 거 
--  LIKE '%ㅋ%' : ㅋ가 포함
-- 왜 LIKE 대신 ( = 'ㅋ%') 는 안되는가?
-- 등호를 써서 식을 표현하면 패턴으로 인식하는게 아닌 'ㅋ%' 문자 그대로 인식해버림

-- '해'가 들어가는 회사에서 만든 과자 이름 조회 
SELECT s_name FROM snack WHERE s_maker LIKE '%해%';
-- '이'가 들어가는 과자들 평균가
SELECT ROUND(AVG(s_price),1) FROM snack WHERE s_name LIKE '%이%';
-- 오리온과자거나, 꼬깔콘~ 인 이름, 제조사, 가격 조회
SELECT s_name,s_maker,s_price FROM snack WHERE  s_maker ='오리온' OR s_name LIKE '%꼬칼콘%';
-- 과자의 이름이 새콤달콤을 포함하거나, 꼬칼콘을 포함하는 과자의 이름, 제조사, 가격 조회
SELECT s_name,s_maker,s_price FROM snack WHERE s_name LIKE '%새콤달콤%' OR  s_name LIKE '%꼬칼콘%';
--SELECT s_name,s_maker,s_price FROM snack WHERE s_name LIKE IN('%새콤달콤%','%꼬칼콘%')';

-- Oracle에서 LIKE~IN 구조는 없음 
--REGEXP_LIKE(컬럼명, 패턴1||패턴2|...)
SELECT s_name,s_maker,s_price FROM snack WHERE REGEXP_LIKE(S_NAME,'^새콤달콤|이$');
-- 패턴 앞에 ^를 넣으면 : 패턴값으로 시작하는 문자열 찾기
-- 패턴 뒤에 $를 넣으면 : 패턴값으로 끝나는 문자열 찾기
-- 여러 개의 패턴을 이용해서 찾고 싶다면 |(파이프)를 넣어서 패턴을 추가하면 됨
------------------------------------------------------------------------
--집합 연산자 
--합집합
-- UNION : 중복되는 값 제외하고 출력
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL UNION
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL UNION
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL;

-- UNION ALL : 중복되더라도 모두 출력 
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL UNION ALL
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL UNION ALL
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL;

-- 교집합
-- INTERSECT : 두 테이블의 집합 중 공통되는 값 출력
SELECT 1 ID,'수학' SUBJECT, 90 SCORE FROM DUAL UNION
SELECT 2 ID,'영어' SUBJECT, 80 SCORE FROM DUAL INTERSECT --합집합으로 수학, 영어 둘 다 들어가고
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL; --교집합으로 공통된 값 수학만 출력

-- 차집합
-- MINUS : 첫번째 SELECT문 중에서 두번째 SELECT문에는 없는 값 출력 
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL MINUS
SELECT 1 ID, '수학' SUBJECT , 80 SCORE FROM DUAL MINUS -- 여기까지는 첫번쨰 SELECT문 출력
SELECT 1 ID, '수학' SUBJECT , 90 SCORE FROM DUAL; --여기는 값이 같으므로 반환되지 않음

-- 연산자 우선순위 (오른쪽이 최우선순위)
--OR > AND > NOT > 비교연산자 > 괄호
-- 과자 데이터 중에서 회사가 오리온이고 가격이 1000원 이하거나 2000원 이상인 과자의
-- 이름, 가격, 유통기한 조회

SELECT s_name, s_price, s_exp, s_maker FROM snack WHERE s_maker = '오리온' AND (s_price <= 1000 OR s_price >= 2000);
-------------------------------------------------------------------------
-- GROUP BY : 그룹으로 묶어서 연산하여 하나의 결과를 나타내는 것
-- 회사별 과자 평균가격, 최소가격, 최대가격
SELECT S_MAKER, AVG(S_PRICE), MIN(S_PRICE), MAX(S_PRICE) FROM SNACK GROUP BY S_MAKER;

-- ROLLUP 연산자
GROUP BY ROLLUP[그룹 대상]
-- 컬럼에 대한 소계(SUBTOTAL)을 만들어 줌 
-- GROUP BY 절의 컬럼 갯수가 N개라고 하면, ROLLUP을 썼을 때 N+1개 추가 

-- 회사 이름, 회사별 과자 총 가격 합계와 모든 과자들의 가격 합계
SELECT S_MAKER, SUM(S_PRICE) FROM SNACK GROUP BY ROLLUP(S_MAKER) ;

SELECT NVL2(S_MAKER, S_MAKER, '전체') S_MAKER, SUM(S_PRICE) FROM SNACK GROUP BY ROLLUP(S_MAKER);

-- DECODE(컬럼, 조건, 조건에 맞는 결과값, 조건에 맞지 않는 결과값)
SELECT DECODE(S_MAKER, NULL, '전체', S_MAKER) S_MAKER, SUM(S_PRICE) 
FROM SNACK GROUP BY ROLLUP(S_MAKER);
-------------------------------------------------------------------
-- HAVING : GROUP BY절에 의해 생성된 결과 중 원하는 조건에 부합하는 자료만 찾고자 할 때 사용
-- HAVING과 WHERE 모두 조건을 이용해서 원하는 조건에 맞는 자료만 뽑아온다는 공통점
-- HAVING : 그룹에 대한 결과를 제한 
-- VS
-- WHERE : 조건을 사용해서 그 결과를 제한 

--회사별 과자 평균 가격이 2000원 이상인 회사의 이름과 과자 평균 가격을 조회
SELECT s_maker, AVG(S_PRICE) FROM SNACK GROUP BY(S_MAKER) HAVING AVG(S_PRICE)>=2000; 
------------------------------------------------------------------
--ORDER BY : 정렬! 기본값은 오름차순 ASC, 내림차순 정렬은 DESC 
--ORDER BY [정렬대상 ASC/DESC] 
--롯데 또는 해태 회사의 과자 평균가격이 1800원 이상일 때 각 회사의 평균 가격 내림차순 정렬
SELECT s_maker, AVG(S_PRICE) 
FROM SNACK WHERE S_MAKER IN('해태','롯데')
GROUP BY (S_MAKER) 
HAVING AVG(S_PRICE)>=1800
ORDER BY AVG(S_PRICE) DESC;
