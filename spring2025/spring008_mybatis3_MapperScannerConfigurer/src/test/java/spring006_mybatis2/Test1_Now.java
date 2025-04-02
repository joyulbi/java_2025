package spring006_mybatis2;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.TestDao;

@RunWith(SpringJUnit4ClassRunner.class)  //1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml") //2. 설정
public class Test1_Now {
	
	@Autowired ApplicationContext  context;  //3. Bean(스프링이 관리하는객체) 생성~소멸관리
	@Autowired DataSource dataSource;
	@Autowired TestDao dao;
	
	@Ignore /* @Test */public void test0() {  System.out.println(context);   }
	@Test public void test1() {  System.out.println(dataSource);   }
	@Test public void test2() {  System.out.println(dao.now());   }
	//NoSuchBeanDefinitionException: No qualifying bean   @Repository
}
