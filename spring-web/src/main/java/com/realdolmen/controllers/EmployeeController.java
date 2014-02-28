package com.realdolmen.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realdolmen.dao.EmployeeDAO;
import com.realdolmen.domain.Employee;
import com.realdolmen.services.CalculatorService;

/**
 * http://localhost:8080/SpringMVC/employee
 * 
 * @author Marco Brasci
 * 
 */
@Controller
public class EmployeeController extends AbstractController{
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	public static final String BASE = "/employee";
	
	/**
	 * URL's
	 */
	public static final String URL_TEST = BASE + "/test";
	public static final String URL_ADD = BASE + "/addEmployee";
	public static final String URL_REMOVE = BASE + "/removeEmployee";
	public static final String URL_REMOVE_ALL = BASE + "/removeAllEmployees";
	public static final String URL_EDIT = BASE + "/edit";
	public static final String URL_PROCESS = BASE + "/process";
	public static final String URL_LIST = BASE + "/list";
	public static final String URL_LIST_JSON = BASE + "/json/list";
	
	/**
	 * Pages
	 */
	public static final String PAGE_REDIRECT = "redirect:/";
	public static final String PAGE_TEST = "employee/test";
	public static final String PAGE_EDIT = "employee/editEmployee";
	public static final String PAGE_LIST = "employee/list";
	

	@Autowired
	private CalculatorService calculatorService;

	@Autowired
	private EmployeeDAO employeeDAO;
	

	
	/**
	 * http://localhost:8080/SpringMVC/employee/test
	 * @param model
	 * @return
	 */
	@RequestMapping(value = URL_TEST, method = RequestMethod.GET)
	public String testEmployee(Model model) {
		return PAGE_TEST;
	}
	
	@RequestMapping(value = URL_LIST, method = RequestMethod.GET)
	public String employeeList(Model model) {
		
		return PAGE_LIST;
	}
	
    @RequestMapping(value = URL_ADD, method = RequestMethod.POST)
    public @ResponseBody void addTrain(@RequestBody Employee employee) {
    	employeeDAO.create(employee);
    	LOGGER.info("Employee created");
    }
    @RequestMapping(value = URL_REMOVE, method = RequestMethod.POST)
    public @ResponseBody void removeEmployee(@RequestBody long id) {
    	employeeDAO.removeEmployee(id);
    }
    @RequestMapping(value = URL_REMOVE_ALL, method = RequestMethod.POST)
    public @ResponseBody int removeAllEmployees() {
    	int deletedRecords = employeeDAO.removeAllEmployees();
    	return deletedRecords;
    }


	/**
	 * http://localhost:8080/SpringMVC/employee/list
	 * @param model
	 * @return
	 */
	@RequestMapping(value = URL_LIST_JSON, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployeeJsonList(Model model) {

		List<Employee> employees = employeeDAO.findAll();

		model.addAttribute("employees", employees);
		LOGGER.info("Employees found: {}", employees.size());
		
		return employees;
	}

}