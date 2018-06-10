package es.altair.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.altair.webservice.bean.Person;
import es.altair.webservice.dao.PersonDAO;

@RestController
@RequestMapping("/service/person/")
public class PersonController {

	@Autowired
	private PersonDAO personDAO;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers="Accept=application/json")
	public List<Person> listPersons() {
		return personDAO.listPersons();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addPerson(@RequestBody Person p) {
		if (p.getId() == 0) {
			// add
			personDAO.addPerson(p);
		} else {
			// edit
			personDAO.editPerson(p);
		}
	}
	
	@RequestMapping(value = "/edit/{id}")
	public @ResponseBody Person editPerson(@PathVariable("id") int id) {
		return (Person) personDAO.getPersonById(id);
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		personDAO.deletePerson(id);
	}
}
