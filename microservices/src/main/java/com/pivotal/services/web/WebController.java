package com.pivotal.services.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pivotal.employees.Employee;

@RestController
public class WebController {
	@Autowired
	private EmployeesServiceFeignClient esfc;
	
	@RequestMapping(value = "/welcomeDefault")
	public String welcomeScreenDefault(){
		return "Welcome to Web service default welcome screen";
	}
	
	@RequestMapping(value = "/fetchEmps")
	public List<Employee> fetchEmps(){
		List<Employee> e = esfc.getEmployees();
		return e;
	}
}
