package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/add-form")
	public String employeeForm() {
		return "Add-Employee";
	}
	
	

}
