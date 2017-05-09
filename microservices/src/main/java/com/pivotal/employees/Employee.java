package com.pivotal.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="T_EMPLOYEE")
public class Employee {
	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;
	
	@Id
	private Long id;
	private String fname;
	private String lname;
	private String emailid;
	
	public Employee(){
		
	}
	
	public Employee(String fname, String lname, String emailid) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.emailid = emailid;
	}
	
	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
}
