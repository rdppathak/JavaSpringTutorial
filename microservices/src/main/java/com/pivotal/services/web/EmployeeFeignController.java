package com.pivotal.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeFeignController {
	
	@RequestMapping(value = "/welcome")
	public String welcomeScreenWebService(){
		return "Welcome to Web Service HomeScreen";
	}
}
