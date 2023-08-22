--웹사이트에서 게시판에 대한 테이블과 이를 [참조하는] 게시판 댓글 테이블을 만드려고 합니다.
--게시판 테이블의 구조는 [작성자/게시판 글 내용/작성 시간]에 대한 부분이 있었으면 좋겠고
--댓글 테이블에는 [작성자/ 댓글 내용/ 작성 시간]에 대한 부분이 있었으면...

--1. 테이블 구조를 파악해서 게시판 테이블 만들기
CREATE TABLE 게시판(
    post_number number(5) primary key,
    user_id varchar2(15 char) not null,
    user_text varchar2(300 char) not null,
    writtentime date not null
);

CREATE SEQUENCE table_seq;

--2. 테이블 구조를 파악해서 댓글 테이블 만들기
--[ 조건: 참조 되는 테이블의 내용이 삭제되면 관련있는 댓글도 삭제]
CREATE TABLE 댓글(
     post_number number(5) primary key,
     board_post_number number(5) not null,
     user_id varchar2(15 char) not null,
     user_comment varchar2(300 char) not null,
     writtentime date not null,
     constraint fk_board_post_number foreign key(board_post_number)
     references 게시판(post_number) on delete cascade
);

CREATE SEQUENCE commnet_seq;
--3. 게시판 테이블이 값 2개를 생성하고, 각 게시판마다 댓글을 2개씩 생성 
--[ 조건: 작성시간에 대한 값은 현재 날짜/시간으로 통일] 

insert into "게시판" values(table_seq.nextval,'john','hi',sysdate);
insert into "게시판" values(table_seq.nextval,'ken','hi',sysdate);

insert into "댓글" values(commnet_seq.nextval,1,'zill','wow',sysdate);
insert into "댓글" values(commnet_seq.nextval,2,'zill','wow',sysdate);

select * from "게시판";
select * from "댓글";

delete from "게시판" where post_number = 1;