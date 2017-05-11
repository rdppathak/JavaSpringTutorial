package com.pivotal.services.web;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pivotal.employees.Employee;

@FeignClient(value = "employee-service", fallback = EmployeesServiceFeignClientFallback.class)
public interface EmployeesServiceFeignClient{
	@RequestMapping(value = "/FetchEmployees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> getEmployees();
}
