--<쓸만한 내장 함수>
--1. 숫자 함수
--   -ABS(숫자) : 절대값 계산                              ex) ABS(-4.5)  
--   -ROUND(숫자,M) : 숫자 반올림, M은 반올림 기준 자릿수     ex) ROUND(5.36,1)
--   -POWER(숫자,N) : 숫자를 N제곱 값을 계산                ex) POWER(2,3)
--   -TRUNC(숫자,M) : 숫자 값을 M번째 자리까지 남기고 값을 버림 
--                                                       ex) TRUNC(123.456,2)
--                                                       ex) TRUNC(123.456,-1)
--                                                       ex) TRUNC(123.456,0)
--   -MOD(M,N) : 숫자 M을 N으로 나눈 나머지                 ex) MOD(12,10)
--   -SQRT(숫자) : 숫자의 제곱근 값을 계산(숫자는 양수)       ex) SQRT(9.0)

SELECT ABS(-4.5) FROM DUAL;
SELECT ROUND(5.36,1) FROM DUAL;
SELECT POWER(2,3) FROM DUAL;
SELECT TRUNC(123.456,1) FROM DUAL;
SELECT TRUNC(123.456,-1) FROM DUAL;
SELECT MOD(12,10) FROM DUAL;
SELECT SQRT(9.0) FROM DUAL;

--2. 문자 함수 
--   -CONCAT(S1,S2) : 두 문자열을 연결                    ex) CONCAT('ABCD','EFG')
--   -SUBSTR(S1,N,K) : 문자열의 N번째부터 K번째만큼의 길이를 반환
--                                                      ex) SUBSTR('ABCDEFG',3,4)
--   -INSTR(S1,S2,N,K) : S1의 N번째부터 시작하여 찾고자하는 
--      문자열 S2가 K번째에 나타나는 문자열의 위치를 반환     ex) INSTR('HELLO',L,1,2)
--   -LPAD(S,N,C) : 문자열 S의 왼쪽으로부터 지정한 자릿 수 N까지 
--    지정한 문자 C로 채움                                 ex) LPAD('ABC',5,'*')
--   -RPAD(S,N,C) : 문자열 S의 오른쪽으로부터 지정한 자릿 수 N까지 
--    지정한 문자 C로 채움                                 ex) RPAD('ABC',5,'*')
--   -LTRIM(S1,S2) : 문자열 S1을 기준으로 왼쪽에 있는 지정한 문자 S2 제거
--                                                       ex) LTRIM('*ABC','*')
--   -RTRIM(S1,S2) : 문자열 S1을 기준으로 오른쪽에 있는 지정한 문자 S2 제거
--                                                       ex) RTRIM('ABC*','*')
--   -REPLACE(S1,S2,S3) : S1의 지정한 문자 S2를 원하는 문자 S3로 변경
--                                                       ex) REPLACE('JACK and JUE' , 'J' , 'BL')
--   -LENGTH : 글자 수를 세어주는 함수
--   -LENGTHB : 글자의 바이트를 수를 세어주는 함수
SELECT CONCAT('ABCD','EFG') FROM DUAL;
SELECT SUBSTR('ABCDEFG',3,4) FROM DUAL;
SELECT INSTR('HELLO','L',1,2) FROM DUAL;
SELECT LPAD('ABC',5,'*') FROM DUAL;
SELECT RPAD('ABC',5,'*') FROM DUAL;
SELECT LTRIM('**ABC','*') FROM DUAL;
SELECT RTRIM('ABC**','*') FROM DUAL;
SELECT REPLACE('JACK and JUE','J', 'BL') FROM DUAL;
SELECT LENGTH('ㅋㅋㅋ') 글자수,LENGTHB('ㅋㅋㅋ')바이트수 FROM DUAL;

--3. 날짜 / 시간 함수
--[날짜 형식]
-- YYYY: 4자리 연도/YYY,YY,Y : 각각 4자리 연도의 마지막 3,2,1 자리
-- MM : 월 / DD: 1달 중 날짜(일자) / DAY: 요일(월요일~일요일)/ DY:요일(월~일)
-- HH,HH12 : 12시간단위 /HH24: 24시간 단위 / MI: 분/ SS : 초/ AM/PM : 오전/오후

--   -SYSDATE : 현재 날짜/시간을 반환
--   -TO_DATE(S1,DATETIME형식): 문자형 데이터를 날짜형으로 반환
SELECT TO_DATE ('2023-08-21 오후 03:10','YYYY-MM-DD AM HH:MI') FROM DUAL;

--   -TO_CHAR(DATE,DATETIME형식): 날짜형 데이터를 문자형으로 반환
SELECT TO_CHAR (SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR (TO_DATE ('2023-08-21 오후 03:10','YYYY-MM-DD AM HH:MI'),'YYYY-MM-DD AM HH:MI') FROM DUAL;
-- 특정 날짜 값을 받아오고 싶다면 SYSDATE 자리에 TO_DATE함수를 넣어서 만들자!
--  => 반환되는 데이터 타입이 다르다는걸 기억!!
--  TO_DATE는 날짜형 / TO_CHAR는 문자형

-- -ADD_MONTHS(DATE,숫자) : 날짜에서 지정한 달만큼 더함(1: 다음달, -1: 이전달)
SELECT ADD_MONTHS(SYSDATE,-3) FROM DUAL;

-- -LAST_DAY(DATE) : 달의 마지막 날을 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

SELECT CONCAT (TO_CHAR(SYSDATE,'YYYY'),'년') 연도 FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY')||'년' 연도 FROM DUAL;

SELECT CONCAT (TO_CHAR(SYSDATE,'MM'),'월') 월 FROM DUAL;
SELECT CONCAT (TO_CHAR(SYSDATE,'DD'),'일') 일 FROM DUAL;
SELECT CONCAT (TO_CHAR(SYSDATE,'HH'),'시') 시,CONCAT (TO_CHAR(SYSDATE,'mm'),'분') 분 FROM DUAL;
SELECT CONCAT (TO_CHAR(SYSDATE,'ss'),'초') 초 FROM DUAL;
SELECT TO_CHAR(SYSDATE,'DAY')  FROM DUAL;
SELECT TO_CHAR(SYSDATE,'AM') "오전/오후" FROM DUAL;
-- 문자열 '2023-08-23 오전 06:00' 을 문자열 2023.08.23으로 조회
SELECT TO_CHAR 
(TO_DATE ('2023-08-23 오전 06:00','YYYY-MM-DD AM HH:MI'),'YYYY-MM-DD') FROM DUAL;
-- 오늘 날짜 기준 3달전 마지막날은 몇월 며칠인지 조회
SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE,-3)),'MM-DD') FROM DUAL;

--4. 집계 / 분석 함수
--  -AVG(필드명) : 평균 
--  -COUNT(필드명) : 검색되는 데이터 수 
--  -MAX(필드명) : 최대값
--  -MIN(필드명) : 최소값
--  -SUM(필드명) : 총합
--  -RANK: 중복 순위만큼 다음 순위값을 증가 시킴(1,2,2,4)
--  -DENSE_RANK: 중복 순위가 존재해도 순차적으로 다음 순위값으로 표시함(1,2,2,3)

--5. NULL 관련 함수
--현재 제약조건에 NOT NULL로 무조건 데이터를 입력하게 해놨는데 
--NULL : 미확인 값이나 아직 적용되지 않은 값 / 0이나 공란도 아님! 
--    말그대로 아직 값이 없다!! 

--NVL함수: NULL인 경우만 지정된 값으로 대치하는 함수 
-- NVL(값,NULL일 때 대체값)
SELECT NVL(NULL,'B'),NVL('C','B') FROM DUAL;

--NVL2함수: NULL의 여부에 따라서 지정한 값으로 대치하는 함수
-- NVL2(값,값이 있을때 대체값, NULL일 때 대체값)
SELECT NVL2(NULL,'A','B'),NVL2('C','A','B') FROM DUAL;
