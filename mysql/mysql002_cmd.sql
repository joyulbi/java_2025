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


#Repeat001
use mbasic;
desc milk;
select *from milk;
alter table milk drop mnum;
alter table milk drop mtotal;
insert into milk values(1,'white',1000);
insert into milk values(2,'choco',1200);
insert into milk values(3,'banana',1800);
insert into milk values(4,'melon',5000);
# 여러줄 실행 ctrl + shift + enter
# 한줄 실행 ctrl + enter
update milk set mprice=1500 where mno=4;
delete from milk where mno=4;
select *from milk;


## ■ part002 진도 - select basic
select * from userinfo;
create table select_userinfo select * from userinfo;
desc select_userinfo;
alter table select_userinfo modify no int not null auto_increment primary key;
select * from select_userinfo;

insert into select_userinfo (name,age) values ('first',55);
insert into select_userinfo (name,age) values ('third',66);

##2-2
-- 1. 전체 데이터 검색
select * from select_userinfo;
-- 2. 부분 검색
select name,age from select_userinfo;
-- 3. 중복 제거
select distinct name from select_userinfo;
-- 4. 별명
select name as '이름',age '나이' from select_userinfo;
-- 5. where 조건(=같다, != <> 다르다, < <= > >= )
select * from select_userinfo where name = 'second';
select * from select_userinfo where name != 'second';
select * from select_userinfo where name <> 'second';

select * from select_userinfo where age<33;
select * from select_userinfo where age<=33;
select * from select_userinfo where age>33;
select * from select_userinfo where age>=33;
-- 6. 모든 조건 - and, between and / 조건중에 - or, in 
select * from select_userinfo where age>=22 and age<=33;
select * from select_userinfo where age between 22 and 33;

select * from select_userinfo where age<22 or age>33;
select * from select_userinfo where age not between 22 and 33;

select * from select_userinfo where age=22 or age=33;
select * from select_userinfo where age in(22,33);

select * from select_userinfo where age not in(22,33);

-- 7. null 검색 ( is null, is not null, not in, not between)
desc select_userinfo;
alter table select_userinfo modify age int null;
insert into select_userinfo (name)values('seven');
select*from select_userinfo;

## null 값이 비워있다라는 상태
select * from select_userinfo where age=null; -- (X)
select * from select_userinfo where age!=null; -- (X)

select * from select_userinfo where age is null;
select * from select_userinfo where age is not null;

-- 8. like 문자열 검색( like 'a%', '%a', '%a%', '_a%')
select * from select_userinfo where name = 'first';
select * from select_userinfo where name like 'f%'; -- f로 시작
select * from select_userinfo where name like '%t'; -- t로 끝남
select * from select_userinfo where name like '%i%'; -- i포함
select * from select_userinfo where name like '_e%'; -- 두번째 글자가 e

## 연습문제
create table select_emp select * from emp;
desc select_emp;
#[001]~#[010]
select * from select_emp; 
alter table select_emp rename column nodept to deptno; -- 1
select * from select_emp where dept = 30; -- 2
select * from select_emp where deptno = 30 and job='SALESMAN'; -- 3
select* from select_emp where deptno=30 or job='check'; -- 4
select * from select_emp where sal*12=36000; -- 5
select * from select_emp where sal>=3000; -- 6
select * from select_emp where  ename >='F'; -- 7
select * from select_emp where  ename <='FORD'; -- 8
select * from select_emp where  sal != 3000; -- 9
select * from select_emp where  sal <> 3000; -- 10

#[011]~#[020]
select * from select_emp where not sal= 3000; -- 11
select * from select_emp where job='MANAGER' or job='SALESMAN' or job= 'CLERK'; -- 12
select * from select_emp where job in('MANAGER','SALESMAN','CLERK'); -- 13
select * from select_emp where job!='MANAGER' and job!='SALESMAN' and job!= 'CLERK'; -- 14
select * from select_emp where job not in('MANAGER','SALESMAN','CLERK'); -- 15
select * from select_emp where sal>=2000 and sal<=3000; -- 16
select * from select_emp where sal  between 2000 and 3000; -- 17
select * from select_emp where sal not between 2000 and 3000; -- 18
select * from select_emp where not ( sal>=2000 and sal<=3000); -- 19
select * from select_emp where empno=7499 and deptno =30; -- 20

#[021]~#[030]
select * from select_emp where deptno =20 or job = 'SALESMAN'; -- 21
select * from select_emp where sal>=2500 and job='ANALYST'; -- 22
select * from select_emp where deptno in (10,20); -- 23
select * from select_emp where deptno not in (10,20); -- 24
select * from select_emp where ename like 'S%'; -- 25
select * from select_emp where ename like '_L%'; -- 26
select * from select_emp where ename like '%AM%'; -- 27
select * from select_emp where ename not like '%AM%'; -- 28
select ename as 'ENAME',sal 'SAL' ,sal*12+comm 'ANNSAL', comm 'COMM' from select_emp where ENAME in ('JAMES','ADAMS'); -- 29
select * from select_emp where comm is null; -- 30

#[031]~#[040]
select * from select_emp where comm is null; -- 31
select * from select_emp where mgr is not null; -- 32
select * from select_emp where sal >null; -- 33
select * from select_emp where sal >null or comm is null; -- 34
select * from select_emp where ename like '%S'; -- 35
select empno,ename,job,sal,deptno
from select_emp
where deptno=30 and job='SALESMAN'; -- 36
select empno,ename,job,sal
from select_emp
where deptno in (20,30) and sal>2000; -- 37
select * from select_emp where sal<2000 or sal>3000; -- 38
select * from select_emp where deptno=30 and ename like '%E%' and sal not between 1000 and 2000; -- 39
select * from select_emp where comm is null and mgr is not null and job in('MANAGER','CLERK') and ename not like '_L%'; -- 40


## 복습문제
use mbasic;
select * from emp;
select * from emp where ename like '%E%' and sal between 1000 and 2000;
select * from emp where comm is null and mgr is not null and job in('MANAGER','CLERK') and ename not like '_L%'; 

show tables;
select * from select_userinfo;
delete from select_userinfo where no=7;


## ■ 1. order by + limit
/*  
select   필드1, 필드2
from     테이블명
where    조건식 
group by  그룹핑
having    조건식
order by 기준필드  [asc(1,2,3오름차순) | desc(3,2,1 내림차순)]
limit    몇개

avg(컬럼명) 평균, max 최대값, min 최소값 , sum 합계 , count 갯수

*/
-- 1-2. 정렬
select * from select_userinfo order by age desc; -- 내림
select * from select_userinfo order by age asc; -- 오름

-- 나이많은 3명
select * from select_userinfo order by age desc limit 3;
select * from select_userinfo order by age desc limit 2;

-- no가 높은순으로 4명
select * from select_userinfo order by no desc limit 4;

-- no가 두번째로 높은순으로 2명 limit 어디서부터,몇개
select * from select_userinfo order by no desc limit 0,2; -- 6,5
select * from select_userinfo order by no desc limit 1,2; -- 5,4

-- 1-3 연습문제 select_emp
select * from select_emp where job='SALESMAN';-- 2
select ename,mgr,sal -- 3
from select_emp;-- 4
select ename,mgr,sal
from select_emp
where job='SALESMAN'; -- 5
select * from select_emp order by sal desc; -- 6
select ename,sal,empo 'select_empo'
from select_emp
where sal>2000
order by select_emp desc; -- 7
select distinct  job from select_emp; -- 8
select empno as '사원번호' ,ename '이름',job '담당업무' from select_emp; -- 9
select* from select_emp order by sal asc; -- 10
select* from select_emp order by sal desc; -- 11
select* from select_emp order by deptno asc, sal desc; -- 12
select empno 'select_employee_no',ename'select_employee_name',job
,mgr 'MANAGER',hiredate,sal 'SALARY', comm'COMMISION', deptno 'DEPARTMENT_NO'
from  select_emp
order by deptno desc, ename asc; -- 13

create table group_user(
no int not null primary key auto_increment,
name varchar(20) not null,
age int not null,
sex char(2),
kor int,
eng int,
math int,
ban char(2),
sns char(2));

select * from group_user;
desc group_user;
alter table group_user modify sns char(2) default 'y';

insert into group_user values(1,'first',11,null,100,100,99,'A','n');
update group_user set kor = 100 where no=1;
insert into group_user values(2,'second',22,'m',89,92,78,'B','n');
update group_user set sns = 'y' where no=2;
insert into group_user values(3,'third',33,'m',90,92,97,'A','y');

insert into group_user values(4,'fouth',44,'f',40,42,67,'C','n');
insert into group_user values(5,'fifth',55,'f',89,86,99,'B','y');
insert into group_user values(6,'sixth',66,'m',10,20,44,'C','n');

alter table group_user rename group_userinfo;

-- 2-2 기본
select  @@sql_mode; -- 2
set  SESSION  sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

select * from group_userinfo group by ban; -- 4

-- 나이평균
select avg(age) from group_userinfo;

-- 반별 몇명있는지
select * from group_userinfo;
select ban, count(*) from group_userinfo group by ban;

-- 반별 국, 영, 수의 총점 확인
select ban, sum(kor) '국어총합',sum(eng) '영어총합',sum(math) '수학총합' 
from group_userinfo
group by ban;

-- 반별 국,영,수의 평균 확인
select ban, avg(kor) '국어 평균',avg(eng) '영어 평균' ,avg(math)'수학 평균'
from group_userinfo
group by ban;

-- 반별 나이의 총합과 나이 평균 확인 alter
select ban, sum(age) '나이총합', avg(age) '나이평균',max(age)'최고나이', min(age)'최저나이'
from group_userinfo
group by ban;

select ban, avg(kor) '국어 평균'
from group_userinfo
group by ban
having avg(kor)>=89;

select ban, sum(age) '나이총합', avg(age) '나이평균'
from group_userinfo
group by ban
having avg(age) >=35
order by avg(age) desc;

desc emp;
alter table emp change dept deptno int;
select * from emp;
select sum(sal) '급여합계'
from emp;
select sum(comm) '추가수당'
from emp;
select sum(distinct sal) 'sum(distinct sal)', sum(all sal) 'sum(all sal)', sum(sal) 'sum(sal)'
from emp;
select count(empno);

select count(deptno) '부서직원수'
from emp 
group by deptno
having deptno=30;
select count(distinct sal) 'count(distinct sal)',count(all sal) '(all sal)', count(sal) 'count(sal)'
from emp;
select count(comm) '추가수당을 받는 사원수'
from emp;
select count(*) '추가수당을 받는 사원수'
from emp
where comm is not null;
select max(sal)'부서 10 최대급여' from emp where deptno=10;
select min(sal)'부서 10 최소급여' from emp where deptno=10;

select hiredate '부서 20 최근입사일' 
from emp 
where deptno=20
order by hiredate desc limit 1;

select hiredate '부서 20 제일 오래된 입사일' 
from emp 
where deptno=20
order by hiredate asc limit 1;

select avg(sal)
from emp
where deptno = 30;

select avg(distinct sal)
from emp
where deptno = 30;

select deptno,avg(sal)'평균급여'
from emp
group by deptno
order by deptno asc;

select deptno,job,avg(sal)'평균급여'
from emp
group by mgr,deptno
order by deptno asc ,job asc;

select deptno,job,avg(sal)'평균급여'
from emp
group by deptno,job
having avg(sal)>2000
order by deptno asc ;

select deptno,job,avg(sal)
from emp
where avg(sal)>=2000 -- 오류남 
group by deptno,job
order by deptno,job;

select deptno,job,avg(sal)'평균급여'
from emp
where sal<=3000
group by deptno,job
having avg(sal)>=2000
order by deptno asc ;
select*from emp;

select deptno,job,count(deptno) '사원수',max(sal),sum(sal)'급여함',avg(sal)'평균급여'
from emp
group by deptno,job
order by deptno asc;

create table milk_order(
ono int not null primary key auto_increment,
oname varchar(20) not null,
onum int not null,
odate datetime default current_timestamp,
oip varchar(100) not null 
);
desc milk_order;
select *from milk_order;

-- Q1.  milk_order 값삽입.  insert 구문 완성    (oname, onum, oip)     'white' , 2,  '127.0.0.1'
insert into milk_order (oname,onum,oip)values('white',2,'127.0.0.1');
-- Q2.  milk_order no가 1인데이터 조회 
select * from milk_order where ono=1;
-- Q3.  milk_order 전체데이터조회
select *from milk_order;
-- Q4.  milk_order 해당번호의 이름과 갯수 수정
update milk_order set oname='choco' where ono=1;
-- Q5.  milk_order 해당번호의 데이터 삭제
delete from milk_order where ono=1;

use mbasic;
SELECT CEIL(1.1), FLOOR(1.9), ROUND(1.5), MOD(10,3);
select 123.4578,
round(123.4578,0) 'ROUND1',
round(123.4578,-1) 'ROUND2',
round(123.4578,1) 'ROUND3',
round(123.4578,2) 'ROUND4';
select 123.4578,
ceil(123.4578) 'CEIL',
floor(123.4578) 'FLOOR';

select length('abc') 'LENGTH';
select 'ABC' 'DEFAULT',
upper('abc') 's1',
lower('ABC') 's2';

select instr('abc','b') 'b의 위치',
instr('abc','ab') 'ab의 위치',
instr('abc','ac') 'ac의 위치';

select left('abc',1) 'l1',
left('abc',2) '12',
right('abc',1)'r1',
right('abc',2)'r2';

select substr('abcde',2,2);
#####################################################################################
## ■ function
##1. Number
##2. String
##3. Date
##4. if / case

##1. Number (ceil 올림, floor 내림, round 반올림, mod 나머지)

use mbasic;
select ceil(1.1)`올림`,floor(1.9)`내림`,round(1.5)`반올림`,mod(10,3)`나머지`;
-- 연습문제 1
select 123.4578, round(123.4578)`ROUND1`,round(123.4578,-1)`ROUND2`,round(123.4578,1)`ROUND3`,round(123.4578,2)`ROUND4`; 
-- 연습문제 2
select 123.4578, ceil(123.4578)`CEIL`, floor(123.4578)`FLOOR`;

##2. String
## length() 문자길이, upper()/loewr() 대문자/소문자, instr(문자열,찾을 문자열) 위치찾기 
## substr(문자열,시작,객수) 문자열 일부 추출, left(문자열,갯수) 왼쪽에서 추출, right(문자열,갯수) 오른쪽에서 추출 
## concat(문자열,문자열) 연결, trim() - ltrim왼쪽,rtrim오른쪽 공백제거, replace(문자열,찾아서바꾸기) 찾아서 바꾸기 
## repeat(문자열,반복횟수) 반복, lpad(문자열,전체자리수,특정문자) 왼쪽특정문자채우기, rpad() 오른쪽특정문자채우기

-- 2-1. basic
-- 1) length(문자열) 개수
select length('abc');

-- 2) upper / lower
select 'abc', upper('abc'), lower('abc');

-- 3) instr 위치
select instr('abc', 'b') `B의 위치`, instr('abc', 'ab') `ab의 위치`, instr('abc','ac') `ac의 위치`;

-- 4) left, right, substr
select left('abc', 1), left('abc',2), right('abc',1), right('abc',2);
select substr('abcde', 2,2) `bc`, substr('abcde',2,3) `bcd`,substr('abcde',1,3) `abc`;

-- 5) 문자열 연결 concat(문자열1, 문자열2)
select concat('hello ', 'mysql') `hello mysql`;

-- 6) trim 좌우공백제거
select trim(' a b c ') `a b c`;
select concat('#',trim(' a b c '),'#')`#a b c#`,
   concat('#',ltrim(' a b c '),'#')`#a b c #`,
   concat('#',rtrim(' a b c '),'#')`# a b c#`;
    
-- 7) replace (문자열에서,무엇을찾아서,바꾸기)
select replace("hello sally",'sally','alpha')`hello alpha`;

-- 8) repeat (무엇을,몇개반복)
select repeat('*',5)`*****`;

-- 9) 빈칸채우기 
select lpad('abc',10,'#'),
   rpad('abc',10,'#');
    
## 연습문제
create table fn_select_userinfo2(
no int not null default 0,
name varchar(20) not null,
age int not null,
email varchar(20) not null
);
desc fn_select_userinfo2;
insert into fn_select_userinfo2 values(1,'aaa',11,'aaa@gmail.com');
insert into fn_select_userinfo2 values(2,'bbb',22,'bbb@gmail.com');
insert into fn_select_userinfo2 values(3,'ccc',33,'ccc@gmail.com');
insert into fn_select_userinfo2 values(4,'ddd',44,'ddd@gmail.com');
insert into fn_select_userinfo2 values(5,'abc',55,'abc@gmail.com');
insert into fn_select_userinfo2 values(6,'bca',66,'bca@gmail.com');
select*from fn_select_userinfo2;

-- 1
select name`이름`,length(name)`갯수` from fn_select_userinfo2;
-- 2
select name,left(name,1)`첫번째 글자`,right(name,1)`마지막 글자` from fn_select_userinfo2;
-- 3
select name,replace(name,'aaa','aaa 1등') from fn_select_userinfo2;
-- 4
select concat(name,'는 개발자입니다.')`직업` from fn_select_userinfo2;
-- 5 
select upper(name) from fn_select_userinfo2;
-- 6
select lower(name) from fn_select_userinfo2;
-- 7
select name, instr(name,'b') from fn_select_userinfo2 where age>=40;
-- 8
select name, instr(name,'b') from fn_select_userinfo2 where age>=40 order by age desc limit 2;
-- 9
select name,concat(left(name,1),'*',right(name,1))`test` from fn_select_userinfo2;
-- 10
create table select_userinfo2(
no int not null,
name varchar(20) not null,
age int not null,
email varchar(20) not null
);
insert into select_userinfo2 values(1,'aaaa',11,'aaa@gmail.com');
insert into select_userinfo2 values(2,'bbaab',22,'bbb@gmail.com');
insert into select_userinfo2 values(3,'cccaac',33,'ccc@gmail.com');
insert into select_userinfo2 values(4,'daadd',44,'ddd@gmail.com');
insert into select_userinfo2 values(5,'abc',55,'abc@gmail.com');
insert into select_userinfo2 values(6,'baaca',66,'bca@gmail.com');
select*from select_userinfo2;
select name,concat(left(name,1),repeat('*',length(name)-2),right(name,1))`test` from select_userinfo2;

##3. DATE
-- 1) 시스템의 현재 시각조회
select now();
select current_timestamp();
select curdate();
select curtime();
select current_date();
select current_time();

-- 2) 요일 (0=MON,1=TUE,...,6=SUN)
select weekday(now()); -- 4 금
select weekday("2025-03-21");

-- 3) 날짜형식 date_format(날짜지정,'%Y-%m-%d')
select date_format("2025-03-21",'%Y-%m-%d');
select date_format(now(),'%Y-%m-%d %H:%i:%s');

-- 4) 100일 전/ 후 date_add
select date_add(now(),interval -10 day);
select date_add(now(),interval 10 day);
select date_add(now(),interval -3 hour);

-- 5) datediff(날짜1,날짜2) 날짜차이
select datediff('2025-03-22','2025-03-21');
select timestampdiff(hour,'2025-03-22','2025-03-21');

##연습문제 1
create table date_userinfo (
no int not null default 0,
name varchar(100) not null,
age int not null,
date datetime default current_timestamp
);
desc date_userinfo;
insert into date_userinfo values (1,'aaa',11,'2022-12-30 00:00:00');
insert into date_userinfo values (2,'bbb',22,'2022-11-30 00:00:00');
insert into date_userinfo values (3,'ccc',33,'2022-10-30 00:00:00');
insert into date_userinfo values (4,'ddd',44,'2022-09-30 00:00:00');
select*from date_userinfo;
-- 1
select name,date from date_userinfo where date<'2022-11-01';
-- 2
select name,date,date_add(date,interval 30 day)`event` from date_userinfo where date between '2022-12-01' and '2022-12-31';
select name,date,date_add(date,interval 30 day)`event` from date_userinfo where month(date)=12; -- month() 월만
-- 3
select name,date_format(date,'%Y년 %m월 %d일')`가입날짜` from date_userinfo;

##연습문제 2
-- 1
select now();
-- 2
select datediff('2025-12-25',now());
-- 3
select date_add(now(),interval 5 month);
-- 4
select date_add(curdate(),interval(6-weekday(curdate())) day);

##4. if / case
-- if(조건,참,거짓)
-- 다형식
/*   case
   when 조건1 then 상태1
    when 조건2 then 상태2
    else 모든조건에 해당하지 않을 때, 생략가능
    end
*/

create table control (no int);
insert into control values (1),(2),(3);
select*from control;

-- 1-1.
select no, if(no=1,'1이다','1이 아니다')`상태` from control;
-- 1-2.
select no, if(no>1,'1보다 크다','1보다 작거나같다')`상태` from control;
-- 1-3. case when/then end
select no,case 
         when no=1 then '1이다'
            when no=2 then '2이다'
            when no=3 then '3이다'
            else '1,2,3 이 아니다'
        end `state`
from control;
-- 1-4. 2이다, 크다, 작다
select no,case
         when no=2 then '2이다'
            when no>2 then '크다'
            when no<2 then '작다'
        end 'state'
from control;

## 연습문제 1
create table if_userinfo(
no int not null auto_increment primary key,
name varchar(100) not null,
age int default 0,
sex char(1),
sns char(1)
);
desc if_userinfo;
insert into if_userinfo (name,age,sex,sns) values 
('first',11,null,'n'), 
('second',22,'m','y'),
('third',33,'m','y'),
('fourth',44,'f','n'),
('fifth',55,'f','y'),
('sixth',66,'m','n');
select*from if_userinfo;
-- 1
select *,if(sns='y','수신유지','수신거부')`수신여부상태` from if_userinfo;
-- 2
select *,if(age<19,'미성년자','성인')`성인여부` from if_userinfo;
-- 3
select count(*)`sns수신거부수` from if_userinfo where sns='n';
select sum(if(sns='n',1,0))`sns수신거부수` from if_userinfo;
select count(if(sns='n',1,null))`sns수신거부수` from if_userinfo;

## 연습문제 2 emp 테이블에서
-- 1
select ename`ENAME`,deptno`DEPTNO`,case 
when deptno=10 then 'ACCOUNTING'
when deptno=20 then 'RESEARCH'
when deptno=30 then 'SALES'
end`부서이름` 
from emp;
select ename`ENAME`,deptno`DEPTNO`,case deptno 
when 10 then 'ACCOUNTING'
when 20 then 'RESEARCH'
when 30 then 'SALES'
end`부서이름` 
from emp;
-- 2
select ename,job,case
when job='CLERK' then '판매원'
when job='SALESMAN' then '영업사원'
else '사원'
end`job2`
from emp;


create table join_userban(
no int not null primary key auto_increment,
name varchar(20) not null,
ban char(2));

desc join_userban;
select *from join_userban;
insert into join_userban values(1,'first','A');
insert into join_userban values(2,'second','B');
insert into join_userban values(3,'third','A');
insert into join_userban values(4,'fourth','C');
insert into join_userban values(5,'fifth','B');
insert into join_userban values(6,'sixth','C');
insert into join_userban values(7,'fifth','B');
insert into join_userban values(8,'sixth','C');

update join_userban set ban ='D' where no>=7;
delete from join_userban where no>=7;

select ban,count(*) '학생수'
from join_userban
group by ban;


# 데이터베이스 언어 ★
# DDL - create, alter, drop
# DML - insert, select, update, delete
# DCL - grant, revoke

# e(entitiy:테이블)r(relation:관계) 속성:pk, fk
# join ★
-- 두개이상의 테이블들을 연결해서 데이터를 조회
-- 테이블간의 연결고리(pk, fk)

# 종류 : inner join, outer join

create table join_userinfo(
no int(11) not null default '0',
name varchar(100) not null,
age int(11) not null);
desc join_userinfo;

insert into join_userinfo values (1,'first',11);
insert into join_userinfo values (2,'second',22);
insert into join_userinfo values (3,'third',33);
insert into join_userinfo values (4,'fourth',44);
select*from join_userinfo;

-- (1) join
select a.no,a.name,a.age,b.ban
from join_userinfo a, join_userban b
where a.no = b.no;

-- (2) join on
select  a.no,a.name,a.age,b.ban
from join_userinfo a join join_userban b on (a.no = b.no);

-- (3) join using
select  a.no,a.name,a.age,b.ban
from join_userinfo a join join_userban b using(no);

-- (4) natural join - natural join 알아서 join 연결할 부위찾아서 연결해줌.
select no,name,age,ban
from join_userinfo natural join join_userban;


##연습문제
-- Q1
select a.no,a.name, a.age, b.ban
from join_userinfo a , join_userban b 
where (a.no = b.no) and age between 20 and 40;
-- Q2
select a.no,a.name, a.age, b.ban
from join_userinfo a join join_userban b on(a.no = b.no)
where age between 20 and 40;
-- Q3
select a.no,a.name, a.age, b.ban
from join_userinfo a join join_userban b using(no)
where age between 20 and 40;

## right join은 오른쪽 값 보장
select a.no,a.name, a.age, b.ban
from join_userinfo a right join join_userban b on a.no=b.no;

## left join은 왼쪽 값 보장
select a.no,a.name, a.age, b.ban
from join_userban b left join join_userinfo a on a.no=b.no;

-- Q4 right join
select b.no,b.name,b.ban,a.age
from join_userinfo a right join join_userban b on a.no=b.no;

-- Q5 left join
select b.no,b.name,b.ban,a.age
from join_userban b right join  join_userinfo a on a.no=b.no;

##연습문제
-- (1) join은 연결부위가 필요함
select * from emp,dept
order by empno;

-- (2)
select *
from emp a join dept b using(deptno);

-- (3)
select *
from emp E, dept D
where E.deptno=D.deptno
order by empno;

-- (4)
select empno,ename,deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;
-- 1052 에러발생 empno등 앞에 e나 d를 붙여야함

-- (5)
select empno,ename,e.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;

-- (6)
select empno,ename,e.sal,dname,loc
from emp e, dept d
where e.deptno = d.deptno and sal>=3000;

select empno,ename,e.sal,dname,loc
from emp e join dept d on(e.deptno = d.deptno)
where  sal>=3000;

select empno,ename,e.sal,dname,loc
from emp e join dept d using(deptno)
where  sal>=3000;

select empno,ename,e.sal,dname,loc
from emp e natural join dept d
where  sal>=3000;

select*from salagrade;
select*from emp;

-- (7) 
select E.empno, E.ename, E.job, E.mgr, E.hiredate, E.sal, E.comm, E.deptno, S.grade, S.losal, S.hisal
from emp E, salagrade S
where E.sal between S.losal and S.hisal
order by s.grade asc, e.sal asc;


-- (8)
select e1.empno, e1.ename, e1.mgr, e2.empno'MGR_EMPNO', e2.ename 'MGR_ENAME'
from emp e1,emp e2,salagrade s
where e1.mgr=e2.empno and e1.sal  between s.losal and  s.hisal
order by e2.empno asc;


-- (9)
select e1.empno, e1.ename, e1.mgr, e2.empno'MGR_EMPNO', e2.ename 'MGR_ENAME'
from emp e1 left join emp e2 
on( e1.mgr=e2.empno)
order by e1.empno asc;


-- (10) right join right쪽의 테이블 값 보장 
select e1.empno, e1.ename, e1.mgr, e2.empno'MGR_EMPNO', e2.ename 'MGR_ENAME'
from emp e1 right join emp e2 on( e1.mgr=e2.empno)
order by e2.ename;

-- (11)
select empno,ename,job,mgr,hiredate,sal,comm,deptno,dname,loc
from emp natural join dept
order by deptno, empno;

select * from dept;
select * from emp;

-- (12)
select empno,ename,job,mgr,hiredate,sal,comm,deptno,dname,loc
from emp e join dept d using(deptno)
where sal >=3000
order by deptno, empno;

-- (13)
select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc
from emp e join dept d on(e.deptno = d.deptno)
where sal<=3000
order by deptno, empno;

-- (14)
select d.deptno,d.dname,e.empno,e.ename,e.sal
from emp e join dept d on(e.deptno = d.deptno)
where sal>2000;

-- (15)
select d.deptno,d.dname,e.empno,e.ename,e.sal
from emp e  natural join dept d 
where sal>2000;

-- (16)
select d.deptno, d.dname,avg(sal)'avg_sal',max(sal)'max_sal',min(sal)'min_sal',count(*)'cnt'
from emp e join dept d 
where e.deptno = d.deptno
group by deptno
order by cnt asc;

-- (17)
select d.deptno, d.dname,avg(sal)'avg_sal',max(sal)'max_sal',min(sal)'min_sal',count(*)'cnt'
from emp e join dept d using(deptno)
group by deptno
order by cnt asc;

-- (18)
select deptno, dname, empno, ename, job, sal
from dept d left join emp e  using (deptno)
order by deptno asc;

-- (19)
select deptno, dname, empno, ename, job, sal
from  emp e right join dept d  using (deptno)
order by deptno asc;

-- (20)
select d.deptno,dname,e.empno,
		e.ename,e.mgr,e.sal,e.deptno,s.losal,s.hisal,s.grade
		,e2.empno'MGR_EMPNO',e2.ename'MGR_ENAME'
from emp e right join dept d on(e.deptno=d.deptno)
		left join salagrade s on(e.sal between s.losal and s.hisal) 
        left join emp e2 on(e.mgr=e2.empno)
order by d.deptno,e.empno;


use mbasic;
create table sub_userinfo(
no int(11) not null primary key auto_increment,
name varchar(20) not null,
age int(11) not null,
sex char(2),
kor int(11),
eng int(11),
math int(11),
ban char(2),
sns char(2) default 'y');

select*from sub_userinfo;

insert into sub_userinfo values(1,'first',11,null,100,100,99,'A','n');
insert into sub_userinfo values(2,'second',22,'m',89,92,78,'B','y');
insert into sub_userinfo values(3,'third',33,'m',90,92,97,'A','y');
insert into sub_userinfo values(4,'fourth',44,'f',40,42,67,'C','n');
insert into sub_userinfo values(5,'fifth',55,'f',89,86,99,'B','y');
insert into sub_userinfo values(6,'sixth',66,'m',10,20,44,'C','n');

select*from sub_userinfo;
/*
1. 서브쿼리
- select 구문안에 select 구문
- 서브쿼리 결과가 하나 이상 반환시 in,any,all사용

2. 형식
select 컬럼 from 테이블명 where 컬럼 in (select 문);
*/

-- #1-1 평균나이 이상인 레코드를 추출하시오
-- select * from sub_userinfo where age>=평균나이
-- #1-2 평균나이
-- select avg(age) from sub_userinfo;
-- #1-3 #1-1 + #1-2
select * from sub_userinfo where age>=(select avg(age) from sub_userinfo);

-- #2-1 first와 같은반친구들의 국어, 영어, 수학점수를 추출하시오.
-- select ban,name,kor,eng,math from sub_userinfo where ban ='first'반;
-- #2-2 first 의반
-- select ban from sub_userinfo where name='first';
-- #2-3 #2-1 + #2-2
select ban,name,kor,eng,math from sub_userinfo 
where ban =(select ban from sub_userinfo where name='first');

-- #3  first와 같은반친구들의  국어평균점수, 영어평균점수, 수학평균점수를 추출하시오.
select ban,avg(kor) 'kor',avg(eng) 'eng',avg(math) 'math'
from sub_userinfo
where ban = (select ban from sub_userinfo where name='first')
group by ban;


/*1. 다중행 연산자
-  in , any(some) ,  all
2. in  : 서브쿼리의 결과가 하나라도 일치하면 true
3. any : 서브쿼리의 결과가 하나이상이면 true
4. all : 서브쿼리의 결과가 모두 만족하면  true

2. any : 하나라도 일치하면 참  (선한개)
컬럼명  < any(1,2,3)            |(1)   |(2)   |(3)  ★     최대값보다 작다.
컬럼명  > any(1,2,3)          ★ |(1)   |(2)   |(3)  최소값보다 크다

3. all : 모두가 일치하면 참 (선 3개)
컬럼명  < all(1,2,3)          ★ |(1)   |(2)   |(3)        최소값보다 작다  
컬럼명  > all(1,2,3)             |(1)   |(2)   |(3)  ★       최대값보다 크다*/

create table atest as 			select 1 num from dual
					  union all select 2 num from dual
                      union all select 3 num from dual
                      union all select 4 num from dual 
                      union all select 5 num from dual 
                      union all select 6 num from dual;

select * from atest;

-- 최대값보다 작다 1,2,3,4
select num from atest where num<any(select num from atest where num in(3,4,5)) order by num;
-- 최소값보다 크다 4,5,6
select num from atest where num>any(select num from atest where num in(3,4,5)) order by num;
-- 최소값보다 작다 1,2
select num from atest where num<all(select num from atest where num in(3,4,5)) order by num;
-- 최대값보다 크다 6
select num from atest where num>all(select num from atest where num in(3,4,5)) order by num;





##연습문제
-- (1)
select sal from emp 
where ename = 'JONES';
-- (2)
select * from emp
where sal>2975;
-- (3)
select * from emp
where sal>(select sal from emp where ename = 'JONES');
-- (4)
select * from emp
where hiredate<(select hiredate from emp where ename='SCOTT');
-- (5)
select * from emp
where deptno ='20' and sal>(select avg(sal) from emp);
-- (6)
select * from emp
where deptno ='20' or deptno = '30';
-- (7)
select max(sal) from emp
group by deptno
order by deptno asc;
-- (8)
select * from emp
where sal in (select max(sal) from emp group by deptno);
-- (9)
select * from emp
where sal = any (select max(sal) from emp group by deptno);
-- (10)
select * from emp
where sal = some (select max(sal) from emp group by deptno);
-- (11)
select sal from emp
where deptno =30;
-- (12)
select * from emp e
where sal < all (select max(sal) from emp where deptno=e.deptno);
select * from emp
where sal < all (select max(sal) from emp group by deptno);
-- (13)
select * from emp
where sal>(select min(sal) from emp where deptno = 30);
-- (14)
select * from emp
where sal<all(select min(sal) from emp where deptno =30);
-- (15)
select * from emp 
where sal >all(select max(sal) from emp where deptno=30);
-- (16)
select * from emp
where exists (select dname from dept where deptno = 10); 
-- (17)
select * from emp 
where exists (select dname from dept where deptno = 50); 
-- (18)
select * from emp e
where sal in(select max(sal) from emp where deptno=e.deptno );
-- (19)