package spring002_di_ex;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.ioctest.AnimalFarm;
import com.company.ioctest.Cat;

@RunWith(SpringJUnit4ClassRunner.class) //spring 구동
//@ContextConfiguration(locations = "classpath:config/test1.xml") //설정
@ContextConfiguration(locations = "classpath:config/test2.xml") //설정
public class DiTest {
	
	@Autowired ApplicationContext context; //1. bean(스프링이 관리하는 객체들)
	// 2. ApplicationContext - bean 생성부터 소멸까지 관리
	// 3. 생성자, 프로퍼티 있는지 테스트하고 자동연결, 적용
	
	@Test //@Ignore
	public void test() {
		AnimalFarm farm = context.getBean("animalFarm",AnimalFarm.class);
		farm.print();
	}
}
