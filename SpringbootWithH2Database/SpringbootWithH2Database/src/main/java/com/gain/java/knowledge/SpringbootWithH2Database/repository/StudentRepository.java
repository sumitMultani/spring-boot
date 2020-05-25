package com.gain.java.knowledge.SpringbootWithH2Database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gain.java.knowledge.SpringbootWithH2Database.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
