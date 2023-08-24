CREATE TABLE TB1(NAME VARCHAR2(20), AGE NUMBER(3));
CREATE TABLE TB2(NAME VARCHAR2(20), AGE NUMBER(3));
  
--INSERT INTO TB1 VALUES('����',30);
--INSERT INTO TB1 VALUES('�ں��',35);
--INSERT INTO TB1 VALUES('�ֺ��',40);
--INSERT INTO TB1 VALUES('�����',40);
--
--INSERT INTO TB2 VALUES('����',30);
--INSERT INTO TB2 VALUES('�̺��',50);
--INSERT INTO TB2 VALUES('�����',55);

--CROSS JOIN : ������ ���� ���� �� ���̺� ���� ������ ��� ����� ��ȸ(��� ����� ��)
--��ǻ� �Ⱦ��� ����
SELECT * FROM TB1, TB2;
SELECT * FROM TB1 CROSS JOIN TB2;

--INNER JOIN: ���ǿ� �ش��ϴ� ���� ����
SELECT * FROM TB1 INNER JOIN TB2 ON tb1.name = tb2.name;
SELECT * FROM TB1 A, TB2 B WHERE a.name = b.name; --EQUI ����(��������) 
SELECT * FROM TB1 JOIN TB2 USING (NAME); --JOIN~USING(���δ���÷���)
SELECT * FROM TB1 NATURAL JOIN TB2; --�ڿ�����,������ ���� ���ʿ� ���� ���� �÷��� ��ȸ

--OUTER JOIN: ���� ���̺��� �����Ͱ� ��� ��ȸ(���� ����) �ǰ�
--��� ���̺� �����Ͱ� ���� ��� �ش� �÷��� ���� �������� ���ؼ� ���
-- (+)�� �̿��� OUTER JOIN: NULL�� ��µǴ� ���̺��� �÷��� (+) ��ȣ �߰�

-- LEFT OUTER JOIN: ���� ���̺� ���� ������ ������ ���̺��� ���ǿ� ���� �ʾƵ� ����
--      (���ǿ� ���� ������ NULL�� �޲�)
SELECT * FROM TB1 LEFT OUTER JOIN TB2 ON tb1.name = tb2.name;
SELECT * FROM TB1, TB2 WHERE tb1.name = tb2.name(+);

-- RIGHT OUTER JOIN: �����U ���̺� ���� ������ ���� ���̺��� ���ǿ� ���� �ʾƵ� ����
--      (���ǿ� ���� ������ NULL�� �޲�)
SELECT * FROM TB1 RIGHT OUTER JOIN TB2 ON tb1.name=tb2.name;
SELECT * FROM TB1, TB2 WHERE tb1.name(+) = tb2.name;

-- FULL OUTER JOIN : ���� ���̺� ���� ���� �� �ٸ��� ���̺��� ���ǿ� ���� �ʾƵ� ����
SELECT * FROM TB1 FULL OUTER JOIN TB2 ON tb1.name=tb2.name;

--SELF JOIN ** �򰥸�
--�ϳ��� ���̺� ���� �ִ� �÷����� �����ϴ� ������ �ʿ��� ���

--�� ������Ʈ�� ȸ���� 5���� �ְ� �����ڰ� 2���� ����
--ȸ���� �̸��� ���� ȸ��1~5 / �������� �̸� ������ 1,2
--ȸ���� ���̵�� ���� MEMBER1~5 / �������� ���̵�� ���� MANAGER1,2
--ȸ�� 1~3���� ������ 1�� ���� / ������ȸ���� ������ 2�� ����

CREATE TABLE web(
   me_id varchar2(8 char) primary key,
   me_name varchar2(15 char) not null,
   ma_id char(8 char) 
);

INSERT INTO web values('member1','ȸ��1','manager1');
INSERT INTO web values('member2','ȸ��2','manager1');
INSERT INTO web values('member3','ȸ��3','manager1');
INSERT INTO web values('member4','ȸ��4','manager2');
INSERT INTO web values('member5','ȸ��5','manager2');
INSERT INTO web values('manager1','������1',null);
INSERT INTO web values('manager2','������2',null);

--�� ���̺� ������ �� �����ڰ� � ȸ���� �����ϴ��� �˰� ����
select * 
from web A join web B 
on a.me_id=b.me_id;

select A.me_id,A.me_name,b.ma_id
from web A join web B 
on a.me_id = b.ma_id;


--select me_id,me_name,ma_id
--from web
--where ma_id in (select m_id from web);