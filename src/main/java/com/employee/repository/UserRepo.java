package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.entity.User;


public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
