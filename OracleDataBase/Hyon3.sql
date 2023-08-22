--모든 과자 이름, 가격, 유통기한 조회
SELECT s_name "과자 이름", s_price "가격" ,s_exp "유통기한" FROM snack;
--모든 과자 이름, 가격, 부가세 조회(가격의 10%)
SELECT s_name "과자 이름" ,s_price "가격" ,s_price/10 "부가세" FROM snack;
--모든 과자 이름, 가격, 판매가(20% 할인)
SELECT s_name "과자 이름" ,s_price "가격" ,s_price*0.8 "판매가(20%할인)" FROM snack;
--2000원보다 큰 금액의 평균가
SELECT AVG(s_price) FROM snack WHERE s_price>2000;
--최고가, 최저가, 총 과자 종류 몇 가지? 
SELECT MAX(s_price),MIN(s_price),COUNT(*) FROM snack;
--2000원 이상인 과자의 전체정보
SELECT * FROM SNACK WHERE s_price>=2000;
--2000원 미만인 과자의 이름, 가격, 판매가(20% 할인)
SELECT s_name "과자 이름" ,s_price "가격" ,s_price*0.8 "판매가(20%할인)" FROM snack WHERE s_price<2000;
--2000원짜리 과자 몇개?
SELECT count(*) FROM snack WHERE s_price<2000;
--허니버터칩의 가격?
SELECT s_price FROM snack WHERE s_name = '허니버터칩';
--오리온 회사의 과자 가격 총합
SELECT SUM(s_price) FROM snack WHERE s_maker = '오리온';
--이번달 안에 먹어야 하는 과자이름; 가격, 유통기한 
SELECT s_name "과자 이름", s_price "가격" ,s_exp "유통기한" FROM snack WHERE S_EXP < TO_DATE('2023-09-01 00:00:00','YYYY-MM-DD HH24:MI:SS') AND s_exp >= SYSDATE;