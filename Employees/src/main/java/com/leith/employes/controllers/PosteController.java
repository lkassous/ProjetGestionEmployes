package com.leith.employes.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leith.employes.models.Employee;
import com.leith.employes.models.Poste;
import com.leith.employes.service.EmployeeService;
import com.leith.employes.service.PosteService;


@Controller
public class PosteController {
	 @Autowired
	    PosteService posteService;
	  @Autowired
	    EmployeeService employeService;
	 @RequestMapping("/CreatePoste")
	  public String CreatePoste(ModelMap modelMap)
	    {
	  
	    modelMap.addAttribute("poste",new Poste());
	    modelMap.addAttribute("mode","new");
	    
	    return "formPoste";
	    }
	 
	 @RequestMapping("/savePoste")
	    public String savePoste(Poste poste)
	    {
	    posteService.savePoste(poste);
		return "redirect:/ListePostes";
	    }
	 
	 @RequestMapping("/ListePostes")
	    public String listePostes(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	    	Page<Poste> pos = posteService.getAllPostesParPage(page, size);
	    	modelMap.addAttribute("postes", pos);
	    	modelMap.addAttribute("pages", new int[pos.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listeposte";
	    }
	 
	 
	 @RequestMapping("/supprimerPoste")
	    public String supprimerPoste(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        posteService.deletePosteById(id);
	        Page<Poste> pos = posteService.getAllPostesParPage(page, size);
	        		modelMap.addAttribute("postes", pos);
	        		modelMap.addAttribute("pages", new int[pos.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "listeposte";
	    }
	 @RequestMapping("/modifierPoste")
	    public String editerPoste(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Poste p= posteService.getPoste(id);
	    modelMap.addAttribute("poste", p);
	    modelMap.addAttribute("mode", "edit");
	    return "formPoste";
	    }
	 
	 
	 @RequestMapping("/updatePoste")
	    public String updatePoste(@ModelAttribute("poste") Poste poste,ModelMap modelMap) throws ParseException
	    {

	        posteService.updatePoste(poste);
	        List<Poste> pos = posteService.getAllPostes();
	        modelMap.addAttribute("postes", pos);
	        return "listeposte";
	    }
	 @RequestMapping("/chercherPos")
	
	    public String chercherPoste(@RequestParam("nomPoste") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List<Employee> pos = employeService.findByNomPosteContains(nom);
	    	  System.out.println(pos);
	    	  modelMap.addAttribute("categories",pos);
	    	  
	    	  return "chercherCat";
	    } 


 
}
