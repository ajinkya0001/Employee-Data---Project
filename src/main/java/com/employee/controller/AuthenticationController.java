package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.employee.entity.Employee;
import com.employee.entity.User;
import com.employee.repository.UserRepo;
import com.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
//@RequestMapping("/employee")
public class AuthenticationController {

	@Autowired
	private UserRepo userRepo;
	

	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/")
	public String homePage() {
	    return "index";
	}
	
	
	@GetMapping("/signup")
	public String signupPage() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute User user) {
		user.setRole("USER");
		userRepo.save(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username,
			@RequestParam String password, Model model) {
		
		User user = userRepo.findByUsername(username);
		if(user!=null && user.getPassword().equals(password)) {
			if(user.getRole().equals("ADMIN")) {
				return "redirect:/employee/";
			}else {
				return "redirect:/user/dashboard";
			}
		}
		
		model.addAttribute("error", "Invalid Credentials");
		return "login";
		
	}
	
	
	@GetMapping("/user/dashboard")
	public String userDashboard() {
		return "user-dashboard";
	}
	
	 @PostMapping("/user/add-employee")
	    public String addEmployeeByUser(@ModelAttribute Employee employee) {

	        empService.saveEmployee(employee);
	        return "redirect:/user/dashboard";
	 }
	
	
}
