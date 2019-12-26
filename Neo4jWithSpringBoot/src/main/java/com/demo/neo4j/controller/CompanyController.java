package com.demo.neo4j.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.neo4j.model.Company;
import com.demo.neo4j.service.CompanyService;

@RestController
@RequestMapping(value="/api/company")
public class CompanyController {

	@Autowired
	private CompanyService service;
	

	@GetMapping
	private List<Company> getAllCompany(){
		return service.getCompanies();
	}

	@GetMapping("/{id}")
	private Company getCompanyById(@PathVariable Long id){
		return service.getCompanyById(id);
	}
	
	@PostMapping
	private Company saveCompany(@RequestBody Company company){
		return service.saveCompany(company);
	}
	
	@PatchMapping("/{id}")
	private Company updateCompany(@PathVariable Long id, @RequestBody Company company){
		return service.updateCompany(id, company);
	}
	
	@DeleteMapping("/{id}")
	private Company deleteCompany(@PathVariable Long id){
		return service.deleteCompany(id);
	}
}
