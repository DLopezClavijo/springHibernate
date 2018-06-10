package es.altair.webserviceclient.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import es.altair.webserviceclient.bean.Person;

@Controller
public class HomeController {
	
	private final String URL = "http://localhost:8080/webservice/service/person/";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		model.addAttribute("person", new Person());
		
		RestTemplate rest = new RestTemplate();
		
		List<LinkedHashMap> persons = rest.getForObject(URL + "list/", List.class);		
		
		return new ModelAndView("home", "listPersons", persons);
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deletePerson(@PathVariable("id") int id) {
		RestTemplate rest = new RestTemplate();
		
		rest.delete(URL + "delete/{id}", id);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/add")
	public String addPerson(@ModelAttribute("person") Person p) {
		RestTemplate rest = new RestTemplate();
		
		rest.postForObject(URL + "add/", p, Person.class);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		RestTemplate rest = new RestTemplate();
		
		Person p = rest.getForObject(URL + "edit/{id}", Person.class, id);
		
		model.addAttribute("person", p);
		
		List<LinkedHashMap> persons = rest.getForObject(URL + "list/", List.class);
		
		model.addAttribute("listPersons", persons);
		
		return "home";
	}
}
