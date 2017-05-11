package com.pivotal.services.web;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pivotal.employees.Employee;
import com.pivotal.employees.EmployeeRepository;

@Component
public class EmployeesServiceFeignClientFallback implements EmployeesServiceFeignClient{	
	@Override
	public List<Employee> getEmployees() {
		System.out.println("Calling fallback method");
		return null;
	}

}
