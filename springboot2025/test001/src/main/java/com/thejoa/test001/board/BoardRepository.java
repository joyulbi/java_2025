package com.thejoa.test001.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board,Long> {
	// id 기준 내림차순
	@Query("SELECT b From Board b ORDER BY b.id DESC")
	List<Board> findAllOrderByIdDesc();
	
	// id pass 같으면 삭제
	@Modifying 		
	@Transactional	
	@Query("delete from Board b where b.id= :id and b.bpass = :bpass ")
	int deleteByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass);
	
	//update
	@Modifying 		
	@Transactional	
	@Query("update Board b set b.btitle = :btitle, b.bcontent = :bcontent where b.id = :id and b.bpass = :bpass")
	int updateByIdAndBpass(@Param("id") Long id,
	                       @Param("bpass") String bpass,
	                       @Param("btitle") String btitle,
	                       @Param("bcontent") String bcontent);

}
