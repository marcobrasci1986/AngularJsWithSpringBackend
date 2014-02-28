package com.realdolmen.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.realdolmen.domain.Employee;

@Service
public class EmployeeDAO extends AbstractDAO<Long, Employee> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * be.realdolmen.dao.EmployeeInterface#findEmployeesByName(java.lang.String)
	 */
	public List<Employee> findEmployeesByName(String name) {
		List<Employee> employees = em.createNamedQuery(Employee.NQ_GET_EMPLOYEE_BY_NAME, Employee.class).setParameter("name", name).getResultList();
		return employees;
	}

	public int removeAllEmployees() {
		int result = em.createNativeQuery("DELETE FROM Employee").executeUpdate();
		return result;
	}
	
	public void removeEmployee(long id) {	
		Employee employee = em.find(Employee.class, id);
		this.delete(employee);
	}

}
