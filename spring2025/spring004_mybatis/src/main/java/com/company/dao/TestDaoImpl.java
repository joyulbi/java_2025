package com.company.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 1. 스프링이 관리하는 부품객체 - dao  
public class TestDaoImpl implements TestDao {
	
	@Autowired private SqlSession SqlSession; 
	//2. crud(insert, update, delete, select)
	private static final String namespace="com.company.dao.TestDao";
	
	@Override public String readTime() {
		return SqlSession.selectOne(namespace+".readTime");
	}
	// sqlSeesion.insert(경로의 메서드명, dto)
	// sqlSeesion.update(경로의 메서드명, dto)
	// sqlSeesion.delete(경로의 메서드명, dto)
	// sqlSeesion.selectOne(경로의 메서드명, no)
	// sqlSeesion.selectList(경로의 메서드명, no)
}
