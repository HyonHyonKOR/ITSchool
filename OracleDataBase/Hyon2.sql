--<������ ���� �Լ�>
--1. ���� �Լ�
--   -ABS(����) : ���밪 ���                              ex) ABS(-4.5)  
--   -ROUND(����,M) : ���� �ݿø�, M�� �ݿø� ���� �ڸ���     ex) ROUND(5.36,1)
--   -POWER(����,N) : ���ڸ� N���� ���� ���                ex) POWER(2,3)
--   -TRUNC(����,M) : ���� ���� M��° �ڸ����� ����� ���� ���� 
--                                                       ex) TRUNC(123.456,2)
--                                                       ex) TRUNC(123.456,-1)
--                                                       ex) TRUNC(123.456,0)
--   -MOD(M,N) : ���� M�� N���� ���� ������                 ex) MOD(12,10)
--   -SQRT(����) : ������ ������ ���� ���(���ڴ� ���)       ex) SQRT(9.0)

SELECT ABS(-4.5) FROM DUAL;
SELECT ROUND(5.36,1) FROM DUAL;
SELECT POWER(2,3) FROM DUAL;
SELECT TRUNC(123.456,1) FROM DUAL;
SELECT TRUNC(123.456,-1) FROM DUAL;
SELECT MOD(12,10) FROM DUAL;
SELECT SQRT(9.0) FROM DUAL;

--2. ���� �Լ� 
--   -CONCAT(S1,S2) : �� ���ڿ��� ����                    ex) CONCAT('ABCD','EFG')
--   -SUBSTR(S1,N,K) : ���ڿ��� N��°���� K��°��ŭ�� ���̸� ��ȯ
--                                                      ex) SUBSTR('ABCDEFG',3,4)
--   -INSTR(S1,S2,N,K) : S1�� N��°���� �����Ͽ� ã�����ϴ� 
--      ���ڿ� S2�� K��°�� ��Ÿ���� ���ڿ��� ��ġ�� ��ȯ     ex) INSTR('HELLO',L,1,2)
--   -LPAD(S,N,C) : ���ڿ� S�� �������κ��� ������ �ڸ� �� N���� 
--    ������ ���� C�� ä��                                 ex) LPAD('ABC',5,'*')
--   -RPAD(S,N,C) : ���ڿ� S�� ���������κ��� ������ �ڸ� �� N���� 
--    ������ ���� C�� ä��                                 ex) RPAD('ABC',5,'*')
--   -LTRIM(S1,S2) : ���ڿ� S1�� �������� ���ʿ� �ִ� ������ ���� S2 ����
--                                                       ex) LTRIM('*ABC','*')
--   -RTRIM(S1,S2) : ���ڿ� S1�� �������� �����ʿ� �ִ� ������ ���� S2 ����
--                                                       ex) RTRIM('ABC*','*')
--   -REPLACE(S1,S2,S3) : S1�� ������ ���� S2�� ���ϴ� ���� S3�� ����
--                                                       ex) REPLACE('JACK and JUE' , 'J' , 'BL')
--   -LENGTH : ���� ���� �����ִ� �Լ�
--   -LENGTHB : ������ ����Ʈ�� ���� �����ִ� �Լ�
SELECT CONCAT('ABCD','EFG') FROM DUAL;
SELECT SUBSTR('ABCDEFG',3,4) FROM DUAL;
SELECT INSTR('HELLO','L',1,2) FROM DUAL;
SELECT LPAD('ABC',5,'*') FROM DUAL;
SELECT RPAD('ABC',5,'*') FROM DUAL;
SELECT LTRIM('**ABC','*') FROM DUAL;
SELECT RTRIM('ABC**','*') FROM DUAL;
SELECT REPLACE('JACK and JUE','J', 'BL') FROM DUAL;
SELECT LENGTH('������') ���ڼ�,LENGTHB('������')����Ʈ�� FROM DUAL;

--3. ��¥ / �ð� �Լ�
--[��¥ ����]
-- YYYY: 4�ڸ� ����/YYY,YY,Y : ���� 4�ڸ� ������ ������ 3,2,1 �ڸ�
-- MM : �� / DD: 1�� �� ��¥(����) / DAY: ����(������~�Ͽ���)/ DY:����(��~��)
-- HH,HH12 : 12�ð����� /HH24: 24�ð� ���� / MI: ��/ SS : ��/ AM/PM : ����/����

--   -SYSDATE : ���� ��¥/�ð��� ��ȯ
--   -TO_DATE(S1,DATETIME����): ������ �����͸� ��¥������ ��ȯ
SELECT TO_DATE ('2023-08-21 ���� 03:10','YYYY-MM-DD AM HH:MI') FROM DUAL;

--   -TO_CHAR(DATE,DATETIME����): ��¥�� �����͸� ���������� ��ȯ
SELECT TO_CHAR (SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR (TO_DATE ('2023-08-21 ���� 03:10','YYYY-MM-DD AM HH:MI'),'YYYY-MM-DD AM HH:MI') FROM DUAL;
-- Ư�� ��¥ ���� �޾ƿ��� �ʹٸ� SYSDATE �ڸ��� TO_DATE�Լ��� �־ ������!
--  => ��ȯ�Ǵ� ������ Ÿ���� �ٸ��ٴ°� ���!!
--  TO_DATE�� ��¥�� / TO_CHAR�� ������

-- -ADD_MONTHS(DATE,����) : ��¥���� ������ �޸�ŭ ����(1: ������, -1: ������)
SELECT ADD_MONTHS(SYSDATE,-3) FROM DUAL;

-- -LAST_DAY(DATE) : ���� ������ ���� ��ȯ
SELECT LAST_DAY(SYSDATE) FROM DUAL;

SELECT CONCAT (TO_CHAR(SYSDATE,'YYYY'),'��') ���� FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY')||'��' ���� FROM DUAL;

SELECT CONCAT (TO_CHAR(SYSDATE,'MM'),'��') �� FROM DUAL;
SELECT CONCAT (TO_CHAR(SYSDATE,'DD'),'��') �� FROM DUAL;
SELECT CONCAT (TO_CHAR(SYSDATE,'HH'),'��') ��,CONCAT (TO_CHAR(SYSDATE,'mm'),'��') �� FROM DUAL;
SELECT CONCAT (TO_CHAR(SYSDATE,'ss'),'��') �� FROM DUAL;
SELECT TO_CHAR(SYSDATE,'DAY')  FROM DUAL;
SELECT TO_CHAR(SYSDATE,'AM') "����/����" FROM DUAL;
-- ���ڿ� '2023-08-23 ���� 06:00' �� ���ڿ� 2023.08.23���� ��ȸ
SELECT TO_CHAR 
(TO_DATE ('2023-08-23 ���� 06:00','YYYY-MM-DD AM HH:MI'),'YYYY-MM-DD') FROM DUAL;
-- ���� ��¥ ���� 3���� ���������� ��� ��ĥ���� ��ȸ
SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE,-3)),'MM-DD') FROM DUAL;

--4. ���� / �м� �Լ�
--  -AVG(�ʵ��) : ��� 
--  -COUNT(�ʵ��) : �˻��Ǵ� ������ �� 
--  -MAX(�ʵ��) : �ִ밪
--  -MIN(�ʵ��) : �ּҰ�
--  -SUM(�ʵ��) : ����
--  -RANK: �ߺ� ������ŭ ���� �������� ���� ��Ŵ(1,2,2,4)
--  -DENSE_RANK: �ߺ� ������ �����ص� ���������� ���� ���������� ǥ����(1,2,2,3)

--5. NULL ���� �Լ�
--���� �������ǿ� NOT NULL�� ������ �����͸� �Է��ϰ� �س��µ� 
--NULL : ��Ȯ�� ���̳� ���� ������� ���� �� / 0�̳� ������ �ƴ�! 
--    ���״�� ���� ���� ����!! 

--NVL�Լ�: NULL�� ��츸 ������ ������ ��ġ�ϴ� �Լ� 
-- NVL(��,NULL�� �� ��ü��)
SELECT NVL(NULL,'B'),NVL('C','B') FROM DUAL;

--NVL2�Լ�: NULL�� ���ο� ���� ������ ������ ��ġ�ϴ� �Լ�
-- NVL2(��,���� ������ ��ü��, NULL�� �� ��ü��)
SELECT NVL2(NULL,'A','B'),NVL2('C','A','B') FROM DUAL;
