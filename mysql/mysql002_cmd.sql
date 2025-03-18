# 1. rdb : 관계형 데이터 베이스 - 테이블(Entity)들의 관계(Relationship) 외래키(Attribute)
# 2. 데이터베이스 언어
# 정의어 DDL - creat, alter, drop - cad
# 조작어 DML - insert, select, update, delete - crud
# 제어어 DCL - grant, revoke

# 실습1) insert
use mbasic;
show tables;
desc userinfo;

#1-1 구조와 순서를 알고 있을때
insert into userinfo values(1,'first',11);
select*from userinfo; 

insert into userinfo values('second',2,22); #필드 순서 안 맞음
#Error Code: 1366. Incorrect integer value: 'second' for column 'no' at row 1

#1-2 원하는 필드만 데이터 입력
insert into userinfo(name,age) values('second',22);
insert into userinfo(name,age) values('fourth',44);
insert into userinfo(age,name) values(33,'third');
select*from userinfo; 

# 실습2) update
/*  update 테이블명
	set	   필드1 = 값1, 필드2 = 값2
	where  조건
*/

# 2-1. 전체데이터 수정
set sql_safe_updates=0; -- eror code 1175
update userinfo set age=0;
select*from userinfo; 


# 실습3) delete
/*
	delete from 테이블명
    where 조건식
*/
-- 준비 구조 + 데이터복사
create table userinfo_delete select *from userinfo;
alter table userinfo_delete add primary key(no);
alter table userinfo_delete modify no int not null auto_increment;

desc userinfo_delete;
select *from userinfo_delete;

# 3-1 age가 11인 유저 삭제
delete from userinfo_delete where age=11;
delete from userinfo_delete where age=22 and name='second';
#전체 데이터 삭제
delete from userinfo_delete;
# 2-2. 바꿀데이터 여러개
update userinfo set age = 11 where no=1;
update userinfo set age = 22,name='two' where no=2;
update userinfo set name = 'second' where no=2 and age=22;

update userinfo set age = 33,name ='third' where no=3;
update userinfo set age = 44,name ='third' where no=4; -- 조건이 안 맞으면 반영 안됨
update userinfo set age = 44 where name='fourth';
select*from userinfo; 

########################################################################
# 연습문제 insert
# [001]
desc emp;
select*from emp;
alter table emp change deptno dept int;
alter table emp modify ename varchar(50) not null;
insert into emp values(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
insert into emp values (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30);
insert into emp values (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30);
insert into emp values (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20);
insert into emp values (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30);
insert into emp values (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30);
insert into emp values (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10);
insert into emp values (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19', 3000, NULL, 20);
insert into emp values (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10);
insert into emp values (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30);
insert into emp values (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100, NULL, 20);
insert into emp values (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30);
insert into emp values (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20);
insert into emp values (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10);

# [002]
select*from dept;
insert into dept values (10,'ACCOUNTING','NEW YORK');
insert into dept values (20,'RESEARCH','DALLAS');
insert into dept values (30,'SALES','CHICAGO');
insert into dept values (40,'OPERATIONS','BOSTON');

# [003]
select*from salagrade;
insert into salagrade values (1,700,1200);
insert into salagrade values (2,1201,1400);
insert into salagrade values (3,1401,2000);
insert into salagrade values (4,2001,3000);
insert into salagrade values (5,3001,9999);



# 연습문제 update
select*from score;
desc score;
insert score values(1,'aaa',100,100,100,100,null,null,null);
insert score values(2,'bbb',90,98,88,100,null,null,null);
insert score values(3,'ccc',70,20,78,80,null,null,null);
insert score values(4,'ddd',78,89,68,98,null,null,null);
insert score values(5,'abc',89,98,69,77,null,null,null);
#[001]
update score set sjava=90,sjsp=90,sspring=90 where sname='ccc';
#[002]
update score set semail='admin@gmail.com';
#[003]
update score set sstotal=sjava+sjsp+sspring+sproject;
#[004]
update score set ssavg=(sjava+sjsp+sspring+sproject)/4;
#[005]
update score set semail='first@gmail.com' where ssavg=100;
#[006]
update score set sjava=92,sjsp=78 where sname='bbb';
#[007]
alter table score modify ssavg double;
update score set semail='second@gmail.com' where ssavg=89.5;
#[008]
update score set semail='ccc@gmail.com' where sname='ccc';
#[009]
update score set semail='blackstudent@gmail.com' where sproject<80;
#[010] -- 맞는 데이터가 없어서 수정 안됨
update score set semail='hello@gmail.com' where ssavg=89.5 and sproject=98;


# 연습문제 delete
create table emp_del select*from emp;
desc emp_del;
select*from emp_del;
#[001]
delete from emp_del where job='SALESMAN';
#[002]
delete from emp_del where job='MANAGER' and ename = 'JONES';
#[003]
delete from emp_del;