package com.employee.service;

import com.employee.entity.Employee;
import java.util.List;


public interface EmployeeService {
	
	void saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	void deleteEmployee(int id);
}
