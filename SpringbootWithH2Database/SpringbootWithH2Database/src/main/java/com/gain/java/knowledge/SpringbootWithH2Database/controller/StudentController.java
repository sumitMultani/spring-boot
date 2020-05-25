package com.gain.java.knowledge.SpringbootWithH2Database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gain.java.knowledge.SpringbootWithH2Database.model.Student;
import com.gain.java.knowledge.SpringbootWithH2Database.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@GetMapping
	public List<Student> getAllStudent(){
		return repository.findAll();
	}
	
}
