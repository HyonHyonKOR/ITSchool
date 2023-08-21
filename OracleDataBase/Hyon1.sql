create table snack(
s_no number(4) primary key,
s_name varchar2 (10 char) not null, 
s_maker varchar2 (10 char) not null, 
s_price number(4) not null
);

INSERT INTO snack(s_name,s_price,s_no,s_maker) VALUES('���޴���',500,1,'�Ե�');
INSERT INTO snack VALUES (2,'���ڱ�','���',1000); 
INSERT INTO snack(s_no, s_maker,s_name,s_price) VALUES(3,'���ѱ�','�ѼŻѼ�',800);
INSERT INTO snack VALUES(4,'������','���',1000);

DROP TABLE snack CASCADE CONSTRAINTS PURGE;

CREATE SEQUENCE snack_seq;

INSERT INTO snack VALUES(snack_seq.NEXTVAL,'���޴���','�Ե�',500);
INSERT INTO snack VALUES (snack_seq.NEXTVAL,'���ڱ�','���',1000); 
INSERT INTO snack VALUES (snack_seq.NEXTVAL,'���ѱ�','�ѼŻѼ�',800); 
INSERT INTO snack VALUES(snack_seq.NEXTVAL,'������','���',1000);

SELECT * from snack;
DROP TABLE snack CASCADE CONSTRAINTS PURGE;
DROP SEQUENCE snack_seq;

create table snack(
s_no number(4) primary key,
s_name varchar2 (10 char) not null, 
s_maker varchar2 (10 char) not null, 
s_price number(4) not null,
s_exp date not null
);

CREATE SEQUENCE snack_seq;

SELECT SYSDATE FROM DUAL;

--Ư�� �ð�/ ��¥
-- �����Լ� - to_date('��','����')
-- ����(�빮��) - YYYY(���� 4�ڸ�), MM(��),DD(��),AM/PM(����/����),
--                    HH,HH24(��õ),MI(��),SS(��)

 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'���޴���','�Ե�',500,TO_DATE('2023-08-22 12','YYYY-MM-DD HH24'));
  INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'������','����',3000,TO_DATE('2023-08-25 15','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��Ϲ���Ĩ','����',3000,TO_DATE('2023-08-20 07','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'���ں�','TOHATO',1200,TO_DATE('2023-08-21 09','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'���ҶҰ���Ĩ','������',2000,TO_DATE('2023-08-22 09','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��������','������',1500,TO_DATE('2023-08-11 11','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'�����佺','�Ե�',1600,TO_DATE('2023-08-24 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��Į�� ����������','�Ե�',1000,TO_DATE('2023-08-21 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��Į�� ����������','�Ե�',1000,TO_DATE('2023-08-23 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��Į�� �����Ѹ�','�Ե�',1000,TO_DATE('2023-08-25 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��Į�� ���޴����Ѹ�','�Ե�',1000,TO_DATE('2023-08-15 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��Į�� ����Ѹ�','�Ե�',1000,TO_DATE('2023-08-20 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'Ȩ����','����',1100,TO_DATE('2023-08-25 08','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'����','����',1000,TO_DATE('2023-08-22 11','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'������','����',2800,TO_DATE('2023-08-19 09','YYYY-MM-DD HH24'));
  INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'���ڼ���','������',1000,TO_DATE('2023-08-25 15','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��������','������',3000,TO_DATE('2023-08-22 10','YYYY-MM-DD HH24'));
  INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��īĨ ��������','������',1200,TO_DATE('2023-08-24 16','YYYY-MM-DD HH24'));
 INSERT INTO snack VALUES
 (snack_seq.NEXTVAL,'��īĨ ��Ͼ��','������',1200,TO_DATE('2023-08-23 08','YYYY-MM-DD HH24'));
 
 --���� �����͵��� ��ȸ�غ��ô�!
 --R(Read) ********
 /*select [distinct] [�÷���],[�÷��� as ��Ī || �÷��� ��Ī], [������ ���],[����Լ�],
 from [���̺��]
 where [���ǽ�]
 group by [�׷���]
 having [�Լ� ���� ����]
 order by [���Ĵ�� ASC/DESC (�������� / ��������)] --�⺻���� ��������
 --�� ���� 
 */
 
 --�������̺� ��ü ��ȸ
 --'*' : ���̺� ���� ��� �÷��� �����´�
 SELECT * FROM snack;
 
 SELECT s_maker FROM snack;
 --distinct : �ߺ� ����
 SELECT DISTINCT s_maker FROM snack;
 
 --��Ī ���� ��쿡�� select�� �ȿ��� ���� ����� �����ѵ� (+,-,*,/)
 SELECT s_price / 100 FROM snack;
 --�÷��� ��ü�� s_price/100���� ����
 --���� ���α׷��� ���� �����ϴٺ��� �÷����� �̿��ؼ� ���� �ҷ����� ��찡 �ִµ�,
 --��Ī�� �Ἥ �򰥸��� �����ϴ� �뵵�� ��� 
 SELECT s_price / 100 as s_price,s_price / 100 s_price2 from snack;
 
 --������ ���(���������)
 --Dual ���̺��� ����
 --1. ����Ŭ ��ü���� �����ϴ� �������̺�
 --2. �����ϰ� �Լ��� �̿��ؼ� ��� ������� Ȯ���� �� ����ϴ� ���̺�
 SELECT 1+'3' FROM DUAL; 
 --� ������� ���ñ�??? => 4�� ����
 --��κ� �ٸ� ���� ���� ��쿡�� ���� �켱���� 13�̶�� ����� �����µ�
 --����Ŭ ������ �ݴ�� ���ڰ� �켱�õ�!!
 --����Ŭ�������� �����ڰ� ���ڸ� �������� 
 
 SELECT 1+'a' FROM DUAL; --����! invalid number
 
 --���ڸ� �����ֱ� ���� �����ڰ� ���� �ִµ�
 -- '||' (shift + \)
 SELECT '3' || 10 from dual;
 
 -- WHERE��(���ǽ�)
-- ��ü ������ �� ������ ���ǿ� �´� �����͸� ã���ִ� ����
-- ���ǽĿ� ����� ������ => �� ������ 
-- =,!=,^=,<>,>,<,>=,<=
-- 2,3,4��°�� '���� �ʴ�' �� ���̴� �������ε� �� 3���� �ɱ�...?
-- ^= ����Ŭ�� ����ȭ ������ �׳� �� ���� 

SELECT * FROM snack WHERE S_PRICE = 3000;
--��� ������ �̸�, ���� ��ȸ
--��� ���� �̸�(����)���� ��ȸ 
--2000�� ������ ���� �� �ּҰ��� 
--��� ������ ��հ�
--���� �̸��� ������ 30% ���� �ݾ� 
-- 3500���� ������ ���� 
-- 4000�� ������ ���� �̸�, ȸ�� �̸� 

SELECT s_name �̸� FROM snack;
SELECT s_price || '��' ���� FROM snack;
SELECT s_name||'(' || s_price|| '��)' "�̸�(����)" FROM snack;
SELECT MIN(s_price) FROM snack WHERE s_price <=2000;
SELECT ROUND(AVG(s_price),1) ||'��' ��հ��� FROM snack;
SELECT s_name "���� �̸�", s_price*0.7 || '��' "30% ���� �ݾ�" FROM Snack;
SELECT COUNT(*) FROM snack WHERE s_price <=3500;
SELECT s_name "���� �̸�" , s_maker "ȸ�� �̸�" FROM Snack WHERE s_price <=4000;