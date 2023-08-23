-----------------------------------------------------------------------------------------
-- ��ľ� ����������
-- ȫ����� �������� ȫ�浿�� ��ϰ� 100��
-- ȫ����� �������� ��浿�� ��ϰ� 80��
-- �ѽ����� �������� ȫ�浿�� ��ϰ� 150��
-- �������� �������� �ֱ浿�� ��ϰ� 130��
-----------------------------------------------------------------------------------------
-- ȫ�浿, 1990-03-01�ϻ�, ����
-- ��浿, 1992-02-01�ϻ�, ����
-- ȫ�浿, 1991-12-12�ϻ�, ����
-- �ֱ浿, 1989-07-14�ϻ�, ����
-----------------------------------------------------------------------------------------

CREATE TABLE FRANCHISE(
    f_no   NUMBER(4) PRIMARY KEY,
    f_name VARCHAR2(15 CHAR) NOT NULL,
    f_location VARCHAR2(10 CHAR) NOT NULL,
    f_ceo NUMBER(3) NOT NULL,   --����� ��ȣ, �̸������� �ϰԵǸ� 'ȫ�浿' ��ħ
    f_seat NUMBER(3) NOT NULL
);

CREATE SEQUENCE FRANCHISE_SEQ;

INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'ȫ�����','����',1,100);
INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'ȫ�����','����',2,80);
INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'�ѽ�����','����',3,150);
INSERT INTO FRANCHISE VALUES(FRANCHISE_SEQ.NEXTVAL,'��������','����',4,130);

SELECT * FROM FRANCHISE;

CREATE TABLE CEO(
    c_no NUMBER(3) PRIMARY KEY,
    c_name VARCHAR2(15 CHAR) NOT NULL,
    c_birthday DATE NOT NULL,
    c_gender CHAR(2 CHAR) NOT NULL
    CONSTRAINT OwnerInfo_c_gender CHECK(c_gender IN('����','����'))
);

CREATE SEQUENCE CEO_SEQ;


INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'ȫ�浿',
TO_DATE('1990-03-01','YYYY-MM-DD'),'����');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'��浿',
TO_DATE('1992-02-01','YYYY-MM-DD'),'����');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'ȫ�浿',
TO_DATE('1991-12-12','YYYY-MM-DD'),'����');
INSERT INTO CEO VALUES(CEO_SEQ.NEXTVAL,'�ֱ浿',
TO_DATE('1989-07-14','YYYY-MM-DD'),'����');

SELECT * FROM CEO;

SELECT * FROM CEO WHERE c_no = 
  (SELECT f_ceo FROM FRANCHISE WHERE f_seat=
  (SELECT MAX(f_seat) FROM FRANCHISE)
  );
      
 --¥���,5000��,ȫ����� ������(100��)
 --�Ҵ߹�,12000��,�ѽ����� ������(150��)
   
 CREATE TABLE MENU(     
     m_no NUMBER(3) PRIMARY KEY, --�޴� ��ȣ
     m_name VARCHAR(20 CHAR) NOT NULL,
     m_price NUMBER(5) NOT NULL,
     m_f_no NUMBER(3) NOT NULL  --�޴� �Ĵ� �Ĵ� ��ȣ
 );
 
CREATE SEQUENCE MENU_SEQ;   
    
INSERT INTO MENU 
VALUES(MENU_SEQ.NEXTVAL,'¥���',5000,
(SELECT f_no FROM FRANCHISE WHERE f_name='ȫ�����' AND
f_location='����'));

INSERT INTO MENU 
VALUES(MENU_SEQ.NEXTVAL,'�Ҵ߹�',12000,
(SELECT f_no FROM FRANCHISE WHERE f_name='�ѽ�����' AND
f_location='����'));

-- 1 ȫ����� ���� 100, 2 ȫ����� ���� 80, 
-- 3 �ѽ����� ���� 150, 4 �������� ���� 130

INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'«��',6000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'������',7000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'������',6000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'���¥��',10000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'����������',12000,1);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'¥���',5000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'«��',6000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'«�͹�',7000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'����¥��',6000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'Ī��������',4500,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'���̴�',2000,2);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'�����',5000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'�߶���',15000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'�߹�',10000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'������',12000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'������',13000,3);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'�������',8000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'ġ��������',11000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'�����',4000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'ȫ����',11000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'������',10000,4);
INSERT INTO MENU VALUES(MENU_SEQ.NEXTVAL,'����̹�ħ',8000,4);

--���������� �޴� ��ü�� �̸�, ���� ��ȸ
--  => ������ ���� �������� => �޴��� ������ ����
SELECT m_name �޴��� ,m_price ���� FROM menu ORDER BY m_price, m_name DESC;

-- ��ü ����Ե� �̸�, ���� ��ȸ
SELECT c_name "���� �̸�", c_birthday "���� ����" FROM CEO;

-- ���������� �Ĵ� �� ��?
SELECT COUNT(f_no) "���������� �Ĵ� ����" FROM FRANCHISE;

-- �޴� ��ü�� ��հ�
SELECT ROUND(AVG(m_price),1)||'��' "��ü �޴��� ��հ�" FROM MENU;

-- ���� ��� �޴� �̸�, ����
SELECT m_name �޴��� ,m_price ���� FROM MENU WHERE m_price =
(SELECT MAX(m_price) FROM MENU);

-- �ֿ����� ����� �̸�, ����
SELECT c_name "���� �̸�", c_birthday "���� ����" FROM CEO WHERE c_birthday =
(SELECT MIN(c_birthday) FROM CEO);

-- �¼� �� ���� ���� �Ĵ� �̸�, ������, �¼� �� 
SELECT f_name "�Ĵ� �̸�", f_location ������, f_seat �¼��� 
FROM FRANCHISE WHERE f_seat =
(SELECT MIN(f_seat) FROM FRANCHISE);

-- ȫ����� ������ ��ϴ� ����� �̸�, ����
SELECT c_name "������ ���", c_birthday "��� ����" FROM CEO WHERE c_no=
(SELECT f_ceo FROM FRANCHISE WHERE f_name='ȫ�����' AND f_location='����');

--'¥��'�� �� ������ ��𰡸� ���� �� �ֳ�?
SELECT f_location "¥�� �Ĵ� �� "FROM FRANCHISE WHERE f_no IN 
(SELECT m_f_no FROM MENU WHERE m_name IN 
(SELECT m_name FROM MENU WHERE m_name LIKE '%¥��%'));

-- �¼� �� ���� ���� �Ĵ��� ��ϴ� ����� ��� ����
SELECT * FROM CEO WHERE c_no =
(SELECT f_no FROM FRANCHISE WHERE f_seat =
(SELECT MAX(f_seat) FROM FRANCHISE));

--�ֿ��� ����Գ� ���� �޴� �̸�, ���� ��ȸ
SELECT m_name �޴���, m_price ���� FROM MENU WHERE m_f_no =
(SELECT f_no FROM FRANCHISE WHERE f_ceo =
(SELECT c_no FROM CEO WHERE c_birthday =
(SELECT MAX(c_birthday) FROM CEO))) ORDER BY(m_name);


--DROP table DRINK cascade constraint PURGE;
--DROP SEQUENCE DRINK_SEQ;