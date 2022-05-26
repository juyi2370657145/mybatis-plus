package com.atcaibinwei.mp.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * Employee实体类
 *
 * mybatis-plus会自动去找对类名对应的表名
 */
@TableName(value = "tbl_employee")
public class Employee extends Model<Employee> {
	/**
	 * mybatis-plus 默认会注入全部属性，对主键需要添加@TableId注解并赋上主键类型
	 */
	//@TableId(type = IdType.AUTO)
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender;
	private Integer age;

	public Employee() {
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Employee(String lastName, String email, Integer gender, Integer age) {
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", age=" + age +
				'}';
	}
}
