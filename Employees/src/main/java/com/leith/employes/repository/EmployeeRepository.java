package com.leith.employes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.leith.employes.models.Employee;
import com.leith.employes.models.Poste;
@RepositoryRestResource(path = "rest")
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
  List<Employee>findByNomEmploye(String nom);
  List<Employee>findByNomEmployeContains(String nom);
  @Query("select e from Employee e where e.nomEmploye like %:nom and e.domaine > :domaine")
  List<Employee> findByNomDomaine (@Param("nom") String nom,@Param("domaine") String domaine);
  
  @Query("select e from Employee e where e.poste = ?1")
  List<Employee> findByPoste (Poste poste);
  
  List<Employee> findByPosteIdPoste(Long id);
  
  List<Employee> findByOrderByNomEmployeAsc();
  
  @Query("select e from Employee e order by e.nomEmploye ASC, e.domaine DESC")
  List<Employee> trierEmployesNomsDomaine ();
  
  @Query("select e from Employee  e where e.poste.nomPoste like ?1")
	 List<Employee> findByNomPosteContains(String nom);
}
