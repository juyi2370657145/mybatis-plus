package connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;

import com.atcaibinwei.mp.bean.Employee;
import com.atcaibinwei.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

public class TestMp {
	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	private final EmployeeMapper  employeeMapper= context.getBean(EmployeeMapper.class);

	@Test
	public void testDelete() {
		//和update类似
		Integer integer = employeeMapper.deleteById(7);
		System.out.println(integer);
	}

	@Test
	public void testEntityWrapperSelect() {
		List<Employee> employeeList = employeeMapper.selectPage(
				new Page<>(1, 2),
				new EntityWrapper<Employee>()
						.between("age", 18, 50)
						.eq("gender", 1)
						.like("last_name", "test")
				);
		System.out.println(employeeList);
	}

	@Test
	public void testSelect() {
		//通过id查询
		//Employee employee = employeeMapper.selectById(5);

		//同过筛选条件查询
//		Employee employee = new Employee();
//		employee.setLastName("caibinwei");
//		employee.setId(6);
//		Employee employee1 = employeeMapper.selectOne(employee);

		//通过id list查询一系列数据
//		List<Integer> ids = new ArrayList<>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(3);
//		ids.add(4);
//		ids.add(5);
//		ids.add(5);
//		List<Employee> employees = employeeMapper.selectBatchIds(ids);

		//通过map<字段名，字段值> 筛选数据，返回list
//		Map<String, Object> map = new HashMap<>();
//		map.put("last_name", "caibinwei");
//		map.put("id", 7);
//		List<Employee> employees = employeeMapper.selectByMap(map);
//		System.out.println(employees);

		//分页查询
		List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 2), null);
		System.out.println(employees);

	}

	@Test
	public void testCommonUpdate() {
		Employee employee = new Employee("caibinweiChange", "email", 0, 100);
		employee.setId(5);

		Integer integer = employeeMapper.updateById(employee);
		System.out.println(integer);
	}

	@Test
	public void testCommonInsert() {
		Employee employee = new Employee("caibinwei", "email", 1, 22);
		Integer insert = employeeMapper.insert(employee);
		System.out.println(insert);
		System.out.println(employee.getId());
	}

	@Test
	public void testDateSource() {
		DataSource ds = context.getBean(DataSource.class);
		System.out.println(ds.toString());
		try {
			Connection connection = ds.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
