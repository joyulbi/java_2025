package com.company.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 1. �������� �����ϴ� ��ǰ��ü - dao  
public class TestDaoImpl implements TestDao {
	
	@Autowired private SqlSession SqlSession; 
	//2. crud(insert, update, delete, select)
	private static final String namespace="com.company.dao.TestDao";
	
	@Override public String readTime() {
		return SqlSession.selectOne(namespace+".readTime");
	}
	// sqlSeesion.insert(����� �޼����, dto)
	// sqlSeesion.update(����� �޼����, dto)
	// sqlSeesion.delete(����� �޼����, dto)
	// sqlSeesion.selectOne(����� �޼����, no)
	// sqlSeesion.selectList(����� �޼����, no)
}
