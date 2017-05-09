package com.pivotal.employees;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {
	protected EmployeeRepository employeeRepository;
	
	

	@Autowired
	public EmployeesController(EmployeeRepository employeeRepository) throws IOException, TimeoutException{
		this.employeeRepository = employeeRepository;
	}
	@RequestMapping("/EmployeesHome")
	public String employeesHome(){
		return "Welcome to employees home page";
	}
	
	@RequestMapping("/FetchEmployees")
	public List<Employee> fetchEmployee(){
		List<Employee> employee = null;
		return employeeRepository.findAll();
		
	}
}
