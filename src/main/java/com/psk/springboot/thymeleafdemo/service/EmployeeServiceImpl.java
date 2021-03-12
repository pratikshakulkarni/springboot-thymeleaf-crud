package com.psk.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psk.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.psk.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	//Inject DAO
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo=employeeRepo;
	}

	@Override
	public void deleteById(int id) {
		 employeeRepo.deleteById(id);
	}

	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);		
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
			Optional<Employee> result = employeeRepo.findById(id);
			
			Employee theEmployee = null;
			
			if (result.isPresent()) {
				theEmployee = result.get();
			}
			else {
				// we didn't find the employee
				throw new RuntimeException("Did not find employee id - " + id);
			}
			
			return theEmployee;
		
	}
	
	
}
