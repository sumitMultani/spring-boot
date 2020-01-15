package com.gain.java.knowledge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gain.java.knowledge.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getEmployees() {
		 return repository.getEmployees();
	}

}
