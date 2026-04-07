package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	
	

	@Query("SELECT e FROM Employee e WHERE " +
	       "(:name IS NULL OR LOWER(e.employeeName) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
	       "(:desg IS NULL OR e.desg = :desg)")
	List<Employee> searchEmployees(@Param("name") String name,
	                               @Param("desg") String desg);
	
}
