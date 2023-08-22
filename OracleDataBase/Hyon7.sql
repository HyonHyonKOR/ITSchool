--1. �������̺�� ī�����̺� �����
-- �������̺� : �����̸�/����/�Ǹ��ϴ� ī���� �̸�
-- ī�������� : ī���̸� / ���� /�¼� �� 
-- �� ���̺��� �����̸��� ī���̸��� ������ ���� ���´�
-- �� ���̺��� ���踦 ���

CREATE TABLE cafe(
    c_name varchar2(15 char) primary key,
    c_address varchar2(5 char) not null,
    c_space number(3) not null
);

CREATE TABLE drink(
    d_name varchar2(15 char) primary key,
    d_price number(5) not null,
    d_c_name varchar2(15 char) not null,
    constraint fk_d_c_name foreign key (d_c_name)
    references cafe(c_name)
    on delete cascade
);

--2. ���ǿ� �´� ���̺��� ����� ���� �־��ּ���
--Aī��� ���￡ ��ġ�ϰ� �¼��� 100���̸�, (�Ƹ޸�ī��,2000��) (��,3000��)
--(����,2500��)�� �Ǹ��մϴ�
INSERT INTO cafe VALUES ('Aī��','����',100);
INSERT INTO drink VALUES ('�Ƹ޸�ī��',2000,'Aī��');
INSERT INTO drink VALUES ('��',3000,'Aī��');
INSERT INTO drink VALUES ('����',2500,'Aī��');

--Bī��� ��õ�� ��ġ�ϰ� �¼��� 80���̸� (ȫ��,2500��),(������,3000��)
--(����������,4000���� �Ǹ��մϴ�.

INSERT INTO cafe VALUES ('Bī��','��õ',80);
INSERT INTO drink VALUES ('ȫ��',2500,'Bī��');
INSERT INTO drink VALUES ('������',3000,'Bī��');
INSERT INTO drink VALUES ('����������',4000,'Bī��');


--3. ��û�ϴ� �������� �ۼ����ּ���
--��հ����� ��� ����� �� ����?
SELECT COUNT(*) FROM DRINK WHERE D_PRICE>
(SELECT AVG(D_PRICE) FROM DRINK);

--���� �� ���Ḧ �Ĵ� ī���� �̸�?
SELECT c_name FROM CAFE WHERE c_name=
(SELECT d_c_name FROM DRINK WHERE d_price=   
(SELECT MIN(D_PRICE) FROM DRINK)
);

--���￡ �ִ� ī�信�� ����� ���� ��հ�?
SELECT AVG(D_PRICE) FROM DRINK WHERE d_c_name=
(SELECT c_name FROM CAFE WHERE c_address ='����');

--�¼��� 90�� �̻��� ī�信�� �Ĵ� ������ �̸�?
SELECT d_name FROM DRINK WHERE d_c_name IN
(SELECT c_name FROM CAFE WHERE c_space >= 90);

--��հ� ������ ������ �̸�?
SELECT d_name FROM DRINK WHERE d_price <=
 (SELECT AVG(d_price) FROM DRINK);

--���� ��� ���Ḧ �Ĵ� ī��� ��� �ִ���?
SELECT c_address FROM CAFE WHERE c_name = 
(SELECT d_c_name FROM DRINK WHERE d_price =
  (SELECT MAX(d_price) FROM DRINK)
);