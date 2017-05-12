package com.pivotal.services.web;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pivotal.employees.Employee;
import com.pivotal.employees.EmployeeRepository;

@Component
public class EmployeesServiceFeignClientFallback implements EmployeesServiceFeignClient{	
	@Override
	public List<Employee> fetchEmployees() {
		System.out.println("Calling fallback method for fetchEmployee");
		return null;
	}

	@Override
	public EmployeeDto getEmployee(long id) {
		System.out.println("Calling fallback method for getEmployee");
		EmployeeDto ed = new EmployeeDto();
		ed.setId(0L);
		ed.setFname("NULL");
		ed.setLname("NULL");
		ed.setEmailid("NULL");
		
		return ed;
	}

	@Override
	public String employeeHome() {
		// TODO Auto-generated method stub
		return "Unable to connect with employee service";
	}
	
	
	

}
