package spring001_di;

import static org.junit.Assert.assertEquals;   //##
import static org.junit.Assert.assertSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.ioctest.Calc;
import com.company.ioctest.MyArea;

@RunWith(SpringJUnit4ClassRunner.class) //1. Spring ioc �����̳� ����
@ContextConfiguration(locations = "classpath:config/beans002.xml") //2. �������� ���
public class JunitTest002 {
	@Autowired ApplicationContext context; // 3. Bean(spring �����ϴ� ��ü)
	//		   ApplicationContext - bean ���, ����, ��ȸ, ��ȯ����
	// @Autowired - ��ü�� �ִ��� �˻��ϰ� �ִٸ� �ڵ�����
	
	@Test
	//@Ignore
	public void test() {
		Calc calc1 = context.getBean("rect",Calc.class);
		Calc calc2 = (Calc) context.getBean("tri");
		MyArea myArea = context.getBean("myArea", MyArea.class);
		//��� ��� 1 : assertEquals("���� ��", "ó���� ��");
		assertEquals("alpha>100.0", myArea.mycalc(10,10));
	} // ctrl + f11
	
	//@Test
	@Ignore
	public void test2() {
		MyArea area1 = context.getBean("myArea",MyArea.class);
		MyArea area2 = context.getBean("myArea",MyArea.class);
		//��� ��� 2 : assertSame(area1,area2);
		assertSame(area1,area2);
	}
}
