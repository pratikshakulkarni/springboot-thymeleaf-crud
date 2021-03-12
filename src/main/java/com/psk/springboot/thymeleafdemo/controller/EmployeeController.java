	package com.psk.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psk.springboot.thymeleafdemo.entity.Employee;
import com.psk.springboot.thymeleafdemo.service.EmployeeServiceInterface;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeServiceInterface empService;
	
	public EmployeeController(EmployeeServiceInterface empService) {
		this.empService = empService;
	}
	
	
	@GetMapping("/list")
	public String ListEmp(Model theModel) {
		
		List<Employee> theEmp = empService.findAll();
		
		theModel.addAttribute("employees",theEmp);
		
		return "employees/list-emp";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		System.out.println("in showAddFrom");
		Employee emp = new Employee();
		
		theModel.addAttribute("employee", emp);
		
		
		return "employees/empForm";
	}
	
	//Save
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee emp) {
		
		empService.save(emp);
		
		return "redirect:/employees/list";
	}
	
	//Update
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int id, Model theModel) {
		
		//Get Emp from the db
		Employee emp = empService.findById(id);
		
		theModel.addAttribute("employee",emp);
		
		return "employees/empForm";	
	}
	
	//Delete
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		
		empService.deleteById(id);
		
		return "redirect:/employees/list";
			
	}
	
}

