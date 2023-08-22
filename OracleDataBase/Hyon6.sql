--*** ��������(SUBQUERY)
-- SELECT�� �ȿ� �ٽ� SELECT���� ����ϴ� ���
-- �ϳ��� SQL�� �ȿ� �ٸ� SQL���� ��ø�� ���Ǹ� ���� 
-- �ٸ� ���̺��� ������ �����ͷ� ���� ���̺� �ִ� ������ ã�ų� ������ �� �����
-- ���߿� ��� JOIN

--������ (MAIN QUERY, �ܺ�����)�� �μ�����(SUB QUERY, ���� ����)�� ������

select s_name, s_price 
    from snack 
        where s_price < (
                           select avg(s_price) 
                           from snack
                        );
                                                   
-- ��հ����� ������ ���� ������ �̸��� ���� ������ ��ȸ�� ����
-- �Ѱ��� ���̶�� ���������� ���������� ������ ����
-- ���������� WHERE������ ���������� ����� ���� ���� �ݵ��!! �񱳿����ڸ� ���!!

-- �ְ� ������
select s_price from snack 
       where s_price =(
                         select max(s_price)
                         from snack
                      );
-- ���� ��� ������ �̸�, ������ , ����
select s_name, s_maker, s_price from snack 
       where s_price =(
                         select max(s_price)
                         from snack
                      );

-- ���� �� ���ڴ� ��𿡼� �������?
select s_maker from snack 
       where s_price =(
                         select min(s_price)
                         from snack
                      );
-- ��հ����� ��� ���ڴ� �� ����?
select count(*) from snack 
       where s_price >(
                         select avg(s_price)
                         from snack
                      );

-- ��������� ���� ���� ���� ������ ��ü ����
select * from snack where s_exp = (
                                  select max(s_exp)
                                    from snack
                                  );

-------------------------------------
-- ����ȸ�� ���̺��� ����ǵ� => ȸ�� �̸�, �ּ�(����), ���� �� ���� ���� �Ӽ�
-- ���� ���̺� ���缭 ������ �־��ּ���!
CREATE TABLE maker(
    m_name varchar2 (10 char) primary key,
    m_address varchar2 (10 char) not null,
    m_employee number(3) not null
);


insert into maker values ('������','����',100);
insert into maker values ('����','����',50);
insert into maker values ('�Ե�','�λ�',30);
insert into maker values ('TOHATO','���',5); 

-- ���� ���� ���� ���� ȸ�翡�� ����� �����̸�, ���� ��ȸ
SELECT s_name �����̸�, s_price ���� FROM snack 
       WHERE s_maker = (      
                  SELECT m_name FROM maker 
                     WHERE m_employee=
                     (SELECT MIN(m_employee) FROM maker)        
                       );
                      
-- ���� ��� ���ڸ� ����� ȸ��� ���?
-- ORA-01427: single-row subquery returns more than one row
-- m_name = , =�� ���綧���� ������ ���� ������ �� ����
-- �� ��쿡�� =�� �ƴ� IN���� ó���Ѵ� 

SELECT m_address �ּ� FROM maker 
       WHERE m_name IN (      
                 SELECT s_maker FROM snack 
                     WHERE s_price IN
                     (SELECT MAX(s_price) FROM snack)       
                       );

-- ���￡ �ִ� ȸ�翡�� ����� ������ ��հ�?
SELECT AVG(s_price) ��հ� FROM snack
     WHERE s_maker IN (
          SELECT m_name FROM maker 
         WHERE m_address = '����'
       );

-- ��հ� �̻��� ���ڸ� ����� ȸ�� �̸�, ��ġ ��ȸ
SELECT m_name "ȸ�� �̸�", m_address "��ġ" FROM maker
     WHERE m_name IN (
          SELECT s_maker FROM snack 
         WHERE s_price > 
         (SELECT AVG(s_price) FROM snack)
       );