package com.demo.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.demo.neo4j.model.Company;

public interface CompanyRepository extends Neo4jRepository<Company,Long>{

}
