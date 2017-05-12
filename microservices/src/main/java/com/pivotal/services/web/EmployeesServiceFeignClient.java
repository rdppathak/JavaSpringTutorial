package com.pivotal.services.web;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pivotal.employees.Employee;

import feign.Param;

@FeignClient(value = "employee-service", fallback = EmployeesServiceFeignClientFallback.class)
public interface EmployeesServiceFeignClient{
	@RequestMapping(value = "/FetchEmployees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> fetchEmployees();
	
	@RequestMapping(value="/GetEmployee",method = RequestMethod.GET,  produces="application/json")
	public EmployeeDto getEmployee(@RequestParam(name="id") long id);
	
	@RequestMapping(value="/EmployeesHome", method=RequestMethod.GET, produces="application/json")
	public String employeeHome();
}
