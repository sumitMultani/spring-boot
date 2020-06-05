package com.gain.java.knowledge.SpringBootCache.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gain.java.knowledge.SpringBootCache.dao.StudentDAO;
import com.gain.java.knowledge.SpringBootCache.model.Student;

@Service
@CacheConfig(cacheNames = "studentCache")
public class StudentService {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentDAO dao;
	
	@CachePut(cacheNames = "studentCache", key="#student.id")
	public Student save(Student student){
		logger.info("[service]: [save] hitting to DB." );
		return dao.save(student);
	}
	
	@Cacheable(cacheNames = "studentCache", key="#id")
	public Student getStudentById(Long id) {
		logger.info("[service]: [getStudentById] fetching from DB, id : " +id);
		return dao.findById(id).get();
	}
	
	@CachePut(cacheNames = "studentCache", key="#id")
	public Student update(Student request, Long id) {
		logger.info("[service]: [update] hitting to DB.");
		Student student = dao.findById(id).get();
		student.setName(request.getName());
		student.setCity(request.getCity());
		return dao.save(student);
	}
	
	@CacheEvict(cacheNames = "studentCache", key="#id")
	public void deleteById(Long id) {
		logger.info("[service]: [deleteById] DB interaction." );
		dao.deleteById(id);
	}
	
	@Cacheable(cacheNames = "studentCache")
	public List<Student> getAllStudent() {
		logger.info("[service]:[getAllStudent] fetching from DB." );
		return dao.findAll();
	}
	 
}
