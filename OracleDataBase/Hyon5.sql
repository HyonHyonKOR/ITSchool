--���� ������
--NOT, AND, OR, BETWEEN, IN
--���� AND�� BETWEEN
--������ 1000�� �̻� 3000�� ������ ������ ��ü������ ��ȸ
--AND�� �Ἥ �ϴ� ���
SELECT * FROM snack WHERE S_PRICE >=1000 AND S_PRICE <= 3000;
--BETWEEN�� �Ἥ �ϴ� ���
SELECT * FROM snack WHERE S_PRICE BETWEEN 1000 AND 3000;
--BETWEEN�� �̻�/���Ϸ� ������ ���ϱ� ������
--1000�� �ʰ�, 3000�� �̸������� BETWEEN ��� ����..
--OR�� �Ἥ �ϴ� ���
--������ 1000��, 2000��, 3000���� ������ ��ü������ ��ȸ
SELECT * FROM snack WHERE S_PRICE =1000 OR S_PRICE = 2000 OR S_PRICE = 3000;
--��ȿ�����̰� ������ ������� ��� ��� ���ϰ� �� �� �ִ� ����� ������...?
--���ӵ��� ���� ������ �޾ƿ��� ���� ���� IN�� ��� 
SELECT * FROM snack WHERE S_PRICE IN(1000,2000,3000);
--NOT IN�� �Ἥ �ϴ� ��� 
SELECT * FROM snack WHERE S_PRICE NOT IN(1000,2000,3000);
---------------------------------------------------------------
--���� ������
--���ڿ��� �����ϴ� �˻� : LIKE '����'�� ����
-- �� �� ���Ͽ��� '%'�� �ִµ� ���� ���� �𸥴ٴ� ��!
--  LIKE '%��' : ���� �����°� 
--  LIKE '��%' : ���� �����ϴ� �� 
--  LIKE '%��%' : ���� ����
-- �� LIKE ��� ( = '��%') �� �ȵǴ°�?
-- ��ȣ�� �Ἥ ���� ǥ���ϸ� �������� �ν��ϴ°� �ƴ� '��%' ���� �״�� �ν��ع���

-- '��'�� ���� ȸ�翡�� ���� ���� �̸� ��ȸ 
SELECT s_name FROM snack WHERE s_maker LIKE '%��%';
-- '��'�� ���� ���ڵ� ��հ�
SELECT ROUND(AVG(s_price),1) FROM snack WHERE s_name LIKE '%��%';
-- �����°��ڰų�, ������~ �� �̸�, ������, ���� ��ȸ
SELECT s_name,s_maker,s_price FROM snack WHERE  s_maker ='������' OR s_name LIKE '%��Į��%';
-- ������ �̸��� ���޴����� �����ϰų�, ��Į���� �����ϴ� ������ �̸�, ������, ���� ��ȸ
SELECT s_name,s_maker,s_price FROM snack WHERE s_name LIKE '%���޴���%' OR  s_name LIKE '%��Į��%';
--SELECT s_name,s_maker,s_price FROM snack WHERE s_name LIKE IN('%���޴���%','%��Į��%')';

-- Oracle���� LIKE~IN ������ ���� 
--REGEXP_LIKE(�÷���, ����1||����2|...)
SELECT s_name,s_maker,s_price FROM snack WHERE REGEXP_LIKE(S_NAME,'^���޴���|��$');
-- ���� �տ� ^�� ������ : ���ϰ����� �����ϴ� ���ڿ� ã��
-- ���� �ڿ� $�� ������ : ���ϰ����� ������ ���ڿ� ã��
-- ���� ���� ������ �̿��ؼ� ã�� �ʹٸ� |(������)�� �־ ������ �߰��ϸ� ��
------------------------------------------------------------------------
--���� ������ 
--������
-- UNION : �ߺ��Ǵ� �� �����ϰ� ���
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL UNION
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL UNION
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL;

-- UNION ALL : �ߺ��Ǵ��� ��� ��� 
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL UNION ALL
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL UNION ALL
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL;

-- ������
-- INTERSECT : �� ���̺��� ���� �� ����Ǵ� �� ���
SELECT 1 ID,'����' SUBJECT, 90 SCORE FROM DUAL UNION
SELECT 2 ID,'����' SUBJECT, 80 SCORE FROM DUAL INTERSECT --���������� ����, ���� �� �� ����
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL; --���������� ����� �� ���и� ���

-- ������
-- MINUS : ù��° SELECT�� �߿��� �ι�° SELECT������ ���� �� ��� 
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL MINUS
SELECT 1 ID, '����' SUBJECT , 80 SCORE FROM DUAL MINUS -- ��������� ù���� SELECT�� ���
SELECT 1 ID, '����' SUBJECT , 90 SCORE FROM DUAL; --����� ���� �����Ƿ� ��ȯ���� ����

-- ������ �켱���� (�������� �ֿ켱����)
--OR > AND > NOT > �񱳿����� > ��ȣ
-- ���� ������ �߿��� ȸ�簡 �������̰� ������ 1000�� ���ϰų� 2000�� �̻��� ������
-- �̸�, ����, ������� ��ȸ

SELECT s_name, s_price, s_exp, s_maker FROM snack WHERE s_maker = '������' AND (s_price <= 1000 OR s_price >= 2000);
-------------------------------------------------------------------------
-- GROUP BY : �׷����� ��� �����Ͽ� �ϳ��� ����� ��Ÿ���� ��
-- ȸ�纰 ���� ��հ���, �ּҰ���, �ִ밡��
SELECT S_MAKER, AVG(S_PRICE), MIN(S_PRICE), MAX(S_PRICE) FROM SNACK GROUP BY S_MAKER;

-- ROLLUP ������
GROUP BY ROLLUP[�׷� ���]
-- �÷��� ���� �Ұ�(SUBTOTAL)�� ����� �� 
-- GROUP BY ���� �÷� ������ N����� �ϸ�, ROLLUP�� ���� �� N+1�� �߰� 

-- ȸ�� �̸�, ȸ�纰 ���� �� ���� �հ�� ��� ���ڵ��� ���� �հ�
SELECT S_MAKER, SUM(S_PRICE) FROM SNACK GROUP BY ROLLUP(S_MAKER) ;

SELECT NVL2(S_MAKER, S_MAKER, '��ü') S_MAKER, SUM(S_PRICE) FROM SNACK GROUP BY ROLLUP(S_MAKER);

-- DECODE(�÷�, ����, ���ǿ� �´� �����, ���ǿ� ���� �ʴ� �����)
SELECT DECODE(S_MAKER, NULL, '��ü', S_MAKER) S_MAKER, SUM(S_PRICE) 
FROM SNACK GROUP BY ROLLUP(S_MAKER);
-------------------------------------------------------------------
-- HAVING : GROUP BY���� ���� ������ ��� �� ���ϴ� ���ǿ� �����ϴ� �ڷḸ ã���� �� �� ���
-- HAVING�� WHERE ��� ������ �̿��ؼ� ���ϴ� ���ǿ� �´� �ڷḸ �̾ƿ´ٴ� ������
-- HAVING : �׷쿡 ���� ����� ���� 
-- VS
-- WHERE : ������ ����ؼ� �� ����� ���� 

--ȸ�纰 ���� ��� ������ 2000�� �̻��� ȸ���� �̸��� ���� ��� ������ ��ȸ
SELECT s_maker, AVG(S_PRICE) FROM SNACK GROUP BY(S_MAKER) HAVING AVG(S_PRICE)>=2000; 
------------------------------------------------------------------
--ORDER BY : ����! �⺻���� �������� ASC, �������� ������ DESC 
--ORDER BY [���Ĵ�� ASC/DESC] 
--�Ե� �Ǵ� ���� ȸ���� ���� ��հ����� 1800�� �̻��� �� �� ȸ���� ��� ���� �������� ����
SELECT s_maker, AVG(S_PRICE) 
FROM SNACK WHERE S_MAKER IN('����','�Ե�')
GROUP BY (S_MAKER) 
HAVING AVG(S_PRICE)>=1800
ORDER BY AVG(S_PRICE) DESC;
