package com.psk.springboot.thymeleafdemo.service;

import java.util.List;

import com.psk.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeServiceInterface {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

	

}
