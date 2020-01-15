package com.gain.java.knowledge.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gain.java.knowledge.EmployeeService;
import com.gain.java.knowledge.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
}
