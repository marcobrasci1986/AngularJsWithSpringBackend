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
public class ApplicationController extends AbstractController{
	private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);


	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String firstPage(Model model) {	
		return "app/index";
	}
	
	@RequestMapping(value = "/partials/partial1", method = RequestMethod.GET)
	public String partial1(Model model) {	
		return "app/partials/partial1";
	}
	@RequestMapping(value = "/partials/partial2", method = RequestMethod.GET)
	public String partial2(Model model) {	
		return "app/partials/partial2";
	}

}