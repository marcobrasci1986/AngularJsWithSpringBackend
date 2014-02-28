package com.realdolmen.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@NamedQueries({ 
	@NamedQuery(name = Employee.NQ_GET_EMPLOYEE_BY_NAME, query = "SELECT e FROM Employee e where e.name LIKE :name"), 
	@NamedQuery(name = Employee.NQ_REMOVE_EMPLOYEES_BY_ID, query = "SELECT e FROM Employee e where e.name LIKE :name")
	
})
public class Employee extends AbstractEntity {

	public static final String NQ_GET_EMPLOYEE_BY_NAME = "Employee.getEmployeeByName";
	public static final String NQ_REMOVE_EMPLOYEES_BY_ID = "Employee.removeEmployeeById";

	@Size(min = 3, max = 20, message = "{error.name}")
	private String name;
	@Min(value = 20)
	// , message="Employee must be at least 20 years old."
	private int age;

	@Email(message = "Invalid email address.")
	private String email;
	private Date birthDate;

	public Employee() {
	}

	public Employee(String name, int age, Date birthDate) {
		super();
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
