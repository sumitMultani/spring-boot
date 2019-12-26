package com.demo.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.demo.neo4j.model.Person;

public interface PersonRepository extends Neo4jRepository<Person,Long>{

}
