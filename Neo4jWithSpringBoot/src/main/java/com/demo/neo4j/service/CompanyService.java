package com.demo.neo4j.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.neo4j.model.Company;
import com.demo.neo4j.model.Person;
import com.demo.neo4j.repository.CompanyRepository;
import com.demo.neo4j.repository.PersonRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired PersonRepository personRepository;
	
	public List<Company> getCompanies() {
		return (List<Company>) companyRepository.findAll();
	}

	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}

	public Company deleteCompany(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		companyRepository.deleteById(id);
		Set<Person> persons = company.get().getPersons();
		persons.forEach(person -> {
			personRepository.deleteById(person.getEntityId());
		});
		return company.get();

	}

	public Company getCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		return company.get();
	}

	public Company updateCompany(Long id, Company company) {
		Optional<Company> companyOpt = companyRepository.findById(id);
		Company companyEntity = companyOpt.get();
		updateCompanyEntity(company, companyEntity);
		return companyRepository.save(companyEntity);
	}

	private void updateCompanyEntity(Company request, Company companyEntity) {
		if(request.getName() != null && !request.getName().isEmpty())
			companyEntity.setName(request.getName());
		if(request.getLocation() != null && !request.getLocation().isEmpty())
			companyEntity.setLocation(request.getLocation());
		if(request.getPersons() != null && !request.getPersons().isEmpty()){
			Set<Person> persons = new HashSet<>();
			persons.addAll(companyEntity.getPersons());
			persons.addAll(request.getPersons());
			companyEntity.setPersons(persons);
		}
	}

}
