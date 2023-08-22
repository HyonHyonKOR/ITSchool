--������Ʈ���� �Խ��ǿ� ���� ���̺�� �̸� [�����ϴ�] �Խ��� ��� ���̺��� ������� �մϴ�.
--�Խ��� ���̺��� ������ [�ۼ���/�Խ��� �� ����/�ۼ� �ð�]�� ���� �κ��� �־����� ���ڰ�
--��� ���̺��� [�ۼ���/ ��� ����/ �ۼ� �ð�]�� ���� �κ��� �־�����...

--1. ���̺� ������ �ľ��ؼ� �Խ��� ���̺� �����
CREATE TABLE �Խ���(
    post_number number(5) primary key,
    user_id varchar2(15 char) not null,
    user_text varchar2(300 char) not null,
    writtentime date not null
);

CREATE SEQUENCE table_seq;

--2. ���̺� ������ �ľ��ؼ� ��� ���̺� �����
--[ ����: ���� �Ǵ� ���̺��� ������ �����Ǹ� �����ִ� ��۵� ����]
CREATE TABLE ���(
     post_number number(5) primary key,
     board_post_number number(5) not null,
     user_id varchar2(15 char) not null,
     user_comment varchar2(300 char) not null,
     writtentime date not null,
     constraint fk_board_post_number foreign key(board_post_number)
     references �Խ���(post_number) on delete cascade
);

CREATE SEQUENCE commnet_seq;
--3. �Խ��� ���̺��� �� 2���� �����ϰ�, �� �Խ��Ǹ��� ����� 2���� ���� 
--[ ����: �ۼ��ð��� ���� ���� ���� ��¥/�ð����� ����] 

insert into "�Խ���" values(table_seq.nextval,'john','hi',sysdate);
insert into "�Խ���" values(table_seq.nextval,'ken','hi',sysdate);

insert into "���" values(commnet_seq.nextval,1,'zill','wow',sysdate);
insert into "���" values(commnet_seq.nextval,2,'zill','wow',sysdate);

select * from "�Խ���";
select * from "���";

delete from "�Խ���" where post_number = 1;