CREATE TABLE STUDENT(
  S_NO NUMBER(3) PRIMARY KEY,
  S_NAME VARCHAR2(10 CHAR) NOT NULL,
  S_HEIGHT NUMBER(4,1) NOT NULL,
  S_CLASS CHAR(4 CHAR) NOT NULL
);

CREATE SEQUENCE STUDENT_SEQ;

INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'ASDF', 172.1, '1강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'GQAS', 156.2, '3강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'BADG', 182.1, '2강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'AWSS', 164.6, '3강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'HBRV', 164.7, '1강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'FESV', 127.8, '2강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'AFTD', 167.5, '1강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'DSAS', 189.4, '1강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'SSWD', 184.3, '3강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'GHTV', 175.2, '1강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'DWGB', 148.7, '2강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'VRYJ', 158.4, '1강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'DGHR', 196.7, '3강의장');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'BDHJ', 155.2, '3강의장');


-- WINDOW함수
-- 행과 행 사이에 관계를 쉽게 정의하기 위해 만든 함수
-- 복잡한 프로그램을 하나의 문장으로 쉽게 해결할 수 있다.
-- 대표적으로 이전에 배운 집계함수 및 순위함수가 있다.

--구조 
--SELECT 컬럼명, 컬럼명, 집계 함수, ...,
--    OVER ( [PARTITION] BY 컬럼명] [ORDER BY 컬럼명] [WINDOWING절])
--    FROM 테이블명 ; 
    
-- OVER() : ORDER BY, GROUP BY 구문을 대체할 수 있는 함수
-- PARTITION BY : 컬럼을 기준으로 그룹(파티션)을 나눈다
-- ORDER BY: OVER함수 내에서 정렬
-- WINDOWING 절: 행 기준의 범위를 정함
--   옵션... 
--   ROWS: 범위를 지정(행을 기준으로)
--   RANGE: 범위를 지정(행이 가지고 있는 값을 기준으로)
--   BETWEEN~AND : 시작과 끝 위치를 설정
--   UNBOUNDED PRECEDING : 시작위치가 첫번째 행
--   UNBOUNDED FOLLOWING : 마지막위치가 마지막 행 

-- RANK : 중복 순위만큼 다음 순위값을 증가 시킴
SELECT S_NAME, S_CLASS, S_HEIGHT,
    RANK() OVER(ORDER BY S_HEIGHT DESC) HEIGHT_RANK,
    RANK() OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC) IN_CLASS_RANK
 FROM STUDENT;
 
 -- DENSE_RANK : 중복 순위가 존재해도 순차적으로 다음 순위값을 나타냄
 SELECT S_NAME, S_CLASS, S_HEIGHT,
    RANK() OVER(ORDER BY S_HEIGHT DESC) RANK,
    RANK() OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC) DENSE_RANK
 FROM STUDENT;
 
 --FIRST VALUE : 그룹(파티션)에서 가장 처음에 나오는 값
 SELECT S_CLASS,S_NAME,S_HEIGHT,
   -- 강의장별로 그룹 지었고, 그 안에서 학생들의 키 내림차순 정렬
   FIRST_VALUE(S_NAME) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC
   -- 그 그룹내의 처음부터 끝까지 행에는 처음 나오는 나오는 학생의 이름값을 불러오겠다
   ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
   FROM STUDENT;
   
    --LAST_VALUE : 그룹(파티션)에서 가장 마지막에 나오는 값
 SELECT S_CLASS,S_NAME,S_HEIGHT,
   -- 강의장별로 그룹 지었고, 그 안에서 학생들의 키 내림차순 정렬
   LAST_VALUE(S_NAME) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC
   -- 그 그룹내의 처음부터 끝까지 행에는 마지막에  나오는 학생의 이름값을 불러오겠다
   ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
   FROM STUDENT;
   
   --LAG : 이전 행의 값을 가져옴
   SELECT S_CLASS, S_NAME, S_HEIGHT,
   --이전행의 S_HEIGHT값을 가져올건데 강의장별로 그룹을 지었고, 키 오름차순으로 정렬
   --만약 이전 행에 대한 값이 없어서 NULL 값이면 '-'으로 바꾸고
     DECODE(LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT),NULL,'-',
     --이전 행의 값이 있으면 그 값을 불러오겠다.
     LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LAG_HEIGHT
   FROM STUDENT;  
   
   ----LEAD : 다음 행의 값을 가져옴
   SELECT S_CLASS, S_NAME, S_HEIGHT,
   --이전행의 S_HEIGHT값을 가져올건데 강의장별로 그룹을 지었고, 키 오름차순으로 정렬
   --만약 이전 행에 대한 값이 없어서 NULL 값이면 '-'으로 바꾸고
     DECODE(LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT),NULL,'-',
     --이전 행의 값이 있으면 그 값을 불러오겠다.
     LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LEAD_HEIGHT
   FROM STUDENT;  
   
   --NTILE: 결과를 사용자가 지정한 그룹 수로 나눠서 출력
   -- 키 내림차순 기준으로 5개로 그룹으로 나누기
   SELECT S_CLASS,S_NAME,S_HEIGHT,
        NTILE(5) OVER(ORDER BY S_HEIGHT DESC)N_TILE
   FROM STUDENT;     