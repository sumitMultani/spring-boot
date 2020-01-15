package com.gain.java.knowledge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gain.java.knowledge.model.Employee;

@Repository
public class EmployeeRepository {

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Ravi","GAIN JAVA KNOWLEDGE"));
		employees.add(new Employee(1, "vivek","GAIN JAVA KNOWLEDGE"));
		employees.add(new Employee(1, "teja","GAIN JAVA KNOWLEDGE"));
		employees.add(new Employee(1, "mohan","GAIN JAVA KNOWLEDGE"));
		employees.add(new Employee(1, "karan","GAIN JAVA KNOWLEDGE"));
		return employees;
	}

}
