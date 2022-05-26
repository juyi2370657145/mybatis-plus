package connect;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atcaibinwei.mp.bean.Employee;

public class TestMpAr {

	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	/**
	 * 测试AR插入
	 */
	@Test
	public void testARInsert() {
		Employee employee = new Employee();
		employee.setLastName("arTest");
		employee.setEmail("ar@qq.com");
		employee.setGender(1);
		employee.setAge(45);

		boolean re = employee.insert();
		System.out.printf("re:" + re);
	}
}
