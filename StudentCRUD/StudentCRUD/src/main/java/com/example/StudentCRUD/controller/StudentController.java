package com.example.StudentCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentCRUD.entity.Student;
import com.example.StudentCRUD.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/student")
	private Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@GetMapping("/students")
	private List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@PutMapping("/student/{id}")
	private Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return service.updateStudent(id, student);
	}
	
	@DeleteMapping("/delete/student/{id}")
	private Student deleteStudent(@PathVariable Long id) {
		return service.deleteStudent(id);
	}
}
