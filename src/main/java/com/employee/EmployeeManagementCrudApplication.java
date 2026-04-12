package com.employee;

import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.net.URI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementCrudApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner openBrowser() {
	    return args -> {
	        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://localhost:8080/");
	    };
	}

}
