package com.pivotal.services.web;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pivotal.employees.Employee;

@RestController
public class WebController {
	@Autowired
	private EmployeesServiceFeignClient esfc;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping(value = "/welcomeDefault")
	public String welcomeScreenDefault(){
		return "Welcome to Web service default welcome screen";
	}
	
//	@RequestMapping(value = "/addEmployee")
//	public void addEmployee(@RequestBody EmployeeDto employeeDto){
//		
//	}
	
	@RequestMapping(value = "/getEmployee")
	public EmployeeDto getEmployee(@RequestParam long id){
		EmployeeDto ed = null;
		System.out.println("Received id: "+ id);
		ed = modelMapper.map(esfc.getEmployee(id), EmployeeDto.class);
		return ed;
	}
	
	@RequestMapping(value = "/fetchEmployees")
	public List<Employee> fetchEmployees(){
		List<Employee> e = esfc.fetchEmployees();
		return e;
	}
	
	@RequestMapping(value="/employeeHome")
	public String employeeHome(){
		return esfc.employeeHome();
	}
}
