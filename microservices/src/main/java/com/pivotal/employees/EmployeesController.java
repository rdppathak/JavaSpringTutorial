package com.pivotal.employees;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {
	protected EmployeeRepository employeeRepository;

	@Autowired
	public EmployeesController(EmployeeRepository employeeRepository) throws IOException, TimeoutException{
		this.employeeRepository = employeeRepository;
	}
	@RequestMapping(value = "/EmployeesHome")
	public String employeesHome(){
		return "Welcome to employees home page";
	}
	
	@RequestMapping("/FetchEmployees")
	public List<Employee> fetchEmployee(){
		List<Employee> employee = null;
		return employeeRepository.findAll();
		
	}
	
	@RequestMapping("/GetEmployee")
	public Employee getEmployee(@RequestParam long id){
		Employee e = null;
		e = employeeRepository.findById(id);
		return e;
	}
}
