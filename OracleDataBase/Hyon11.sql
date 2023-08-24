--CREATE TABLE TEMPER_DATA -- 복사(저장)본 데이터
--(
--    STD_DE VARCHAR2(11 CHAR) PRIMARY KEY, -- 날짜를 달음 컬럼
--    AREA_CD VARCHAR2(5 CHAR), -- 지역 코드를 담을 컬럼
--    AVG_TEMPER NUMBER(5, 2), -- 평균 기온을 담을 컬럼
--    MIN_TEMPER NUMBER(5, 2), -- 최저 기온을 담을 컬럼
--    MAX_TEMPER NUMBER(5, 2) -- 최고 기온을 담을 컬럼
--);
--
INSERT INTO TEMPER_DATA -- INSERT INTO에 서브쿼리 넣어버리기.
    SELECT
        REPLACE(STD_DE, '-', '') STD_DE, -- 내부 데이터 값을 대체하는 함수.
        AREA_CD,
        AVG_TEMPER,
        MIN_TEMPER,
        MAX_TEMPER
    FROM TEMPER_DATA;
    
    select * from temper_data;

--서울시의 역사상 최저온도, 최고온도와 해당일자 조회
select min(min_temper) 최저온도, max(max_temper) 최고온도
from temper_data;

--서울시의 역사상 최저온도의 해당일자 최고온도의 해당일자를 조회

select b.std_de, b.min_temper, b.max_temper
  from (
    select min(a.min_temper) min_temper, max(a.max_temper) max_temper
    from temper_data A) A, temper_data B
    where b.min_temper = a.min_temper
    or b.max_temper = a.max_temper;

--select a.std_de,b.min_temper,b.max_temper
--from temper_data A  
--join temper_data B
--on a.min_temper = b.min_temper
--and a.max_temper = b.max_temper
--and a.std_de = b.std_de


