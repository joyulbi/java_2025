package com.thejoa.boot005.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board,Long>{
	
	//1. @Query 엔티티 테이블명 사용 : Board - select 기본작업
	//@Query(value="select * from board order by id desc", nativeQuery = true)
	@Query(value="select b from Board b order by id desc")
	List<Board> findAllByOrderByDesc();
	
	//2. insert, update, delete - @Modifying, @Transactional, @Query
	@Modifying 		//2-1. 삽입, 수정, 삭제 쿼리는 변경작업
	@Transactional	//2-2. rollback 활성화 
	@Query("delete from Board b where b.id= :id and b.bpass = :bpass ")
	int deleteByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass);
	//2-3. @Param("id") 쿼리의 변수명과 동일하면 생략가능
	//2-4. deleteByIdAndBpass(Board board) X 객체 파라미터 지원 안 함. 
	
	@Modifying 		//2-1. 삽입, 수정, 삭제 쿼리는 변경작업
	@Transactional	//2-2. rollback 활성화 
	@Query("update Board b set b.btitle = :btitle, b.bcontent = :bcontent where b.id = :id and b.bpass = :bpass")
	int updateByIdAndBpass(@Param("id") Long id,
	                       @Param("bpass") String bpass,
	                       @Param("btitle") String btitle,
	                       @Param("bcontent") String bcontent);


	
}

/*
mysql> desc member;
+------------------+--------------+------+-----+---------+----------------+
| Field            | Type         | Null | Key | Default | Extra          |
+------------------+--------------+------+-----+---------+----------------+
| id               | bigint       | NO   | PRI | NULL    | auto_increment |
| age              | int          | NO   |     | NULL    |                |
| create_date_time | datetime(6)  | YES  |     | NULL    |                |
| name             | varchar(255) | YES  |     | NULL    |                |
+------------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)
 */