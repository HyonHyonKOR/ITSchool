--CREATE TABLE TEMPER_DATA -- ����(����)�� ������
--(
--    STD_DE VARCHAR2(11 CHAR) PRIMARY KEY, -- ��¥�� ���� �÷�
--    AREA_CD VARCHAR2(5 CHAR), -- ���� �ڵ带 ���� �÷�
--    AVG_TEMPER NUMBER(5, 2), -- ��� ����� ���� �÷�
--    MIN_TEMPER NUMBER(5, 2), -- ���� ����� ���� �÷�
--    MAX_TEMPER NUMBER(5, 2) -- �ְ� ����� ���� �÷�
--);
--
INSERT INTO TEMPER_DATA -- INSERT INTO�� �������� �־������.
    SELECT
        REPLACE(STD_DE, '-', '') STD_DE, -- ���� ������ ���� ��ü�ϴ� �Լ�.
        AREA_CD,
        AVG_TEMPER,
        MIN_TEMPER,
        MAX_TEMPER
    FROM TEMPER_DATA;
    
    select * from temper_data;

--������� ����� �����µ�, �ְ�µ��� �ش����� ��ȸ
select min(min_temper) �����µ�, max(max_temper) �ְ�µ�
from temper_data;

--������� ����� �����µ��� �ش����� �ְ�µ��� �ش����ڸ� ��ȸ

select b.std_de, b.min_temper, b.max_temper
  from (
    select min(a.min_temper) min_temper, max(a.max_temper) max_temper
    from temper_data A) A, temper_data B
    where b.min_temper = a.min_temper
    or b.max_temper = a.max_temper;

--select a.std_de,b.min_temper,b.max_temper
--from temper_data A  
--join temper_data B
--on a.min_temper = b.min_temper
--and a.max_temper = b.max_temper
--and a.std_de = b.std_de


