package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import com.employee.service.EmployeeService;
import com.employee.EmployeeManagementCrudApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.employee.entity.Employee;
import java.util.List;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

//    private final EmployeeManagementCrudApplication employeeManagementCrudApplication;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/add-form")
	public String employeeForm() {
		return "Add-Employee";
	}
	
	@PostMapping("/add")
	public String addEvent(@ModelAttribute Employee employee) {
		
		empService.saveEmployee(employee);
		return "redirect:/employee/view-employees";
		
	}
	
	@GetMapping("/view-employees")
	public String viewEmployees(Model model) {
		List<Employee> elist = empService.getAllEmployees();
		
		model.addAttribute("employeeList", elist);
		return "View-Employees";
	}
	
	
	@GetMapping("/edit/{id}")
	public String getEditForm(@PathVariable int id, Model model) { // Path variable get mapping into local variable  @PathVariable("id")
		Employee existingEmployee = empService.getEmployeeById(id);  // existing event
		model.addAttribute("employee", existingEmployee);
		return "Edit-Form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable int id ) {
		empService.deleteEmployee(id);
		return "redirect:/event/view-employees";
	}
	
	@GetMapping("/")
	public String home() {
		return "Home";
	}

	@GetMapping("/search")
	public String searchEmployees(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String desg,
			Model model) {

		List<Employee> list = empService.searchEmployees(name, desg);
		model.addAttribute("employeeList", list);
		
		return "View-Employees";
	}
}
