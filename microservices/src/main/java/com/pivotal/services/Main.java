package com.pivotal.services;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.pivotal.services.employee.EmployeeService;
import com.pivotal.services.registration.RegistrationService;
import com.pivotal.services.web.WebService;

public class Main {
	public static void main(String args[]) throws IOException, TimeoutException{
		System.out.println("Initialzing main class");
		String serviceName = "NO_SERVICE";
		serviceName = args[0].toLowerCase();
		if (serviceName.equals("registration-service")){
			System.out.println("Initializing registration service");
			RegistrationService.main(args);
		} else if(serviceName.equals("employee-service")) {
			System.out.println("Initializing employee service");
			EmployeeService.main(args);
		}else if(serviceName.equals("web-service")){
			System.out.println("Initializing web service");
			WebService.main(args);
		}
		else{
			System.out.println("Invalid service input found");
		}
			
	}
}
