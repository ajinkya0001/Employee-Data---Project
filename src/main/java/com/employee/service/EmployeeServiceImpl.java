package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepo empRepo;
	
	@Override
	public void saveEmployee(Employee employee) {
		if(employee!=null) {
			empRepo.save(employee);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return empRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployee(int id) {
		
		empRepo.deleteById(id);
		
	}
	
	@Override
	public List<Employee> searchEmployees(String name, String desg) {
	    return empRepo.searchEmployees(name, desg);
	}

}


