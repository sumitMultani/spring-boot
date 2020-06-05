package com.gain.java.knowledge.SpringBootCache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "city", nullable = false)
	private String city;

	public Student() {
		super();
	}

	public Student(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	 

}
