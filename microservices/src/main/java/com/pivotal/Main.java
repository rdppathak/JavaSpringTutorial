package com.pivotal;

import com.pivotal.services.employee.EmployeeService;
import com.pivotal.services.registration.RegistrationService;

public class Main {
	public static void main(String args[]){
		System.out.println("Initialzing main class");
		String serviceName = "NO_SERVICE";
		serviceName = args[0].toLowerCase();
		if (serviceName.equals("registration-service")){
			System.out.println("Initializing registration service");
			RegistrationService.main(args);
		} else if(serviceName.equals("employee-service")) {
			System.out.println("Initializing employee service");
			EmployeeService.main(args);
		}else{
			System.out.println("Invalid service input found");
		}
	}
}
