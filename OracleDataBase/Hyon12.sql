CREATE TABLE STUDENT(
  S_NO NUMBER(3) PRIMARY KEY,
  S_NAME VARCHAR2(10 CHAR) NOT NULL,
  S_HEIGHT NUMBER(4,1) NOT NULL,
  S_CLASS CHAR(4 CHAR) NOT NULL
);

CREATE SEQUENCE STUDENT_SEQ;

INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'ASDF', 172.1, '1������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'GQAS', 156.2, '3������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'BADG', 182.1, '2������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'AWSS', 164.6, '3������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'HBRV', 164.7, '1������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'FESV', 127.8, '2������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'AFTD', 167.5, '1������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'DSAS', 189.4, '1������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'SSWD', 184.3, '3������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'GHTV', 175.2, '1������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'DWGB', 148.7, '2������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'VRYJ', 158.4, '1������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'DGHR', 196.7, '3������');
INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, 'BDHJ', 155.2, '3������');


-- WINDOW�Լ�
-- ��� �� ���̿� ���踦 ���� �����ϱ� ���� ���� �Լ�
-- ������ ���α׷��� �ϳ��� �������� ���� �ذ��� �� �ִ�.
-- ��ǥ������ ������ ��� �����Լ� �� �����Լ��� �ִ�.

--���� 
--SELECT �÷���, �÷���, ���� �Լ�, ...,
--    OVER ( [PARTITION] BY �÷���] [ORDER BY �÷���] [WINDOWING��])
--    FROM ���̺�� ; 
    
-- OVER() : ORDER BY, GROUP BY ������ ��ü�� �� �ִ� �Լ�
-- PARTITION BY : �÷��� �������� �׷�(��Ƽ��)�� ������
-- ORDER BY: OVER�Լ� ������ ����
-- WINDOWING ��: �� ������ ������ ����
--   �ɼ�... 
--   ROWS: ������ ����(���� ��������)
--   RANGE: ������ ����(���� ������ �ִ� ���� ��������)
--   BETWEEN~AND : ���۰� �� ��ġ�� ����
--   UNBOUNDED PRECEDING : ������ġ�� ù��° ��
--   UNBOUNDED FOLLOWING : ��������ġ�� ������ �� 

-- RANK : �ߺ� ������ŭ ���� �������� ���� ��Ŵ
SELECT S_NAME, S_CLASS, S_HEIGHT,
    RANK() OVER(ORDER BY S_HEIGHT DESC) HEIGHT_RANK,
    RANK() OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC) IN_CLASS_RANK
 FROM STUDENT;
 
 -- DENSE_RANK : �ߺ� ������ �����ص� ���������� ���� �������� ��Ÿ��
 SELECT S_NAME, S_CLASS, S_HEIGHT,
    RANK() OVER(ORDER BY S_HEIGHT DESC) RANK,
    RANK() OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC) DENSE_RANK
 FROM STUDENT;
 
 --FIRST VALUE : �׷�(��Ƽ��)���� ���� ó���� ������ ��
 SELECT S_CLASS,S_NAME,S_HEIGHT,
   -- �����庰�� �׷� ������, �� �ȿ��� �л����� Ű �������� ����
   FIRST_VALUE(S_NAME) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC
   -- �� �׷쳻�� ó������ ������ �࿡�� ó�� ������ ������ �л��� �̸����� �ҷ����ڴ�
   ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
   FROM STUDENT;
   
    --LAST_VALUE : �׷�(��Ƽ��)���� ���� �������� ������ ��
 SELECT S_CLASS,S_NAME,S_HEIGHT,
   -- �����庰�� �׷� ������, �� �ȿ��� �л����� Ű �������� ����
   LAST_VALUE(S_NAME) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT DESC
   -- �� �׷쳻�� ó������ ������ �࿡�� ��������  ������ �л��� �̸����� �ҷ����ڴ�
   ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
   FROM STUDENT;
   
   --LAG : ���� ���� ���� ������
   SELECT S_CLASS, S_NAME, S_HEIGHT,
   --�������� S_HEIGHT���� �����ðǵ� �����庰�� �׷��� ������, Ű ������������ ����
   --���� ���� �࿡ ���� ���� ��� NULL ���̸� '-'���� �ٲٰ�
     DECODE(LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT),NULL,'-',
     --���� ���� ���� ������ �� ���� �ҷ����ڴ�.
     LAG(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LAG_HEIGHT
   FROM STUDENT;  
   
   ----LEAD : ���� ���� ���� ������
   SELECT S_CLASS, S_NAME, S_HEIGHT,
   --�������� S_HEIGHT���� �����ðǵ� �����庰�� �׷��� ������, Ű ������������ ����
   --���� ���� �࿡ ���� ���� ��� NULL ���̸� '-'���� �ٲٰ�
     DECODE(LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT),NULL,'-',
     --���� ���� ���� ������ �� ���� �ҷ����ڴ�.
     LEAD(S_HEIGHT) OVER(PARTITION BY S_CLASS ORDER BY S_HEIGHT)) LEAD_HEIGHT
   FROM STUDENT;  
   
   --NTILE: ����� ����ڰ� ������ �׷� ���� ������ ���
   -- Ű �������� �������� 5���� �׷����� ������
   SELECT S_CLASS,S_NAME,S_HEIGHT,
        NTILE(5) OVER(ORDER BY S_HEIGHT DESC)N_TILE
   FROM STUDENT;     