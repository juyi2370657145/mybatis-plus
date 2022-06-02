package connect;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atcaibinwei.mp.bean.Employee;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

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

	@Test
	public void testARSelect() {
		Employee employee = new Employee();

		employee = employee.selectById(2);
		System.out.println(employee);

		List<Employee> employees = employee.selectAll();
		System.out.println(employees);

		List<Employee> employees1 = employee.selectList(new EntityWrapper<Employee>().like("last_name", "test"));
		System.out.println(employees1);

		int gender = employee.selectCount(new EntityWrapper().like("gender", "0"));
		System.out.println(gender);

	}

	@Test
	public void testARPage() {
		Employee employee = new Employee();
		Page<Employee> employeePage = employee.selectPage(new Page<>(1, 2), new EntityWrapper<Employee>());
		System.out.println(employeePage);
		System.out.println(employeePage.getRecords());


	}
}
