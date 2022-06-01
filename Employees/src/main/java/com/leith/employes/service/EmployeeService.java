package com.leith.employes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.leith.employes.models.Employee;
import com.leith.employes.models.Poste;

public interface EmployeeService {
	Employee saveEmployee(Employee e);
	Employee updateEmployee(Employee e);
	void deleteEmployee(Employee e);
	void deleteEmployeeById(Long id);
	Employee getEmployee(Long id);
	List<Employee> getAllEmployees();
	 List<Poste> getAllPostes();

	
	Page<Employee> getAllEmployeesParPage(int page, int size);
	List<Employee> findByNomEmploye(String nom);
	List<Employee> findByNomEmployesContains(String nom);
	List<Employee> findByNomDomaine (String nom, String domaine);
	 List<Employee> findByPoste (Poste poste);
	List<Employee> findByPosteIdPoste(Long id);
	List<Employee> findByOrderByNomEmployeAsc();
	List<Employee> trierEmployesNomsDomaine();
	List<Employee> findByNomPosteContains (String nom);

}
