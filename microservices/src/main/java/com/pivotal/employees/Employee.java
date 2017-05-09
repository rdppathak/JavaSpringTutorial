package com.pivotal.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="T_EMPLOYEE")
public class Employee {
	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;
	@Id
	private Long id;
	private String fname;
	private String lname;
	private String emailid;	
}
