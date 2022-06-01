package com.leith.employes;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.leith.employes.models.Employee;
import com.leith.employes.models.Poste;
import com.leith.employes.repository.EmployeeRepository;
import com.leith.employes.service.EmployeeService;

@SpringBootTest
class EmployeesApplicationTests {
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private EmployeeService employeeService;
	@Test
	public void testCreateEmploye() {
		Employee emp=new Employee("Leith Kassous","Business Intelligence",new Date(),new Poste());
		employeeRepository.save(emp);
	}
	@Test
	public void testFindEmployee()
	{
	Employee e = employeeRepository.findById(1L).get();

	System.out.println(e);
	}
	@Test
	public void testUpdateEmployee()
	{
	Employee e = employeeRepository.findById(1L).get();
	e.setDomaine("Technology Informatique");
	employeeRepository.save(e);
	}
	@Test
	public void testDeleteEmployee()
	{
	employeeRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousEmployees()
	{
	List<Employee> prods = employeeRepository.findAll();
	for (Employee p : prods)
	{
	System.out.println(p);
	}

}
	@Test
	public void testFindByNomEmployeContains()
	{
	Page<Employee> emps = employeeService.getAllEmployeesParPage(0, 2);
	System.out.println(emps.getSize());
	System.out.println(emps.getTotalElements());


	System.out.println(emps.getTotalPages());
	emps.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Employee e : emps)
	{
	System.out.println(e);
	} */
	}
	@Test
	public void testFindByNomProduit()
	{
	List<Employee> emps = employeeRepository.findByNomEmploye("Leith Kassous");

	for (Employee e : emps)
	{
	System.out.println(e);
	}

	}
	@Test
	public void testFindByNomProduitContains ()
	{
	List<Employee> emps=employeeRepository.findByNomEmployeContains("Safa Kassous");

	for (Employee e : emps)
	{
	System.out.println(e);
	} }
	@Test
	public void testfindByNomDomaine()
	{
	List<Employee> emps = employeeRepository.findByNomDomaine("Leith Kassous", "Technology Informatique");
	for (Employee e : emps)
	{
	System.out.println(e);
	}

	}
	@Test
	public void testfindByPoste()
	{
	Poste pos = new Poste();
	pos.setIdPoste(1L);;

	List<Employee> emps = employeeRepository.findByPoste(pos);
	for (Employee e : emps)
	{
	System.out.println(e);
	}

	}
	@Test
	public void findByPosteIdPoste()
	{
	List<Employee> emps = employeeRepository.findByPosteIdPoste(1L);
	for (Employee e : emps)
	{
	System.out.println(e);
	}

	}
	@Test
	public void testfindByOrderByNomEmployeAsc()
	{
	List<Employee> emps =

	employeeRepository.findByOrderByNomEmployeAsc();
	for (Employee e : emps)
	{
	System.out.println(e);
	}

	}
	@Test
	public void testTrierEmployesNomsDomaine()
	{
	List<Employee> emps = employeeRepository.trierEmployesNomsDomaine();
	for (Employee e : emps)
	{
	System.out.println(e);
	}

	}

}
