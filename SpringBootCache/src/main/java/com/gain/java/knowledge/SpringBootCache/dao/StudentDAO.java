package com.gain.java.knowledge.SpringBootCache.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gain.java.knowledge.SpringBootCache.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long>{

}
