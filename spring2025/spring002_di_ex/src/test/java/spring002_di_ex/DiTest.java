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

@RunWith(SpringJUnit4ClassRunner.class) //spring ����
//@ContextConfiguration(locations = "classpath:config/test1.xml") //����
@ContextConfiguration(locations = "classpath:config/test2.xml") //����
public class DiTest {
	
	@Autowired ApplicationContext context; //1. bean(�������� �����ϴ� ��ü��)
	// 2. ApplicationContext - bean �������� �Ҹ���� ����
	// 3. ������, ������Ƽ �ִ��� �׽�Ʈ�ϰ� �ڵ�����, ����
	
	@Test //@Ignore
	public void test() {
		AnimalFarm farm = context.getBean("animalFarm",AnimalFarm.class);
		farm.print();
	}
}
