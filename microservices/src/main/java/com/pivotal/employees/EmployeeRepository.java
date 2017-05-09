package com.pivotal.employees;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Employee findById(Long id);
	
	public List<Employee> findByFname(String fname);
}
