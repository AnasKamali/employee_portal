package com.precedence.timesheet.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.precedence.timesheet.Employee;

@RestController
public class RestControllerExmple {

	@GetMapping("/rest")
	public Employee restExample() {
		Employee employee = new Employee();
		employee.setUserName("Anas Kamali");
		employee.setPassword("adfasdf");
		return employee;
	}

}
