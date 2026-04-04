package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Id;


@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	private String employeeName;
	private String desg;
	private int age;
	private double salary;
	private String address;
	
	
}
