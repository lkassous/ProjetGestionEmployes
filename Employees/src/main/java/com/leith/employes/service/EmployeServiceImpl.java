package com.leith.employes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.leith.employes.models.Employee;
import com.leith.employes.models.Poste;
import com.leith.employes.repository.EmployeeRepository;
import com.leith.employes.repository.PosteRepository;

@Service
public class EmployeServiceImpl implements EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;
  @Autowired
  PosteRepository posteRepository;
@Override
public Employee saveEmployee(Employee e) {
	// TODO Auto-generated method stub
	return employeeRepository.save(e);
}

@Override
public Employee updateEmployee(Employee e) {
	// TODO Auto-generated method stub
	return employeeRepository.save(e);
}

@Override
public void deleteEmployee(Employee e) {
	// TODO Auto-generated method stub
	employeeRepository.delete(e);
	
}

@Override
public void deleteEmployeeById(Long id) {
	// TODO Auto-generated method stub
	employeeRepository.deleteById(id);
}

@Override
public Employee getEmployee(Long id) {
	// TODO Auto-generated method stub
	return employeeRepository.findById(id).get();
}

@Override
public List<Employee> getAllEmployees() {
	
	return employeeRepository.findAll();
}

@Override
public Page<Employee> getAllEmployeesParPage(int page, int size) {
	return employeeRepository.findAll(PageRequest.of(page, size));
}

@Override
public List<Employee> findByNomEmploye(String nom) {
	// TODO Auto-generated method stub
	return employeeRepository.findByNomEmploye(nom);
}

@Override
public List<Employee> findByNomEmployesContains(String nom) {
	// TODO Auto-generated method stub
	return employeeRepository.findByNomEmployeContains(nom);
}

@Override
public List<Employee> findByNomDomaine(String nom, String domaine) {
	// TODO Auto-generated method stub
	return employeeRepository.findByNomDomaine(nom, domaine);
}

@Override
public List<Employee> findByPoste(Poste poste) {
	// TODO Auto-generated method stub
	return employeeRepository.findByPoste(poste);
}

@Override
public List<Employee> findByPosteIdPoste(Long id) {
	// TODO Auto-generated method stub
	return employeeRepository.findByPosteIdPoste(id);
}

@Override
public List<Employee> findByOrderByNomEmployeAsc() {
	// TODO Auto-generated method stub
	return employeeRepository.findByOrderByNomEmployeAsc();
}

@Override
public List<Employee> trierEmployesNomsDomaine() {
	// TODO Auto-generated method stub
	return employeeRepository.trierEmployesNomsDomaine();
}

@Override
public List<Poste> getAllPostes() {
	return posteRepository.findAll();
}

@Override
public List<Employee> findByNomPosteContains(String nom) {
	return employeeRepository.findByNomPosteContains(nom);
}


  
}
