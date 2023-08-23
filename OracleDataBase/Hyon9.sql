--1. ��ü �Ĵ� �̸�, ������, ����� �̸�, ����� ���� ��ȸ
SELECT f_name, f_location,c_name,c_birthday 
FROM franchise,ceo 
WHERE franchise.f_ceo=ceo.c_no;

--2. ��ü �޴���, ����, �Ĵ��̸�, ������
SELECT m_name, m_price, f_name, f_location 
FROM franchise,menu
WHERE franchise.f_ceo= menu.m_f_no;

--3. �¼� ���� 50�� �̻��� �Ĵ��� �޴���, ����, �Ĵ��̸�, ������, �¼� ��
SELECT m_name, m_price, f_name, f_location 
FROM franchise,menu
WHERE franchise.f_ceo = menu.m_f_no 
AND franchise.f_seat>=50;

--4. �¼� ���� ���� ���� �Ĵ��� �޴���, ����, �Ĵ��̸�, ������, �¼� ��
SELECT m_name, m_price, f_name, f_location 
FROM franchise,menu
WHERE franchise.f_ceo = menu.m_f_no 
AND franchise.f_seat =
(SELECT MAX(franchise.f_seat) FROM franchise);

--5. ��ü �޴���, ����, �Ĵ��̸�, ������, ����� �̸�, ����
SELECT m_name,m_price, f_name, f_location, c_name, c_birthday
FROM menu,franchise,ceo
WHERE franchise.f_ceo = menu.m_f_no 
AND menu.m_f_no = ceo.c_no; 

--6. �ֿ����� ����Գ� ������ ��ü �޴���, ����, �Ĵ��̸�, ������, ������̸� ,����
SELECT m_name,m_price, f_name, f_location, c_name, c_birthday
FROM menu,franchise,ceo
WHERE franchise.f_ceo = menu.m_f_no 
AND menu.m_f_no = ceo.c_no
AND ceo.c_birthday = 
(SELECT MAX(c_birthday) FROM ceo);

--6-1. 6���� �޴��� �����ټ�, �Ĵ��̸� �����ټ����� ����
SELECT m_name,m_price, f_name, f_location, c_name, c_birthday
FROM menu,franchise,ceo
WHERE franchise.f_ceo = menu.m_f_no 
AND menu.m_f_no = ceo.c_no
AND ceo.c_birthday = 
(SELECT MAX(c_birthday) FROM ceo)
ORDER BY m_name,f_name;

/*
�������� ������ ������ �������� ������ ���� (����¡ ó��)
��� �ұ�?
�޴� ���̺� M_NO�� ����(PRIMARY KEY)
SEQUENCE�� ó������
INSERT�ϴµ� �����ص� �ö�
������ �����ߴٸ� ? => ��ȣ�� ��������Ű�...
M_NO�� ��Ȯ�� 1,2,3,4�� �ƴ� ��� � ����� ������?
----------------------------------------------------
<ROWNUM(�����ʵ�) ���>
SELECT �Ҷ����� �ڵ����� �ο���
*���� ���� ��� ����
ORDER BY���� ���� �ο� 
������ 1������ ��ȸ�ؾ�!!

*/

-- �޴��� �����ټ����� �����ؼ� MENU ���̺��� ��ü ����
SELECT ROWNUM, M_NO, M_NAME, M_PRICE, M_F_NO FROM MENU ORDER BY m_name;


--�޴��� �����ټ����� �����ؼ� MENU ���̺� ��ü ����
SELECT ROWNUM, M_NO,M_NAME, M_PRICE
  FROM(                         --SUB QUERY�� FROM �ȿ� �ִ� ���
  SELECT M_NO, M_NAME, M_PRICE  --INLINE VIEW��� ��(�ζ��� ��)
  FROM MENU ORDER BY m_name     --�ϳ��� ������ ������ ���̺�ó�� ���
                                --������ �����Ŀ� �����!
  );
 
--�޴��� �����ټ����� �����ؼ� ROWNUM 2~4���� MENU ���̺� ��ü ����

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
 
 --~�浿 �̸��� ���� ����Գ�
 -- �޴���, ����, �Ĵ��, ������, ������̸�
 -- ���� �������� => �޴��� �����ټ�
 -- => 3 ~ 8 ���� ��ȸ
 
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
         (SELECT c_name FROM ceo WHERE c_name LIKE '%�浿')
         ORDER BY m_price DESC, m_name
        )
 ) 
 WHERE RN BETWEEN 3 AND 8;
 
 
 -- �达 ���� ���� ����Գ�
 -- �޴���, ����, ������̸�, ����
 -- ���� �������� 
 -- => 2 ~ 3 ���� ��ȸ
 
 SELECT ROWNUM ,RN, m_name,m_price,c_name,c_gender
    FROM
    ( 
    SELECT ROWNUM RN, m_name,m_price,c_name,c_gender
      FROM( 
         SELECT m_name,m_price,c_name,c_gender
         FROM menu,ceo
         WHERE m_f_no = c_no
         AND c_name LIKE '��%'
         ORDER BY m_price
          )
     )
     WHERE RN BETWEEN 2 AND 3;
     
  SELECT * FROM franchise;