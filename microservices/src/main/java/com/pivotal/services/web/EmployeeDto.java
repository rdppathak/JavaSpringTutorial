package com.pivotal.services.web;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("Account")
public class EmployeeDto {
	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;
	private Long id;
	private String fname;
	private String lname;
	private String emailid;
}