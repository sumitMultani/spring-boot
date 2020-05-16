package com.example.StudentCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentCRUD.dao.StudentRepository;
import com.example.StudentCRUD.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public Student addStudent(Student student) {
		return repository.save(student);
	}

	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	public Student updateStudent(Long id, Student request) {
		Student student = repository.findById(id).orElse(null);
		if(student != null) {
			student.setCity(request.getCity());
			student.setName(request.getName());
		}
		return  repository.save(student);
	}

	public Student deleteStudent(Long id) {
		repository.deleteById(id);
		return null;
	}

}
