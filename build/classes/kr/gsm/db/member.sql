-- 회원 테이블
create table member(
   num int not null primary key auto_increment,
   id varchar(30) not null,
   pass varchar(30) not null,
   name varchar(30) not null,
   age int not null,
   phone varchar(20) not null,
   email varchar(30),
   unique key(id)
);
-- 회원 저장(insert)
insert into member(id,pass,name,age,phone,email)
values('admin','admin','관리자',30,'010-1111-1111','admin@gsm.kr');


-- 데이터 가져오기(select)
select * from member;
