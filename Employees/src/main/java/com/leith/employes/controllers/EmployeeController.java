package com.leith.employes.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.leith.employes.models.Employee;
import com.leith.employes.models.Poste;
import com.leith.employes.models.Role;
import com.leith.employes.models.User;
import com.leith.employes.service.EmployeeService;
import com.leith.employes.service.PosteService;

@Controller
public class EmployeeController {
   @Autowired
   EmployeeService employeService;
   @Autowired
   PosteService posteService;
   @RequestMapping("/showCreate")
   public String showCreate(ModelMap modelMap)
   {
	   List<Poste> post=employeService.getAllPostes();
	   Employee emp=new Employee(); 
	   Poste pos=new Poste(); 
	   emp.setPoste(pos);
	   
	   modelMap.addAttribute("employe",emp);
	   modelMap.addAttribute("mode", "new");
	   modelMap.addAttribute("postes", post);
	   return "formEmploye";
   }
   
   @RequestMapping("/saveEmploye")
   public String saveEmploye(@Valid Employee employe,

   BindingResult bindingResult)

   {
   if (bindingResult.hasErrors()) 
	   return "formEmploye";
   employeService.saveEmployee(employe);
   return "redirect:/ListeEmployes";
   }
   @RequestMapping("/ListeEmployes")
   public String listeEmployes(ModelMap modelMap,

   @RequestParam (name="page",defaultValue = "0") int page,
   @RequestParam (name="size", defaultValue = "2") int size)

   {
	   
   Page<Employee> emps = employeService.getAllEmployeesParPage(page, size);
   List<Poste> post=employeService.getAllPostes();
   modelMap.addAttribute("employes", emps);
   modelMap.addAttribute("postes", post);
   modelMap.addAttribute("pages", new int[emps.getTotalPages()]);

   modelMap.addAttribute("currentPage", page);
   return "listeEmploye";
   }
   @RequestMapping("/supprimerEmploye")
   public String supprimerEmploye(@RequestParam("id") Long id,

    ModelMap modelMap,
   @RequestParam (name="page",defaultValue = "0") int page,
   @RequestParam (name="size", defaultValue = "2") int size)

   {
   employeService.deleteEmployeeById(id);
   Page<Employee> emps = employeService.getAllEmployeesParPage(page, size);

   modelMap.addAttribute("employes", emps);
   modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
   modelMap.addAttribute("currentPage", page);
   modelMap.addAttribute("size", size);
   return "listeEmploye";
   }
   
   
   @RequestMapping("/modifierEmploye")
   public String editerEmploye(@RequestParam("id") Long id,ModelMap modelMap)
   {
   Employee e= employeService.getEmployee(id);
   List<Poste> post=employeService.getAllPostes();
   modelMap.addAttribute("employe", e);
   modelMap.addAttribute("mode", "edit");
   modelMap.addAttribute("postes", post);
   return "formEmploye";
   }
   @RequestMapping("/updateEmploye")
   public String updateEmploye(@ModelAttribute("employe") Employee employe,
   @RequestParam("date") String date,

   
   ModelMap modelMap) throws ParseException

   {
   //conversion de la date

   SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
   Date datenaissance = dateformat.parse(String.valueOf(date));
   employe.setDateNaissance(datenaissance);
   employeService.updateEmployee(employe);
   List<Employee> emps = employeService.getAllEmployees();
   modelMap.addAttribute("employe", emps);
   return "listeEmploye";

   }
   @RequestMapping("/chercherPoste")
	  public String chercherPoste(@RequestParam("idPoste") int idPoste,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {     
		 	
	    	  List <Employee> employes = employeService.getAllEmployees();
	    	  employes = employes.stream().filter(e ->e.getPoste().getIdPoste() == idPoste) .collect(Collectors.toList());
	    	  modelMap.addAttribute("employes",employes);
	    	  Page<Poste> pos = posteService.getAllPostesParPage(page, size);
	    		modelMap.addAttribute("postes", pos);
	    		modelMap.addAttribute("pages", new int[pos.getTotalPages()]);
	    		modelMap.addAttribute("currentPage", page);
	    	  
	    	  return "listeEmploye";
	    }  
   @RequestMapping("/chercherNom")
   public String chercherEmploye(@RequestParam("nomEmploye") String nom,
   		ModelMap modelMap,
   		@RequestParam (name="page",defaultValue = "0") int page,
   		@RequestParam (name="size", defaultValue = "10") int size)
   
   
   {     
	 	
   	  List <Employee> emps = employeService.findByNomEmployesContains(nom);
   	  
   	  modelMap.addAttribute("Employes",emps);
   	 
   	  
   	  return "resultat";
   }  
  
}

