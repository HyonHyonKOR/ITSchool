--��� ���� �̸�, ����, ������� ��ȸ
SELECT s_name "���� �̸�", s_price "����" ,s_exp "�������" FROM snack;
--��� ���� �̸�, ����, �ΰ��� ��ȸ(������ 10%)
SELECT s_name "���� �̸�" ,s_price "����" ,s_price/10 "�ΰ���" FROM snack;
--��� ���� �̸�, ����, �ǸŰ�(20% ����)
SELECT s_name "���� �̸�" ,s_price "����" ,s_price*0.8 "�ǸŰ�(20%����)" FROM snack;
--2000������ ū �ݾ��� ��հ�
SELECT AVG(s_price) FROM snack WHERE s_price>2000;
--�ְ�, ������, �� ���� ���� �� ����? 
SELECT MAX(s_price),MIN(s_price),COUNT(*) FROM snack;
--2000�� �̻��� ������ ��ü����
SELECT * FROM SNACK WHERE s_price>=2000;
--2000�� �̸��� ������ �̸�, ����, �ǸŰ�(20% ����)
SELECT s_name "���� �̸�" ,s_price "����" ,s_price*0.8 "�ǸŰ�(20%����)" FROM snack WHERE s_price<2000;
--2000��¥�� ���� �?
SELECT count(*) FROM snack WHERE s_price<2000;
--��Ϲ���Ĩ�� ����?
SELECT s_price FROM snack WHERE s_name = '��Ϲ���Ĩ';
--������ ȸ���� ���� ���� ����
SELECT SUM(s_price) FROM snack WHERE s_maker = '������';
--�̹��� �ȿ� �Ծ�� �ϴ� �����̸�; ����, ������� 
SELECT s_name "���� �̸�", s_price "����" ,s_exp "�������" FROM snack WHERE S_EXP < TO_DATE('2023-09-01 00:00:00','YYYY-MM-DD HH24:MI:SS') AND s_exp >= SYSDATE;