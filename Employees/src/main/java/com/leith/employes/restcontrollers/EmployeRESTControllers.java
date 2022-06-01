package com.leith.employes.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leith.employes.models.Employee;
import com.leith.employes.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeRESTControllers {
	@Autowired
	EmployeeService employeeService;
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> getAllEmployes(){
		return employeeService.getAllEmployees();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Employee getEmployeById(@PathVariable("id") Long id) {
	return employeeService.getEmployee(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public Employee createEmploye(@RequestBody Employee employe) {
	return employeeService.saveEmployee(employe);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Employee updateEmploye(@RequestBody Employee employe) {
	return employeeService.updateEmployee(employe);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEmploye(@PathVariable("id") Long id)
	{
	employeeService.deleteEmployeeById(id);
	}
	@RequestMapping(value="/empspos/{idPoste}",method = RequestMethod.GET)
	public List<Employee> getEmployesByPosteId(@PathVariable("idPoste") Long idPoste) {
	return employeeService.findByPosteIdPoste(idPoste);
	}
}
