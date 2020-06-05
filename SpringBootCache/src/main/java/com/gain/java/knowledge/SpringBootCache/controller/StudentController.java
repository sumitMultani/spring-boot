package com.gain.java.knowledge.SpringBootCache.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gain.java.knowledge.SpringBootCache.model.Student;
import com.gain.java.knowledge.SpringBootCache.service.StudentService;

@RestController
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService service;
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		logger.info("[controller] [getStudentById] Enter : ");
		return service.getStudentById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		logger.info("[controller] [deleteById]  studentId= "+id);
		service.deleteById(id);
	}
	
	@PutMapping("/updateById/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
		logger.info("[controller] [saveStudent]  saveStudent= "+student);
		return service.update(student, id);
	}
	
	@PostMapping("/save")
	public Student addStudent(@RequestBody Student student) {
		logger.info("[controller] [saveStudent]  saveStudent= "+student);
		return service.save(student);
	}
	
	@GetMapping("/")
	public List<Student> getAllStudent() {
		logger.info("[controller] [getAllStudent] Enter : ");
		return service.getAllStudent();
	}
	 
}
