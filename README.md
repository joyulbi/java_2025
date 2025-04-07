####  2025-02-17 
1. welcome!
2. git (로컬저장소 - 원격저장소)
3. java ( 설치, eclipse )

---
####  2025-02-18
1. 자료형
2. scanner
---
####  2025-02-19
1. 연산자
2. source tree 트러블 슈팅 > 커밋이 올라가지 않음
---
####  2025-03-06
1. interface
---
####  2025-03-06
1. interface
2. 익명 클래스
---
####  2025-04-07
1. springboot 첫시간
■ STEP1. project
  - enc UTF-8
  - project
  
■ STEP2. setting (properties)
■ STEP3. db
- jpa
	1) application.properties
	2) @Entity - Dto/테이블 만들기
	3) @Repository - Dao

- ex)
	1) @Entitiy이용해서 Member 테이블 만들기
	2) @Repository 이용해서 MemberRepository

■ STEP4. view
1. pom.xml 셋팅확인
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<!--  https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect  -->
<!--  추가  -->
<dependency>
<groupId>nz.net.ultraq.thymeleaf</groupId>
<artifactId>thymeleaf-layout-dialect</artifactId>
</dependency>
<!--  추가  -->

2. application.properties 설정확인
# Thymeleaf
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html

3. layout
4. 화면설정

■ STEP5. board
■ STEP6. security
---
